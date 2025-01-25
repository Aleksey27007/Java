package island.animals.herbivores;

import island.animals.Animal;

import static island.animals.enumClasses.FoodType.CARNIVORES;

public class Goat extends Animal {
    public Goat(String name, double weight, int speed, double amountOfFood, Enum foodType, int coordinateX, int coordinateY) {
        super(name, weight, speed, amountOfFood, foodType, coordinateX, coordinateY);
    }

    public Goat() {
        this.name = "Goat";
        this.weight = 60;
        this.speed = 3;
        this.amountOfFood = 10;
        this.foodType = CARNIVORES;
        this.coordinateX = 0;
        this.coordinateY = 0;
    }
}
