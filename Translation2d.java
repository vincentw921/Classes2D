public class Translation2d {
    private double x;
    private double y;

    public Translation2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Translation2d() {
        this(0, 0);
    }

    public Translation2d(double mag, Rotation2d radians) {
        this(mag * radians.getCos(), mag * radians.getSin());
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDistance(Translation2d other) {
        return Math.hypot(x - other.getX(), y - other.getY());
    }

    public double getMag() {
        return Math.hypot(x, y);
    }

    public double getAngle() {
        return Math.atan2(y, x);
    }

    public void div(double mag) {
        x /= mag;
        y /= mag;
    }

    public void mult(double mag) {
        x *= mag;
        y *= mag;
    }

    public void add(Translation2d other) {
        x += other.x;
        y += other.y;
    }

    public void sub(Translation2d other) {
        x -= other.x;
        y -= other.y;
    }

    public boolean equals(Translation2d other) {
        return this.x == other.getX() && this.y == other.getY();
    }

    public void normalize() {
        double mag = getMag();
        if (mag != 0) {
            div(mag);
        }
    }

    public void rotateBy(Rotation2d rotation) {
        double newX = x * rotation.getCos() - y * rotation.getSin();
        y = x * rotation.getSin() + y * rotation.getCos();
        x = newX;
    }

    public Translation2d getRotation(Rotation2d rotation) {
        double newX = x * rotation.getCos() - y * rotation.getSin();
        double newY = x * rotation.getSin() + y * rotation.getCos();
        return new Translation2d(newX, newY);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public void inverse() {
        x = -x;
        y = -y;
    }

    public Translation2d getInverse() {
        return new Translation2d(-x, -y);
    }
}
