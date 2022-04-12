/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author 07166848960
 */
public class ModelProfessor extends ModelPessoa {
    
    private int idProfessor;
    private String nivelGraduacao;
    
    public ModelProfessor(String nomeEntrada, String cpfCnpjEntrada) {
        super(nomeEntrada,cpfCnpjEntrada);
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNivelGraduacao() {
        return nivelGraduacao;
    }

    public void setNivelGraduacao(String nivelGraduacao) {
        this.nivelGraduacao = nivelGraduacao;
    }
    
}
