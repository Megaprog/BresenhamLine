package bresenham_line;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * User: Tomas
 * Date: 31.03.2014
 * Time: 13:29
 */
@RunWith(Parameterized.class)
public class BresenhamLineTest3D {

    @Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[][] {{1,9,8}, {2,9,9}, {3,9,10}, {4,8,11}, {5,8,11}, {6,8,12}, {7,8,13}, {8,7,14}, {9,7,15}, {10,7,16}, {11,7,16}, {12,6,17}, {13,6,18}, {14,6,19}} },
                { new int[][] {{9,1,8}, {9,2,9}, {9,3,10}, {8,4,11}, {8,5,11}, {8,6,12}, {8,7,13}, {7,8,14}, {7,9,15}, {7,10,16}, {7,11,16}, {6,12,17}, {6,13,18}, {6,14,19}} },
                { new int[][] {{9,8,1}, {9,9,2}, {9,10,3}, {8,11,4}, {8,11,5}, {8,12,6}, {8,13,7}, {7,14,8}, {7,15,9}, {7,16,10}, {7,16,11}, {6,17,12}, {6,18,13}, {6,19,14}} },
                { new int[][] {{1,8,9}, {2,9,9}, {3,10,9}, {4,11,8}, {5,11,8}, {6,12,8}, {7,13,8}, {8,14,7}, {9,15,7}, {10,16,7}, {11,16,7}, {12,17,6}, {13,18,6}, {14,19,6}} }
        });
    }

    private LineProcessor3D processor3D = new BresenhamLine();

    private int[][] points;

    public BresenhamLineTest3D(int[][] points) {
        this.points = points;
    }

    @Test
    public void testProcessLine3D() throws Exception {
        final int[] index = {0};

        final int[] first = points[0];
        final int[] last = points[points.length - 1];

        processor3D.processLine3D(first[0], first[1], first[2], last[0], last[1], last[2], new PointHandler3D<Void>() {
            @Override
            public Void handlePoint(int x, int y, int z) {
                int[] point = points[index[0]++];
                assertEquals(point[0], x);
                assertEquals(point[1], y);
                assertEquals(point[2], z);

                System.out.println("x=" + x + ", y=" + y + ", z=" + z);

                return null;
            }
        });

        assertEquals(points.length, index[0]);
    }
}
