package org.JSON;

import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
    public String brand;
    public String model;
    public int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}

public class CarToJson {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Car car = new Car("Toyota", "Camry", 2022);
            String json = objectMapper.writeValueAsString(car);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
