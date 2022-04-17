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
public class ModelAluno extends ModelPessoa{
    
    private int idAluno;
    private String matricula;

    public ModelAluno(String nome, String cpf) {
        super(nome, cpf);
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricvula) {
        this.matricula = matricvula;
    }
    
}
