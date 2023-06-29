package shapes;

public class Circle {
    // attributes
    private double radius;
    private double area;

    // input radius
    public void setRadius(String radius) {
        this.radius = Double.parseDouble(radius);
    }

    // calculate area
    public void calculateArea() {
        area = Math.PI * (radius * radius);
    }

    // return area
    public double getArea() {
        return area;
    }
}
