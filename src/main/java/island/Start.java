package island;

import island.animals.Animal;
import island.animals.herbivores.Goat;
import island.animals.carnivores.Wolf;


public class Start {
    public static void main(String[] args) {
        Animal goat = new Goat();
        Animal wolf = new Wolf();

        goat.eat();
        wolf.eat();

    }
}
