package Octree;

import Models.Body;
import Models.Vector3;

public class BodyNode extends OctreeNode {
    private Body body;

    public BodyNode(Body body, Vector3 position, double size) {
        this.body = body;
        this.position = position;
        this.size = size;
        this.massCenter = body.getPosition();
        this.totalMass = body.getMass();
    }
    public Body getBody() {
        return body;
    }

    @Override
    public int bodyCount() {
        return 1;
    }

    @Override
    public OctreeNode add(Body body) {
        return new InnerNode(this, body);
    }

    @Override
    public void draw(IOctreeDrawer drawer) {
        drawer.drawBodyNode(this);
    }
}