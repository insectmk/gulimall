package cn.insectmk.gulimall.product.service.impl;

import cn.insectmk.gulimall.product.entity.AttrEntity;
import cn.insectmk.gulimall.product.entity.ProductAttrValueEntity;
import cn.insectmk.gulimall.product.entity.SpuInfoDescEntity;
import cn.insectmk.gulimall.product.service.ProductAttrValueService;
import cn.insectmk.gulimall.product.service.SpuImagesService;
import cn.insectmk.gulimall.product.service.SpuInfoDescService;
import cn.insectmk.gulimall.product.vo.SpuSaveVo;
import cn.insectmk.gulimall.product.vo.spusave.BaseAttrs;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.insectmk.common.utils.PageUtils;
import cn.insectmk.common.utils.Query;
import cn.insectmk.gulimall.product.dao.SpuInfoDao;
import cn.insectmk.gulimall.product.entity.SpuInfoEntity;
import cn.insectmk.gulimall.product.service.SpuInfoService;
import org.springframework.transaction.annotation.Transactional;

@Service("spuInfoService")
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {
    @Autowired
    private SpuInfoDescService spuInfoDescService;
    @Autowired
    private SpuImagesService spuImagesService;
    @Autowired
    private AttrServiceImpl attrService;
    @Autowired
    private ProductAttrValueService attrValueService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(params),
                new QueryWrapper<SpuInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public void saveSpuInfo(SpuSaveVo spuSaveVo) {
        // 1. 保存spu基本信息:spu_info
        SpuInfoEntity spuInfoEntity = new SpuInfoEntity();
        BeanUtils.copyProperties(spuSaveVo, spuInfoEntity);
        spuInfoEntity.setCreateTime(new Date());
        spuInfoEntity.setUpdateTime(new Date());
        this.saveBaseSpuInfo(spuInfoEntity);
        // 2. 保存spu的描述图片:spu_info_desc
        List<String> decripts = spuSaveVo.getDecript();
        SpuInfoDescEntity descEntity = new SpuInfoDescEntity();
        descEntity.setSpuId(spuInfoEntity.getId());
        descEntity.setDecript(String.join(",", decripts));
        spuInfoDescService.saveSpuInfoDesc(descEntity);
        // 3. 保存spu的图片集:spu_images
        List<String> images = spuSaveVo.getImages();
        spuImagesService.saveImages(spuInfoEntity.getId(), images);
        // 4. 保存spu的规格参数:product_attr_value
        List<BaseAttrs> baseAttrs = spuSaveVo.getBaseAttrs();
        List<ProductAttrValueEntity> attrValues = baseAttrs.stream().map(attr -> {
            ProductAttrValueEntity valueEntity = new ProductAttrValueEntity();
            valueEntity.setAttrId(attr.getAttrId());
            AttrEntity attrEntity = attrService.getById(attr.getAttrId());
            valueEntity.setAttrName(attrEntity.getAttrName());
            valueEntity.setAttrValue(attr.getAttrValues());
            valueEntity.setQuickShow(attr.getShowDesc());
            valueEntity.setSpuId(spuInfoEntity.getId());
            return valueEntity;
        }).collect(Collectors.toList());
        attrValueService.saveProductAttr(attrValues);
        // 5. 保存spu的积分信息
        // 6. 保存当前spu对应的所有sku信息
        // 6.1) sku的基本信息:sku_info
        // 6.2) sku的图片信息:sku_images
        // 6.3) sku的销售属性信息:sku_sale_attr_value
        // 6.4) sku的优惠、满减等信息（跨库）
    }

    @Override
    public void saveBaseSpuInfo(SpuInfoEntity spuInfoEntity) {
        this.baseMapper.insert(spuInfoEntity);
    }

}
