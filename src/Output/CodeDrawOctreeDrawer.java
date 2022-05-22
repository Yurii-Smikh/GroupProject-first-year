package Output;

import Models.Body;
import Models.Vector3;
import Octree.BodyNode;
import Octree.IOctreeDrawer;
import codedraw.CodeDraw;
import codedraw.Corner;

import java.awt.*;

public class CodeDrawOctreeDrawer implements IOctreeDrawer {
    private int fieldSize;
    private CodeDraw codeDraw;
    private boolean drawSquares;
    private double scale;

    public CodeDrawOctreeDrawer(int fieldSize, boolean drawSquares, double scale){
        this.fieldSize = fieldSize;
        this.codeDraw = new CodeDraw(fieldSize, fieldSize);
        this.drawSquares = drawSquares;
        this.scale = scale;
    }

    @Override
    public void display() {
        codeDraw.show();
    }

    @Override
    public void drawBodyNode(BodyNode node) {
        drawBody(node.getBody());
        if(drawSquares) drawSquare(node);
    }

    @Override
    public void clean() {
        codeDraw.clear(Color.BLACK);
    }

    private void drawBody(Body body){
        codeDraw.setColor(Color.LIGHT_GRAY);
        Vector3 position = body.getPosition().multiply(1/scale).multiply(fieldSize);
        position = position.add(position.multiply(0.5));
        codeDraw.fillCircle(position.getX(), position.getY(), 50);
    }

    private void drawSquare(BodyNode node){
        codeDraw.setColor(Color.LIGHT_GRAY);
        Vector3 position = node.getPosition().add(new Vector3(fieldSize/2, fieldSize/2, 0));
        codeDraw.drawSquare(position.multiply(0.5).getX(), position.multiply(0.5).getY(), node.getSize());
    }
}
