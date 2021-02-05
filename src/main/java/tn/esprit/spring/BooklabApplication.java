package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class BooklabApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooklabApplication.class, args);
	}

}
