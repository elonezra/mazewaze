import java.io.Serializable;

public class Edge implements edge_data, Serializable {
    NodeData node;              // Destination Node
    double weight;
    String info;
    int tag;

    ///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////Constructor/////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////
    public Edge(NodeData node, double weight){
        this.node = node;
        this.weight = weight;

    }


    ///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////Getters and Setters/////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////
    /**
     * The id of the source node of this edge.
     *
     * @return
     */
    @Override
    public int getSrc() {
        return this.node.previous;
    }

    /**
     * The id of the destination node of this edge
     *
     * @return
     */
    @Override
    public int getDest() {
        return this.node.getKey();
    }

    /**
     * @return the weight of this edge (positive value).
     */
    @Override
    public double getWeight() {
        return this.weight;
    }

    /**
     * return the remark (meta data) associated with this edge.
     *
     * @return
     */
    @Override
    public String getInfo() {
        return this.info;
    }

    /**
     * Allows changing the remark (meta data) associated with this edge.
     *
     * @param s
     */
    @Override
    public void setInfo(String s) {
        this.info = s;
    }

    /**
     * Temporal data (aka color: e,g, white, gray, black)
     * which can be used be algorithms
     *
     * @return
     */
    @Override
    public int getTag() {
        return this.tag;
    }

    /**
     * Allow setting the "tag" value for temporal marking an edge - common
     * practice for marking by algorithms.
     *
     * @param t - the new value of the tag
     */
    @Override
    public void setTag(int t) {
        this.tag = t;
    }

    public void setDest(NodeData dest) {
        this.node = dest;
    }

    public void setSrc(NodeData src) {
        this.node.previous = src.getKey();
    }
}
