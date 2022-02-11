package practice.persistence.dao.services.implementations;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import practice.persistence.dao.repositories.CarRepository;
import practice.persistence.dao.services.interfaces.CarSimpleService;
import practice.persistence.model.Car;

import java.util.List;

@EnableScheduling
@Service
public class CarSimpleServiceImpl implements CarSimpleService {
    private CarRepository carRepository;
    @PreAuthorize(value = "hasAuthority('ROLE_ADMIN')")
    @Cacheable("cars")
    @Override
    public List<Car> findAll() {
        return Lists.newArrayList(carRepository.findAll());
    }

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void deleteById(long id) {
        carRepository.deleteById(id);
    }

    @Override
    @CachePut(value = "car", condition = "#result != null", key = "#result.hashCode()")
    public List<Car> findCarByMark(String mark) {
        return carRepository.findCarByMark(mark);
    }

    @Override
    public List<Car> findCarByMarkAndModelAndSpeed(String mark, String model, int speed) {
        return carRepository.findCarByMarkAndModelAndSpeed(mark, model, speed);
    }

    @Override
    public void deleteCarByMark(String mark) {
        carRepository.deleteCarByMark(mark);
    }

    @Scheduled(fixedRate = 1000L)
    @CacheEvict("cars")
    @Override
    public void clearCache() {
        System.out.println("Cache cleared");
    }

    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}
