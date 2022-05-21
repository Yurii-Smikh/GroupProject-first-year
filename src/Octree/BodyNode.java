package Octree;

import Models.Body;
import Models.IntVector;

public class BodyNode extends OctreeNode {
    private Body body;

    public BodyNode(Body body, IntVector position, int size) {
        this.body = body;
        this.position = position;
        this.size = size;
    }

    @Override
    public int bodyCount() {
        return 1;
    }

    @Override
    public OctreeNode add(Body body) {
        return new InnerNode(this, body);
    }
}