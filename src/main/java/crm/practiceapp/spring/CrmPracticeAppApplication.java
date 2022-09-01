package crm.practiceapp.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="crm.practiceapp.spring")
public class CrmPracticeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmPracticeAppApplication.class, args);
	}

}
