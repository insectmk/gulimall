package cn.insectmk.gulimall.ware.feign;

import cn.insectmk.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 商品服务远程调用
 * @Author makun
 * @Date 2024/5/24 14:23
 * @Version 1.0
 */
@FeignClient("gulimall-gateway")
public interface ProductFeignService {
    /**
     * 查询SKU的详细信息
     * @param skuId
     * @return
     */
    @RequestMapping("/api/product/skuinfo/info/{skuId}")
    R info(@PathVariable("skuId") Long skuId);
}
