package com.daniel.jobtrack.repository;

// Importamos la entidad JobVacancy.
import com.daniel.jobtrack.entity.JobVacancy;

// Importamos JpaRepository para obtener métodos CRUD automáticamente.
import org.springframework.data.jpa.repository.JpaRepository;

// Este repositorio se encargará de las operaciones en base de datos
// relacionadas con JobVacancy.
//
// JpaRepository<JobVacancy, Long> significa:
// - JobVacancy: entidad principal del repositorio.
// - Long: tipo de dato del ID.
public interface JobVacancyRepository extends JpaRepository<JobVacancy, Long> {

}