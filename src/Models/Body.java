package Models;

import java.util.Random;

public class Body {
    private double mass;
    private Vector3 position;
    private Vector3 velocity;

    public Body(double mass, Vector3 position, Vector3 velocity){
        this.mass = mass;
        this.position = position;
        this.velocity = velocity;
    }

    //good values: size{4 * 1.989e30}, velocity{5e3}
    public static Body getRandom(Random random, double approximateMass, double simulationSize, double approximateVelocity){
        double mass = Math.abs(Math.random()) * approximateMass;
        Vector3 position = new Vector3( (Math.random()* 2 - 1) * simulationSize/2, (Math.random()* 2 - 1) * simulationSize/2,  0);
//        Vector3 velocity = new Vector3(0 + Math.random()) * approximateVelocity, 0 + Math.random() * approximateVelocity, 0 + Math.random() * approximateVelocity);
        Vector3 velocity = new Vector3();
        return new Body(mass, position, velocity);
    }

    public double getMass() {
        return mass;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Vector3 getMovementVector() {
        return velocity;
    }

    public double distanceTo(Body body){
        return position.distanceTo(body.position);
    }

    public void move(Vector3 force){   // F = m*a => a = F/m
        Vector3 newPosition = velocity.add(position.add(force.multiply(1d / mass)));
        Vector3 newVelocity = newPosition.subtract(position);
        position = newPosition;
        velocity = newVelocity;
    }
}
