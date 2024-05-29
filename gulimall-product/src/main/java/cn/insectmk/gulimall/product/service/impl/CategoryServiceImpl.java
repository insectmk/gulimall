package cn.insectmk.gulimall.product.service.impl;

import cn.insectmk.gulimall.product.service.CategoryBrandRelationService;
import cn.insectmk.gulimall.product.vo.Catelog2Vo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.insectmk.common.utils.PageUtils;
import cn.insectmk.common.utils.Query;

import cn.insectmk.gulimall.product.dao.CategoryDao;
import cn.insectmk.gulimall.product.entity.CategoryEntity;
import cn.insectmk.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {
    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 查出所有的集合
        List<CategoryEntity> allCategories = baseMapper.selectList(null);
        // 过滤出所有的根分类
        List<CategoryEntity> rootCategories = allCategories.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .peek((category) -> category.setChildren(getChildren(category, allCategories)))
                .sorted(Comparator.comparingInt(category -> ((category.getSort() == null) ? 0 : category.getSort())))
                .collect(Collectors.toList());

        return rootCategories;
    }

    @Override
    public boolean removeMenuByIds(List<Long> ids) {
        // TODO: 删除分类前进行判断
        return this.removeByIds(ids);
    }

    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> paths = new ArrayList<>();
        List<Long> parentPath = findParentPath(catelogId, paths);
        Collections.reverse(parentPath);

        return parentPath.toArray(new Long[0]);
    }

    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        categoryBrandRelationService.updateCategory(category.getCatId(), category.getName());
    }

    @Override
    public List<CategoryEntity> getLevel1Categories() {
        return baseMapper.selectList(new LambdaQueryWrapper<CategoryEntity>()
                .eq(CategoryEntity::getParentCid, 0));
    }

    @Override
    public Map<String, List<Catelog2Vo>> getCatalogJson() {
        //System.out.println("查询了数据库......");

        List<CategoryEntity> selectList = baseMapper.selectList(null);
        System.out.println(selectList);
        // 查询所有一级分类
        List<CategoryEntity> level1Category = getParent_cid(selectList, 0L);

        // 2 封装数据
        Map<String, List<Catelog2Vo>> parent_cid = level1Category.stream().collect(Collectors.toMap(k -> k.getCatId().toString(), v -> {
                    // 1 每一个的一级分类，查到这个一级分类的二级分类
                    List<CategoryEntity> categoryEntities = getParent_cid(selectList, v.getCatId());
                    // 2 分装上面的结果
                    List<Catelog2Vo> catelog2Vos = null;

                    if (categoryEntities != null) {

                        catelog2Vos = categoryEntities.stream().map(l2 -> {
                            Catelog2Vo catelog2Vo = new Catelog2Vo(v.getCatId().toString(), null, l2.getCatId().toString(), l2.getName());
                            // 1 找当前二级分类的三级分类封装成vo
                            List<CategoryEntity> level3Catelog = getParent_cid(selectList, l2.getCatId());
                            if (level3Catelog != null) {
                                List<Catelog2Vo.Catelog3Vo> collect = level3Catelog.stream().map(l3 -> {
                                    // 2 分装成指定格式
                                    Catelog2Vo.Catelog3Vo catelog3Vo = new Catelog2Vo.Catelog3Vo(l2.getCatId().toString(), l3.getCatId().toString(), l3.getName());
                                    return catelog3Vo;
                                }).collect(Collectors.toList());
                                catelog2Vo.setCatalog3List(collect);
                            }
                            return catelog2Vo;
                        }).collect(Collectors.toList());
                    }
                    return catelog2Vos;

                }

        ));
        return parent_cid;
    }

    //@Override
    @Deprecated
    public Map<String, List<Catelog2Vo>> getCatalogJson2() {
        // 查出所有一级分类
        List<CategoryEntity> level1Categories = getLevel1Categories();
        // 封装数据
        Map<String, List<Catelog2Vo>> catalogs = level1Categories.stream().collect(Collectors.toMap(key -> {
            return key.getCatId().toString();
        }, value -> {
            // 查询二级分类
            List<CategoryEntity> categoryEntities = baseMapper.selectList(new LambdaQueryWrapper<CategoryEntity>()
                    .eq(CategoryEntity::getParentCid, value.getCatId()));
            // 封装数据
            List<Catelog2Vo> catelog2Vos = null;
            if (categoryEntities != null) {
                catelog2Vos = categoryEntities.stream().map(l2 -> {
                    Catelog2Vo catelog2Vo = new Catelog2Vo(value.getCatId().toString(), null, l2.getCatId().toString(), l2.getName());
                    // 找当前二级分类的三级分类
                    List<CategoryEntity> level3Catalog = baseMapper.selectList(new LambdaQueryWrapper<CategoryEntity>()
                            .eq(CategoryEntity::getParentCid, l2.getCatId()));
                    if (level3Catalog != null) {
                        List<Catelog2Vo.Catelog3Vo> catelog3Vos = level3Catalog.stream().map(l3 -> {
                            // 封装为指定格式
                            Catelog2Vo.Catelog3Vo catelog3Vo = new Catelog2Vo.Catelog3Vo(l2.getCatId().toString(), l3.getCatId().toString(), l3.getName());
                            return catelog3Vo;
                        }).collect(Collectors.toList());
                        catelog2Vo.setCatalog3List(catelog3Vos);
                    }
                    return catelog2Vo;
                }).collect(Collectors.toList());
            }
            return catelog2Vos;
        }));

        return catalogs;
    }

    /**
     * 递归查询分类ID的父分类ID
     * @param catelogId
     * @param paths
     * @return
     */
    private List<Long> findParentPath(Long catelogId, List<Long> paths) {
        paths.add(catelogId);
        CategoryEntity categoryEntity = baseMapper.selectById(catelogId);
        if (categoryEntity.getParentCid() != 0) {
            findParentPath(categoryEntity.getParentCid(), paths);
        }
        return paths;
    }

    /**
     *
     * @param selectList
     * @param parent_cid
     * @return
     */
    private List<CategoryEntity> getParent_cid(List<CategoryEntity> selectList, Long parent_cid) {
        List<CategoryEntity> collect = selectList.stream().filter(item -> {
            return item.getParentCid() == parent_cid;
        }).collect(Collectors.toList());
        return collect;
        // return baseMapper.selectList(new QueryWrapper<CategoryEntity>().eq("parent_cid", v.getCatId()));
    }

    /**
     * 获取分类的子分类
     * @param root
     * @param allCategories
     * @return
     */
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> allCategories) {
        // 装载root分类的子分类
        List<CategoryEntity> children = allCategories.stream()
                .filter(category -> root.getCatId().equals(category.getParentCid()))
                .peek(category -> category.setChildren(getChildren(category, allCategories)))
                .sorted(Comparator.comparingInt(category -> ((category.getSort() == null) ? 0 : category.getSort())))
                .collect(Collectors.toList());
        return children;
    }
}
