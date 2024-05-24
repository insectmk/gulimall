package cn.insectmk.gulimall.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description 采购项合并VO
 * @Author makun
 * @Date 2024/5/24 11:44
 * @Version 1.0
 */
@Data
public class MergeVo {
    private Long purchaseId;
    private List<Long> items;
}
