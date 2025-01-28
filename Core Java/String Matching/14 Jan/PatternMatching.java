import java.util.regex.*;

public class PatternMatching{
    public static void main(String[] args) {
        String s1= "Wissen Technology";
        String s2 ="Tech";

        Pattern p1 = Pattern.compile(s2);
        Matcher m1 =p1.matcher(s1);

        System.out.println("'"+s1+"' contains '"+s2+"' : '"+m1.find());

        System.out.println("--------------------------------");
        //Email Matching
        String email = "abc@xyz.in";
        Pattern p2 = Pattern.compile("[a-zA-Z0-9.]+@[a-zA-Z]+\\.com$");
        Matcher m2 = p2.matcher(email);
        // System.out.println(m2.matches());

        //Phone Number Matching
        long mobileNo = 9820826181L;
        Pattern p3 = Pattern.compile("[8-9][0-9]{9}");
        Matcher m3 = p3.matcher(mobileNo+"");
        // System.out.println(m3.matches());


        //Name Pattern Matching

        String name = "Sanat Patil";
        Pattern p4 = Pattern.compile("^[A-Z][a-zA-Z]+\\s[A-Z][a-zA-Z]+$");
        Matcher m4 = p4.matcher(name);
        System.out.println(m4.matches());

        
 
        
    }
}