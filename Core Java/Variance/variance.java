import java.util.*;;

class Animal{
    int feet =4;
    public void makeSound(){
        System.out.println("Every animal makes some sound");
    }
}

class Dog extends Animal{
    public void makeSound(){
        System.out.println("Woof Woof");
    }
}

class Cat extends Animal{
    public void makeSound(){
        System.out.println("Meow Meow");
    }
}



public class variance{
    
    public static void main(String[] args) {
        /*

        //Covariance-> will allow to assign a "child class collection" to a "parent class collection"
        //Read only 
        List<Dog> dogs = new LinkedList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        dogs.add(new Dog());

        List<? extends Animal> animals = dogs;

        //This shall throw a compile time 
        // animals.add(new Dog());

        for (Animal animal : animals) {
            animal.makeSound();
        }

        */

        /*

        //Contravariance-> will allow to assign a "parent class collection" to a "child class collection"
        //Write Only
        // 
        List<? super Dog> animals = new LinkedList<>();
        animals.add(new Dog());
        animals.add(new Dog());
        animals.add(new Dog());

        //This is not possible since compiler is not sure which type will animals get
        //Animal animal = animals.get(0);

        Object obj = animals.get(0);

         */
        
        
    }
}