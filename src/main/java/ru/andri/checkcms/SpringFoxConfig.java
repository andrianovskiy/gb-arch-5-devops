package ru.andri.checkcms;

import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
@RequiredArgsConstructor
public class SpringFoxConfig {

    @Value(value = "${build.version:1.0-SNAPSHOT}")
    private String buildVersion;

    private static final String TITLE = "Check CMS";
    private static final String DESCRIPTION = "Api Documentation";
    private static final String TERMS_OF_SERVICE_URL = "urn:tos";
    private static final String LICENSE = "Apache 2.0";
    private static final String LICENSE_URL = "http://www.apache.org/licenses/LICENSE-2.0";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.andri.checkcms.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(
                        new ApiInfo(
                                TITLE,
                                DESCRIPTION,
                                buildVersion,
                                TERMS_OF_SERVICE_URL,
                                ApiInfo.DEFAULT_CONTACT,
                                LICENSE,
                                LICENSE_URL,
                                Collections.emptyList()));
    }
}
