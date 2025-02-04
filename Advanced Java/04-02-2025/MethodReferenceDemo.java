
// Functional interface with a single abstract method
interface I {
    void abc();
}

// Functional interface with a single abstract method that returns an Object
interface J {
    Object getObject();
}

class A {
    public A() {
        System.out.println("From Constructor A()");
    }

    public static void classMethod() {
        System.out.println("From static classMethod()");
    }

    public void instanceMethod() {
        System.out.println("From instanceMethod()");
    }
}

class B {
    public static void demo() {
        System.out.println("From B class demo()");
    }
}

class C {
    C() {
        System.out.println("C ka object created");
    }

    //overridden toString method
    public String toString() {
        System.out.println("From C class object");
        return "";

    }
}

public class MethodReferenceDemo {
    // Only Possible with Functional Interfaces

    public static void main(String[] args) {

        // Method reference to a static method of class A
        I i1 = A::classMethod;
        i1.abc();

        // Method reference to an instance method of a particular object of class A
        I i2 = new A()::instanceMethod;
        i2.abc();

        // Method reference to a constructor of class A
        I i3 = A::new;
        i3.abc();

        // Method reference to a static method of class B
        I i4 = B::demo;
        i4.abc();

        // Method reference to a constructor of class C
        J j1 = C::new;
        Object obj = j1.getObject();
        System.out.println(obj);

        // Method reference to a constructor of class Thread
        J j2 = Thread::new;
        System.out.println(j2.getObject());

    }

}
