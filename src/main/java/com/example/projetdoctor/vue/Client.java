package com.example.projetdoctor.vue;
import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Client implements Runnable {
        private static String message;
        private PrintWriter printwriter;

        public Client(String message) {
            this.message = message;
        }
        @Override
        public void run() {
            myTask mt = new myTask();
            mt.execute();
        }

        static class myTask extends AsyncTask<Void, Void, Void> {
            @SuppressLint("SetTextI18n")
            @Override
            protected Void doInBackground(Void...params){

                try {

                    System.out.println(message);

                    // the IP and port should be correct to have a connection established
                    // Creates a stream socket and connects it to the specified port number on the named host.
                    Socket socket = new Socket("192.168.56.1", 1234);

                    OutputStream os = socket.getOutputStream();

                    PrintWriter pw = new PrintWriter(os, true);

                    pw.println(message);
                    System.out.println("Send");

                    InputStream is = socket.getInputStream();
                    InputStreamReader isr= new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);
                    String a = br.readLine();
                    System.out.println("##Receive : "+a);
                    socket.close();
                }
                catch(Exception ex) {
                    System.out.println("err");
                }

                return null;
            }
        }
    }

