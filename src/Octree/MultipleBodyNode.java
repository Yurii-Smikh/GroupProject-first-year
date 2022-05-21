package Octree;

import Simulation.Body;

public class MultipleBodyNode extends BodyNode{
    private BodyNode[] leafNodes;

    public MultipleBodyNode(SingleBodyNode... nodes){
        leafNodes = new BodyNode[8];
        for (BodyNode node : leafNodes) {
            node = new EmptyBodyNode();
        }
        for (SingleBodyNode inputNode : nodes) {
            add(inputNode);
        }
    }

    @Override
    public int size() {
        int sum = 0;
        for (BodyNode node :
                leafNodes) {
            sum += node.size();
        }
        return sum;
    }

    @Override
    public BodyNode add(SingleBodyNode node){
        //TODO actually add it
        return this;
    }
}