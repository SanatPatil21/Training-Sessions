import java.io.*;

public class IODemo{
	public static void main(String args[]){
		try{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter file name: ");
		String fname = br.readLine();
		//This is used to access the file and store it in a file object
		File f = new File(fname);
		if(f.exists())
		{
			/*This is used to read the content of the file line by line. We are using a  to read file The BufferedReader reads text from a character input stream.
			*/
			BufferedReader fr = new BufferedReader(new FileReader(f));
			String line = null;
			//This loop will keep on running till we get a line as null.
			while((line=fr.readLine())!=null){
				System.out.println(line);
			}
			fr.close();
		
		}else{
			System.out.println("Sorry ! File does nor exists");
		}
		br.close();
		}catch(Exception e){
			System.out.println(e);
		}



	}	


}