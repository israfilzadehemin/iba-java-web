package app.task1704;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderedPrintingV2 {

  static class Track {
    int row = 0;
    int col = 0;
    int dir = 0;
  }

  private static String dataOrdered(int R, int C, int[][] a) {
    Track track = new Track();
    track.col = C-1;

    return IntStream.range(0, R*C).map(n -> {
      int value = a[track.row][track.col];

      switch (track.dir) {
        case 0:
           if (track.row==R-1) { track.col--; track.dir  = 2; }
          else {
             track.row++;
           }
          break;

        case 1: track.col --;
        if (track.row == 0) track.dir = 0;
        else if (track.row == R-1) track.dir = 2;
        break;

        case 2:
          if (track.row==0) { track.col--; track.dir = 0; }
          else {
            track.row--;
          }
          break;
      }
      return value;

    }).mapToObj(String:: valueOf).collect(Collectors.joining(" "));

  }

  public static void main(String[] args) {
    int[][]a =
        {
            {1,  2, 3, 4, },
            {5,  6, 7, 8, },
            {9, 10,11, 12,},
            {13,14,15, 16,},
            {17,18,19, 20,},
        };

    // reference output
    System.out.println("4 8 12 16 20 19 15 11 7 3 2 6 10 14 18 17 13 9 5 1");
    // your output
    System.out.println(dataOrdered(a.length, a[0].length, a));
  }

}
