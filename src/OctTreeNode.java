public class OctTreeNode {
    private Vector location;
    private double width;
    private Body data;
    private int numOfChildren;
    private boolean isInnerNode;

    private double totalMass;
    private Vector totalCentre;




//    private OctTree topLeftFront;  0 in Array
//    private OctTree topRightFront; 1
//    private OctTree botLeftFront; 2
//    private OctTree botRightFront; 3
//
//    private OctTree topLeftBack; 4
//    private OctTree topRightBack; 5
//    private OctTree botLeftBack; 6
//    private OctTree botRightBack; 7
    private OctTreeNode[] children;
    public OctTreeNode(Vector location,double widthOfCanvas){
        this.location = location;
        this.width = widthOfCanvas;

        this.isInnerNode = true;
        this.totalCentre = new Vector();
        this.totalMass = 0;
        this.numOfChildren = 0;
        this.children = new OctTreeNode[8];
    }

    public void split(){
        double childrenWidth = width / 2;

        children[0] = new OctTreeNode(new Vector(location.getX() + ));
    }
}
