package com.daniel.jobtrack.service;

// Importamos las entidades que usaremos.
import com.daniel.jobtrack.entity.Company;
import com.daniel.jobtrack.entity.JobVacancy;

// Importamos los repositorios necesarios.
import com.daniel.jobtrack.repository.CompanyRepository;
import com.daniel.jobtrack.repository.JobVacancyRepository;

// Importamos @Service para indicar que esta clase contiene lógica de negocio.
import org.springframework.stereotype.Service;

// Importamos List para devolver listas de vacantes.
import java.util.List;

@Service
public class JobVacancyService {

    // Repositorio de vacantes.
    private final JobVacancyRepository jobVacancyRepository;

    // Repositorio de empresas.
    // Lo necesitamos porque al crear una vacante debemos validar que la empresa exista.
    private final CompanyRepository companyRepository;

    // Constructor con inyección de dependencias.
    // Spring inyecta automáticamente ambos repositorios.
    public JobVacancyService(JobVacancyRepository jobVacancyRepository,
                             CompanyRepository companyRepository) {
        this.jobVacancyRepository = jobVacancyRepository;
        this.companyRepository = companyRepository;
    }

    // Obtiene todas las vacantes registradas.
    public List<JobVacancy> getAllJobVacancies() {
        return jobVacancyRepository.findAll();
    }

    // Busca una vacante por ID.
    public JobVacancy getJobVacancyById(Long id) {
        return jobVacancyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job vacancy not found with id: " + id));
    }

    // Crea una vacante asociada a una empresa.
    //
    // Recibimos:
    // - companyId: ID de la empresa a la que pertenece la vacante.
    // - jobVacancy: datos de la vacante.
    public JobVacancy createJobVacancy(Long companyId, JobVacancy jobVacancy) {

        // Primero buscamos la empresa.
        // Si no existe, lanzamos una excepción.
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + companyId));

        // Asociamos la empresa encontrada a la vacante.
        jobVacancy.setCompany(company);

        // Guardamos la vacante en la base de datos.
        return jobVacancyRepository.save(jobVacancy);
    }

    // Actualiza una vacante existente.
    public JobVacancy updateJobVacancy(Long id, JobVacancy jobVacancyDetails) {

        // Primero buscamos la vacante existente.
        JobVacancy jobVacancy = getJobVacancyById(id);

        // Actualizamos los campos editables.
        jobVacancy.setTitle(jobVacancyDetails.getTitle());
        jobVacancy.setDescription(jobVacancyDetails.getDescription());
        jobVacancy.setLevel(jobVacancyDetails.getLevel());
        jobVacancy.setWorkMode(jobVacancyDetails.getWorkMode());
        jobVacancy.setLocation(jobVacancyDetails.getLocation());
        jobVacancy.setSalaryRange(jobVacancyDetails.getSalaryRange());
        jobVacancy.setRequiredTechnologies(jobVacancyDetails.getRequiredTechnologies());
        jobVacancy.setPublicationUrl(jobVacancyDetails.getPublicationUrl());

        // Guardamos los cambios.
        return jobVacancyRepository.save(jobVacancy);
    }

    // Elimina una vacante por ID.
    public void deleteJobVacancy(Long id) {

        // Primero validamos que exista.
        JobVacancy jobVacancy = getJobVacancyById(id);

        // Después eliminamos.
        jobVacancyRepository.delete(jobVacancy);
    }
}