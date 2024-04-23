package com.recorded.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.recorded.common.constants.Constants;
import com.recorded.common.interceptor.CheckLoginSessionInterceptor;

@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer{
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(Constants.UPLOADED_RESSOURCE_HANDLER)
                .addResourceLocations(Constants.UPLOADED_RESSOURCE_LOCATIONS);
        
    }
    
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new CheckLoginSessionInterceptor()) //LoginCheckInterceptor 등록
//				.order(2)
				//어드민 페이지 락 걸기 
				.addPathPatterns("/*/*/*/*orders*")
				.excludePathPatterns(
//						"/resources/**",
						"/adm/**"
//						"/adm/infra/v1/register",
//						"/adm/infra/v1/loginAdm",
//						"/adm/infra/v1/account-details",
//						"/adm/infra/v1/checkout",
//						"/adm/infra/v1/dashboard",
//						"/adm/infra/v1/order",
//						"/adm/infra/v1/order-details"
//						"/v1/infra/member/signoutXdmProc"
//						"/v1/infra/index/indexXdmView"
//						"/members/add", 
//						"/login", 
//						"/logout", 
				)
		;
	}
    
}

