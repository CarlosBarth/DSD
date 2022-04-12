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

//import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.text.ParseException;
import java.util.List;
import java.util.Map.Entry;
import models.ModelPessoa;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

/**
 *
 * @author 07166848960
 */
public class ControllerConexao extends InterfaceSocketConnection {
    final String classePessoa      = "1";
    final String classeTurma       = "2";
    final String tipoProfessor     = "1";
    final String tipoAluno         = "2";
    
    private List <ModelPessoa> Pessoas;
    
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
            
//            for (byte b : dadosStr) {
//                out.write(b);
//            }
        }
    }
    
    public void iserePessoa(String Dados) {
        String[] aDados = Dados.split(";");
        String op       = aDados[0];
        String classe   = aDados[1];
        String cpf      = aDados[2];
        String nome     = aDados[3];
        String endereco = aDados[4];
        String tipoPes  = aDados[5];
        String matricula= "";
        String graduacao= "";
        
        if (aDados[5] == this.tipoAluno) {
            matricula = aDados[6];
        } else {
            graduacao = aDados[6];
        }
//        String classe = "ModelPessoa";
        ModelPessoa pessoa = new ModelPessoa();
        Dados.substring(0);
    }
}
