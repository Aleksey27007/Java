package island.island;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Island {
    private static String size;
    private static Cage cage; // 1 ячейка поля
    private static int maxValueOfAnimals;
    private List[][] coordinates;
}
