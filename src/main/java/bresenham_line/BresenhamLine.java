package bresenham_line;

/**
 * User: Tomas
 * Date: 31.03.2014
 * Time: 12:43
 */
public class BresenhamLine implements LineProcessor2D, LineProcessor3D {

    protected static int sign(int a) {
        return (a > 0) ? 1 : (a < 0) ? -1 : 0;
    }

    @Override
    public <T> T processLine2D(int x0, int y0, int x1, int y1, PointHandler2D<T> handler) {
        int x = x0;
        int y = y0;

        T result = handler.handlePoint(x, y);
        if (result != null) return result;

        final int dx = x1 - x0;
        final int dy = y1 - y0;

        final int sign_dx = sign(dx);
        final int sign_dy = sign(dy);

        final int abs_dx = Math.abs(dx);
        final int abs_dy = Math.abs(dy);

        final int px, py, d0, d1;
        if (abs_dx > abs_dy) {
            px = sign_dx;
            py = 0;
            d0 = abs_dx;
            d1 = abs_dy;
        }
        else {
            px = 0;
            py = sign_dy;
            d0 = abs_dy;
            d1 = abs_dx;
        }

        int delta = d0/2;

        for (int p = 0; p < d0; p++) {
            delta -= d1;
            if (delta < 0) {
                delta += d0;
                x += sign_dx;
                y += sign_dy;
            }
            else {
                x += px;
                y += py;
            }

            result = handler.handlePoint(x, y);
            if (result != null) return result;
        }

        return null;
    }

    @Override
    public <T> T processLine3D(int x0, int y0, int z0, int x1, int y1, int z1, PointHandler3D<T> handler) {
        int x = x0;
        int y = y0;
        int z = z0;

        T result = handler.handlePoint(x, y, z);
        if (result != null) return result;

        final int dx = x1 - x0;
        final int dy = y1 - y0;
        final int dz = z1 - z0;

        final int sign_dx = sign(dx);
        final int sign_dy = sign(dy);
        final int sign_dz = sign(dz);

        final int abs_dx = Math.abs(dx);
        final int abs_dy = Math.abs(dy);
        final int abs_dz = Math.abs(dz);

        final int px, py, pz, d0, d1, d2, jx1, jy1, jz1, jx2, jy2, jz2;
        if (abs_dx > abs_dy && abs_dx > abs_dz) {
            px = sign_dx;
            py = 0;
            pz = 0;
            jx1 = 0;
            jy1 = sign_dy;
            jz1 = 0;
            jx2 = 0;
            jy2 = 0;
            jz2 = sign_dz;
            d0 = abs_dx;
            d1 = abs_dy;
            d2 = abs_dz;
        }
        else if (abs_dy > abs_dx && abs_dy > abs_dz) {
            px = 0;
            py = sign_dy;
            pz = 0;
            jx1 = sign_dx;
            jy1 = 0;
            jz1 = 0;
            jx2 = 0;
            jy2 = 0;
            jz2 = sign_dz;
            d0 = abs_dy;
            d1 = abs_dx;
            d2 = abs_dz;
        }
        else {
            px = 0;
            py = 0;
            pz = sign_dz;
            jx1 = sign_dx;
            jy1 = 0;
            jz1 = 0;
            jx2 = 0;
            jy2 = sign_dy;
            jz2 = 0;
            d0 = abs_dz;
            d1 = abs_dx;
            d2 = abs_dy;
        }

        int delta1 = d0/2;
        int delta2 = delta1;

        for (int p = 0; p < d0; p++) {
            delta1 -= d1;
            delta2 -= d2;

            if (delta1 < 0) {
                delta1 += d0;
                x += jx1;
                y += jy1;
                z += jz1;
            }

            if (delta2 < 0) {
                delta2 += d0;
                x += jx2;
                y += jy2;
                z += jz2;
            }

            x += px;
            y += py;
            z += pz;

            result = handler.handlePoint(x, y, z);
            if (result != null) return result;
        }

        return null;
    }
}
