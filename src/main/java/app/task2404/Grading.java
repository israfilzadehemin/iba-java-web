package app.task2404;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Grading {

  public static void main(String[] args) {
    List<Integer> src = Arrays.asList(71, 73, 63, 57, 39, 36, 93, 99);

    System.out.println(gradingStudents(src));
  }

  public static List<Integer> gradingStudents(List<Integer> grades) {
    List<Integer> newgrades = new ArrayList<>();

    for (Integer gr : grades) {

      if ((gr + 1) % 5 == 0) {
        newgrades.add(gr + 1);
      } else if ((gr + 2) % 5 == 0) {
        newgrades.add(gr + 2);
      } else if (gr < 38) newgrades.add(gr);

      else newgrades.add(gr);

    }



    return newgrades;
  }


}
