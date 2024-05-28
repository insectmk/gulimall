package cn.insectmk.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 错误码和错误信息定义类
 * 1. 错误码定义规则为5 为数字
 * 2. 前两位表示业务场景，最后三位表示错误码。例如：100001。10:通用001:系统未知异常
 * 3. 维护错误码后需要维护错误描述，将他们定义为枚举形式
 * 错误码列表：
 *  10: 通用
 *      001：参数格式校验
 *  11: 商品
 *  12: 订单
 *  13: 购物车
 *  14: 物流
 * @Author makun
 * @Date 2024/5/16 15:18
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
public enum BizCodeEnum {
    UNKNOWN_EXCEPTION(10000, "系统未知异常"),
    VALID_EXCEPTION(10001, "参数格式校验失败"),
    PRODUCT_UP_EXCEPTION(11000, "商品上架异常");

    private final int code;
    private final String msg;
}
