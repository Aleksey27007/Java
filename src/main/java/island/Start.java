package island;

import island.animals.Animal;
import island.animals.herbivores.Goat;
import island.animals.carnivores.Wolf;
import island.island.Island;

import java.util.ArrayList;
import java.util.Arrays;


public class Start {
    public static void main(String[] args) {
        Island island = new Island("100x100");
        System.out.println(island.getSize());

        int[][] array = island.getCoordinates();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%d" + " ", array[i][j]);
            }
            System.out.println();
        }
    }
}
