package cn.insectmk.gulimall.order.dao;

import cn.insectmk.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author InsectMk
 * @email 3067836615@qq.com
 * @date 2024-05-09 11:08:13
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
