package com.tecsup.petclinic.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "types")
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private Boolean active = true;
    private String size_category;
    private Integer average_lifespan;
    private String care_level;

    // Getters y setters
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Boolean getActive() { return active; }

    public void setActive(Boolean active) { this.active = active; }

    public String getSize_category() { return size_category; }

    public void setSize_category(String size_category) { this.size_category = size_category; }

    public Integer getAverage_lifespan() { return average_lifespan; }

    public void setAverage_lifespan(Integer average_lifespan) { this.average_lifespan = average_lifespan; }

    public String getCare_level() { return care_level; }

    public void setCare_level(String care_level) { this.care_level = care_level; }
}
