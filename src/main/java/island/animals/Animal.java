package island.animals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Animal {
    protected String name;
    protected double weight;
    protected int speed;
    protected double amountOfFood;
    protected Enum foodType;
    protected int coordinateX;
    protected int coordinateY;

    public boolean eat() {
        System.out.println(getClass().getSimpleName() + " eats!");
        return true;
    }

    public boolean chooseTheDirectionOfMovement() {
        System.out.println(getClass().getSimpleName() + " chose the direction!");
        return true;
    }

    public boolean move() {
        System.out.println(getClass().getSimpleName() + " moves!");
        return true;
    }

    public boolean multiply() {
        System.out.println(getClass().getSimpleName() + " multiplies!");
        return true;
    }

    public boolean die() {
        System.out.println(getClass().getSimpleName() + " died!");
        return true;
    }


}
