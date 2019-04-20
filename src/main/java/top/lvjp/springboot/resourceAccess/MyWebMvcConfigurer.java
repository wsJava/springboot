package top.lvjp.springboot.resourceAccess;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    /**
     * 添加静态资源文件位置映射
     * 默认静态资源文件位置为 classpath:/static/**
     * 引用内部文件使用 classpath:
     * 引用外部路径使用 file:
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        /image/** 为访问路径, D:/xxx 为实际路径, 且可添加多个
        registry.addResourceHandler("/image/**").addResourceLocations("file:D:/mingliyuan/img/")
                .addResourceLocations("file:D:\\mingliyuan\\associationFile\\file\\video/");
    }

    /**
     * 设置默认首页
     * 相当于在 controller 中 @RequestMapping("/") ... return "index";
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
