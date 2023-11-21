package com.ll.sb20231114.global.webMvc;

import com.ll.sb20231114.global.interceptor.NeedToAdminInterceptor;
import com.ll.sb20231114.global.interceptor.NeedToLoginInterceptor;
import com.ll.sb20231114.global.interceptor.NeedToLogoutInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final NeedToLogoutInterceptor needToLogoutInterceptor;
    private final NeedToLoginInterceptor needToLoginInterceptor;
    private final NeedToAdminInterceptor needToAdminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(needToLogoutInterceptor)
                .addPathPatterns("/member/login")
                .addPathPatterns("/member/join")
                .addPathPatterns("/member/findUsername")
                .addPathPatterns("/member/findPassword");
        registry.addInterceptor(needToLoginInterceptor)
                .addPathPatterns("/adm/**");
        registry.addInterceptor(needToAdminInterceptor)
                .addPathPatterns("/adm/**");
    }
}