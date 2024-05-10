package cn.insectmk.gulimall.member.dao;

import cn.insectmk.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author InsectMk
 * @email 3067836615@qq.com
 * @date 2024-05-09 10:49:33
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
