package com.daniel.jobtrack.service;

// Importamos la entidad Company.
import com.daniel.jobtrack.entity.Company;

// Importamos el repositorio para poder usar los métodos de base de datos.
import com.daniel.jobtrack.repository.CompanyRepository;

// @Service indica que esta clase contiene lógica de negocio.
import org.springframework.stereotype.Service;

// Importamos List porque algunos métodos devolverán listas de empresas.
import java.util.List;

// @Service le dice a Spring que esta clase será administrada como un componente de servicio.
// Aquí colocamos la lógica antes de llegar a la base de datos.
@Service
public class CompanyService {

    // Declaramos una variable final del repositorio.
    // final significa que una vez asignado, no se puede cambiar.
    private final CompanyRepository companyRepository;

    // Constructor de la clase.
    // Spring usa este constructor para inyectar automáticamente CompanyRepository.
    //
    // A esto se le llama inyección de dependencias por constructor.
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // Método para obtener todas las empresas.
    // Devuelve una lista de objetos Company.
    public List<Company> getAllCompanies() {

        // findAll() viene heredado de JpaRepository.
        // Ejecuta una consulta similar a: SELECT * FROM company;
        return companyRepository.findAll();
    }

    // Método para buscar una empresa por su ID.
    public Company getCompanyById(Long id) {

        // findById(id) busca un registro por ID.
        // Devuelve un Optional porque puede existir o no existir.
        return companyRepository.findById(id)

                // Si no encuentra la empresa, lanza una excepción.
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));
    }

    // Método para crear una nueva empresa.
    public Company createCompany(Company company) {

        // save(company) guarda la empresa en la base de datos.
        // Si el objeto no tiene ID, JPA lo interpreta como un nuevo registro.
        return companyRepository.save(company);
    }

    // Método para actualizar una empresa existente.
    public Company updateCompany(Long id, Company companyDetails) {

        // Primero buscamos la empresa existente.
        // Si no existe, getCompanyById lanzará una excepción.
        Company company = getCompanyById(id);

        // Actualizamos los campos de la empresa existente
        // con los valores que llegaron en companyDetails.
        company.setName(companyDetails.getName());
        company.setSector(companyDetails.getSector());
        company.setLocation(companyDetails.getLocation());
        company.setWorkMode(companyDetails.getWorkMode());
        company.setWebsite(companyDetails.getWebsite());
        company.setNotes(companyDetails.getNotes());

        // Guardamos los cambios en la base de datos.
        // Como company ya tiene ID, JPA lo interpreta como actualización.
        return companyRepository.save(company);
    }

    // Método para eliminar una empresa por ID.
    public void deleteCompany(Long id) {

        // Primero buscamos la empresa.
        // Esto nos ayuda a validar que exista antes de eliminar.
        Company company = getCompanyById(id);

        // Eliminamos la empresa encontrada.
        companyRepository.delete(company);
    }
}