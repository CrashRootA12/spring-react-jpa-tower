package practice.vzn_tower_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class VznTowerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(VznTowerBackendApplication.class, args);
	}

}
@Configuration
class CORSConfiguration {
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer(){
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}
}
