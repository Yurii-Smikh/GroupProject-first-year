package Octree;

import Simulation.Body;

public class SingleBodyNode extends BodyNode{
    private Body body;

    public SingleBodyNode(Body body) {
        this.body = body;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public BodyNode add(SingleBodyNode body) {
        //TODO
        return null;
    }
}