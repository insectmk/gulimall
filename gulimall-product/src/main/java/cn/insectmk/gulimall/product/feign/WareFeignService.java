package cn.insectmk.gulimall.product.feign;

import cn.insectmk.common.utils.R;
import cn.insectmk.gulimall.product.vo.SkuHasStockVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Description 仓储服务远程调用接口
 * @Author makun
 * @Date 2024/5/28 10:35
 * @Version 1.0
 */
@FeignClient("gulimall-ware")
public interface WareFeignService {
    /**
     * 查询当前sku的总库存量
     * @param skuIds
     * @return
     */
    @PostMapping("/ware/waresku/hasstock")
    R getSkusHasStock(@RequestBody List<Long> skuIds);
}
