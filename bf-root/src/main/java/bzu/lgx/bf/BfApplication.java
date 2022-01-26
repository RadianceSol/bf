package bzu.lgx.bf;

import bzu.lgx.bf.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/***
 * @Author: LGX-LUCIFER
 * @Date: 2022-01-08 12:45
 * @Description:
 */
@SpringBootApplication
public class BfApplication {

    public static void main(String[] args) {
        SpringApplication.run(BfApplication.class, args);
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-08 12:50
     * @Return: bzu.lgx.bf.utils.IdWorker
     * @Description: Twitter 雪花算法 用于生成ID
     */
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
