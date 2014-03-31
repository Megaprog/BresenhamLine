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
public class BresenhamLineTest {

    @Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[][] {{0, 1},  {1, 1},   {2, 2},   {3, 2},   {4, 3},   {5, 3},   {6, 4}} },
                { new int[][] {{0, -1}, {1, -1},  {2, -2},  {3, -2},  {4, -3},  {5, -3},  {6, -4}} },
                { new int[][] {{0, 1},  {-1, 1},  {-2, 2},  {-3, 2},  {-4, 3},  {-5, 3},  {-6, 4}} },
                { new int[][] {{0, -1}, {-1, -1}, {-2, -2}, {-3, -2}, {-4, -3}, {-5, -3}, {-6, -4}} },
                { new int[][] {{1, 0},  {1, 1},   {2, 2},   {2, 3},   {3, 4},   {3, 5},   {4, 6}} },
                { new int[][] {{-1, 0}, {-1, 1},  {-2, 2},  {-2, 3},  {-3, 4},  {-3, 5},  {-4, 6}} },
                { new int[][] {{1, 0},  {1, -1},  {2, -2},  {2, -3},  {3, -4},  {3, -5},  {4, -6}} },
                { new int[][] {{-1, 0}, {-1, -1}, {-2, -2}, {-2, -3}, {-3, -4}, {-3, -5}, {-4, -6}} }
        });
    }


    private LineProcessor2D processor2D = new BresenhamLine();
    private LineProcessor3D processor3D = new BresenhamLine();

    private int[][] points;

    public BresenhamLineTest(int[][] points) {
        this.points = points;
    }

    @Test
    public void testProcessLine2D() throws Exception {
        final int[] index = {0};

        final int[] first = points[0];
        final int[] last = points[points.length - 1];

        processor2D.processLine2D(first[0], first[1], last[0], last[1], new PointHandler2D<Void>() {
            @Override
            public Void handlePoint(int x, int y) {
                int[] point = points[index[0]++];
                assertEquals(point[0], x);
                assertEquals(point[1], y);
                return null;
            }
        });

        assertEquals(points.length, index[0]);
    }

    @Test
    public void testProcessLine3Das2Dz() throws Exception {
        final int[] index = {0};

        final int[] first = points[0];
        final int[] last = points[points.length - 1];

        processor3D.processLine3D(first[0], first[1], 0, last[0], last[1], 0, new PointHandler3D<Void>() {
            @Override
            public Void handlePoint(int x, int y, int z) {
                int[] point = points[index[0]++];
                assertEquals(point[0], x);
                assertEquals(point[1], y);
                assertEquals(0, z);
                return null;
            }
        });

        assertEquals(points.length, index[0]);
    }

    @Test
    public void testProcessLine3Das2Dx() throws Exception {
        final int[] index = {0};

        final int[] first = points[0];
        final int[] last = points[points.length - 1];

        processor3D.processLine3D(0, first[0], first[1], 0, last[0], last[1], new PointHandler3D<Void>() {
            @Override
            public Void handlePoint(int x, int y, int z) {
                int[] point = points[index[0]++];
                assertEquals(point[0], y);
                assertEquals(point[1], z);
                assertEquals(0, x);
                return null;
            }
        });

        assertEquals(points.length, index[0]);
    }

    @Test
    public void testProcessLine3Das2Dy() throws Exception {
        final int[] index = {0};

        final int[] first = points[0];
        final int[] last = points[points.length - 1];

        processor3D.processLine3D(first[0], 0, first[1], last[0], 0, last[1], new PointHandler3D<Void>() {
            @Override
            public Void handlePoint(int x, int y, int z) {
                int[] point = points[index[0]++];
                assertEquals(point[0], x);
                assertEquals(point[1], z);
                assertEquals(0, y);
                return null;
            }
        });

        assertEquals(points.length, index[0]);
    }
}
