package app.task2004;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DiagonalDifference {
  public static void main(String[] args) {
    int[][] src = new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {15, 8, 9}
    };

    System.out.println(calculate(src));
  }

  static int calculate(int[][] source) {
    int sumLeft = 0;
    int sumRight = 0;
    for (int i = 0; i<source.length; i++) {
      sumLeft = sumLeft + source[i][i];
      sumRight = sumRight + source[i][source.length-1-i];
    }
    return Math.abs(sumLeft-sumRight);
  }}
