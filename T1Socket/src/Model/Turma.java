/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author 07166848960
 */
public class Turma extends Model{
    
    private int idTurma;
    private String descricao;
    private int qtdAlunos;
    private int ano;
    private static List<Aluno> alunos;
    private static Professor Professor;

    public Turma(String descricaoEntrada) {
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
    
    public void addAluno(Aluno aluno) {
        if (alunos == null) {
            alunos = new ArrayList<Aluno>();
        }
        alunos.add(aluno);
    }
    
    public void setProfessor(Professor professor) {
        Professor = professor;
    }
    
    public static Pessoa getProfessor() {
        return Professor;
    }
    
    public List<Aluno> getAlunos() {
        if (alunos == null) {
            alunos = new ArrayList<Aluno>();
        }
        return alunos;
    }
    
    public Pessoa getPessoaByCpfCnpj(String cpfCnpj) {
        if (getProfessor() != null && Professor.getCpf().equals(cpfCnpj)) {
            return getProfessor();
        } else {
            for (Aluno aluno : getAlunos()) {
                if (aluno.getCpf().equals(cpfCnpj)) {
                    return aluno;
                }
            }
        }
        return null;
    }

    public boolean deletePessoa(String cpfCnpj) {
        if (getProfessor() != null && Professor.getCpf().equals(cpfCnpj)) {
            Professor = null;
            return true;
        } else {
            for (Aluno aluno : getAlunos()) {
                if (aluno.getCpf().equals(cpfCnpj)) {
                    alunos.remove(aluno);
                    return true;
                }
            }
        }
        return false;
    }
    
    public String toString() {
        StringBuilder bobTheBuilder = new StringBuilder();
        bobTheBuilder.append("Turma:"+ "\n");
        bobTheBuilder.append(getDescricao()+ "\n");
        if (Professor != null) {
            bobTheBuilder.append("Professor" + "\n");
            bobTheBuilder.append(Professor.toString() + "\n");
        }
        if (alunos != null) {
            bobTheBuilder.append("Alunos: " + "\n");
        }
        for (Aluno aluno : getAlunos()) {
            bobTheBuilder.append(aluno.toString()+ "\n");
            bobTheBuilder.append("    ======================" + "\n");
        }
        bobTheBuilder.append("==========================" + "\n");
        return bobTheBuilder.toString();
    }

    @Override
    public int requiredArgs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
