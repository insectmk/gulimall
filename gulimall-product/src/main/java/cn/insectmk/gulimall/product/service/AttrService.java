package cn.insectmk.gulimall.product.service;

import cn.insectmk.gulimall.product.vo.AttrVo;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.insectmk.common.utils.PageUtils;
import cn.insectmk.gulimall.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author InsectMk
 * @email 3067836615@qq.com
 * @date 2024-05-17 16:47:08
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    /**
     * 根据属性分组分页查询该组所有属性
     * @param params
     * @param catelogId
     * @return
     */
    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId);
}

