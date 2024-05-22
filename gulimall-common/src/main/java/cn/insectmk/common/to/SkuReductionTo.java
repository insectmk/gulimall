package cn.insectmk.common.to;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description 商品优惠信息
 * @Author makun
 * @Date 2024/5/22 17:21
 * @Version 1.0
 */
@Data
public class SkuReductionTo {
    private Long skuId;
    private int fullCount;
    private BigDecimal discount;
    private int countStatus;
    private BigDecimal fullPrice;
    private BigDecimal reducePrice;
    private int priceStatus;
    private List<MemberPrice> memberPrice;
}
