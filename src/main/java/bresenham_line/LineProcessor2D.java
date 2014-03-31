package bresenham_line;

/**
 * User: Tomas
 * Date: 31.03.2014
 * Time: 12:21
 *
 * Interface for processing 2D lines point by point
 */
public interface LineProcessor2D {

    /**
     * Process 2D line
     * @param handler 2D point handler
     * @param <T> handler and return value type
     * @return some value of type T or null
     */
    <T> T processLine2D(int x0, int y0, int x1, int y1, PointHandler2D<T> handler);
}
