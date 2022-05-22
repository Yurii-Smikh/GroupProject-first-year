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
    public static Body getRandom(Random random, double approximateSize, double approximateVelocity){
        double size = Math.abs(random.nextGaussian()) * approximateSize;
        Vector3 position = new Vector3(1.5 * random.nextGaussian() * Constants.AU, 1.5 * random.nextGaussian() * Constants.AU, 1.5 * random.nextGaussian() * Constants.AU);
        Vector3 velocity = new Vector3(0 + random.nextGaussian() * approximateVelocity, 0 + random.nextGaussian() * approximateVelocity, 0 + random.nextGaussian() * approximateVelocity);
        return new Body(size, position, velocity);
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
