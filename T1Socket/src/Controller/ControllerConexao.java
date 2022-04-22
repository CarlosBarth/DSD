/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.InterfaceSocketConnection;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
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
public class ControllerConexao extends InterfaceSocketConnection {

    private static OutputStream out;
    private static InputStream in;
    private static DataInputStream input;
    private static ServerSocket server;
    private static Socket conn;

    public ControllerConexao() throws IOException {
        server = new ServerSocket(80);
        server.setReuseAddress(true);
    }

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
        System.out.println("Aguardando conexao...");

        try (Socket conn = server.accept();) /* try-with  */ {
            setSetings(conn);

            if (input.available() > 0) {
                executeOperation(input.readUTF());
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    private static void setSetings(Socket conn) throws Exception {
        conn.setKeepAlive(true);
        conn.setSoTimeout(9999999);
        out = conn.getOutputStream();
        in = conn.getInputStream();
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
            writeOutPut(new String[] {"Erro na execução do Servidor. Tente novamente em instantes"});
        }
    }
}
