package bresenham_line;

/**
 * User: Tomas
 * Date: 31.03.2014
 * Time: 12:21
 *
 * Interface for processing 3D lines point by point
 */
public interface LineProcessor3D {

    /**
     * Process 3D line
     * @param handler 3D point handler
     * @param <T> handler and return value type
     * @return some value of type T or null
     */
    <T> T processLine3D(int x0, int y0, int z0, int x1, int y1, int z1, PointHandler3D<T> handler);
}
