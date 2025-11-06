package com.tecsup.petclinic.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tecsup.petclinic.entities.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
    List<Type> findByName(String name);
    List<Type> findByActive(Boolean active);
    List<Type> findBySizeCategory(String sizeCategory);
    List<Type> findByCareLevel(String careLevel);

    @Override
    List<Type> findAll();
}