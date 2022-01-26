package bzu.lgx.bf.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import  org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import  springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import  springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-08 16:34
 * @Description: Swagger2 API 接口文档
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            // 为当前包路径
            .apis(RequestHandlerSelectors.basePackage("bzu.lgx.bf"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(" ⌈滨纷⌋ RESTFUL API")
                .contact(new Contact("LGX",  "https://liuguoxing.top",  "2050180797@qq.com"))
                .version("1.0")
                .description("API 描述")
                .build();
    }
}
