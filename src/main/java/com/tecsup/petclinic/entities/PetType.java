package com.tecsup.petclinic.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad que representa un tipo de mascota (Pet Type)
 * Tabla: types
 *
 * @author Juan - CASO 5
 */
@Entity
@Table(name = "types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "size_category", length = 20)
    private String sizeCategory;

    @Column(name = "average_lifespan")
    private Integer averageLifespan;

    @Column(name = "care_level", length = 20)
    private String careLevel;

    /**
     * Constructor simplificado para pruebas básicas
     */
    public PetType(String name) {
        this.name = name;
        this.active = true;
    }
}