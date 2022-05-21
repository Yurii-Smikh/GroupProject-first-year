package Octree;

import Simulation.Body;

public abstract class BodyNode{
    protected double massCenter;
    protected double totalMass;

    public double getMassCenter() {
        return massCenter;
    }

    public double getTotalMass() {
        return totalMass;
    }

    public BodyNode add(Body body){
        return add(new SingleBodyNode(body));
    }

    public abstract int size();
    public abstract BodyNode add(SingleBodyNode body);
}


