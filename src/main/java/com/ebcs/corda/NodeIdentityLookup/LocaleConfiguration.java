package com.ebcs.corda.NodeIdentityLookup;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class LocaleConfiguration implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/dist/index.html");
        registry.addViewController("dist/").setViewName("forward:/dist/index.html");
        registry.addViewController("dist/login").setViewName("forward:/dist/index.html");
        registry.addViewController("dist/home").setViewName("forward:/dist/index.html");
        registry.addViewController("dist/dollarCapSettings").setViewName("forward:/dist/index.html");
        registry.addViewController("dist/{spring:[a-zA-Z0-9_-]+}").setViewName("forward:/dist/index.html");
        registry.addViewController("dist/{spring:[a-zA-Z0-9_-]+}/{spring:[a-zA-Z0-9_-]+}").setViewName("forward:/dist/index.html");
    }
}