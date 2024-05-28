package cn.insectmk.gulimall.product.service;

import cn.insectmk.gulimall.product.entity.BrandEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.insectmk.common.utils.PageUtils;
import cn.insectmk.gulimall.product.entity.CategoryBrandRelationEntity;

import java.util.List;
import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author InsectMk
 * @email 3067836615@qq.com
 * @date 2024-05-08 18:54:36
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存详细的品牌分类信息
     * @param categoryBrandRelation
     */
    void saveDetail(CategoryBrandRelationEntity categoryBrandRelation);

    /**
     * 更新品牌名称
     * @param brandId
     * @param name
     */
    void updateBrand(Long brandId, String name);

    /**
     * 更新分类名称
     * @param catId
     * @param name
     */
    void updateCategory(Long catId, String name);

    /**
     * 获取分类关联的品牌
     * @param catId
     * @return
     */
    List<BrandEntity> getBrandsByCatId(Long catId);
}

