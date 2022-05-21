package Simulation;

public class Vector3 {
    private double x;
    private double y;
    private double z;

    public Vector3(){
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Vector3(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Vector3 add(Vector3 vector3){
        return new Vector3(x + vector3.getX(), y + vector3.getY(), z + vector3.getZ());
    }

    public Vector3 subtract(Vector3 vector3){
        return add(vector3.multiply(-1));
    }

    public Vector3 multiply(double factor){
        return new Vector3(x * factor, y * factor, z * factor);
    }

    public double length(){
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public Vector3 getNormal(){
        return new Vector3(x/this.length(), y/this.length(), z/this.length());
    }

    public double distanceTo(Vector3 point) {
        return Math.sqrt((Math.pow((x - point.x),2))+(Math.pow((y - point.y),2))+(Math.pow((z - point.z),2)));
    }
}
