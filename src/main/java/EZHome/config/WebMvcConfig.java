package EZHome.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

<<<<<<< HEAD
/*
WebMvcConfigurer
    스프링 MVC를 위하여 자바 기반의 구성설정을 도와주는 유틸리티 인터페이스

 @Configuration : Configuration 어노테이션을 작성하면 설정파일의 객체를 생성해준다. = 설정 파일로 하겠다는 뜻.


*/

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${uploadPath}") // from application.properties
    String uploadPath; // 이 안에 uploadPath 경로가 담깁니다.

    @Override // 이 메소드는 정적자원(images, js and css)들을 서비스 해주기 위한 기능을 수행합니다.
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        // "/images"로 시작하는 요청이 들어오는 경우 uploadPath에 설정된 폴더를 기준으로 읽어들이겟습니다.
        registry.addResourceHandler("/images/**")
                .addResourceLocations(uploadPath); // 내컴퓨터에서 저장된파일을 읽어들일 ROOT 경로를 지정
=======
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${uploadPath}")
    String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/images/**").addResourceLocations(uploadPath);
>>>>>>> 1165e2ed5b4c1ee3c1aab0b8157f5ae81385c2a7
    }
}
