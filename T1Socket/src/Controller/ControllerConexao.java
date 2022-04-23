/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.SocketException;
import java.text.ParseException;
import Operations.FactoryOperation;
import Operations.Operation;

/**
 *
 * @author 07166848960
 */
public class ControllerConexao {

    private static OutputStream out;
    private static DataInputStream input;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException, ParseException, InterruptedException, Exception {
        IniSet.inicialyzeData();

        while (true) {

            runServer();

            server.close();
        }
    }

    public static void writeOutPut(String[] str) throws Exception {
        for (int i = 0; i < str.length; i++) {
            Thread.sleep(1000);
            out.write(str[i].getBytes());
        }
    }

    public static void runServer() throws Exception {
        server = new ServerSocket(80);
        server.setReuseAddress(true);
        System.out.println("Aguardando conexao...");

        try (Socket conn = server.accept();) /* try-with  */ {
            setSetings(conn);

            if (input.available() > 0) {
                executeOperation(input.readUTF());
            }
        } catch (SocketException e) {
            throw e;
        }
    }

    private static void setSetings(Socket conn) throws Exception {
        conn.setKeepAlive(true);
        conn.setSoTimeout(9999999);
        out = conn.getOutputStream();
        input = new DataInputStream(conn.getInputStream());

        System.out.println("Conectado com: " + conn.getInetAddress().getHostAddress());
    }

    public static void executeOperation(String str) throws Exception {
        try {
            FactoryOperation factory = new FactoryOperation();
            Operation op = factory.getOperation(str.split(";"));
            op.execute();
            writeOutPut(op.getMessage());
        } catch (Exception ex) {
            writeOutPut(new String[] {"Não foi possível reconhecer a Operação!"});
        }
    }
}
