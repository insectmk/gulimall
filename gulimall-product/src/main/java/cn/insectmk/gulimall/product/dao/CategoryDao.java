package cn.insectmk.gulimall.product.dao;

import cn.insectmk.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author InsectMk
 * @email 3067836615@qq.com
 * @date 2024-05-08 18:54:36
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
