public class TryWithResources_1 {
    public static void main(String args[]){

        try(A a1= new A(); B b1=new B()){
            a1.process();
            if(true){
                System.out.println("Kuch Error aaya!!");
                // return;
                throw new NullPointerException();
            }          
                //So after this, first the close method will be called on all the resources in the try() bracket, then the program shall be terminated
            b1.process();
            //While closing, the close methods is automatically called on B and then A in reverse of how they are allocated.
            
        }catch(NullPointerException e){
            System.out.println(e);
        }
        System.out.println("Program Continues");
    }
    
}


//This autocloseable must be implemented in our class
class A implements AutoCloseable{
    A(){
        System.out.println("Allocating Resources for A");
    }

    public void process(){
        System.out.println("A is performing some tasks");
    }

    public void close(){
        System.out.println("Deallocating the resources of A");
    }
}


class B implements AutoCloseable{
    B(){
        System.out.println("Allocating Resources for B");
    }

    public void process(){
        System.out.println("B is performing some tasks");
    }

    public void close(){
        System.out.println("Deallocating the resources of B");
    }
}


