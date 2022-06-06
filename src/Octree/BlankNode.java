package Octree;

import Models.Body;
import Models.Vector3;

public class BlankNode extends OctreeNode {
    public BlankNode(Vector3 position, double size){
        this.position = position;
        this.size = size;
    }

    @Override
    public Vector3 getForceExertedAt(Body target, double t) {
        return new Vector3();
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
    public void draw(IOctreeDrawer drawer) {}
}
