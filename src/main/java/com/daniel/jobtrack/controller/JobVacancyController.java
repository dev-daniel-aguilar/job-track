package com.daniel.jobtrack.controller;

// Importamos la entidad JobVacancy.
import com.daniel.jobtrack.entity.JobVacancy;

// Importamos el servicio de vacantes.
import com.daniel.jobtrack.service.JobVacancyService;

// Importamos anotaciones de Spring Web.
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Importamos List para devolver listas de vacantes.
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobVacancyController {

    // Dependencia del servicio.
    private final JobVacancyService jobVacancyService;

    // Constructor para inyectar el servicio.
    public JobVacancyController(JobVacancyService jobVacancyService) {
        this.jobVacancyService = jobVacancyService;
    }

    // Endpoint para listar todas las vacantes.
    //
    // Método: GET
    // URL: http://localhost:8080/api/jobs
    @GetMapping
    public List<JobVacancy> getAllJobVacancies() {
        return jobVacancyService.getAllJobVacancies();
    }

    // Endpoint para buscar una vacante por ID.
    //
    // Método: GET
    // URL: http://localhost:8080/api/jobs/1
    @GetMapping("/{id}")
    public JobVacancy getJobVacancyById(@PathVariable Long id) {
        return jobVacancyService.getJobVacancyById(id);
    }

    // Endpoint para crear una vacante asociada a una empresa.
    //
    // Método: POST
    // URL: http://localhost:8080/api/jobs/company/1
    //
    // En este ejemplo, el 1 representa el ID de la empresa.
    @PostMapping("/company/{companyId}")
    public JobVacancy createJobVacancy(@PathVariable Long companyId,
                                       @RequestBody JobVacancy jobVacancy) {
        return jobVacancyService.createJobVacancy(companyId, jobVacancy);
    }

    // Endpoint para actualizar una vacante.
    //
    // Método: PUT
    // URL: http://localhost:8080/api/jobs/1
    @PutMapping("/{id}")
    public JobVacancy updateJobVacancy(@PathVariable Long id,
                                       @RequestBody JobVacancy jobVacancy) {
        return jobVacancyService.updateJobVacancy(id, jobVacancy);
    }

    // Endpoint para eliminar una vacante.
    //
    // Método: DELETE
    // URL: http://localhost:8080/api/jobs/1
    @DeleteMapping("/{id}")
    public void deleteJobVacancy(@PathVariable Long id) {
        jobVacancyService.deleteJobVacancy(id);
    }
}