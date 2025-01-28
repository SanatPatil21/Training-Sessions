//In singleton,there should be only one object of the singleton class.
//Two types 1: Early Instantiation(Pehle se bana ke rakho) 2: Lazy Instantiation(Make object when class called)

//TYPE 1: EARLY INSTANTIATION
final class Principal{
    static private final Principal p1 = new Principal();
    private Principal(){
        System.out.println("Principal(Early) object created.......");

    }

    public static Principal getPrincipal(){
        return p1;
    }
}

//TYPE 2: LAZY INSTANTIATION
/* 
final class Principal{
    private static Principal p1 = null;
    private Principal(){
        System.out.println("Principal(Lazy) object created.......");

    }

    public static Principal getPrincipal(){
        if(p1==null)
            p1=new Principal();
        return p1;
    }
}
*/



public class Singleton{
    public static void main(String args[]){

        Principal p1 = Principal.getPrincipal();
        System.out.println(p1);

        Principal p2 = Principal.getPrincipal();
        System.out.println(p2);

    }
}