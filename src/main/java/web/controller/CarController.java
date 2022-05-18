package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarService;
import service.CarServiceImpl;


@Controller
public class CarController {

    CarService carService = new CarServiceImpl();

    @GetMapping(value = "/cars")
    public String printWelcome(@RequestParam(value = "count", defaultValue = "5") Integer count, Model model) {
        model.addAttribute("messageCars", carService.listCarsAndQty(count));
        return "cars";
    }
}
