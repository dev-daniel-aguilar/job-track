package com.daniel.jobtrack.entity;

// Importamos las anotaciones de JPA.
// JPA nos permite mapear una clase Java como una tabla en la base de datos.
import jakarta.persistence.*;
// Importamos Lombok para generar automáticamente getters y setters.
// Así evitamos escribir manualmente getName(), setName(), etc.
import lombok.Getter;
import lombok.Setter;

// @Entity indica que esta clase representa una tabla en la base de datos.
// En este caso, JPA creará o usará una tabla llamada company.
@Entity
// @Getter genera automáticamente los métodos get para todos los atributos.
@Getter
// @Setter genera automáticamente los métodos set para todos los atributos.
@Setter
public class Company {

    // @Id indica que este campo será la llave primaria de la tabla.
    @Id

    // @GeneratedValue indica que el valor del ID será generado automáticamente.
    // GenerationType.IDENTITY le dice a MySQL que use auto_increment.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String sector;
    private String location;
    private String workMode;
    private String website;

    // Notas adicionales sobre la empresa.
    // @Column(length = 1000) permite que este campo guarde textos más largos.
    // Si no lo ponemos, JPA puede usar un tamaño más limitado por defecto.
    @Column(length = 1000)
    private String notes;
}