package com.example.demo;

import com.example.demo.netty.server.ChattingServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootWebApplication  {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebApplication.class, args);

    }

//    @Override
//    public void run(String... args) throws Exception {
//        ChattingServer cs= new ChattingServer();
//        cs.startServer();
//    }
}
