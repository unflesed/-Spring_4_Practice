package practice.persistence.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Comparator;
import java.util.List;

@Data
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String mark;
    private String model;
    private int engine;
    private int price;
    private int speed;

    public Car() {
    }

    public Car(String mark, String model, int engine, int price, int speed) {
        this.mark = mark;
        this.model = model;
        this.engine = engine;
        this.price = price;
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public static int totalPrice(List<Car> cars) {
        int sum = 0;
        for (Car car : cars) {
            sum += car.getPrice();
        }
        System.out.println("TotalPrice = " + sum);
        return sum;
    }
    public static Car maxSpeed(List<Car> cars) {
        Car car;
        car = cars.stream().max(Comparator.comparing(Car::getSpeed)).get();
        System.out.println("MaxSpeed has " + car.getMark() + " " + car.getModel()
                + " with speed " + car.getSpeed());
        return car;
    }
}
