package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.PetType;
import java.util.List;

public interface PetTypeService {

    PetType savePetType(PetType type);

    PetType findPetTypeById(Integer id);

    List<PetType> findAllPetTypes();

    void deletePetType(PetType type);

    void deletePetTypeById(Integer id);
}
