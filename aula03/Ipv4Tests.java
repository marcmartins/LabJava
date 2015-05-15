import java.io.*;
import java.net.*;
import java.io.File.*;



class Ipv4Tests {

	public static void main(String args[]) throws Exception    {
		InetAddress inet =  InetAddress.getByName("localhost");
		
		System.out.println(inet.getHostAddress());
		System.out.println(inet.getHostName());

		File f = new File("c:\\Temp\\teste.txt");
		
		FileWriter w = new FileWriter(f);
		
		w.write("hotname: " + inet.getHostName() + ", ip: " + inet.getHostAddress());
		
		w.close();
	}

};