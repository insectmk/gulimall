package cn.insectmk.gulimall.member.dao;

import cn.insectmk.gulimall.member.entity.MemberLoginLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员登录记录
 * 
 * @author InsectMk
 * @email 3067836615@qq.com
 * @date 2024-05-09 10:49:34
 */
@Mapper
public interface MemberLoginLogDao extends BaseMapper<MemberLoginLogEntity> {
	
}
