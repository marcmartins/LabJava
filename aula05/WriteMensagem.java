import java.io.File;
import java.io.FileWriter;
import java.io.*;

class WriteMensagem extends Mensagem {

	public void save() throws Exception
	{
		File file = new File("/tmp/teste.txt");

		FileWriter w = new FileWriter(file);

		w.write("MSG:" + getMensagem());

		w.close();
	}

	public static void main(String [] args) throws Exception {
		WriteMensagem msg = new WriteMensagem();
	
		msg.setMensagem("testando a classe File e a classe FileWrite");
		
		msg.save();
	}
}
