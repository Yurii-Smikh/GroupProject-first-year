package Models;

import codedraw.CodeDraw;
public class Body {
    private double mass;
    private Vector3 position;
    private Vector3 velocity;

    public Body(double mass, Vector3 location, Vector3 movement){
        this.mass = mass;
        this.position = location;
        this.velocity = movement;
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
    public void draw(CodeDraw cd) {
        cd.setColor(SpaceDraw.massToColor(this.mass));
        position.drawAsFilledCircle(cd, SpaceDraw.massToRadius(this.mass));
    }
}
