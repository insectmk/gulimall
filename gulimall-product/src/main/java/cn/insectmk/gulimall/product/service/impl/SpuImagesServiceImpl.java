package cn.insectmk.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.insectmk.common.utils.PageUtils;
import cn.insectmk.common.utils.Query;

import cn.insectmk.gulimall.product.dao.SpuImagesDao;
import cn.insectmk.gulimall.product.entity.SpuImagesEntity;
import cn.insectmk.gulimall.product.service.SpuImagesService;


@Service("spuImagesService")
public class SpuImagesServiceImpl extends ServiceImpl<SpuImagesDao, SpuImagesEntity> implements SpuImagesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuImagesEntity> page = this.page(
                new Query<SpuImagesEntity>().getPage(params),
                new QueryWrapper<SpuImagesEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveImages(Long spuId, List<String> images) {
        if (images != null && !images.isEmpty()) {
            List<SpuImagesEntity> spuImagesEntities = images.stream().map(img -> {
                SpuImagesEntity spuImagesEntity = new SpuImagesEntity();
                spuImagesEntity.setSpuId(spuId);
                spuImagesEntity.setImgUrl(img);
                return spuImagesEntity;
            }).collect(Collectors.toList());
            this.saveBatch(spuImagesEntities);
        }
    }

}
