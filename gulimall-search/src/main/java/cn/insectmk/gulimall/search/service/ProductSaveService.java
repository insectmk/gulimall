package cn.insectmk.gulimall.search.service;

import cn.insectmk.common.to.es.SkuEsModel;

import java.io.IOException;
import java.util.List;

/**
 * @Description 商品保存服务
 * @Author makun
 * @Date 2024/5/28 10:56
 * @Version 1.0
 */
public interface ProductSaveService {
    /**
     * 上架商品
     * @param skuEsModels
     */
    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;
}
