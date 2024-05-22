package cn.insectmk.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.insectmk.common.utils.PageUtils;
import cn.insectmk.gulimall.product.entity.ProductAttrValueEntity;
import java.util.List;
import java.util.Map;

/**
 * spu属性值
 *
 * @author InsectMk
 * @email 3067836615@qq.com
 * @date 2024-05-08 18:54:36
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 批量保存商品的属性
     * @param attrValues
     */
    void saveProductAttr(List<ProductAttrValueEntity> attrValues);
}

