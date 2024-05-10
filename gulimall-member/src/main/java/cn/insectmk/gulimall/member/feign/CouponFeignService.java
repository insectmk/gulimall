package cn.insectmk.gulimall.member.feign;

import cn.insectmk.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 优惠券服务远程调用接口
 * @Author makun
 * @Date 2024/5/9 13:17
 * @Version 1.0
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {
    /**
     * 优惠券服务请求测试
     * @return
     */
    @RequestMapping("/coupon/coupon/member/list")
    R memberList();
}
