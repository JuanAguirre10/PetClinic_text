package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.PetType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TypeServiceTest {

    @Autowired
    private PetTypeService petTypeService;

    @Test
    public void testDeleteType() {
        PetType type = new PetType();
        type.setName("Tortuga");
        petTypeService.savePetType(type);
        Integer id = type.getId();

        assertNotNull(petTypeService.findPetTypeById(id));

        petTypeService.deletePetType(type);
        assertNull(petTypeService.findPetTypeById(id));
    }

    @Test
    public void testCompleteCRUDCycle() {

        PetType type = new PetType();
        type.setName("Pez");
        petTypeService.savePetType(type);
        Integer id = type.getId();

        assertEquals("Pez", petTypeService.findPetTypeById(id).getName());

        PetType updated = petTypeService.findPetTypeById(id);
        updated.setName("Pez Dorado");
        petTypeService.savePetType(updated);

        assertEquals("Pez Dorado", petTypeService.findPetTypeById(id).getName());

        petTypeService.deletePetType(updated);
        assertNull(petTypeService.findPetTypeById(id));
    }
}
