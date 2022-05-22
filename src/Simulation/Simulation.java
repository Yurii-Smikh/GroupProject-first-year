package Simulation;
import Models.*;
import Octree.IOctreeDrawer;
import Octree.Octree;
import Output.CodeDrawOctreeDrawer;

import java.util.Random;

public class Simulation {
    private static final int NUMBER_OF_BODIES = 1000;
    private static final double AVERAGE_BODY_MASS = 10; // kilograms (some Big number)
    private static final int CANVAS_SIZE = 512;  // size of the Canvas(window)
    private static final boolean DRAW_SQUARES = true;
    private static final double SIMULATION_SIZE = 512;  // size of the simulation boundaries


    public static void main(String[] args) {
        IOctreeDrawer drawer = new CodeDrawOctreeDrawer(CANVAS_SIZE, DRAW_SQUARES);
        Body[] bodies = new Body[NUMBER_OF_BODIES];
        Octree iterationTree;
        for (int i = 0; i < bodies.length; i++) {
            bodies[i] = Body.getRandom(AVERAGE_BODY_MASS, SIMULATION_SIZE,0.00025);
        }
        bodies[0] = new Body(1, new Vector3(50,50,50), new Vector3() );
        int seconds = 0;
        while (true) {
            seconds++;
            iterationTree = Octree.fromBodies(bodies, (int)SIMULATION_SIZE);
            //performSimulationStep(bodies, iterationTree);
            if (seconds % (3600) == 0) {
                drawer.clean();
                iterationTree.draw(drawer);
                drawer.display();
            }
            //Forces Algorithm
        }
    }

    private static void performSimulationStep(Body[] bodies, Octree octree){
        for (Body body : bodies) {
            body.move(body.getPosition().multiply(1/body.getPosition().length()).multiply(-1).multiply(0.01));
        }
    }
}
