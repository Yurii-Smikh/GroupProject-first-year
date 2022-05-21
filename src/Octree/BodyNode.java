package Octree;

import Models.Body;
import Models.Vector3;
import codedraw.CodeDraw;

public class BodyNode extends OctreeNode {
    private Body body;

    public BodyNode(Body body, Vector3 position, double size) {
        this.body = body;
        this.position = position;
        this.size = size;
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
    public void draw(CodeDraw cd) {
        body.draw(cd);
    }
}