import java.util.Scanner;

//CHANGES NEEDED IN THIS CODE

abstract class Vehicle{
    int seats;
    public abstract Vehicle getVehicle(String v);
}

class Car extends Vehicle{
    private Car(){
        this.seats=4;
    }
    public Vehicle getVehicle(String v){
        return new Car();
    }

}


class Bike extends Vehicle{
    private Bike(){
        this.seats=2;
    }
    public Vehicle getVehicle(String v){
        return new Bike();
    }

}



public class FactoryPattern{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter Vehicle type");
            

        }
        
    }
}