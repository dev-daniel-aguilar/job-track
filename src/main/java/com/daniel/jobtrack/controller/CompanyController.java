package com.daniel.jobtrack.controller;

// Importamos la entidad Company porque el controller recibirá y devolverá objetos Company.
import com.daniel.jobtrack.entity.Company;

// Importamos el servicio, que contiene la lógica de negocio.
import com.daniel.jobtrack.service.CompanyService;

// Importamos las anotaciones de Spring Web.
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Importamos List porque algunos endpoints devolverán listas de empresas.
import java.util.List;

// @RestController indica que esta clase será un controlador REST.
// Es decir, recibirá peticiones HTTP y devolverá respuestas.
@RestController

// @RequestMapping define la ruta base para todos los endpoints de esta clase.
// Todos los métodos empezarán con /api/companies.
@RequestMapping("/api/companies")
public class CompanyController {

    // Declaramos el servicio como dependencia.
    private final CompanyService companyService;

    // Constructor para inyectar CompanyService.
    // Spring se encarga de pasar automáticamente una instancia de CompanyService.
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    // Endpoint para obtener todas las empresas.
    //
    // Método HTTP: GET
    // URL: http://localhost:8080/api/companies
    @GetMapping
    public List<Company> getAllCompanies() {

        // Delegamos la lógica al servicio.
        return companyService.getAllCompanies();
    }

    // Endpoint para obtener una empresa por ID.
    //
    // Método HTTP: GET
    // URL: http://localhost:8080/api/companies/1
    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Long id) {

        // @PathVariable toma el valor que viene en la URL.
        // Por ejemplo, si la URL es /api/companies/1,
        // entonces id tendrá el valor 1.
        return companyService.getCompanyById(id);
    }

    // Endpoint para crear una nueva empresa.
    //
    // Método HTTP: POST
    // URL: http://localhost:8080/api/companies
    @PostMapping
    public Company createCompany(@RequestBody Company company) {

        // @RequestBody toma el JSON enviado en la petición
        // y lo convierte automáticamente en un objeto Company.
        return companyService.createCompany(company);
    }

    // Endpoint para actualizar una empresa existente.
    //
    // Método HTTP: PUT
    // URL: http://localhost:8080/api/companies/1
    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Long id, @RequestBody Company company) {

        // Recibimos el ID desde la URL y los nuevos datos desde el body.
        return companyService.updateCompany(id, company);
    }

    // Endpoint para eliminar una empresa.
    //
    // Método HTTP: DELETE
    // URL: http://localhost:8080/api/companies/1
    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id) {

        // Mandamos el ID al servicio para eliminar la empresa.
        companyService.deleteCompany(id);
    }
}