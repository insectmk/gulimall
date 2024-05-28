/**
  * Copyright 2024 bejson.com
  */
package cn.insectmk.gulimall.product.vo;
import cn.insectmk.gulimall.product.vo.spusave.BaseAttrs;
import cn.insectmk.gulimall.product.vo.spusave.Bounds;
import cn.insectmk.gulimall.product.vo.spusave.Skus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Auto-generated: 2024-05-22 15:27:18
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class SpuSaveVo {
    private String spuName;
    private String spuDescription;
    private Long catalogId;
    private Long brandId;
    private BigDecimal weight;
    private int publishStatus;
    private List<String> decript;
    private List<String> images;
    private Bounds bounds;
    private List<BaseAttrs> baseAttrs;
    private List<Skus> skus;
}
