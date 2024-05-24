package cn.insectmk.gulimall.product.service;

import cn.insectmk.gulimall.product.entity.ProductAttrValueEntity;
import cn.insectmk.gulimall.product.vo.AttrGroupRelationVo;
import cn.insectmk.gulimall.product.vo.AttrRespVo;
import cn.insectmk.gulimall.product.vo.AttrVo;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.insectmk.common.utils.PageUtils;
import cn.insectmk.gulimall.product.entity.AttrEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author InsectMk
 * @email 3067836615@qq.com
 * @date 2024-05-17 16:47:08
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    /**
     * 根据属性分组分页查询该组所有属性
     * @param params
     * @param catelogId
     * @return
     */
    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId);

    /**
     * 获取属性的详细信息
     * @param attrId
     * @return
     */
    AttrRespVo getAttrInfo(Long attrId);

    /**
     * 更新详细的属性信息
     * @param attr
     */
    void updateAttr(AttrVo attr);

    /**
     * 获取属性的详细信息
     * @param params
     * @param catelogId
     * @param attrType
     * @return
     */
    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String attrType);

    /**
     * 根据分组ID获取该分组下的所有属性
     * @param attrgroupId
     * @return
     */
    List<AttrEntity> getRelationAttr(Long attrgroupId);

    /**
     * 删除属性分组与属性的关系
     * @param vos
     */
    void deleteRelation(AttrGroupRelationVo[] vos);

    /**
     * 获取当前分组没有关联的所有属性
     * @param params
     * @param attrgroupId
     * @return
     */
    PageUtils getNoRelationAttr(Map<String, Object> params, Long attrgroupId);
}

