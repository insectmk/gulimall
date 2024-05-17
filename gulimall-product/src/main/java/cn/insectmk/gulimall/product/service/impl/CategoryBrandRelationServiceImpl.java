package cn.insectmk.gulimall.product.service.impl;

import cn.insectmk.common.utils.PageUtils;
import cn.insectmk.common.utils.Query;
import cn.insectmk.gulimall.product.dao.BrandDao;
import cn.insectmk.gulimall.product.dao.CategoryBrandRelationDao;
import cn.insectmk.gulimall.product.dao.CategoryDao;
import cn.insectmk.gulimall.product.entity.BrandEntity;
import cn.insectmk.gulimall.product.entity.CategoryBrandRelationEntity;
import cn.insectmk.gulimall.product.entity.CategoryEntity;
import cn.insectmk.gulimall.product.service.CategoryBrandRelationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;


@Service("categoryBrandRelationService")
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationDao, CategoryBrandRelationEntity> implements CategoryBrandRelationService {
    @Autowired
    private BrandDao brandDao;
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryBrandRelationEntity> page = this.page(
                new Query<CategoryBrandRelationEntity>().getPage(params),
                new QueryWrapper<CategoryBrandRelationEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveDetail(CategoryBrandRelationEntity categoryBrandRelation) {
        // 获取品牌详细信息
        BrandEntity brandEntity = brandDao.selectById(categoryBrandRelation.getBrandId());
        // 获取分类详细信息
        CategoryEntity categoryEntity = categoryDao.selectById(categoryBrandRelation.getCatelogId());
        // 装入数据
        categoryBrandRelation.setBrandName(brandEntity.getName());
        categoryBrandRelation.setCatelogName(categoryEntity.getName());

        this.save(categoryBrandRelation);
    }

    @Override
    public void updateBrand(Long brandId, String name) {
        // 装载更新数据
        CategoryBrandRelationEntity categoryBrandRelationEntity = new CategoryBrandRelationEntity();
        categoryBrandRelationEntity.setBrandId(brandId);
        categoryBrandRelationEntity.setBrandName(name);
        // 条件更新
        this.update(categoryBrandRelationEntity, new LambdaUpdateWrapper<CategoryBrandRelationEntity>()
                // 品牌ID相等则更改
                .eq(CategoryBrandRelationEntity::getBrandId, brandId));
    }

    @Override
    public void updateCategory(Long catId, String name) {
        this.baseMapper.updateCategory(catId, name);
    }

}
