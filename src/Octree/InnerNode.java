package Octree;

import Models.*;

import java.sql.Array;

public class InnerNode extends OctreeNode {
    private OctreeNode[][][] leafNodes;

    // representation x and y axis as normal for 2 dimentions and z axis "away from us" ==> front nodes [][][0], back nodes [][][1]
    //LeftTopFront  leafNodes[0][1][0]
    //LeftTopBack [0][1][1]
    //LeftBotFront [0][0][0]
    //LeftBotBack [0][0][1]

    // RightTopFront [1][1][0]
    // RightTopBack [1][1][1]
    // RightBotFront [1][0][0]
    // RightBotBack [1][0][1]

    public InnerNode(){
        leafNodes = new OctreeNode[2][2][2];

        leafNodes[0][1][0] = new BlankNode(new IntVector(position.getX() - , ), size/2);
        leafNodes[0][1][1] = new BlankNode(, size/2);
        leafNodes[0][0][0] = new BlankNode(, size/2);
        leafNodes[0][0][1] = new BlankNode(, size/2);

        leafNodes[1][1][0] = new BlankNode(,size/2);
        leafNodes[1][1][1] = new BlankNode(,size/2);
        leafNodes[1][0][0] = new BlankNode(,size/2);
        leafNodes[1][0][1] = new BlankNode(,size/2);
    }

    private OctreeNode pickNodefor(Body body) {
        Vector3 pos = body.getPosition();
        IntVector indices = new IntVector(0, 0, 0);

        if (pos.getX() > position.getX()) { // right
            indices.setX(1);
        }
        if (pos.getY() > position.getY()) { // top
            indices.setY(1);
        }
        if (pos.getZ() > position.getZ()){ // back
            indices.setZ(1);
        }
        return leafNodes[indices.getX()][indices.getY()][indices.getZ()];
    }

    @Override
    public int bodyCount() {
        int sum = 0;
        for (OctreeNode node :
                leafNodes) {
            sum += node.bodyCount();
        }
        return sum;
    }

    @Override
    public OctreeNode add(BodyNode node){
        //TODO actually add it
        return this;
    }
}