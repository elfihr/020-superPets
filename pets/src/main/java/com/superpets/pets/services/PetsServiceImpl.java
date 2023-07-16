package com.superpets.pets.services;

import com.superpets.pets.model.PetsModel;
import com.superpets.pets.repository.PetsRepository;
import com.superpets.pets.shared.PetsDto;
import com.superpets.pets.shared.PetsListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetsServiceImpl implements PetsService{
    @Autowired
    private PetsRepository petsRepo;


    @Override
    public List<PetsListDto> pegarTodos() {
        return petsRepo.findAll()
                .stream()
                .map(p -> new PetsListDto(p.getId(), p.getNome(), p.getProcedimento()))
                .toList();
    }

    @Override
    public Optional<PetsDto> obterPorID(String id) {
        Optional<PetsModel> pet = petsRepo.findById(id);
        if (pet.isPresent()) {
            return Optional.of(new PetsDto(pet.get().getId(),
                    pet.get().getNome(),
                    pet.get().getRaça(),
                    pet.get().getDataNacimento(),
                    pet.get().isVacinação(),
                    pet.get().getProcedimento()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public PetsDto cadastrar(PetsDto dto) {
        PetsModel pet = new PetsModel(dto);
        petsRepo.save(pet);

        return new PetsDto(pet.getId(),
                pet.getNome(),
                pet.getRaça(),
                pet.getDataNacimento(),
                pet.isVacinação(),
                pet.getProcedimento());
    }


    @Override
    public PetsDto atualizarPorId(String id, PetsDto dto) {
        PetsModel pet = petsRepo.findById(id).orElse(null);

        if (pet != null) {
            PetsModel updatePet = new PetsModel(dto);
            updatePet.setId(id);
            petsRepo.save(updatePet);

            return new PetsDto(updatePet.getId(),
                    updatePet.getNome(),
                    updatePet.getRaça(),
                    updatePet.getDataNacimento(),
                    updatePet.isVacinação(),
                    updatePet.getProcedimento());
        }

        return null;
    }

    @Override
    public void deletarPorId(String id) {
        petsRepo.deleteById(id);
    }
}
