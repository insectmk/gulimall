package cn.insectmk.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 库存服务常量
 * @Author makun
 * @Date 2024/5/24 12:16
 * @Version 1.0
 */
public class WareConstant {
    /**
     * 采购单状态
     */
    @Getter
    @AllArgsConstructor
    public enum PurchaseStatusEnum {
        CREATED(0, "新建"),
        ASSIGNED(1, "已分配"),
        RECEIVE(2, "已领取"),
        FINISH(3, "已完成"),
        HAS_ERROR(4, "有异常");

        private final int code;
        private final String msg;
    }

    /**
     * 采购需求状态
     */
    @Getter
    @AllArgsConstructor
    public enum PurchaseDetailStatusEnum {
        CREATED(0, "新建"),
        ASSIGNED(1, "已分配"),
        BUYING(2, "正在采购"),
        FINISH(3, "已完成"),
        HAS_ERROR(4, "采购失败");

        private final int code;
        private final String msg;
    }
}
