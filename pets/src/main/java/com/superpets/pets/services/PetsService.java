package com.superpets.pets.services;

import com.superpets.pets.shared.PetsDto;
import com.superpets.pets.shared.PetsListDto;

import java.util.List;
import java.util.Optional;

public interface PetsService {

    List<PetsListDto> pegarTodos();

    //NullPointerException e if != null
    Optional<PetsDto>  obterPorID(String id);

    PetsDto cadastrar(PetsDto dto);

    PetsDto atualizarPorId(String id,PetsDto pet);

    void deletarPorId(String id);

}
