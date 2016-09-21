package cn.org.citycloud.zwhs.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan(basePackages={"cn.org.citycloud.zwhs.controller"})
public class CommonSwaggerConfig
{

	@Bean
    public Docket swaggerSpringMvcPlugin(){
    	// ApiInfo
    	ApiInfo apiInfo = new ApiInfo(
    			"中物华商前台Restful API",
    			"中物华商前台Restful API",
    			"1.0",
    			"http://www.citycloud.org.cn/",
    			"Allen",
    			"CCDC",
    			"http://www.citycloud.org.cn/"
    			);
    	
    	Docket docket = new Docket(DocumentationType.SWAGGER_2)
    			.apiInfo(apiInfo);
    	
    	return docket;
    }
}
