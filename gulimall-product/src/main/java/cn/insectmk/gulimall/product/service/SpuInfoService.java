package cn.insectmk.gulimall.product.service;

import cn.insectmk.gulimall.product.entity.SpuInfoDescEntity;
import cn.insectmk.gulimall.product.vo.SpuSaveVo;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.insectmk.common.utils.PageUtils;
import cn.insectmk.gulimall.product.entity.SpuInfoEntity;

import java.util.Map;

/**
 * spu信息
 *
 * @author InsectMk
 * @email 3067836615@qq.com
 * @date 2024-05-08 18:54:36
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存商品信息
     * @param spuSaveVo
     */
    void saveSpuInfo(SpuSaveVo spuSaveVo);

    /**
     * 保存商品基本信息
     * @param spuInfoEntity
     */
    void saveBaseSpuInfo(SpuInfoEntity spuInfoEntity);
}

