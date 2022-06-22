public class Pose2d {
    double x, y;
    Rotation2d rotation;

    public Pose2d(double x, double y, Rotation2d rotation) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }

    public Pose2d(Translation2d translation2d, Rotation2d rotation2d) {
        this(translation2d.getX(), translation2d.getY(), rotation2d);
    }

    public Pose2d() {
        this(0, 0, new Rotation2d());
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAngle() {
        return rotation.getAngle();
    }

    public Rotation2d getRotation2d() {
        return rotation;
    }

    public String toString() {
        return "Pose2d{" +
                "x=" + x +
                ", y=" + y +
                ", rotation=" + rotation +
                '}';
    }
}
