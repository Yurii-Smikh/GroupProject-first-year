package Octree;

import Models.Body;
import Models.Vector3;

public class Octree {
    private OctreeNode root;

    public Octree(int size){
        root = new BlankNode(new Vector3(0,0,0), size);
    }

    public void add(Body body){
        root = root.add(body);
    }

    public void draw(IOctreeDrawer drawer){
        root.draw(drawer);
    }

    public static Octree fromBodies(Body[] bodies, int size){
        Octree tree = new Octree(size);
        for (Body body : bodies) {
            tree.add(body);
        }
        return tree;
    }
}
