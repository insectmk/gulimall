package cn.insectmk.gulimall.product.service;


import cn.insectmk.common.utils.PageUtils;
import cn.insectmk.gulimall.product.entity.AttrEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.Map;

/**
 * 商品属性
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

