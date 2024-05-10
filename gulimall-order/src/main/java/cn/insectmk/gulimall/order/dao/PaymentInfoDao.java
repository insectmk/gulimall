package cn.insectmk.gulimall.order.dao;

import cn.insectmk.gulimall.order.entity.PaymentInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 * 
 * @author InsectMk
 * @email 3067836615@qq.com
 * @date 2024-05-09 11:08:13
 */
@Mapper
public interface PaymentInfoDao extends BaseMapper<PaymentInfoEntity> {
	
}
