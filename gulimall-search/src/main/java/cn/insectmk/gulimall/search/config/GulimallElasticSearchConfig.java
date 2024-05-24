package cn.insectmk.gulimall.search.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 谷粒商城ES配置
 * @Author makun
 * @Date 2024/5/27 15:46
 * @Version 1.0
 */
@Configuration
public class GulimallElasticSearchConfig {
    public static final RequestOptions COMMON_OPTIONS;

    static {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();

        COMMON_OPTIONS = builder.build();
    }

    @Bean
    public RestHighLevelClient esRestClient() {
        return new RestHighLevelClient(RestClient.builder(
                new HttpHost("192.168.114.141", 9200, "http")
        ));
    }
}
