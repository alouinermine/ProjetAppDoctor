package com.example.serverapp.vue;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Serveur en attente");
            while(true) {
                Socket socket = ss.accept();
                System.out.println("accept");

                InputStream is = socket.getInputStream();
                InputStreamReader isr= new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String[] s= br.readLine().split(" ");
//				System.out.println("input: "+s[0]);

                int result =0;
                switch (s[1]) {
                    case "+":{ result=Integer.parseInt(s[0])+Integer.parseInt(s[2]);break;}

                    case "*":{ result=Integer.parseInt(s[0])*Integer.parseInt(s[2]);break;}

                    case "/":{ result=Integer.parseInt(s[0])/Integer.parseInt(s[2]);break;}

                    case "-": {result=Integer.parseInt(s[0])-Integer.parseInt(s[2]);break;}

                    default :{System.out.println("cest pas unne equoition");}
                }
                System.out.println(s[0] + s[1]  +s[2] +" = "+result);

                PrintWriter printwriter = new PrintWriter(socket.getOutputStream(),true);
                printwriter.println(""+result);  // write the message to output stream
                socket.close();
            }
        }
        catch(Exception ex) {System.out.println("erreur");}

    }
}
