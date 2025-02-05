package island.island;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class Island {
    private String size;
    private List<Cage> cage; // 1 ячейка поля
    private int valueOfAnimals;
    // [] строки [] столбцы
    private int[][] coordinates;
    private int x;
    private int y;


    public Island(String size) {
        this.size = size;
        checkSizeFormat(size);
        this.coordinates = fillIslandCoord();
    }

    private static void checkSizeFormat(String islandSize) {

        Pattern pattern = Pattern.compile("[0-9]{3}x{1}[0-9]{3}");
        Matcher matcher = pattern.matcher(islandSize);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("size argument is bad need format 000x000 for example");
        }
    }

    private int[][] fillIslandCoord() {
        islandSizeToInt(size);

        return new int[x][y];
    }

    private void islandSizeToInt(String size) {
        List<String> list = Arrays.stream(size.split("x")).toList();
        if (x == 0 && y == 0) {
            x = Integer.parseInt(list.get(0));
            y = Integer.parseInt(list.get(1));
        }
    }
}
