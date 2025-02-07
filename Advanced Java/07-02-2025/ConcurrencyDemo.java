import java.util.concurrent.Semaphore;

class Shared {
	static int count = 0;
}

class IncThread extends Thread {

	String name;
	Semaphore sem;

	IncThread(String name, Semaphore sem) {
		this.name = name;
		this.sem = sem;
		new Thread(this).start();

	}

	public void run() {
		
		try {
			System.out.println(name+" is waiting to get the permission.....");
			sem.acquire();
			System.out.println(name+" has got the permission :)");
			
			for (int i = 1; i <= 5; i++) {
				System.out.println(name + " : " + ++Shared.count);
				Thread.sleep(500);

			}
			System.out.println(name+" has released......");
			sem.release();
			

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}


class DecThread extends Thread {

	String name;
	Semaphore sem;

	DecThread(String name, Semaphore sem) {
		this.name = name;
		this.sem = sem;
		new Thread(this).start();

	}

	public void run() {
		
		try {
			System.out.println(name+" is waiting to get the permission.....");
			sem.acquire();
			System.out.println(name+" has got the permission :)");
			
			for (int i = 1; i <= 5; i++) {
				System.out.println(name + " : " + --Shared.count);
				Thread.sleep(500);

			}
			System.out.println(name+" has released......");
			sem.release();
			

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

public class ConcurrencyDemo {
	public static void main(String args[]) {

		//This permits allows how many can enter at a time
		Semaphore sem = new Semaphore(1);

		new IncThread("Rajesh", sem);
		new IncThread("Suresh", sem);
		new DecThread("Anil", sem);
		new IncThread("Ganesh", sem);
		new DecThread("Sunil", sem);
		new DecThread("Monil", sem);
		new IncThread("Dinesh", sem);
		new IncThread("Manjesh", sem);

	}

}