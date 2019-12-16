package com.bluedon.config;

import com.bluedon.common.constants.CommonConstant;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @date: 2019/12/10 15:23
 * @author: hhong
 * @description: swagger2配置
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //此包路径下的类，才生成接口文档
                .apis(RequestHandlerSelectors.basePackage("com.bluedon.modules"))
                //加了ApiOperation注解的类，才生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Collections.singletonList(securityScheme()));
        //.globalOperationParameters(setHeaderToken());
    }

    private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name(CommonConstant.BD_REDIS_TOKEN_KEY).description(CommonConstant.BD_REDIS_TOKEN_KEY).modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }

    @Bean
    SecurityScheme securityScheme() {
        return new ApiKey(CommonConstant.BD_REDIS_TOKEN_KEY, CommonConstant.BD_REDIS_TOKEN_KEY, "header");
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //大标题
                .title("bluedon-api")
                // 版本号
                .version("1.0")
                // 描述
                .description("bluedon-api接口文档")
                // 作者
                .contact("研发中心-安全管控")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();

    }


}