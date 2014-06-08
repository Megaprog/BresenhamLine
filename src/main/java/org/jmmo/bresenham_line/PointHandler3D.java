package org.jmmo.bresenham_line;

/**
 * User: Tomas
 * Date: 31.03.2014
 * Time: 12:23
 *
 * Interface for handling point with x, y coordinates and return some value.
 * @param <V> return value type
 * @author Tomas
 */
public interface PointHandler3D<V> {

    /**
     * Handle a 3D point
     * @return if returns null the process will continue, if something not null process will stop.
     */
    V handlePoint(int x, int y, int z);
}
