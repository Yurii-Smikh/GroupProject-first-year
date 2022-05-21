package Octree;

import Models.Body;
import Models.Vector3;
import codedraw.*;

public class BlankNode extends OctreeNode {
    public BlankNode(Vector3 position, double size){
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

    @Override
    public void draw(CodeDraw cd) {}
}
