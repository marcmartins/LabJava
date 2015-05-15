import java.*;
import threads.PrintDot;
import threads.PrintPlus;



public class ThreadTests {

	public static void main(String[] args) throws InterruptedException {
	
		Thread plus = new Thread(new PrintPlus());
		Thread dot = new Thread(new PrintDot());
		
		plus.start();
		dot.start();
		
		plus.join();
		dot.join();
	}
};