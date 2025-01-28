
import java.io.*;

public class RAFDemo{
	public static void main(String args[]){
		try{
			/*
			RandomAccessFile raf = new RandomAccessFile("abc.txt","rw");
		
			//This is used to move the file pointer to the given position, here 5th character from the begining of the file.
			raf.seek(5); //This is 0-indexed
			System.out.println(raf.readLine());
			
			//This will replace the current characters with this text
			//raf.writeBytes("DEMO tutu ADDED");


			//So if we need to apppend, some new text to the end of the file, we can use seek to the last line and then writeBytes()

			
			//This will give the position of the last character in the file.
			raf.seek(raf.length());
			raf.writeBytes("Just for demu");
			*/

			//PrintWriter is a wrapper class of Writer, it provides methods like println() which directly sends the output to the destination.
			//PrintWriter pw = new PrintWriter(System.out);
			//pw.println("Hello BAcchiLog"); //This will be not be default get the output to the Console, it sends it to the buffer.
			
			//This will create a new file if the file does not exists otherwise it will append to the existing file.
			PrintWriter pw = new PrintWriter(new FileOutputStream("def.txt",true));
			//This true which is passed is the append mode parameter, which is by default false.
			pw.println("HEY NAYA FilE");

			//This will flush the buffer to send everything to the destination.
			pw.flush(); 
			pw.close();

		}catch(Exception e){
			System.out.println(e);

		}	

	}


}