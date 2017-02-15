package cz.filmy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DatabazeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabazeApplication.class, args);
	}


}
