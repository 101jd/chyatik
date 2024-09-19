package net.jd101.chyatik.model.client;

import net.jd101.chyatik.model.server.Server;

import java.io.IOException;
import java.net.ServerSocket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.connect();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}