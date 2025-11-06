/**
 * Test para buscar un tipo de mascota por ID
 * Autor: Matias
 * Verifica que:
 * - Se puede encontrar un tipo existente
 * - Los datos recuperados son correctos
 */
@Test
public void testFindTypeById() {
    // Given - Crear un tipo
    PetType type = new PetType();
    type.setName("Gato");
    petTypeService.savePetType(type);
    Integer typeId = type.getId();
    
    // When - Buscar el tipo por ID
    PetType foundType = petTypeService.findPetTypeById(typeId);
    
    // Then - Verificar que se encontró correctamente
    assertNotNull(foundType, "El tipo debe encontrarse");
    assertEquals(typeId, foundType.getId(), "El ID debe coincidir");
    assertEquals("Gato", foundType.getName(), "El nombre debe coincidir");
}

/**
 * Test para listar todos los tipos de mascotas
 * Autor: Matias
 * Verifica que:
 * - Se recuperan todos los tipos
 * - La lista no está vacía
 * - Incluye los tipos creados
 */
@Test
public void testFindAllTypes() {
    // Given - Crear varios tipos
    PetType type1 = new PetType();
    type1.setName("Loro");
    petTypeService.savePetType(type1);
    
    PetType type2 = new PetType();
    type2.setName("Conejo");
    petTypeService.savePetType(type2);
    
    // When - Obtener todos los tipos
    Collection<PetType> allTypes = petTypeService.findAllPetTypes();
    
    // Then - Verificar los resultados
    assertNotNull(allTypes, "La lista de tipos no debe ser nula");
    assertTrue(allTypes.size() >= 2, "Debe haber al menos 2 tipos");
    
    // Verificar que los tipos creados están en la lista
    boolean hasLoro = allTypes.stream()
        .anyMatch(t -> "Loro".equals(t.getName()));
    boolean hasConejo = allTypes.stream()
        .anyMatch(t -> "Conejo".equals(t.getName()));
    
    assertTrue(hasLoro, "La lista debe contener 'Loro'");
    assertTrue(hasConejo, "La lista debe contener 'Conejo'");
}

/**
 * Test para buscar un tipo que no existe
 * Autor: Matias
 * Verifica el manejo de casos no encontrados
 */
@Test
public void testFindTypeByIdNotFound() {
    // When - Buscar un ID que no existe
    PetType foundType = petTypeService.findPetTypeById(99999);
    
    // Then - Verificar que retorna null o lanza excepción según la implementación
    assertNull(foundType, "Debe retornar null cuando el tipo no existe");
}