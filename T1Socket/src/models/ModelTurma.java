/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author 07166848960
 */
public class ModelTurma {
    
    private int idTurma;
    private static String descricao;
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

    public static String getDescricao() {
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
        if (alunos == null) {
            alunos = new ArrayList<ModelAluno>();
        }
        alunos.add(aluno);
    }
    
    public void setProfessor(ModelProfessor professor) {
        Professor = professor;
    }
    
    public static ModelPessoa getProfessor() {
        return Professor;
    }
    
    public static List<ModelAluno> getAlunos() {
        if (alunos == null) {
            alunos = new ArrayList<ModelAluno>();
        }
        return alunos;
    }
    
    public static ModelPessoa getPessoaByCpfCnpj(String cpfCnpj) {
        if (getProfessor() != null && Professor.getCpfCnpj().equals(cpfCnpj)) {
            return getProfessor();
        } else {
            for (ModelAluno aluno : getAlunos()) {
                if (aluno.getCpfCnpj().equals(cpfCnpj)) {
                    return aluno;
                }
            }
        }
        return null;
    }

    public boolean deletePessoa(String cpfCnpj) {
        if (getProfessor() != null && Professor.getCpfCnpj().equals(cpfCnpj)) {
            Professor = null;
            return true;
        } else {
            for (ModelAluno aluno : getAlunos()) {
                if (aluno.getCpfCnpj().equals(cpfCnpj)) {
                    alunos.remove(aluno);
                    return true;
                }
            }
        }
        return false;
    }
    
    public static StringBuilder getListaPessoas() {
        StringBuilder bobTheBuilder = new StringBuilder();
        bobTheBuilder.append("Turma:"+ "\n");
        bobTheBuilder.append(getDescricao()+ "\n");
        for (ModelAluno aluno : getAlunos()) {
            if (Professor != null) {
                bobTheBuilder.append("Professor:"+ "\n");
                bobTheBuilder.append(Professor.getCpfCnpj()+ "\n");
                bobTheBuilder.append(Professor.getNome()+ "\n");
                bobTheBuilder.append(Professor.getEndereco()+ "\n");
                bobTheBuilder.append(Professor.getNivelGraduacao()+ "\n");
            }
            bobTheBuilder.append("Alunos"+ "\n");
            bobTheBuilder.append(aluno.getCpfCnpj()+ "\n");
            bobTheBuilder.append(aluno.getNome() + "\n");
            bobTheBuilder.append(aluno.getEndereco()+ "\n");
            bobTheBuilder.append(aluno.getMatricula()+ "\n");
        }
        return bobTheBuilder;
    }
    
}
