package net.jd101.chyatik.model.server;

import net.jd101.chyatik.model.server.Server;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Server server;
        try {


           server = new Server();
           server.listen();
        } catch (IOException e){
            e.printStackTrace();
        }



    }
}