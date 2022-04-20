/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.InterfaceSocketConnection;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;

import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.SocketException;
import java.text.ParseException;
import java.util.ArrayList;
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

    final static String classePessoa = "1";
    final static String classeTurma = "2";
    final static String tipoAluno = "1";
    final static String tipoProfessor = "2";

    private static List<ModelTurma> turmas;

    static List<ModelTurma> getTurmas() {
        if (turmas == null) {
            turmas = new ArrayList<ModelTurma>();
        }
        return turmas;
    }

    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        ServerSocket server = new ServerSocket(90);
        while (true) {
            server.setReuseAddress(true);

            System.out.println("Aguardando conexao...");

            try (Socket conn = server.accept();) /* try-with  */ {
                String dadosStr = new String("");
                conn.setKeepAlive(true);
                conn.setSoTimeout(9999999);
                System.out.println("Conectado com: "
                        + conn.getInetAddress().getHostAddress());
                OutputStream out = conn.getOutputStream();
//            InputStream in = conn.getInputStream();
                DataInputStream input = new DataInputStream(conn.getInputStream());

                byte[] dados = new byte[1024];
//            int qtde = in.read(dados);

                if (input.available() > 0) {
                    String str = input.readUTF();
//                dadosStr = new String(dados, 0, qtde);
                    System.out.println(dadosStr);
//                qtde = in.read(dados);
                    dadosStr = str;
                }
                //            StringBuilder bobTheBuilder = new StringBuilder();
                //            String op = "INSERT";
                //            bobTheBuilder.append("INSERT;1;07166848960;CARLOS;RUA TESTE;1;11234212;DSD");
                String op = dadosStr.split(";")[0];
                switch (op) {
                    case "INSERT":
                        ModelPessoa pessoa = iserePessoa(dadosStr);
                        String[] strPes = {"Pessoa Inserida Com Sucesso!"};
                        System.out.println(pessoa.toString());
                        for (int i = 0; i < strPes.length; i++) {
                            Thread.sleep(1000);
                            out.write(strPes[i].getBytes());
                        }
                        break;
                    case "UPDATE":
                        ModelPessoa pes = alteraPessoa(dadosStr);
                            System.out.println(dadosStr);
                            String[] stPes = {"Pessoa Alterada com Sucesso!"};
                            System.out.println(pes.toString());
                            for (int i = 0; i < stPes.length; i++) {
                                Thread.sleep(1000);
                                out.write(stPes[i].getBytes());
                            }
                        break;
                    case "DELETE":
                        deletaPessoa(dadosStr);
                        break;
                    case "GET":
                        String[] aDados = dadosStr.split(";");
                        String cpf = aDados[2];
                        getPessoaByCpfCnpj(cpf);
                        break;
                    case "LIST":
                        String[] st = {getAllPessoas().toString()};
                        for (int i = 0; i < st.length; i++) {
                            Thread.sleep(1000);
                            out.write(st[i].getBytes());
                        }
                        break;
                }
            } catch (SocketException e) {
                e.printStackTrace();
            }
//        server.close();
        }
    }

    public static boolean deletaPessoa(String Dados) {
        String[] aDados = Dados.split(";");
        String cpf = aDados[2];
        for (ModelTurma turma : getTurmas()) {
            if (turma.deletePessoa(cpf)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Insere uma pessoa
     *
     * @param Dados
     */
    public static ModelPessoa alteraPessoa(String Dados) {
        String[] aDados = Dados.split(";");
        String op = aDados[0];
        String classe = aDados[1];
        String cpf = aDados[2];
        String nome = aDados[3];
        String endereco = aDados[4];
        String tipoPes = aDados[5];
        String matricula = "";
        String graduacao = "";
        String nomeTruma = aDados[7];

        if (tipoAluno.equals(tipoPes)) {
            matricula = aDados[6];
            ModelPessoa aluno = getPessoaByCpfCnpj(cpf);
            aluno.setNome(nome);
            aluno.setCpfCnpj(cpf);
            aluno.setEndereco(endereco);
            ((ModelAluno) aluno).setMatricula(matricula);
            ModelTurma turma = getTurmaByName(nomeTruma);
            turma.addAluno(((ModelAluno) aluno));
            return turma.getPessoaByCpfCnpj(cpf);
        } else if (tipoProfessor.equals(tipoPes)) {
            graduacao = aDados[6];
            ModelPessoa professor = getPessoaByCpfCnpj(cpf);
            professor.setNome(nome);
            professor.setCpfCnpj(cpf);
            professor.setEndereco(endereco);
            ((ModelProfessor) professor).setNivelGraduacao(graduacao);
            ModelTurma turma = getTurmaByName(nomeTruma);
            turma.setProfessor(((ModelProfessor) professor));
            return turma.getProfessor();
        }
        return null;

    }

    public static void addTurma(ModelTurma turma) {
        turmas.add(turma);
    }

    /**
     * Insere uma pessoa
     *
     * @param Dados
     */
    public static ModelPessoa iserePessoa(String Dados) {
        String[] aDados = Dados.split(";");
        String op = aDados[0];
        String classe = aDados[1];
        String cpf = aDados[2];
        String nome = aDados[3];
        String endereco = aDados[4];
        String tipoPes = aDados[5];
        String matricula = "";
        String graduacao = "";
        String nomeTruma = aDados[7];

        if (tipoAluno.equals(tipoPes)) {
            matricula = aDados[6];
            ModelAluno aluno = new ModelAluno(nome, cpf);
            aluno.setEndereco(endereco);
            aluno.setMatricula(nome);
            ModelTurma turma = getTurmaByName(nomeTruma);
            turma.addAluno(aluno);
            return turma.getPessoaByCpfCnpj(cpf);
        } else if (tipoProfessor.equals(tipoPes)) {
            graduacao = aDados[6];
            ModelProfessor professor = new ModelProfessor(nome, cpf);
            professor.setNivelGraduacao(graduacao);
            ModelTurma turma = getTurmaByName(nomeTruma);
            turma.setProfessor(professor);
            return turma.getProfessor();
        }
        return null;
    }

    /**
     * Retorna a turma correspondente ao nome ou insere uma nova
     *
     * @param nome
     * @return
     */
    public static ModelTurma getTurmaByName(String nome) {
        for (ModelTurma Turma : getTurmas()) {
            if (Turma.getDescricao().equals(nome)) {
                return Turma;
            }
        }
        ModelTurma newTurma = new ModelTurma(nome);
        addTurma(newTurma);
        return newTurma;
    }

    public static ModelPessoa getPessoaByCpfCnpj(String cpfCnpj) {
        for (ModelTurma Turma : getTurmas()) {
            ModelPessoa pes = (Turma.getPessoaByCpfCnpj(cpfCnpj));
            if (pes != null) {
                return pes;
            }
            return null;
        }
        return null;
    }

    public static StringBuilder getAllPessoas() {
        StringBuilder bobTheBuilder = new StringBuilder();
        for (ModelTurma Turma : getTurmas()) {
            bobTheBuilder.append(Turma.getListaPessoas() + "\n");
        }
        return bobTheBuilder;
    }
}
