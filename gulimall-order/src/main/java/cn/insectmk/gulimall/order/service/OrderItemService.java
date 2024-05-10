package cn.insectmk.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.insectmk.common.utils.PageUtils;
import cn.insectmk.gulimall.order.entity.OrderItemEntity;

import java.util.Map;

/**
 * 订单项信息
 *
 * @author InsectMk
 * @email 3067836615@qq.com
 * @date 2024-05-09 11:08:13
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

