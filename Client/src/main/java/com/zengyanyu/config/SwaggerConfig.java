package com.zengyanyu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger配置类
 * 访问地址：http://localhost:8083/doc.html
 *
 * @author
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
                .groupName("曾衍育-所有API").pathMapping("/")
                .select()
                // API基础扫描路径
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(getGlobalParameters());// 添加全局参数
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger-api文档 曾衍育")
                .description("曾衍育")
                .version("1.0.0")
                .build();
    }

    /**
     * 添加Swagger的全局参数
     */
    private List<Parameter> getGlobalParameters() {
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new ParameterBuilder()
                .name("Authorization") // 请求头的名称
                .description("Token") // 描述信息
                .modelRef(new ModelRef("string")) // 类型，这里是string类型
                .parameterType("header") // 参数类型，这里是header类型
                .required(true) // 是否必填，这里设置为false，表示非必填，可以根据实际需求设置
                .build());
        return parameters;
    }

}
