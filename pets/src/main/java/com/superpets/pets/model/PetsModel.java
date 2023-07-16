package com.superpets.pets.model;

import com.superpets.pets.shared.PetsDto;
import org.springframework.data.annotation.Id;

import java.util.List;

public class PetsModel {
    @Id
    private String id;
    private String nome;
    private String raça;
    private int dataNacimento;
    private boolean vacinação;
    private List<String> procedimento;

    public PetsModel() {}

    public PetsModel(PetsDto dto) {
        this.id = dto.id();
        this.nome = dto.nome();
        this.raça = dto.raça();
        this.dataNacimento = dto.dataNascimento();
        this.vacinação = dto.vacinação();
        this.procedimento = dto.procedimento();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaça() {
        return raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

    public int getDataNacimento() {
        return dataNacimento;
    }

    public void setDataNacimento(int dataNacimento) {
        this.dataNacimento = dataNacimento;
    }

    public boolean isVacinação() {
        return vacinação;
    }

    public void setVacinação(boolean vacinação) {
        this.vacinação = vacinação;
    }

    public List<String> getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(List<String> procedimento) {
        this.procedimento = procedimento;
    }
}
