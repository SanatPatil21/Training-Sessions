class A implements Runnable{
	public void run(){
		System.out.println(Thread.currentThread().getName()+" is Waiting......");
		//This synchronised keyword can be also applied to the whole method, but for better use case, it is applied to a part of the code known as Critical Region.
		//This CS could be some Database Opr, File Opr, wherein only one thread should be given access at a time.
		synchronized(this){
			System.out.println(Thread.currentThread().getName()+" has entered the Critical Region");
			for(int i=1;i<=10;i++){
				try{
					Thread.sleep(500);

				}catch(Exception e){
					System.out.println(e);			
				}
				System.out.println(Thread.currentThread().getName()+" : "+i);
			}
			System.out.println(Thread.currentThread().getName()+" has exited the Critical Region");
		}
	}

}

public class SyncDemo{
	public static void main(String args[]) throws Exception
	{
		A a1 = new A();
		//Since Runnable does not have .start(), we need to create a new Thread object and pass it this runnable class object;

		ThreadGroup tg = new ThreadGroup("MyGroup");
		Thread t1 = new Thread(tg,a1);
		Thread t2 = new Thread(tg,a1);
		Thread t3 = new Thread(tg,a1);
		Thread t4 = new Thread(tg,a1);

		t1.setName("Sumit");
		t2.setName("Madhav");
		t3.setName("Pushpa");
		t4.setName("Sanat");

		t3.setDaemon(true);
		//Daemon threads are those threads with least priority.
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		//Threads are picked up randomly but are given executed synchronously
		
	}

}