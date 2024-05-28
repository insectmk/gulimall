package cn.insectmk.gulimall.product.feign;

import cn.insectmk.common.to.SkuReductionTo;
import cn.insectmk.common.to.SpuBoundsTo;
import cn.insectmk.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description 优惠券服务远程调用
 * @Author makun
 * @Date 2024/5/22 17:00
 * @Version 1.0
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {
    /**
     * 保存积分信息
     * @param spuBoundsTo
     * @return
     */
    @PostMapping("/coupon/spubounds/save")
    R saveSpuBounds(@RequestBody SpuBoundsTo spuBoundsTo);

    /**
     * 保存优惠、打折等信息
     * @param skuReductionTo
     */
    @PostMapping("/coupon/skufullreduction/saveinfo")
    R saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);
}
