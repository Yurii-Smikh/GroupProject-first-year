package Simulation;
import codedraw.*;
import Models.*;
import Octree.Octree;

import java.awt.*;
import java.util.Random;

public class Simulation {
    // gravitational constant
    public static final double G = 6.6743e-11;

    // one astronomical unit (AU) is the average distance of earth to the sun.
    public static final double AU = 150e9; // meters

    // one light year
    public static final double LY = 9.461e15; // meters

    // some further constants needed in the simulation
    // set some system parameters
    public static final double SECTION_SIZE = 10 * AU; // the size of the square region in space

    public static final int NUMBER_OF_BODIES = 100;
    public static final double OVERALL_SYSTEM_MASS = 40 * 1.989e30; // kilograms (some Big number)

    // all quantities are based on units of kilogram respectively second and meter.

    // The main simulation method using instances of other classes.
    public static void main(String[] args) {

        // simulation
        CodeDraw cd = new CodeDraw();

        // create some additional bodies
        Body[] bodies = new Body[NUMBER_OF_BODIES];

        Random random = new Random(2022);

        for (int i = 0; i < bodies.length; i++) {
            bodies[i] = new Body(Math.abs(random.nextGaussian()) * OVERALL_SYSTEM_MASS / bodies.length,
                    new Vector3(0.2 * random.nextGaussian() * AU, 0.2 * random.nextGaussian() * AU, 0.2 * random.nextGaussian() * AU),
                    new Vector3(0 + random.nextGaussian() * 5e3, 0 + random.nextGaussian() * 5e3, 0 + random.nextGaussian() * 5e3));
        }




        double seconds = 0;
        while (true) {
            seconds++; // each iteration computes the movement of the celestial bodies within one second.

            // merge bodies that have collided
//            for (int i = 0; i < bodies.length; i++) {
//                for (int j = i + 1; j < bodies.length; j++) {
//                    if (bodies[j].getPosition().distanceTo(bodies[i].getPosition()) <
//                            SpaceDraw.massToRadius(bodies[j].getMass()) + SpaceDraw.massToRadius(bodies[i].getMass())) {
//                        Body[] bodiesOneRemoved = new Body[bodies.length - 1];
//                        for (int k = 0; k < bodiesOneRemoved.length; k++) {
//                            bodiesOneRemoved[k] = bodies[k < j ? k : k + 1];
//                        }
//                        bodies = bodiesOneRemoved;
//
//                        // since the body index i changed size there might be new collisions
//                        // at all positions of bodies, so start all over again
//                        i = -1;
//                        j = bodies.length;
//                    }
//                }
//            }

            // for each body (with index i): compute the total force exerted on it.
            for (int i = 0; i < bodies.length; i++) {
//                forceOnBody.put(bodies[i], new Vector3());
//                forceOnBody[i] = new Vector3();
//                for (int j = 0; j < bodies.length; j++) {
//                    if (i != j) {
//                        Vector3 forceToAdd = bodies[i].gravitationalForce(bodies[j]);
//                        forceOnBody.put(bodies[i], forceOnBody.get(bodies[i]).plus(forceToAdd));
//                    }
//                }
            }
            // now forceOnBody[i] holds the force vector exerted on body with index i.

            // for each body (with index i): move it according to the total force exerted on it.
//            for (int i = 0; i < bodies.length; i++) {
//                bodies[i].move(forceOnBody.get(bodies[i]));
//            }

            // show all movements in the canvas only every hour (to speed up the simulation)
            if (seconds % (3600) == 0) {
                // clear old positions (exclude the following line if you want to draw orbits).
                cd.clear(Color.BLACK);

                // draw new positions
                for (Body body : bodies) {
                    body.draw(cd);
                }

                // show new positions
                cd.show();
            }
        }
    }
}
