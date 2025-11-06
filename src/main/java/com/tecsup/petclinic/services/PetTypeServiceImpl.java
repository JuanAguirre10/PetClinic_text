package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.PetType;
import com.tecsup.petclinic.repositories.PetTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetTypeServiceImpl implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeServiceImpl(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType savePetType(PetType type) {
        return petTypeRepository.save(type);
    }

    @Override
    public PetType findPetTypeById(Integer id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<PetType> findAllPetTypes() {
        return petTypeRepository.findAll();
    }

    @Override
    public void deletePetType(PetType type) {
        petTypeRepository.delete(type);
    }

    @Override
    public void deletePetTypeById(Integer id) {
        petTypeRepository.deleteById(id);
    }
}
