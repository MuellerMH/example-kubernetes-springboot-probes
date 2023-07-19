package example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.handler.GracefulShutdownHandler;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    GracefulShutdownHandler gracefulShutdownHandler;

    @GetMapping("/shutdown")
    public void initiateShutdown() {
        // Rufe den Graceful Shutdown Handler auf
        gracefulShutdownHandler.shutdown();
    }
}