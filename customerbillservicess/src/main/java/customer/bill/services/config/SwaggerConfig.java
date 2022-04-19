package customer.bill.services.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration

class SpringConfig {
	
@Bean
public GroupedOpenApi publicApi() {
	
	return GroupedOpenApi
			.builder()
			.group("customer-bill-app")
			.packagesToScan("customer.bill.services")
			.pathsToMatch("/**").build();
}


  
}