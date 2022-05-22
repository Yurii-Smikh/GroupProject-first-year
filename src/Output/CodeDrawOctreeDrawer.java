package Output;

import Models.Body;
import Models.Vector3;
import Octree.BodyNode;
import Octree.IOctreeDrawer;
import codedraw.CodeDraw;

import java.awt.*;

public class CodeDrawOctreeDrawer implements IOctreeDrawer {
    private int canvasSize;
    private CodeDraw codeDraw;
    private boolean drawSquares;
    public CodeDrawOctreeDrawer(int canvasSize, boolean drawSquares){
        this.canvasSize = canvasSize;
        this.codeDraw = new CodeDraw(canvasSize, canvasSize);
        this.drawSquares = drawSquares;
    }

    @Override
    public void display() {
        codeDraw.show();
    }

    @Override
    public void drawBodyNode(BodyNode node) {
        Color color = Color.getHSBColor((float)Math.random()*0.5f + 0.25f, (float)Math.random()*0.5f + 0.25f, (float)Math.random()*0.5f + 0.25f);
        codeDraw.setColor(color);
        drawBody(node.getBody());
        if(drawSquares) drawSquare(node);
    }

    @Override
    public void clean() {
        codeDraw.clear(Color.BLACK);
    }

    private void drawBody(Body body){
        Vector3 position = body.getPosition().add(new Vector3(canvasSize, canvasSize, 0).multiply(0.5));  // offsetting the location to the centre of canvas
        codeDraw.fillCircle(position.getX(), position.getY(), 1);
    }

    private void drawSquare(BodyNode node){
        //TODO
        Vector3 position = node.getPosition();//.add(new Vector3(canvasSize, canvasSize, 0)).multiply(0.5); // offsetting the location to the centre of canvas

        codeDraw.drawSquare(position.getX(), position.getY(), node.getSize());

        System.out.println(node.getPosition().getX() + " | " + node.getPosition().getY() + " | " + node.getSize());
    }
}
