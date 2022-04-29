public class Vector {
    private double x;
    public double getX() {
        return x;
    }
    private double y;
    public double getY() {
        return y;
    }
    private double z;
    public double getZ() {
        return z;
    }



    public Vector(){  // Null vector
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Vector(double x, double y, double z){  // Null vector
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector add(Vector vector){
        return new Vector(x + vector.getX(), y + vector.getY(), z + vector.getZ());
    }

    public Vector subtract(Vector vector){ //adds with factor -1
        return new Vector(x - vector.getX(), y - vector.getY(), z - vector.getZ());
    }

    public Vector multiply(double factor){
        return new Vector(x * factor, y * factor, z * factor);
    }
    public double length(){
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public Vector getNormal(){
        return new Vector(x/this.length(), y/this.length(), z/this.length());
    }

    public double distanceTo(Vector v) {
        return Math.sqrt((Math.pow((x - v.x),2))+(Math.pow((y - v.y),2))+(Math.pow((z - v.z),2)));
    }
}
