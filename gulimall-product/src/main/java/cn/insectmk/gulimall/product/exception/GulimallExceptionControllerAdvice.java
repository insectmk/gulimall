package cn.insectmk.gulimall.product.exception;

import cn.insectmk.common.exception.BizCodeEnum;
import cn.insectmk.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 控制层全局异常处理
 * @Author makun
 * @Date 2024/5/16 15:05
 * @Version 1.0
 */
@RestControllerAdvice
@Slf4j
public class GulimallExceptionControllerAdvice {
    /**
     * 数据校验错误处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {
        log.error("数据校验出现问题{}，异常类型{}", e.getMessage(), e.getClass());

        Map<String, String> errors = new HashMap<>();
        BindingResult bindingResult = e.getBindingResult();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(), BizCodeEnum.VALID_EXCEPTION.getMsg()).put("data", errors);
    }

    /**
     * 处理全局未知异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable e) {
        log.error("系统出现未知问题{}，异常类型{}", e.getMessage(), e.getClass(), e);
        return R.error(BizCodeEnum.UNKNOWN_EXCEPTION.getCode(), BizCodeEnum.UNKNOWN_EXCEPTION.getMsg());
    }
}
