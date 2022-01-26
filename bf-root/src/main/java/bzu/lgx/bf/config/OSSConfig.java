package bzu.lgx.bf.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-19 15:54
 * @Description: FIXME: Need To Delete .
 */
@Configuration
public class OSSConfig {

    @Bean
    public OSS ossClient() {
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        String keyId = "";
        String keySecret = "";
        return new OSSClientBuilder().build(endpoint, keyId, keySecret);
    }

}
