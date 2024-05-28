package cn.insectmk.gulimall.search.service.impl;

import cn.insectmk.common.to.es.SkuEsModel;
import cn.insectmk.gulimall.search.config.GulimallElasticSearchConfig;
import cn.insectmk.gulimall.search.constant.EsConstant;
import cn.insectmk.gulimall.search.service.ProductSaveService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description 商品保存服务实现类
 * @Author makun
 * @Date 2024/5/28 10:57
 * @Version 1.0
 */
@Service
@Slf4j
public class ProductSaveServiceImpl implements ProductSaveService {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    public boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException {
        // 保存到ES中
        // 1. 给ES建立索引，product，建立好映射关系
        // 2. 给ES中保存这些数据
        BulkRequest bulkRequest = new BulkRequest();
        for (SkuEsModel skuEsModel : skuEsModels) {
            // 构造保存请求
            IndexRequest indexRequest = new IndexRequest(EsConstant.PRODUCT_INDEX);
            indexRequest.id(skuEsModel.getSkuId().toString());
            indexRequest.source(JSON.toJSONString(skuEsModel));
            bulkRequest.add(indexRequest);
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);
        // TODO 如果批量错误
        boolean flag = bulk.hasFailures();
        if (flag) {
            List<String> itemIds = Arrays.stream(bulk.getItems()).map(BulkItemResponse::getId).collect(Collectors.toList());
            log.error("商品上架错误：{}", itemIds);
        }
        return flag;
    }
}
