package example;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import example.factory.GracefulThreadFactory;
import example.handler.GracefulShutdownHandler;

@SpringBootApplication
public class Example {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Example.class, args);

        // Fange das SIGTERM-Signal ab und führe den Graceful Shutdown durch
        GracefulShutdownHandler shutdownHandler = context.getBean(GracefulShutdownHandler.class);
        Runtime.getRuntime().addShutdownHook(new Thread(shutdownHandler::shutdown));

    }

    @Bean
    public GracefulShutdownHandler gracefulShutdownHandler(ApplicationContext context) {
        Executor executor = Executors.newSingleThreadExecutor(new GracefulThreadFactory());
        return new GracefulShutdownHandler(context, executor);
    }




}