package cn.insectmk.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.insectmk.common.utils.PageUtils;
import cn.insectmk.gulimall.ware.entity.WareSkuEntity;

import java.util.Map;

/**
 * 商品库存
 *
 * @author InsectMk
 * @email 3067836615@qq.com
 * @date 2024-05-09 11:14:48
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

