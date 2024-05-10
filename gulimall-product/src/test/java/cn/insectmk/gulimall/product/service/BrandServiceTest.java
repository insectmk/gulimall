package cn.insectmk.gulimall.product.service;

import cn.insectmk.gulimall.product.entity.BrandEntity;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BrandServiceTest {
    @Autowired
    BrandService brandService;

    @Test
    void queryList() {
        List<BrandEntity> list = brandService.list(new LambdaQueryWrapper<BrandEntity>()
                .eq(BrandEntity::getBrandId, 1));
        list.forEach(System.out::println);
    }

    @Test
    void queryPage() {

    }
}
