package threads;

import java.lang.Thread;

public class Ponto implements Runnable{

	public void run(){

		try
		{
			for(int i=0; i<50; i++)
			{
				System.out.print(".");
				Thread.sleep(500);
			}
		}
		catch(InterruptedException e)
		{
		}
	}
};