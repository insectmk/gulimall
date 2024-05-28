package cn.insectmk.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 商品服务常量
 * @Author makun
 * @Date 2024/5/22 10:16
 * @Version 1.0
 */
public class ProductConstant {
    @Getter
    @AllArgsConstructor
    public enum StatusEnum {
        NEW_SPU(0, "新建"),
        SPU_UP(1, "商品上架"),
        SPU_DOWN(2, "商品下架");

        private final int code;
        private final String msg;
    }

    @Getter
    @AllArgsConstructor
    public enum AttrEnum {
        ATTR_TYPE_BASE(1, "基本属性"), ATTR_TYPE_SALE(0, "销售属性");

        private final int code;
        private final String msg;
    }
}
