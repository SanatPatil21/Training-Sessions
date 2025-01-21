//Extends thread
class A extends Thread {
	// We need to override run() method
	public void run() {
		for (int i = 1; i <= 20; i++) {
			System.out.println(Thread.currentThread().getName()+" : "+i);
			try {
				if (i % 2 == 0)
					Thread.sleep(1000);
				/*
				sleep() takes params in milliseconds, it allows the thread to wait for a while.
				It also throws an exception
				*/
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
}

class B extends Thread

{
	public void run() {
		for (int i = 1; i <= 20; i++) {
			// System.out.println("Babita : " + i);
			System.out.println(Thread.currentThread().getName() + " : " + i);
			try {
				if (i % 3 == 0)
					Thread.sleep(3000);
			} catch (Exception e) {
				System.out.println(e);
			}

		}

	}
}

class C extends Thread

{
	public void run() {
		for (int i = 1; i <= 20; i++) {
			System.out.println(Thread.currentThread().getName()+" : "+i);
			try {
					Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
}

public class ThreadDemo {
	public static void main(String args[]) throws Exception {


		ThreadGroup tg = new ThreadGroup("Demo");

		Thread a1 =  new Thread(tg, new A());
		Thread b1 =  new Thread(tg, new B());
		Thread c1 =  new Thread(tg, new C());

		a1.setName("Rita");
		b1.setName("Gita");
		c1.setName("Sita");

		//This method can be manually used to set the priority of the Thread
		//b1.setPriority(8);


		// This start method class the run() method in that class, so we need to add the code to be multithreaded in the run() method.
		a1.start();
		b1.start();
		c1.start();

		for(int i=1;i<=20;i++){
			System.out.println("********** Main : "+i+"**********");
			if(i==5)
				tg.suspend();
			if(i==10)
				tg.resume();
			if(i==13)
				tg.stop();
			if(i==12)
			{
				System.out.println("a1 is alive: "+a1.isAlive());
				System.out.println("b1 is alive: "+b1.isAlive());
				System.out.println("c1 is alive: "+c1.isAlive());
			}

			Thread.sleep(2000);
		}

		a1.join();
		c1.join();	
		//join() will wait for a1 and c1 thread to get completed before continuing with the rest of the code ie Main thread
		System.out.println("-------Main Exit -----------");
	}

}
