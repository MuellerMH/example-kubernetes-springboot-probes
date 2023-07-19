package example.rest;

import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private final ApplicationAvailability availability;

    public HealthController(ApplicationAvailability availability) {
        this.availability = availability;
    }

    @GetMapping("/actuator/health/readiness")
    public String readiness() {
        if (availability.getReadinessState() == ReadinessState.ACCEPTING_TRAFFIC) {
            return "Readiness: Accepting Traffic";
        } else {
            return "Readiness: Not Ready";
        }
    }

    @GetMapping("/actuator/health/liveness")
    public String liveness() {
        if (availability.getLivenessState() == LivenessState.CORRECT) {
            return "Liveness: Correct";
        } else {
            return "Liveness: Incorrect";
        }
    }

    @GetMapping("/actuator/health/startup")
    public String startup() {
        if (availability.getReadinessState() == ReadinessState.ACCEPTING_TRAFFIC) {
            return "Startup: Application Started";
        } else {
            return "Startup: Application Not Started";
        }
    }
}