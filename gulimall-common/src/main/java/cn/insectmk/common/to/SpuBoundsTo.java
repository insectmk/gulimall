package cn.insectmk.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description 积分信息传输对象
 * @Author makun
 * @Date 2024/5/22 17:07
 * @Version 1.0
 */
@Data
public class SpuBoundsTo {
    private Long spuId;
    private BigDecimal buyBounds;
    private BigDecimal growBounds;
}
