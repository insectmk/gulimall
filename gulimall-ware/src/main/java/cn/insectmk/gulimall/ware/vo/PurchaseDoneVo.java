package cn.insectmk.gulimall.ware.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Description 采购单完成VO
 * @Author makun
 * @Date 2024/5/24 13:51
 * @Version 1.0
 */
@Data
public class PurchaseDoneVo {
    @NotNull
    private Long id; // 采购单ID
    private List<PurchaseItemDoneVo> items;
}
