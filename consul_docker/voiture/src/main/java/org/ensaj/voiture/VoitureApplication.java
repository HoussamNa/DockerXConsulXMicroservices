package org.ensaj.voiture;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class VoitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoitureApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate= new RestTemplate();
        SimpleClientHttpRequestFactory requestFactory=new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);
        restTemplate.setRequestFactory(requestFactory);

        return restTemplate;
    }
    /*@Bean
    CommandLineRunner commandLineRunner(CarRepository carRepository){
        return args ->{

            carRepository.save(Car.builder()
                    .brand("Maserati")
                    .model("Ribel")
                    .matricule("911|D|26")
                    .client_id(1L)
                    .build());
            carRepository.save(Car.builder()
                    .brand("G63s")
                    .model("Mercedes")
                    .matricule("1|D|26")
                    .client_id(2L)
                    .build());

        };
    }*/
}
