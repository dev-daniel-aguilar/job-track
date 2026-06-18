package com.daniel.jobtrack.entity;

// Importamos las anotaciones de JPA para mapear esta clase a una tabla.
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// Importamos Lombok para generar getters y setters automáticamente.
import lombok.Getter;
import lombok.Setter;

// @Entity indica que esta clase representa una tabla en la base de datos.
// JPA creará o usará una tabla llamada job_vacancy.
@Entity
@Getter
@Setter
public class JobVacancy {

    // Llave primaria de la tabla job_vacancy.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Título de la vacante.
    // Ejemplo: "Backend Java Jr", "Full Stack Developer Jr".
    private String title;

    // Descripción general de la vacante.
    // Usamos length = 2000 para permitir textos más amplios.
    @Column(length = 2000)
    private String description;


    private String level;
    private String workMode;
    private String location;
    private String salaryRange;

    // Tecnologías principales solicitadas.
    // Ejemplo: "Java, Spring Boot, MySQL, Git".
    @Column(length = 1000)
    private String requiredTechnologies;

    private String publicationUrl;

    // Relación muchos a uno:
    // Muchas vacantes pueden pertenecer a una empresa.
    //
    // FetchType.LAZY significa que la empresa relacionada se carga solo cuando se necesita.
    // Esto ayuda a evitar consultas innecesarias.
    @ManyToOne(fetch = FetchType.LAZY)

    // @JoinColumn define la columna de llave foránea en la tabla job_vacancy.
    // En la base de datos se creará una columna company_id.
    @JoinColumn(name = "company_id")
    private Company company;
}