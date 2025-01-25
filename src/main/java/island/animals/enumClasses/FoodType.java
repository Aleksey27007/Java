package island.animals.enumClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum FoodType {
    HERBIVORES("herbivores"), // травоядные
    CARNIVORES("carnivores"), // плотоядные
    OMNIVORES("omnivores"); // всеядные

    private String name;
}
