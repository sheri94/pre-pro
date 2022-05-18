package service;

import models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CarServiceImpl implements CarService {
    List<Car> cars = new ArrayList<>();

    {
        Car car1 = new Car("Audi", "a6", 777);
        Car car2 = new Car("Mazda", "3", 555);
        Car car3 = new Car("Renault", "Megan", 666);
        Car car4 = new Car("Subaru", "Galdina", 111);
        Car car5 = new Car("BMW", "X6", 999);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
    }

    @Override
    public List<Car> listCarsAndQty(Integer count) {
        if (count == 0 || count >= 5) {
            return cars;
        }
        return cars.subList(0, count);

    }
}
