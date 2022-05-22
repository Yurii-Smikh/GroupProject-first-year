package Octree;

import Models.*;

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

    public InnerNode(BodyNode previoisNodeFromWichToCreate, Body body){
        this.position = previoisNodeFromWichToCreate.getPosition();
        this.size = previoisNodeFromWichToCreate.getSize();

        leafNodes = new OctreeNode[2][2][2];

        double newSize = size * 0.5;
        fillWithBlanks(newSize);

        add(body);
        add(previoisNodeFromWichToCreate.getBody());
    }

    private IntVector pickNodefor(Body body) {
        Vector3 pos = body.getPosition();
        IntVector indices = new IntVector(0, 0, 0);

        if (pos.getX() >= position.getX()) { // right
            indices.setX(1);
        }
        if (pos.getY() >= position.getY()) { // top
            indices.setY(1);
        }
        if (pos.getZ() >= position.getZ()){ // back
            indices.setZ(1);
        }
        return indices;
    }
    private void fillWithBlanks(double newSize){
        leafNodes[0][1][0] = new BlankNode(new Vector3(position.getX() - newSize, position.getY() + newSize, position.getZ() + newSize), newSize);
        leafNodes[0][1][1] = new BlankNode(new Vector3(position.getX() - newSize, position.getY() + newSize, position.getZ() - newSize), newSize);
        leafNodes[0][0][0] = new BlankNode(new Vector3(position.getX() - newSize, position.getY() - newSize, position.getZ() + newSize), newSize);
        leafNodes[0][0][1] = new BlankNode(new Vector3(position.getX() - newSize, position.getY() - newSize, position.getZ() - newSize), newSize);

        leafNodes[1][1][0] = new BlankNode(new Vector3(position.getX() + newSize, position.getY() + newSize, position.getZ() + newSize),newSize);
        leafNodes[1][1][1] = new BlankNode(new Vector3(position.getX() + newSize, position.getY() + newSize, position.getZ() - newSize),newSize);
        leafNodes[1][0][0] = new BlankNode(new Vector3(position.getX() + newSize, position.getY() - newSize, position.getZ() + newSize),newSize);
        leafNodes[1][0][1] = new BlankNode(new Vector3(position.getX() + newSize, position.getY() - newSize, position.getZ() - newSize),newSize);
    }
    @Override
    public int bodyCount() {
        int sum = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    sum += leafNodes[i][j][k].bodyCount();
                }
            }
        }
        return sum;
    }

    @Override
    public OctreeNode add(Body body){
        IntVector choice = pickNodefor(body);
        leafNodes[choice.getX()][choice.getY()][choice.getZ()] = leafNodes[choice.getX()][choice.getY()][choice.getZ()].add(body);
        return this;
    }

    @Override
    public void draw(IOctreeDrawer drawer) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    leafNodes[i][j][k].draw(drawer);
                }
            }
        }
    }
}