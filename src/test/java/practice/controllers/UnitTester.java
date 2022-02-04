package practice.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import practice.persistence.model.Car;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/app-ctx.xml"})
public class UnitTester {
    @Autowired
    List<Car> cars;
    @Autowired
    @Qualifier(value = "car2")
    Car car;

    @Test
    public void testCar(){
        Assert.assertEquals("BMW",car.getMark());
    }

    @Test
    public void testTotalPrice(){
        Assert.assertEquals(110000, Car.totalPrice(cars));
    }

    @Test
    public void testMaxSpeed(){
        Assert.assertEquals(270, Car.maxSpeed(cars).getSpeed());
    }
}
