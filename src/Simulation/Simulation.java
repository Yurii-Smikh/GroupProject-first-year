package Simulation;
import Models.*;
import Octree.IOctreeDrawer;
import Octree.Octree;
import Output.CodeDrawOctreeDrawer;

import java.util.Random;

public class Simulation {
    private static final int NUMBER_OF_BODIES = 500;
    private static final double AVERAGE_BODY_MASS = 10; // kilograms (some Big number)
    private static final int CANVAS_SIZE = 512;  // size of the Canvas(window)
    private static final boolean DRAW_SQUARES = false;
    private static final double SIMULATION_SIZE = 512;  // size of the simulation boundaries
    private static final double T = 1;


    public static void main(String[] args) {
        IOctreeDrawer drawer = new CodeDrawOctreeDrawer(CANVAS_SIZE, DRAW_SQUARES);
        Body[] bodies = new Body[NUMBER_OF_BODIES];
        Octree iterationTree;
        for (int i = 0; i < bodies.length; i++) {
            bodies[i] = Body.getRandom(AVERAGE_BODY_MASS, SIMULATION_SIZE,NUMBER_OF_BODIES * 0.00001);
        }
        bodies[0] = Body.getRandom(AVERAGE_BODY_MASS * NUMBER_OF_BODIES/2, SIMULATION_SIZE,0.00005);

        int seconds = 0;
        while (true) {
            seconds++;
            iterationTree = Octree.fromBodies(bodies, (int)SIMULATION_SIZE);
            performSimulationStep(bodies, iterationTree);
            if (seconds % (180) == 0) {
                drawer.clean();
                iterationTree.draw(drawer);
                drawer.display();
                System.out.println(iterationTree.getNonEmptyNodes());
            }
        }
    }

    private static void performSimulationStep(Body[] bodies, Octree octree){
        for (Body body : bodies) {// calculate total forces acting on every body
            body.addForce(octree.getForceExertedAt(body, T));
        }
        for (Body body : bodies) {// apply all forces
            body.applyForces();
        }
    }
}
