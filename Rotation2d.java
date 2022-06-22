class Rotation2d {
    private double angle; // angle stored in radians

    public Rotation2d(double radians) {
        this.angle = radians;
    }

    public Rotation2d(double x, double y) {
        this.angle = Math.atan2(y, x);
    }

    public Rotation2d() {
        this(0);
    }

    public double getAngle() {
        return angle;
    }

    public void add(double other) {
        this.angle += other;
    }

    public void add(Rotation2d other) {
        this.angle += other.angle;
    }

    public void sub(double other) {
        this.angle -= other;
    }

    public void sub(Rotation2d other) {
        this.angle -= other.angle;
    }

    public void mult(double mag) {
        this.angle *= mag;
    }

    public void mult(Rotation2d mag) {
        this.angle *= mag.angle;
    }

    public void div(double mag) {
        this.angle /= mag;
    }

    public void div(Rotation2d mag) {
        this.angle /= mag.angle;
    }

    public boolean equals(Rotation2d other) {
        return other.getAngle() == this.getAngle();
    }

    public static double toRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

    public static double toDegrees(double radians) {
        return radians / Math.PI * 180;
    }

    // // might be faster?
    // public double divideByTwo() {
    // String text = Double.toString(Math.abs(angle));
    // int decimalPlaces = text.length() - text.indexOf('.') - 1;
    // return ((int) (angle * Math.pow(10, decimalPlaces)) >> 1)
    // / Math.pow(10, decimalPlaces);
    // }

    public double divideByTwo() {
        return angle * 0.5;
    }

    public void normalize() {
        this.angle = this.angle % (2 * Math.PI);
        if (this.angle < 0) {
            this.angle += 2 * Math.PI;
        }
    }

    public double getCos() {
        return Math.cos(this.angle);
    }

    public double getSin() {
        return Math.sin(this.angle);
    }

    public double getTan() {
        return Math.tan(this.angle);
    }

    public String toString() {
        return String.valueOf(angle);
    }

    public Rotation2d interpolate(Rotation2d end, int t) {
        double start = this.angle;
        double endAngle = end.angle;
        return new Rotation2d((endAngle - start) / t);
    }

    public Rotation2d rotateBy(Rotation2d other) {
        return new Rotation2d(Math.atan2(other.getSin() * this.getCos() + other.getCos() * this.getSin(),
                other.getCos() * this.getCos() + other.getSin() * this.getSin()));
    }

    public int hashCode() {
        return Double.hashCode(angle);
    }
}