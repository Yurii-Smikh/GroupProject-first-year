package Octree;

import Simulation.Body;

public class EmptyBodyNode extends BodyNode{
    @Override
    public int size() {
        return 0;
    }

    @Override
    public BodyNode add(SingleBodyNode body) {
        //TODO
        return null;
    }
}
