/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author 07166848960
 */
public class T1Socket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        System.out.println("Criando Conexão...");
        try (Socket conn =  new Socket("10.60.185.67",80)) {
            conn.setReuseAddress(true);
            System.out.println("Conectado!");
            InputStream in = conn.getInputStream();
            
            byte [] dados = new byte[1024];
            int qtde = in.read(dados);
            
            while (qtde >= 0) {
                String dadosStr = new String(dados, 0, qtde);
                System.out.println(dadosStr);
                qtde = in.read(dados);
            }
        } catch (UnknownHostException e ) {
            System.out.println("Host não Encontrado");
            e.printStackTrace();
        }
    }
}
