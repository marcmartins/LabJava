package cliente;

import java.io.*;
import java.net.*;
import java.lang.Thread;

public class TCPThreadClient implements Runnable {
    
    private Socket socket_;
    private long id_;
    
    public TCPThreadClient(Socket socket)
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
            
            /*
             * o método writeBytes envia um stream de dados para o cliente conectado.
             */
            paraCliente.writeBytes("<html><body><h1>Ola!</h1></body></html>");
            
            
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