package Octree;

import Models.Body;
import Models.Vector3;
import codedraw.CodeDraw;

public abstract class OctreeNode {
    protected Vector3 massCenter;  // center of mass of all the bodies inside the node
    protected double totalMass;  // total mass of all the bodies contained
    protected Vector3 position;  // position of this cube (3 dimensional) aka octree node

    protected double size;  // width/height/depth of this cube

    public Vector3 getMassCenter() {
        return massCenter;
    }

    public double getTotalMass() {
        return totalMass;
    }

    public Vector3 getPosition() {
        return position;
    }

    public abstract Vector3 getForceExertedAt(Body target, double t);

    public double getSize() {
        return size;
    }
    public abstract int bodyCount();
    public abstract OctreeNode add(Body body);

    public abstract void draw(IOctreeDrawer drawer);

    public abstract int getNodeEmpty();
}


