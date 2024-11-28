package org.koreait.global.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(FileProperties.class)
public class FileUploadConfig implements WebMvcConfigurer {
    private final FileProperties properties;

    /*@Value("${file.upload.path}")
    private String filePath;

    @Value("${file.upload.url}")
    private String fileUrl;*/

/*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(fileUrl + "**")
                .addResourceLocations("file:///" + filePath);
    }*/


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(properties.getUrl() + "**")
                .addResourceLocations("file:///" + properties.getPath());

    }
}
