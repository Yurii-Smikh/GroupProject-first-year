package Octree;

import Models.Body;
import Models.Constants;
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
    public Vector3 getForceExertedAt(Body target, double t) {
        if(body == target) return new Vector3();
        Vector3 massCenterToTarget = target.getPosition().subtract(massCenter).getNormal().multiply(-1d);
        return massCenterToTarget.multiply((target.getMass() * totalMass) * Constants.G / Math.pow((massCenterToTarget.length()), 2));
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