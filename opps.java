//abstraction def: hiding implementation details and showing only essential features to the user.
/*
Car Interface --> Act as an interface for Outsiude world to operate the car. 
This interface tells 'WHAT' all it can do rather then 'HOW' it does that.
Since this is an interface we cannot directly create Objects of this. We
need to implement it first and then that child class will have the responsibility to 
provide implementation details of all the methods in the interface.*/

interface Car {
    void startEngine(); 
    void shiftGear(int gear);
    void accelerate();
    void brake();
    void stopEngine();
}
//This is a Concrete class

class SportsCar implements Car {
    String brand;
    String model;
    boolean isEngineOn = false;
    int currentSpeed = 0;
    int currentGear = 0;

    public SportsCar(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    @Override
    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine starts with a roar!");
    }

    @Override
    public void shiftGear(int gear) {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is off! Cannot Cannot Shift Gear.");
            return;
        }
        this.currentGear = gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }

    @Override
    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is off! Cannot accelerate.");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }

    @Override
    public void brake() {
        currentSpeed -= 20;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }

    @Override
    public void stopEngine() {
        isEngineOn = false;
        currentGear = 0;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " : Engine turned off.");
    }
}


public class Abstraction {
    public static void main(String[] args) {
        Car myCar = new SportsCar("Ford", "Mustang");
        myCar.startEngine();
        myCar.shiftGear(1);
        myCar.accelerate();
        myCar.shiftGear(2);
        myCar.accelerate();
        myCar.brake();
        myCar.stopEngine();
    }
}


//encapsulation def: wrapping data (variables) and methods (functions) together into a single unit (class) and controlling access using getters and setters.

// Encapsulation says 2 things:
// 1. An Object's Characteristics and its behaviour are encapsulated together
// within that Object.
// 2. All the characteristics or behaviours are not for everyone to access.
// Object should provide data security.


class SportsCar {
    // private because no one can change it from outside 
    private String brand;
    private String model;
    private boolean isEngineOn = false;
    private int currentSpeed = 0;
    private int currentGear = 0;

    //getters and setters concept
    private String tyreCompany;

    public SportsCar(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public int getSpeed() {
        return currentSpeed;
    }

    public String getTyreCompany() {
        return tyreCompany;
    }

    public void setTyreCompany(String tyreCompany) {
        this.tyreCompany = tyreCompany;
    }



    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine starts with a roar!");
    }

    public void shiftGear(int gear) {
        this.currentGear = gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }

    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is off! Cannot accelerate.");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }
    
    public void brake() {
        currentSpeed -= 20;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }

    public void stopEngine() {
        isEngineOn = false;
        currentGear = 0;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " : Engine turned off.");
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        SportsCar mySportsCar = new SportsCar("Ford", "Mustang");

        mySportsCar.startEngine();
        mySportsCar.shiftGear(1);
        mySportsCar.accelerate();
        mySportsCar.shiftGear(2);
        mySportsCar.accelerate();
        mySportsCar.brake();
        mySportsCar.stopEngine();

        System.out.println("Current Speed of My Sports Car is " + mySportsCar.getSpeed());
    }
}