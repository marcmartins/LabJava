package cliente;

import java.io.*;
import java.io.FileReader;
import java.net.*;
import java.lang.Thread;

public class TCPThreadClientReadWrite implements Runnable {
    
    private Socket socket_;
    private long id_;
    
    public TCPThreadClientReadWrite(Socket socket)
    {
        socket_ = socket;
    }
    
    public void run()
    {
        try 
        {
            /* A classe BufferedReader é utilizada na leitura de um fluxo de caracteres de entrada.
             * Esta classe bufferiza os caracteres de forma a providenciar uma leitura eficiente
             * de caracteres, arrays e linhas.
             *
             * A classe InputStreamReader é uma ponte entre um fluxo de bytes e um fluxo de caracteres:
             * Ela lê cada byte na entrada e decodifica-os em caracteres usando um conjunto de caracteres
             * previamente especificados. Está classe tem como parâmetro de contrução uma entrada para a
             * classe InputStream.
             *
             * A classe InputStream é uma classe abstrata e que é uma superclasse de todas as classes
             * representando fluxos de entrada de bytes.
             *
             * O método getInputStream da classe Socket retorna uma instância da classe InputStream.
             */
            
            BufferedReader doCliente = new BufferedReader(new InputStreamReader(socket_.getInputStream()));
            
            String linha = doCliente.readLine();
            String delimitador = "[ /]+";
            
            String[] tokens = linha.split(delimitador);
            
            for (int i = 0; i < tokens.length; i++)
                System.out.println(tokens[i]);
            
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
            
            FileReader ler = new FileReader(tokens[1]);
            
            BufferedReader buffer = new BufferedReader(ler);
            
            linha = buffer.readLine();
            
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