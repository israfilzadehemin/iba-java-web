package app.task2204;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class MigrationBird {
  public static void main(String[] args) {
    Integer[] birds = new Integer[]{1, 3, 5, 7, 9, 9, 9, 7, 5, 3, 2, 2, 1, 5, 5, 7, 5};

    List<Integer> birdList = Arrays.asList(birds);

    System.out.println(migratoryBirds(birdList));
  }

  static String migratoryBirds(List<Integer> arr) {
    int kind = 0;
    HashMap<Integer, Integer> res = new HashMap<>();

    arr.forEach(b -> {
      if (!res.containsKey(b)) {
        res.put(b, 1);
      } else {
        res.replace(b, res.get(b) + 1);
      }
    });

    return res.toString();
  }
}
