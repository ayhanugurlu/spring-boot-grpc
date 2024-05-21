package com.au.example.stubs;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    ApplicationRunner clientRunner(@GrpcClient("helloService") final SimpleGrpc.SimpleBlockingStub client) {
        return args -> {
            HelloReply helloReply = client.sayHello(HelloRequest.newBuilder().setName("Client App").build());
            System.out.println("Client is running "+helloReply.getMessage()) ;
        };
    }
}
