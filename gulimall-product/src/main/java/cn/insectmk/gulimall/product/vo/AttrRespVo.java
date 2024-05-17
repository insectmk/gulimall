package cn.insectmk.gulimall.product.vo;

import lombok.Data;

/**
 * @Description 属性响应视图
 * @Author makun
 * @Date 2024/5/17 17:16
 * @Version 1.0
 */
@Data
public class AttrRespVo extends AttrVo {
    /**
     * 所属分类名字
     */
    private String catelogName;
    /**
     * 所属分组名字
     */
    private String groupName;
    /**
     * 所属分类层级关系
     */
    private Long[] catelogPath;
}
