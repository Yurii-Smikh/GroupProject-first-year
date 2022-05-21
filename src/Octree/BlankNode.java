package Octree;

import Models.Body;
import Models.IntVector;

public class BlankNode extends OctreeNode {
    public BlankNode(IntVector position, int size){
        this.position = position;
        this.size = size;
    }

    @Override
    public int bodyCount() {
        return 0;
    }

    @Override
    public OctreeNode add(Body body) {
        return new BodyNode(body, getPosition(), getSize());
    }
}
