package cn.insectmk.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.insectmk.common.utils.PageUtils;
import cn.insectmk.gulimall.coupon.entity.SeckillSessionEntity;

import java.util.Map;

/**
 * 秒杀活动场次
 *
 * @author InsectMk
 * @email 3067836615@qq.com
 * @date 2024-05-09 10:34:15
 */
public interface SeckillSessionService extends IService<SeckillSessionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

