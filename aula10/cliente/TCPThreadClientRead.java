package cliente;

import java.io.*;
import java.io.FileReader;
import java.net.*;
import java.lang.Thread;

public class TCPThreadClientRead implements Runnable {
    
    private Socket socket_;
    private long id_;
    
    public TCPThreadClientRead(Socket socket)
    {
        socket_ = socket;
    }
    
    public void run()
    {
        try 
        {
            /*
             * A classe DataOutputStream permite uma aplicação gravar dados primitivos do Java, de forma
             * portável, para um fluxo de saída. A aplicação pode então usar um fluxo de dados de entrada
             * para ler os dados de volta.
             *
             * A classe OutputStream é uma classe abstrata e que é uma superclasse de todas as classes
             * representando um fluxo de saída de bytes. Um fluxo de saída aceita bytes de saída e os
             * envia para alguma ponto de processamento.
             */
            DataOutputStream paraCliente = new DataOutputStream(socket_.getOutputStream());
            
            FileReader ler = new FileReader("./index.html");
            
            BufferedReader buffer = new BufferedReader(ler);
            
            String linha = buffer.readLine();
            
            while (linha != null) 
            {
                paraCliente.writeBytes(linha);
                
                linha = buffer.readLine();
            }        
            
            /*
             * fecha a conexao com o cliente
             */
            socket_.close();               
        }
        catch (Exception ex)
        {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}