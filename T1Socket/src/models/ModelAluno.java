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
    private int idAluno2;
    private String matricvula;
    
    public void ModelAuno(String nomeEntrada, String cpfCnpjEntrada) {
        super.ModelPessoa(nomeEntrada, cpfCnpjEntrada);
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getMatricvula() {
        return matricvula;
    }

    public void setMatricvula(String matricvula) {
        this.matricvula = matricvula;
    }
    
}
