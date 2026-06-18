package com.daniel.jobtrack.repository;

// Importamos la entidad Company porque este repositorio trabajará con esa clase.
import com.daniel.jobtrack.entity.Company;

// JpaRepository es una interfaz de Spring Data JPA.
// Nos da métodos listos para hacer CRUD sin escribir SQL manual.
import org.springframework.data.jpa.repository.JpaRepository;

// Esta interfaz se encarga de comunicarse con la base de datos para la entidad Company.
//
// JpaRepository<Company, Long> significa:
// - Company: la entidad con la que va a trabajar.
// - Long: el tipo de dato del ID de Company.
public interface CompanyRepository extends JpaRepository<Company, Long> {

    // Aunque esta interfaz está vacía, ya hereda métodos como:
    //
    // findAll()       -> obtiene todos los registros
    // findById(id)    -> busca un registro por ID
    // save(company)   -> guarda o actualiza un registro
    // delete(company) -> elimina un registro
    // existsById(id)  -> valida si existe un registro por ID
}