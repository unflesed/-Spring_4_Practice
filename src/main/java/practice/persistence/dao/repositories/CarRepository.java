package practice.persistence.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import practice.persistence.model.Car;

import java.util.List;

@Repository
@Transactional
public interface CarRepository extends CrudRepository<Car,Long> {
    List<Car> findCarByMark(String mark);
    List<Car> findCarByMarkAndModelAndSpeed(String mark, String model, int speed);
    void deleteCarByMark(String mark);
}
