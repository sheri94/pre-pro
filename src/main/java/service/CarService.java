package service;

import models.Car;

import java.util.List;

public interface CarService {
    List<Car> listCarsAndQty(Integer qty);
}
