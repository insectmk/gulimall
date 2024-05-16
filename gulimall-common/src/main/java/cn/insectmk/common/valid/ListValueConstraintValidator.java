package cn.insectmk.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 集合校验
 * @Author makun
 * @Date 2024/5/16 16:06
 * @Version 1.0
 */
public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {
    Set<Integer> set = new HashSet<>();

    /**
     * 初始化方法
     * @param constraintAnnotation
     */
    @Override
    public void initialize(ListValue constraintAnnotation) {
        int[] vals = constraintAnnotation.vals();
        // 将允许的数据装载到集合中
        for (int val : vals) {
            set.add(val);
        }
    }

    /**
     * 判断是否校验成功
     * @param integer
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        // 判断数据是否在集合中
        return set.contains(integer);
    }
}
