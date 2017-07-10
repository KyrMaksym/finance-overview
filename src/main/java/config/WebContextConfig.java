package config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by Bsyvuliak on 08.05.2017.
 */


@Configuration
@EnableWebMvc
//@ComponentScan({"config"})
@Import({CamelConfig.class})
public class WebContextConfig extends WebMvcConfigurerAdapter {

/*
   @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }*/

    @Bean

    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();// configure static content handler
    }

}
