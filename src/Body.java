public class Body {
    private double mass;

    public double getMass() {
        return mass;
    }

    private Vector location;

    public Vector getLocation() {
        return location;
    }

    private Vector movementVector;

    public Vector getMovementVector() {
        return movementVector;
    }

    public Body(double mass, Vector location, Vector movement){
        this.mass = mass;
        this.location = location;
        this.movementVector = movement;
    }

    public double distanceTo(Body body){
        return location.distanceTo(body.location);
    }

    public void move(Vector force){   // F = m*a => a = F/m
        Vector newPosition = movementVector.add(location.add(force.multiply(1d / mass)));

        Vector newMovement = newPosition.subtract(location);

        location = newPosition;

        movementVector = newMovement;
    }
}
