package bzu.lgx.bf.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-19 15:54
 * @Description: TODO: The Key Needs To Be Replaced With Your Own.
 */
@Configuration
public class OSSConfig {

    @Bean
    public OSS ossClient() {
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        String keyId = "<your-access-key-id>";
        String keySecret = "<your-access-key-secret>";
        return new OSSClientBuilder().build(endpoint, keyId, keySecret);
    }

}
