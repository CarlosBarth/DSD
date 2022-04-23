/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Dao;
import Operations.FactoryOperation;
import Operations.Operation;

/**
 *
 * @author Barth
 */
public class IniSet {
    
    private static StringBuilder str = new StringBuilder();
    
    public static void inicialyzeData() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        setIniData("INSERT;Aluno;07166848960;CARLOS;RUA TESTE;11234212");
        setIniData("INSERT;Aluno;45685752136;Dailon;RUA TESTE 3;12355");
        setIniData("INSERT;Professor;45896258741;Fernando;RUA TESTE 2;Doutorado");
        setIniData("INSERT;Turma;DSD");
        setIniData("INSERT;Aluno;07166848960;1");
        setIniData("INSERT;Aluno;45685752136;1");
        setIniData("INSERT;Professor;45896258741;1");
        setIniData("UPDATE;Aluno;07166848960;Carlos Barth;Rua Francisco AX;000001;");
        setIniData("UPDATE;Professor;45896258741;Fernando;Rua alterada;Doutor;");
        setIniData("UPDATE;Turma;1;Sistemas Paralelos e Distribuidos");
        setIniData("GET;Pessoa;07166848960");
        setIniData("GET;Turma;1");
//        setIniData("DELETE;Pessoa;07166848960");
//        setIniData("GET;Turma;1");
//        setIniData("DELETE;Turma;1");
//        setIniData("DELETE;Aluno;07166848960;1");
//        setIniData("DELETE;Professor;45896258741;1");
        setIniData("GET;Turma;1");
        setIniData("LIST;Professor");
        setIniData("LIST;Aluno");
        setIniData("LIST;Turma");
//        setIniData();

        System.out.println(str);
//        System.out.println(Dao.getInstance().getTurma(1).toString());

    }
    
    public static void setIniData(String dados) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        FactoryOperation factory = new FactoryOperation();
        Operation op = factory.getOperation(dados.split(";"));
        op.execute();
        str.append(op.getMessage()[0]+ "\n"+ "\n");
//        str.append(op.getMessage().toString() + "\n");
    }
}
