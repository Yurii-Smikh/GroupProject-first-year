package Simulation;
import Models.*;
import Octree.IOctreeDrawer;
import Output.CodeDrawOctreeDrawer;

import java.util.Random;

public class Simulation {
    public static final int NUMBER_OF_BODIES = 10;
    public static final double OVERALL_SYSTEM_MASS = 40 * 1.989e30; // kilograms (some Big number)

    public static void main(String[] args) {
        IOctreeDrawer drawer = new CodeDrawOctreeDrawer();
        Body[] bodies = new Body[NUMBER_OF_BODIES];
        Random random = new Random(2022);
        for (int i = 0; i < bodies.length; i++) {
            bodies[i] = Body.getRandom(random, OVERALL_SYSTEM_MASS/NUMBER_OF_BODIES, 5e3);
        }

        double seconds = 0;
        while (true) {
            seconds++;
            if (seconds % (3600) == 0) {
                //clean canvas

                //draw all bodies
            }
        }
    }
}
