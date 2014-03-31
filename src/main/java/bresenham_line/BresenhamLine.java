package bresenham_line;

/**
 * User: Tomas
 * Date: 31.03.2014
 * Time: 12:43
 */
public class BresenhamLine implements LineProcessor2D {

    @Override
    public <T> T processLine2D(int x0, int y0, int x1, int y1, PointHandler2D<T> handler) {
        final int dx = x1 - x0;
        final int dy = y1 - y0;

        final int sign_dx = (dx > 0) ? 1 : (dx < 0) ? -1 : 0;
        final int sign_dy = (dy > 0) ? 1 : (dy < 0) ? -1 : 0;

        final int abs_dx = Math.abs(dx);
        final int abs_dy = Math.abs(dy);

        final int pdx, pdy, dmx, dmn;
        if (abs_dx > abs_dy) {
            pdx = sign_dx;
            pdy = 0;
            dmx = abs_dx;
            dmn = abs_dy;
        }
        else {
            pdx = 0;
            pdy = sign_dy;
            dmx = abs_dy;
            dmn = abs_dx;
        }

        int x = x0;
        int y = y0;
        int delta = dmx/2;

        T result = handler.handlePoint(x, y);
        if (result != null) return result;

        for (int p = 0; p < dmx; p++) {
            delta -= dmn;
            if (delta < 0) {
                delta += dmx;
                x += sign_dx;
                y += sign_dy;
            }
            else {
                x += pdx;
                y += pdy;
            }

            result = handler.handlePoint(x, y);
            if (result != null) return result;
        }

        return null;
    }
}
