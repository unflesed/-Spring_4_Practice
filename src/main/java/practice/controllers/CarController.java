package practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import practice.persistence.dao.services.interfaces.CarSimpleService;
import practice.persistence.model.Car;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarSimpleService carSimpleService;

    @GetMapping(value = "/all")
    public ModelAndView listAllCars(ModelAndView modelAndView) throws InterruptedException {
        modelAndView.addObject("cars", carSimpleService.findAll());
        modelAndView.setViewName("/car");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public String addNewCar(HttpServletRequest request) {
        Car car = new Car();
        car.setMark(request.getParameter("mark"));
        car.setModel(request.getParameter("model"));
        car.setEngine(Integer.parseInt(request.getParameter("engine")));
        car.setPrice(Integer.parseInt(request.getParameter("price")));
        car.setSpeed(Integer.parseInt(request.getParameter("speed")));
        carSimpleService.addCar(car);

        return "redirect:/car/all";
    }
    @GetMapping(value = "/remove/{id}")
    public ModelAndView deleteCar(@PathVariable long id, ModelAndView modelAndView) throws InterruptedException {
        carSimpleService.deleteById(id);
        modelAndView.addObject("cars", carSimpleService.findAll());
        modelAndView.setViewName("redirect:/car/all");

        return modelAndView;
    }
    @PostMapping(value = "/findByMark")
    public ModelAndView findCarByMark(@RequestParam("mark") String mark, ModelAndView modelAndView) {
        modelAndView.addObject("cars", carSimpleService.findCarByMark(mark));
        modelAndView.setViewName("/result");

        return modelAndView;
    }

    @PostMapping(value = "/findByMarkAndModelAndSpeed")
    public ModelAndView findCarByMarModelSpeed(@RequestParam("mark") String mark,
                                                      @RequestParam("model") String model,
                                                      @RequestParam("speed") int speed,
                                                      ModelAndView modelAndView) {
        modelAndView.addObject("cars", carSimpleService.findCarByMarkAndModelAndSpeed(mark,
                model, speed));
        modelAndView.setViewName("/result");
        return modelAndView;
    }
    @GetMapping(value = "/remove")
    public ModelAndView deleteSpecificCar(@RequestParam("mark")String mark, ModelAndView modelAndView) throws InterruptedException {
        carSimpleService.deleteCarByMark(mark);
        modelAndView.addObject("cars", carSimpleService.findAll());
        modelAndView.setViewName("redirect:/car/all");

        return modelAndView;
    }
}
