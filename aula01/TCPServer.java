import java.io.*;
import java.net.*;

class TCPServidor
{
    public static void main(String argv[]) throws Exception
    {
	String msg_cliente;
	String msg_cliente_cx_alta;
	ServerSocket servidor = new ServerSocket(6789);

	while(true)
	    {
		/*
		 * O método accept do ServerSocket aguarda até que um cliente
		 * faça uma requisição de conexão. Quando recebe a requisição
		 * o método retorna o socket do cliente.
		 */
		Socket socket = servidor.accept();

		/*
		 * A classe BufferedReader é utilizada na leitura de um fluxo de caracteres de entrada.
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
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		/*
		 * A classe DataOutputStream permite uma aplicação gravar dados primitivos do Java, de forma
		 * portável, para um fluxo de saída. A aplicação pode então usar um fluxo de dados de entrada
		 * para ler os dados de volta.
		 *
		 * A classe OutputStream é uma classe abstrata e que é uma superclasse de todas as classes
		 * representando um fluxo de saída de bytes. Um fluxo de saída aceita bytes de saída e os
		 * envia para alguma ponto de processamento.
		 */
		DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());

		/*
		 *
		 */
		msg_cliente = inFromClient.readLine();

		/*
		 * Imprime na saída padrão o conjunto de caracteres enviados pelo
		 * cliente.
		 */
		System.out.println("Recebido: " + msg_cliente);

		/*
		 * O método toUpperCase() da classe String, converte os caracteres
		 * armazenados na string de caixa baixa para caixa alta.
		 */
		msg_cliente_cx_alta = msg_cliente.toUpperCase() + '\n';

		/*
		 *
		 */
		outToClient.writeBytes(msg_cliente_cx_alta);
	    }
    }
}
