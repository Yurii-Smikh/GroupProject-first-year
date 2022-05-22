package Simulation;
import Models.*;
import Octree.IOctreeDrawer;
import Octree.Octree;
import Output.CodeDrawOctreeDrawer;

import java.util.Random;

public class Simulation {
    private static final int NUMBER_OF_BODIES = 1000;
    private static final double AVERAGE_BODY_MASS = 4 * 1.989e30; // kilograms (some Big number)
    private static final int CANVAS_SIZE = 512;
    private static final boolean DRAW_SQUARES = false;
    private static final double SECTION_SIZE = 1;
    private static final double SIMULATION_SIZE = 512;


    public static void main(String[] args) {
        IOctreeDrawer drawer = new CodeDrawOctreeDrawer(CANVAS_SIZE, DRAW_SQUARES, SECTION_SIZE);
        Body[] bodies = new Body[NUMBER_OF_BODIES];
        Random random = new Random(2022);
        Octree iterationTree;
        for (int i = 0; i < bodies.length; i++) {
            bodies[i] = Body.getRandom(random, AVERAGE_BODY_MASS, SIMULATION_SIZE,5e3);
        }
        bodies[0] = new Body(1, new Vector3(50,50,50), new Vector3() );
        int seconds = 0;
        boolean fuckpiss = false;
        while (!fuckpiss) {
            seconds++;
            iterationTree = Octree.fromBodies(bodies, (int)SIMULATION_SIZE);
            if (seconds % (3600) == 0) {
                drawer.clean();
                iterationTree.draw(drawer);
                drawer.display();
                fuckpiss = true;
            }
            //Forces Algorithm
        }
    }
}
