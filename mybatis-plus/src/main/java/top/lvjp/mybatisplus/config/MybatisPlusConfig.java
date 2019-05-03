package top.lvjp.mybatisplus.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import org.apache.catalina.mbeans.GlobalResourcesLifecycleListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lvjp
 * @date 2019/4/24
 */
@EnableTransactionManagement
@Configuration
@MapperScan("top.lvjp.mybatisplus.mapper")
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
}
