package threads;

import java.lang.Thread;

public class PrintDot implements Runnable  {
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.print(".");
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
		}
	}
};