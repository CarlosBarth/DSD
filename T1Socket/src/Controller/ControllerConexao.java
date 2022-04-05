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

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.util.Map.Entry;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author 07166848960
 */
public class ControllerConexao extends InterfaceSocketConnection {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();

        FileWriter writeFile = null;

        //Armazena dados em um Objeto JSON
        jsonObject.put("nome", "Allan");
        jsonObject.put("sobrenome", "Romanato");
        jsonObject.put("pais", "Brasil");
        jsonObject.put("estado", "SP");

//		try{
//			writeFile = new FileWriter("saida.json");
//			//Escreve no arquivo conteudo do Objeto JSON
//			writeFile.write(jsonObject.toJSONString());
//			writeFile.close();
//		}
//		catch(IOException e){
//			e.printStackTrace();
//		}
        //Imprimne na Tela o Objeto JSON para vizualização
        System.out.println(jsonObject.get("nome"));
    }

    public void teste() throws IOException, ParseException {
        ServerSocket server = new ServerSocket(80);
        server.setReuseAddress(true);

        System.out.println("Aguardando conexao...");
        try (Socket conn = server.accept();) /* try-with  */ {

            System.out.println("Conectado com: "
                    + conn.getInetAddress().getHostAddress());

            OutputStream out = conn.getOutputStream();
            InputStream inputStreamObject =  conn.getInputStream();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(new InputStreamReader(inputStreamObject, "UTF-8"));
            System.out.println(jsonObject);
            
            var json = jsonObject.toString().getBytes("UTF-8");

            for (byte b : json) {
                out.write(b);
            }
        }
    }
}
