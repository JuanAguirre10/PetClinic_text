package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.*;
import com.tecsup.petclinic.dtos.TypeDTO;
import com.tecsup.petclinic.exceptions.TypeNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@SpringBootTest
@Slf4j
public class TypeServiceTest {

    @Autowired
    private TypeService typeService;

    @Test
    public void testFindTypeById() {
        String NAME_EXPECTED = "cat";
        Integer ID = 1;
        TypeDTO type = null;

        try {
            type = this.typeService.findById(ID);
        } catch (TypeNotFoundException e) {
            fail(e.getMessage());
        }

        log.info("Type found: " + type);
        assertEquals(NAME_EXPECTED, type.getName());
    }

    @Test
    public void testFindTypeByName() {
        String FIND_NAME = "dog";
        int SIZE_EXPECTED = 1;

        List<TypeDTO> types = this.typeService.findByName(FIND_NAME);

        log.info("Types found: " + types.size());
        assertEquals(SIZE_EXPECTED, types.size());
    }

    @Test
    public void testFindAllTypes() {
        int SIZE_EXPECTED = 8;

        List<TypeDTO> types = this.typeService.findAll();

        log.info("Total types found: " + types.size());
        assertEquals(SIZE_EXPECTED, types.size());
    }

    @Test
    public void testCreateType() {
        String TYPE_NAME = "guinea pig";
        String DESCRIPTION = "Small domestic rodent";
        Boolean ACTIVE = true;
        String SIZE_CATEGORY = "small";
        Integer AVG_LIFESPAN = 5;
        String CARE_LEVEL = "medium";

        TypeDTO typeDTO = TypeDTO.builder()
                .name(TYPE_NAME)
                .description(DESCRIPTION)
                .active(ACTIVE)
                .sizeCategory(SIZE_CATEGORY)
                .averageLifespan(AVG_LIFESPAN)
                .careLevel(CARE_LEVEL)
                .build();

        TypeDTO newTypeDTO = this.typeService.create(typeDTO);

        log.info("TYPE CREATED: " + newTypeDTO.toString());

        assertNotNull(newTypeDTO.getId());
        assertEquals(TYPE_NAME, newTypeDTO.getName());
        assertEquals(DESCRIPTION, newTypeDTO.getDescription());
        assertEquals(ACTIVE, newTypeDTO.getActive());
        assertEquals(SIZE_CATEGORY, newTypeDTO.getSizeCategory());
        assertEquals(AVG_LIFESPAN, newTypeDTO.getAverageLifespan());
        assertEquals(CARE_LEVEL, newTypeDTO.getCareLevel());
    }

    @Test
    public void testUpdateType() {
        String TYPE_NAME = "parrot";
        String DESCRIPTION = "Colorful bird";
        Boolean ACTIVE = true;
        String SIZE_CATEGORY = "small";
        Integer AVG_LIFESPAN = 20;
        String CARE_LEVEL = "high";

        String UP_TYPE_NAME = "parrot-updated";
        String UP_DESCRIPTION = "Very colorful bird";
        Boolean UP_ACTIVE = false;
        String UP_SIZE_CATEGORY = "medium";
        Integer UP_AVG_LIFESPAN = 25;
        String UP_CARE_LEVEL = "high";

        TypeDTO typeDTO = TypeDTO.builder()
                .name(TYPE_NAME)
                .description(DESCRIPTION)
                .active(ACTIVE)
                .sizeCategory(SIZE_CATEGORY)
                .averageLifespan(AVG_LIFESPAN)
                .careLevel(CARE_LEVEL)
                .build();

        log.info("Creating type: " + typeDTO);
        TypeDTO typeDTOCreated = this.typeService.create(typeDTO);
        log.info("Type created: " + typeDTOCreated);

        typeDTOCreated.setName(UP_TYPE_NAME);
        typeDTOCreated.setDescription(UP_DESCRIPTION);
        typeDTOCreated.setActive(UP_ACTIVE);
        typeDTOCreated.setSizeCategory(UP_SIZE_CATEGORY);
        typeDTOCreated.setAverageLifespan(UP_AVG_LIFESPAN);
        typeDTOCreated.setCareLevel(UP_CARE_LEVEL);

        TypeDTO upgradeTypeDTO = this.typeService.update(typeDTOCreated);
        log.info("Type updated: " + upgradeTypeDTO);

        assertEquals(UP_TYPE_NAME, upgradeTypeDTO.getName());
        assertEquals(UP_DESCRIPTION, upgradeTypeDTO.getDescription());
        assertEquals(UP_ACTIVE, upgradeTypeDTO.getActive());
        assertEquals(UP_SIZE_CATEGORY, upgradeTypeDTO.getSizeCategory());
        assertEquals(UP_AVG_LIFESPAN, upgradeTypeDTO.getAverageLifespan());
        assertEquals(UP_CARE_LEVEL, upgradeTypeDTO.getCareLevel());
    }

    @Test
    public void testDeleteType() {
        String TYPE_NAME = "ferret";
        String DESCRIPTION = "Playful mammal";
        Boolean ACTIVE = true;
        String SIZE_CATEGORY = "small";
        Integer AVG_LIFESPAN = 7;
        String CARE_LEVEL = "medium";

        TypeDTO typeDTO = TypeDTO.builder()
                .name(TYPE_NAME)
                .description(DESCRIPTION)
                .active(ACTIVE)
                .sizeCategory(SIZE_CATEGORY)
                .averageLifespan(AVG_LIFESPAN)
                .careLevel(CARE_LEVEL)
                .build();

        TypeDTO newTypeDTO = this.typeService.create(typeDTO);
        log.info("Type created for deletion: " + newTypeDTO);

        try {
            this.typeService.delete(newTypeDTO.getId());
            log.info("Type deleted with id: " + newTypeDTO.getId());
        } catch (TypeNotFoundException e) {
            fail(e.getMessage());
        }

        try {
            this.typeService.findById(newTypeDTO.getId());
            fail("Type should have been deleted");
        } catch (TypeNotFoundException e) {
            log.info("Validation successful: Type not found after deletion");
            assertTrue(true);
        }
    }

    @Test
    public void testFindTypesByActive() {
        Boolean ACTIVE = true;
        int SIZE_EXPECTED = 6;

        List<TypeDTO> types = this.typeService.findByActive(ACTIVE);

        log.info("Active types found: " + types.size());
        assertTrue(types.size() >= SIZE_EXPECTED);
    }
}