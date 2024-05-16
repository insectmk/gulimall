package cn.insectmk.gulimall.thirdparty;

import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class GulimallThirdPartyApplicationTests {
    @Autowired
    private OSSClient ossClient;

    @Test
    void ossTest() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("D:\\Pictures\\个人\\头像\\老头像.jpg");

        ossClient.putObject("insectmk-gulimall", "老头像.jpg", inputStream);

        ossClient.shutdown();

        System.out.println("上传完成");
    }

    @Test
    void contextLoads() {
    }
}
