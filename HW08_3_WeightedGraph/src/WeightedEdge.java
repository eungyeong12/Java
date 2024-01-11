public class WeightedEdge {
    Vertex src;
    Vertex dest;
    int weight;
    //creating a constructor of the class Edge
    WeightedEdge(Vertex src, Vertex dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    @Override
    public String toString() {
        return (this.src + "->" + this.dest); }
    int getSrcVID( ) {
        return this.src.vid;
    }
    int getDestVID() {
        return this.dest.vid;
    }
    Vertex getDest() {
        return this.dest;
    }
    int getWeight() {
        return this.weight;
    }
}
