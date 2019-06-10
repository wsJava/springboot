package top.lvjp.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import top.lvjp.redis.interceptor.ApiIdempotentInterceptor;

/**
 * @author lvjp
 * @date 2019/6/9
 */
@Configuration
public class ApplicationConfig extends WebMvcConfigurationSupport {


    /**
     * 添加幂等性接口拦截器
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiIdempotentInterceptor());
        super.addInterceptors(registry);
    }

    @Bean
    public ApiIdempotentInterceptor apiIdempotentInterceptor(){
        return new ApiIdempotentInterceptor();
    }
}
