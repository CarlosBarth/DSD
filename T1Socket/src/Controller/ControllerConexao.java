/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.InterfaceSocketConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;


import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.text.ParseException;
import java.util.List;
import java.util.Map.Entry;
import models.ModelAluno;
import models.ModelPessoa;
import models.ModelProfessor;
import models.ModelTurma;

/**
 *
 * @author 07166848960
 */
public class ControllerConexao extends InterfaceSocketConnection {
    final static String classePessoa      = "1";
    final static String classeTurma       = "2";
    final static String tipoAluno         = "1";
    final static String tipoProfessor     = "2";
    
    private static List <ModelTurma> turmas;
    
    public static void main(String[] args) throws IOException, ParseException {
        ServerSocket server = new ServerSocket(80);
        server.setReuseAddress(true);

        System.out.println("Aguardando conexao...");
        
        try (Socket conn = server.accept();) /* try-with  */ {
            conn.setKeepAlive(true);
            conn.setSoTimeout(99999);
            StringBuilder bobTheBuilder = new StringBuilder();
            System.out.println("Conectado com: "
                    + conn.getInetAddress().getHostAddress());
            OutputStream out = conn.getOutputStream();
            InputStream inputStreamObject =  conn.getInputStream();
           
            byte [] dados = new byte[1024];
            int qtde = inputStreamObject.read(dados);
            
            while (qtde >= 0) {
                // Deverá vir um Json
                String dadosStr = new String(dados, 6, qtde);
                System.out.println(dadosStr);
                qtde = inputStreamObject.read(dados);
                bobTheBuilder.append(dados);
            }
            String op = bobTheBuilder.toString().split(";")[0];
            String classe = bobTheBuilder.toString().split(";")[0];
            switch (op) {
                case "INSERT":
                    iserePessoa(bobTheBuilder.toString());
                    break;
                case "UPDATE":
                    iserePessoa(bobTheBuilder.toString());
                    break;
            }
        }
    }
    
    public static void iserePessoa(String Dados) {
        String[] aDados     = Dados.split(";");
        String op           = aDados[0];
        String classe       = aDados[1];
        String cpf          = aDados[2];
        String nome         = aDados[3];
        String endereco     = aDados[4];
        String tipoPes      = aDados[5];
        String matricula    = "";
        String graduacao    = "";
        String nomeTruma    = aDados[7]; 
        
        if (tipoPes == tipoAluno) {
            matricula = aDados[6];
            ModelAluno aluno = new ModelAluno(nome, cpf);
            aluno.setEndereco(endereco);
            aluno.setMatricula(nome);
            ModelTurma turma = getTurmaByName(nomeTruma);
            turma.addAluno(aluno);
        } else {
            graduacao = aDados[6];
            ModelProfessor professor = new ModelProfessor(nome, cpf);
            professor.setNivelGraduacao(graduacao);
            ModelTurma turma = getTurmaByName(nomeTruma);
            turma.setProfessor(professor);
        }
    }
    
    public static ModelTurma getTurmaByName(String nome) {
        for (ModelTurma Turma : turmas) {
            if (Turma.getDescricao() == nome) {
                return Turma;
            }
            return new ModelTurma(nome);
        }
        return null;
    }
}
