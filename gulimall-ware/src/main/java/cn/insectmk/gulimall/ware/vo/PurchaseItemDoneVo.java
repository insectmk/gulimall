package cn.insectmk.gulimall.ware.vo;

import lombok.Data;

/**
 * @Description 采购项VO
 * @Author makun
 * @Date 2024/5/24 13:52
 * @Version 1.0
 */
@Data
public class PurchaseItemDoneVo {
    private Long itemId;
    private Integer status;
    private String reason;
}
