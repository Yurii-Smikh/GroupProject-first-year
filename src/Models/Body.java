package Models;

public class Body {
    private double mass;
    private Vector3 position;
    private Vector3 velocity;
    private Vector3 forceExertedOn;

    public Body(double mass, Vector3 position, Vector3 velocity){
        this.mass = mass;
        this.position = position;
        this.velocity = velocity;
        forceExertedOn = new Vector3();
    }

    public static Body getRandom(double medianSimMass, double simulationSize, double medianSpeed){
        double mass = Math.abs(Math.random()) * medianSimMass;
        Vector3 position = new Vector3( (Math.random()* 2 - 1) * simulationSize/2, (Math.random()* 2 - 1) * simulationSize/2,  (Math.random()* 2 - 1) * simulationSize/2);
        Vector3 velocity = new Vector3(Math.random() * medianSpeed, Math.random() * medianSpeed, Math.random() * medianSpeed);
        return new Body(mass, position, velocity);
    }

    public double getMass() {
        return mass;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Vector3 getVelocity() {
        return velocity;
    }

    public double distanceTo(Body body){
        return position.distanceTo(body.position);
    }

    public void addForce(Vector3 force){
        forceExertedOn = forceExertedOn.add(force);
    }

    public void applyForces(){
        velocity = velocity.add(forceExertedOn.multiply(1d / mass));
        position = position.add(velocity);
        forceExertedOn = new Vector3();
    }
}
