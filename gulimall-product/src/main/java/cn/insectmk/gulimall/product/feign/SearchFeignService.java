package cn.insectmk.gulimall.product.feign;

import cn.insectmk.common.to.es.SkuEsModel;
import cn.insectmk.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

/**
 * @Description ES远程服务调用接口
 * @Author makun
 * @Date 2024/5/28 11:29
 * @Version 1.0
 */
@FeignClient("gulimall-search")
public interface SearchFeignService {
    @PostMapping("/search/save/product")
    R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels);
}
