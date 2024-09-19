package net.jd101.chyatik.model.client;

import net.jd101.chyatik.model.server.Server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Arrays;

public class Client {

    private final Socket socket;
    SocketAddress address;

    Thread readThread;

    public Client() throws IOException {
        this.address = new InetSocketAddress(80);
        this.socket = new Socket();

    }

    public void connect() throws IOException {
        try {
            socket.connect(address, 10);
            System.out.println("Connected to server");
            while (true) {
                socket.getKeepAlive();
                try {
                    readText();
//                    this.readThread = new Thread(() -> {
//                        try {
//                            readText();
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    });
//                    readThread.join();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readText() throws IOException, InterruptedException {
        InputStreamReader reader = new InputStreamReader(socket.getInputStream());
        System.out.println(reader.read());
        System.out.flush();
    }

}
