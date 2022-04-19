/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author 07166848960
 */
public class ModelTurma {
    
    private int idTurma;
    private String descricao;
    private int qtdAlunos;
    private int ano;
    private static List<ModelAluno> alunos;
    private static ModelProfessor Professor;

    public ModelTurma(String descricaoEntrada) {
        descricao = descricaoEntrada;
        ano = Calendar.getInstance().get(Calendar.YEAR);
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunos(int qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public void addAluno(ModelAluno aluno) {
        alunos.add(aluno);
    }
    
    public void setProfessor(ModelProfessor professor) {
        Professor = professor;
    }
    
    public static ModelPessoa getProfessor() {
        return Professor;
    }
    
    public static List<ModelAluno> getAlunos() {
        return alunos;
    }
    
    public static ModelPessoa getPessoaByCpfCnpj(String cpfCnpj) {
        if (getProfessor() != null && Professor.getCpfCnpj() == cpfCnpj) {
            return getProfessor();
        } else {
            for (ModelAluno aluno : getAlunos()) {
                if (aluno.getCpfCnpj() == cpfCnpj) {
                    return aluno;
                }
            }
        }
        return null;
    }

    public boolean deletePessoa(String cpfCnpj) {
        if (getProfessor() != null && Professor.getCpfCnpj() == cpfCnpj) {
            Professor = null;
            return true;
        } else {
            for (ModelAluno aluno : getAlunos()) {
                if (aluno.getCpfCnpj() == cpfCnpj) {
                    alunos.remove(aluno);
                    return true;
                }
            }
        }
        return false;
    }
}
