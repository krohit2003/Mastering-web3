import java.io.*;
import java.util.*;


 public class Car {
    private String make;
    private String model;
    private int year;
    private int speed;
    private int x;
    private int y;
    private int z;

    public Car(String make, String model, int year, int speed, int x, int y, int z) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void accelerate(int speed_increment) {
        speed += speed_increment;
    }

    public void brake(int speed_decrement) {
        speed -= speed_decrement;
    }

    public void move() {
        x += speed;
        y += speed;
        z += speed;
    }

    public boolean detect_collision(Car car2) {
        if (Math.abs(this.x - car2.x) < 10 && Math.abs(this.y - car2.y) < 10 && Math.abs(this.z - car2.z) < 10) {
            return true;
        }
        return false;
    }

    public double time_to_collision(Car car2) {
        double distance = Math.sqrt(Math.pow(this.x - car2.x, 2) + Math.pow(this.y - car2.y, 2) + Math.pow(this.z - car2.z, 2));
        double relativeSpeed = Math.abs(this.speed - car2.speed);
        return distance / relativeSpeed;
    }
 
 Car car1 = new Car("TATA NEXON", "Creta", 2022, 50, 0, 0, 0);
Car car2 = new Car("Mahindra Thar", "Alto", 2021, 40, 20, 20, 20);

car1.accelerate(10);
car2.brake(5);

car1.move();
car2.move();

if (car1.detect_collision(car2)) {
    System.out.println("Collision detected!");
}

double timeToCollision = car1.time_to_collision(car2);
System.out.println("Time to collision: " + timeToCollision);
}