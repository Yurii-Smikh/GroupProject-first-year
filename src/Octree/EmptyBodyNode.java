package Octree;

public class EmptyBodyNode extends BodyNode{
    public EmptyBodyNode(){

    }

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
