package bzu.lgx.bf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-09 09:33
 * @Description:
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-28 16:48
     * @Params: registry
     * @Return: void
     * @Description: 跨域配置
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry
            // 允许跨域访问的路径
            .addMapping("/**")
            // 允许跨域访问的源
            .allowedOrigins("*")
            // 允许请求方法
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            // 预检间隔时间
            .maxAge(168000)
            // 允许头部设置
            .allowedHeaders("*")
            // 是否发送cookie
            .allowCredentials(true);
    }

    @Override
    public  void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }


}
