import bresenham_line.BresenhamLine;
import bresenham_line.PointHandler3D;

/**
 * User: Tomas
 * Date: 31.03.2014
 * Time: 16:40
 */
public class Example {

    public static void main(String[] args) {
        new BresenhamLine().processLine3D(1, 9, 8, 14, 6, 19, new PointHandler3D<Void>() {
            @Override
            public Void handlePoint(int x, int y, int z) {
                System.out.println("x=" + x + ", y=" + y + ", z=" + z);
                return null;
            }
        });

    }
}
