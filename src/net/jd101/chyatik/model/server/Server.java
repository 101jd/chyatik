package net.jd101.chyatik.model.server;

import net.jd101.chyatik.model.client.Client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private volatile Socket socket;
    private ServerSocket serverSocket;

    Thread writeThread;

    public Server() throws IOException {

        this.serverSocket = new ServerSocket(80);
    }

    public void listen() throws IOException {
        System.out.println("Listening...");
        while (true) {
            socket = serverSocket.accept();
            if (socket.isConnected()) {
                System.out.println("Client connected");
                try {
                    writeText(serverSocket.accept());
//                }
//                    this.writeThread = new Thread(() -> {
//                        try {
//                            writeText();
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        } catch (UnsupportedEncodingException e) {
//                            throw new RuntimeException(e);
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//                    });
//                    this.writeThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void writeText(Socket socket) throws InterruptedException, IOException {


        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        out.write(input);
        out.flush();
        socket.getInputStream().read();

        System.out.println(input);
    }
}
