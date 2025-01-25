package island.animals.carnivores;

import island.animals.Animal;

import static island.animals.enumClasses.FoodType.CARNIVORES;

public class Wolf extends Animal {

    public Wolf(String name, double weight, int speed, double amountOfFood, Enum foodType, int coordinateX, int coordinateY) {
        super(name, weight, speed, amountOfFood, foodType, coordinateX, coordinateY);
    }

    public Wolf() {
        this.name = "Wolf";
        this.weight = 50;
        this.speed = 3;
        this.amountOfFood = 8;
        this.foodType = CARNIVORES;
        this.coordinateX = 0;
        this.coordinateY = 0;
    }
}
