package cn.insectmk.gulimall.product;

import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Description 阿里云OSS测试
 * @Author makun
 * @Date 2024/5/16 11:39
 * @Version 1.0
 */
@SpringBootTest
public class AliyunOSSTest {
    @Autowired
    private OSSClient ossClient;

    @Test
    void ossTest() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("D:\\Pictures\\个人\\头像\\octopus.jpg");

        ossClient.putObject("insectmk-gulimall", "test.jpg", inputStream);

        ossClient.shutdown();

        System.out.println("上传完成");
    }
}
