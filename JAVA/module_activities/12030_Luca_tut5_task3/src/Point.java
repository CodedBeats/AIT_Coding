public class Point {
    // attributes
    final int x;
    final int y;

    // constructor
    Point(final double x, final double y) {
        this.x = (int) x; // we're dealing with pixels, so just truncate it
        this.y = (int) y;
    }

    // get coords
    public String toString() {
        return "{" + x + ", " + y + "}";
    }

    // return x coord
    public int getX() {
        return x;
    }
    // return y cord
    public int getY() {
        return y;
    }
}
