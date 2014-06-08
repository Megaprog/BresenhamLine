BresenhamLine
=============

Bresenham’s line drawing algorithm implementation in 2D and 3D dimensions.

## How to get it?

You can download the latest build at:
    https://github.com/Megaprog/BresenhamLine/releases

Or use it as a maven dependency:

```xml
<dependency>
    <groupId>org.jmmo</groupId>
    <artifactId>bresenham-line</artifactId>
    <version>1.0</version>
</dependency>
```

## How to use it?

    import bresenham_line.BresenhamLine;
    import bresenham_line.PointHandler3D;

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

The output is:

x=1, y=9, z=8<br/>
x=2, y=9, z=9<br/>
x=3, y=9, z=10<br/>
x=4, y=8, z=11<br/>
x=5, y=8, z=11<br/>
x=6, y=8, z=12<br/>
x=7, y=8, z=13<br/>
x=8, y=7, z=14<br/>
x=9, y=7, z=15<br/>
x=10, y=7, z=16<br/>
x=11, y=7, z=16<br/>
x=12, y=6, z=17<br/>
x=13, y=6, z=18<br/>
x=14, y=6, z=19<br/>
