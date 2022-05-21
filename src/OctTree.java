public class OctTree {

    private Node root;

    public void add(Body body){

    }

    private class Node{
        private Node topLeftFront; // 0
        private Node topRightFront; // 1
        private Node botLeftFront; // 2
        private Node botRightFront; // 3

        private Node topLeftBack;
        private Node topRightBack;
        private Node botLeftBack;
        private Node botRightBack;

        private Body data;

        public Node(Body body){
            topLeftFront = null;
            topRightFront = null;
            botLeftFront = null;
            botRightFront = null;

            topLeftBack = null;
            topRightBack = null;
            botLeftBack = null;
            botRightBack = null;

            data = body;
        }
    }
}
