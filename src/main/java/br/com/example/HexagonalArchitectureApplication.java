package br.com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;

import br.com.example.util.CustomJacksonObjectMapper;

@SpringBootApplication
public class HexagonalArchitectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalArchitectureApplication.class, args);
	}
	
    @Bean
    public ObjectMapper jacksonObjectMapper() {
        return new CustomJacksonObjectMapper();
    }

    @Bean
    public SerializationConfig serializationConfig() {
        return jacksonObjectMapper().getSerializationConfig();
    }
    
    @Bean
    public RestTemplate restTemplate() {
    	return new RestTemplate();
    }
	
}
