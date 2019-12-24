package dataStructure;

public class Edge implements edge_data{
    Node src, dest ;
    double weight;
    String info;
    int tag;

    ///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////Constructor/////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////
    public Edge(Node src, Node dest, double weight){
        this.src = src;
        this.dest = dest;
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
        return src.getKey();
    }

    /**
     * The id of the destination node of this edge
     *
     * @return
     */
    @Override
    public int getDest() {
        return dest.getKey();
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

    public void setDest(Node dest) {
        this.dest = dest;
    }

    public void setSrc(Node src) {
        this.src = src;
    }
}
