/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author 07166848960
 */
public class ControllerConexao {
    public static void main(String[] args) throws IOException {
        System.out.println("Criando Conexão...");
        
        try (Socket conn =  new Socket(Inet4Address.getLocalHost(),80)) {
            conn.setReuseAddress(true);
            System.out.println("Conectado!");
            InputStream in = conn.getInputStream();
            
            byte [] dados = new byte[1024];
            int qtde = in.read(dados);
                // Deverá vir um Json
            
            while (qtde >= 0) {
                // Deverá vir um Json
                String dadosStr = new String(dados, 0, qtde);
                System.out.println(dadosStr);
                qtde = in.read(dados);
            }
            // Após montar um Json criar um Modelo e realizar o Bean
        } catch (UnknownHostException e ) {
            System.out.println("Host não Encontrado");
            e.printStackTrace();
        }
    }
        
}
