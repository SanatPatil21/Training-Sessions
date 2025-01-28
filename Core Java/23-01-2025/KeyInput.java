import java.io.*;

public class KeyInput{

	public static void main(String args[]){
		try{
			//What InputStreamReader does is that, converts the byteStream data coming from IO(keyboard) into Bytes
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			System.out.println("Please enter your name: ");
			String name = br.readLine();

			System.out.println("Please enter your age: ");
			int age = Integer.parseInt(br.readLine());
			//readLine() always returns String, so we always willneed to parse into the required data type.

			System.out.println("Your good name is "+name);
			System.out.println("Your age after 10 years is "+(age+10));

		}catch (Exception e){
			System.out.println(e);
	
		}
			
	
	}

}