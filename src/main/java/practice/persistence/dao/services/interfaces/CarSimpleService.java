package practice.persistence.dao.services.interfaces;


import practice.persistence.model.Car;

import java.util.List;


public interface CarSimpleService {
    List<Car> findAll();
    void addCar(Car car);
    void deleteById(long id);
    List<Car> findCarByMark(String mark);
    List<Car> findCarByMarkAndModelAndSpeed(String mark, String model, int speed);
    void deleteCarByMark(String mark);
    void clearCache();
}
