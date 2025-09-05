package com.nt.configure;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nt.handler.ClientCheckinghandler;

@Component
public class MywebMVCconfigurer implements WebMvcConfigurer {
      
	@Override
      public void addInterceptors(InterceptorRegistry registry) {
    	 WebMvcConfigurer.super.addInterceptors(registry);
    	 
    	 registry.addInterceptor(new ClientCheckinghandler());
    	 
      }
}
