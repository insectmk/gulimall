package cn.insectmk.gulimall.search;

import cn.insectmk.gulimall.search.config.GulimallElasticSearchConfig;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class GulimallSearchApplicationTests {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Data
    class User {
        private String username;
        private String gender;
        private Integer age;
    }

    @Test
    void contextLoads() throws IOException {
        IndexRequest indexRequest = new IndexRequest("users");
        indexRequest.id("1");
        User user = new User();
        user.setUsername("测试");
        user.setGender("男");
        user.setAge(18);
        String jsonString = JSON.toJSONString(user);
        indexRequest.source(jsonString, XContentType.JSON);

        IndexResponse response = restHighLevelClient.index(indexRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);

        System.out.println(response);
    }

}
