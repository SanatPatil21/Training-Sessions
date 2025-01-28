//class var{}
//cannot use var as a classname but can be used as a variable name

public class Variables {
    public static void main(String args[]){
        //Var datatype
        //needs to be initailised along wit declaration
        var a = "Hi";
        System.out.println(a);
        float var = 3.125f;

        String choice = "yes";
        
        enum Month{
            JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC;
        };

        switch (Month.FEB) {
            //Switch now works with multiple choices/inputs
            //"->" basically means that auto break, we dont need to explicitly write the break statement
            //It can also support {} so that we can write multiple comments
            case JAN, FEB,MAR -> {
                System.out.println("SPRING");
                System.out.println("I love this weather!!");
            }
            case APR -> System.out.println("April"); 
            default -> System.out.println("Default case");
        }


	//Switch can also return values now, (; needs to be added at the last)
	String weather=switch(Month.APR){
		case JAN,FEB,MAR -> "Spring, I love this weather";
		case APR -> "Summer";
		case MAY -> "Summer";
		case JUN -> "Summer";
		case JUL -> "Summer";
		case AUG -> "Summer";
		case SEP -> "Summer";
		case OCT -> "Summer";
		case NOV -> "Summer";
		case DEC -> "Summer";

	};
	System.out.println("Weather: "+weather);
    }
}
