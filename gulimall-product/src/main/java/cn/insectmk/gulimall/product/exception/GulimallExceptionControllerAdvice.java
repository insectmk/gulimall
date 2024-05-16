package cn.insectmk.gulimall.product.exception;

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
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {
        log.error("数据校验出现问题{}，异常类型{}", e.getMessage(), e.getClass());

        Map<String, String> errors = new HashMap<>();
        BindingResult bindingResult = e.getBindingResult();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        return R.error(400, "提交的数据不合法").put("data", errors);
    }
}
