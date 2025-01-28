public class LangDemo
{
	public static void main(String args[]) throws Exception
	{
		/* 
		String s1 = "Hi";
		System.out.println(s1);	
		s1 = "hello";
		System.out.println(s1);
		//Since strings are immutable, toUpperCase() will return a new object and needs to be reassigned.
		s1 =  s1.toUpperCase();
		System.out.println(s1);


		StringBuffer sb1 = new StringBuffer("hi");
		sb1.append("hello");
		*/


		Runtime rt = Runtime.getRuntime();
		System.out.println("Wait and see the magic.....");
		Thread.sleep(1000);
		//Process p1 = rt.exec("mspaint.exe");	
		Thread.sleep(1000);
		//Process p2 = rt.exec("calc.exe");

		Process chromeProcess = rt.exec("C:/Program Files/Google/Chrome/Application/chrome.exe");

		System.out.println("Tataaaaa");
		Thread.sleep(3000);
		//p2.destroy();
		//p1.destroy();
		chromeProcess.destroy();
		
	}
}