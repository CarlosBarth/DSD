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
 * @author Barth
 */
public class ControllerServidor {

    private static OutputStream output;
    private static DataInputStream input;
    private static ServerSocket server;

    public static void run(String[] args) throws IOException, ParseException, InterruptedException, Exception {
//        IniSet.inicialyzeData();

        while (true) {

            runServer();

            server.close();
        }
    }

    private static void writeOutPut(String[] str) throws Exception {
        for (int i = 0; i < str.length; i++) {
            output.write(str[i].getBytes());
        }
    }

    private static void runServer() throws Exception {
        server = new ServerSocket(5560);// para evitar que ja esteja sendo utilizada
        server.setReuseAddress(true);
        System.out.println("Aguardando conexao...");

        try (Socket conn = server.accept();) /* try-with  */ {
            setSettings(conn);

            if (input.available() > 0) {
                executeOperation(input.readUTF());
            }
        } catch (SocketException e) {
            throw e;
        }
    }

    private static void setSettings(Socket conn) throws Exception {
        conn.setKeepAlive(true);
        conn.setSoTimeout(9999999);
        output = conn.getOutputStream();
        input = new DataInputStream(conn.getInputStream());

        System.out.println("Conectado com: " + conn.getInetAddress().getHostAddress());
    }

    private static void executeOperation(String str) throws Exception {
        try {
            Operation op = getNewOperation(str);
            op.execute();
            writeOutPut(op.getMessage());
        } catch (Exception ex) {
            writeOutPut(new String[] {"Não foi possível reconhecer a Operação!"});
        }
    }
    
    private static Operation getNewOperation(String str) throws Exception {
        FactoryOperation factory = new FactoryOperation();
        return factory.getOperation(str.split(";"));
    }
}
