import java.util.*;

public class SplitString{

	public static void main(String args[]){
		
		String str = "Raju|24|30000|Tester|232234|raja@gmail.com|Mumbai, Santacruz";

		StringTokenizer st = new StringTokenizer(str,"|;:_");
		int count = st.countTokens();

		for(i=0;i<count;i++){
			System.out.println(st.nextToken());

		}


	}

}