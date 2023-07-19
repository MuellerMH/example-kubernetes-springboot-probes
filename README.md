# Spring Boot App mit Kubernetes Proben

Dieses Repository enthält eine Beispiel-Konfiguration für eine Spring Boot-Anwendung, die Liveness, Readiness und Startup-Proben in Kubernetes verwendet.
Zudem wurde ein Gracefule Shutdown implementiert um die Applikation sauber herunterzufahren.

## Autoren

- [Manuel Engelhardt](https://github.com/muellermh) - [MHM Digitale Lösungen](https://itdevops.de)

## Contributors

- [Manuel Engelhardt](https://github.com/muellermh)

## Kubernetes-Konfiguration

Die Kubernetes-Konfiguration (`deployment.yml`) definiert ein Kubernetes Deployment für die Spring Boot-Anwendung. Der Container in der Pod-Spezifikation enthält die Konfiguration für die Liveness, Readiness und Startup-Proben. Stelle sicher, dass du das Docker-Image in der Konfiguration mit deinem eigenen Image und Tag ersetzt.

Verwende die folgenden Befehle, um die Spring Boot-Anwendung mit Kubernetes zu deployen:

```shell
kubectl apply -f deployment.yml
```

## Spring Boot-Anwendung
Die Spring Boot-Anwendung (SpringBootApp.java) enthält den REST-Controller mit den Endpunkten für die Liveness, Readiness und Startup-Proben. Die Endpunkte geben den Status der Anwendung basierend auf der ApplicationAvailability zurück.

Führe die folgenden Schritte aus, um die Spring Boot-Anwendung lokal auszuführen:

Stelle sicher, dass du Java Development Kit (JDK) installiert hast (empfohlen: JDK 11 oder höher).
Führe den folgenden Befehl aus, um die Anwendung zu kompilieren und auszuführen:
shell
```shell
./mvnw spring-boot:run
```

Die Anwendung wird auf http://localhost:8080 gestartet. Du kannst die Endpunkte wie folgt aufrufen:

Liveness: http://localhost:8080/actuator/health/liveness
Readiness: http://localhost:8080/actuator/health/readiness
Startup: http://localhost:8080/actuator/health/startup

## Erforderliche Abhängigkeiten
Die Spring Boot-Anwendung erfordert die folgenden Abhängigkeiten, die in der pom.xml-Datei konfiguriert sind:

spring-boot-starter-web: Ermöglicht die Erstellung von RESTful Web Services.
spring-boot-starter-actuator: Ermöglicht den Zugriff auf die Health-Endpunkte und die Konfiguration der Proben.

## Weitere Informationen
Weitere Informationen zu Kubernetes Probes und Spring Boot Actuator findest du in den offiziellen Dokumentationen:

Kubernetes Probes: [Kubernetes Documentation](https://kubernetes.io/docs/tasks/configure-pod-container/configure-liveness-readiness-startup-probes/)
Spring Boot Actuator: [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)