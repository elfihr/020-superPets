package com.superpets.pets.shared;

import java.util.List;

public record PetsListDto (String id, String nome, List<String> procedimento){
}
