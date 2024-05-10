package cn.insectmk.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.insectmk.common.utils.PageUtils;
import cn.insectmk.gulimall.coupon.entity.SkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author InsectMk
 * @email 3067836615@qq.com
 * @date 2024-05-09 10:34:15
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

