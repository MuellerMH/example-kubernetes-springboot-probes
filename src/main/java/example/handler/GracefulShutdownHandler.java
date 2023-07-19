package example.handler;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class GracefulShutdownHandler {

        private final ApplicationContext context;
        private final Executor executor;

        private static volatile boolean shuttingDown = false;

        public GracefulShutdownHandler(ApplicationContext context, Executor executor) {
            this.context = context;
            this.executor = executor;
        }

        public void shutdown() {
            if (!shuttingDown) {
                shuttingDown = true;
                executor.execute(() -> {
                    // Führe hier die notwendigen Aufgaben für den Graceful Shutdown aus

                    // Zum Beispiel: Beende geöffnete Verbindungen, speichere den Zustand usw.

                    // Beende die Anwendung
                    SpringApplication.exit(context, () -> 0);
                });
            }
        }
    }