package com.superpets.pets.shared;

import java.util.List;

public record PetsDto (String id,
                       String nome,
                       String raça,
                       int dataNascimento,
                       boolean vacinação,
                       List<String> procedimento) {
}
