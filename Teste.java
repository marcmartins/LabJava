import java.*;
import threads.Ponto;
import threads.Traco;


public class Teste{

	public static void main(String []args)throws InterruptedException{

	Thread minhathread0 = new Thread(new Ponto());
	Thread minhathread1 = new Thread(new Traco());
	
	minhathread0.start();
	minhathread1.start();
	minhathread1.join();
	minhathread0.join();
	
}
}