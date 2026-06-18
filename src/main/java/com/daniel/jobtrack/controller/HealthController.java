package com.daniel.jobtrack.controller;

// Importamos las anotaciones necesarias de Spring Web
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Indicamos que esta clase será un controlador REST
@RestController
public class HealthController {

    // Indicamos que este método responderá a peticiones GET en /api/health
    @GetMapping("/api/health")
    public String healthCheck() {

        // Respuesta que verá el usuario, navegador o Postman
        return "JobTrack API is running";
    }
}