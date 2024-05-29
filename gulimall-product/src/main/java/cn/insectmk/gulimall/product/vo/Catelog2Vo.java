package cn.insectmk.gulimall.product.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description 二级分类VO
 * @Author makun
 * @Date 2024/5/29 9:10
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catelog2Vo {
    private String catalogId;
    private List<Catelog3Vo> catalog3List;
    private String id;
    private String name;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Catelog3Vo {
        private String catalog2Id; // 父分类，二级分类ID
        private String id;
        private String name;
    }
}
