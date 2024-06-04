package cn.insectmk.gulimall.product.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.IOException;

/**
 * @Description Redisson配置
 * @Author makun
 * @Date 2024/6/4 8:48
 * @Version 1.0
 */
@Configuration
public class MyRedissonConfig {
    /**
     * 所有对Redisson的操作都是通过RedissonClient对象
     * @return
     * @throws IOException
     */
    @Bean(destroyMethod="shutdown")
    public RedissonClient redisson() throws IOException {
        // 创建配置
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.114.141:6379");
        // 根据配置创建出RedissonClient实例
        return Redisson.create(config);
    }
}
