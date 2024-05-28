package cn.insectmk.gulimall.product.service.impl;

import cn.insectmk.gulimall.product.service.CategoryBrandRelationService;
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
