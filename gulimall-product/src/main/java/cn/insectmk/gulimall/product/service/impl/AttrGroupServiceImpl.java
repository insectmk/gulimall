package cn.insectmk.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.insectmk.common.utils.PageUtils;
import cn.insectmk.common.utils.Query;

import cn.insectmk.gulimall.product.dao.AttrGroupDao;
import cn.insectmk.gulimall.product.entity.AttrGroupEntity;
import cn.insectmk.gulimall.product.service.AttrGroupService;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        // 定义查询条件
        LambdaQueryWrapper<AttrGroupEntity> wrapper = new LambdaQueryWrapper<>();
        String key = (String) params.get("key");
        // 如果有关键字则增加对应查询条件
        if (StringUtils.isNotBlank(key)) {
            wrapper.and((obj) -> {
                obj.eq(AttrGroupEntity::getAttrGroupId, key)
                        .or()
                        .like(AttrGroupEntity::getAttrGroupName, key);
            });
        }
        // 如果指定了分类ID则加入查询条件
        if (catelogId != 0) {
            wrapper.eq(AttrGroupEntity::getCatelogId, catelogId);
        }
        // 分页查询
        IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params), wrapper);
        return new PageUtils(page);
    }

}
