package cn.insectmk.gulimall.ware.vo;

import lombok.Data;

/**
 * @Description 商品是否有库存VO
 * @Author makun
 * @Date 2024/5/28 10:25
 * @Version 1.0
 */
@Data
public class SkuHasStockVo {
   private Long skuId;
   private Boolean hasStock;
}
