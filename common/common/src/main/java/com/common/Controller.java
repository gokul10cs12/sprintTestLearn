package com.common;

import com.common.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/user-details")
public class Controller {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Value("${employee.url}")
    String employeeUrl;
    @Value("${salary.url}")
    String salaryUrl;

    @GetMapping("/{id}")
    public Person getDetails(@PathVariable("id") String id){
        Person person= new Person();

        WebClient webClient = WebClient.create("https:test.com");


//        CompletableFuture.allOf(
//                CompletableFuture.supplyAsync(() ->  restTemplate.exchange(employeeUrl + id, HttpMethod.GET, null, String.class))
//                        .thenAccept(name -> person.setName(name.getBody())),
//
//                CompletableFuture.supplyAsync(() ->  restTemplate.exchange(salaryUrl + id, HttpMethod.GET, null, String.class))
//                        .thenAccept((salary) -> person.setSalary(salary.getBody()))
//        ).join();
    restTemplate.exchange(employeeUrl + id , HttpMethod.GET, null, String.class);

    restTemplate.exchange(employeeUrl+ id, HttpMethod.GET, null, String.class);
      String name=  webClientBuilder.build()
                .get()
                .uri(employeeUrl + id)
                .retrieve()
                .bodyToMono(String.class)
                .block();
      person.setName(name);

        String salary =  webClientBuilder.build()
                .get()
                .uri(salaryUrl + id)
                .retrieve() // fetch
                .bodyToMono(String.class) // covert the body part to an instance of String/any defined type.
                .block();



        person.setSalary(salary);



       return person;



    }
}
