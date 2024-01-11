public class Vertex {
    String vname; //vertex name
    int vid;
    boolean visited; // used in Graph search
    Vertex prev; // used in Graph search
    int accDist; // accumulated distance from source, used in Graph search
    int level; // used in BFS
    // constructor of the class Vertex /Node
    Vertex(String name) // constructor
    {
        this.vname = name;
        this.visited = false;
        this.prev = null;
        this.accDist = 0;
    }
    public String getName() {
        return this.vname;
    }
    public String toString()
    {
        return this.vname;
    }

    public void setVID(int numVrtx) {
        this.vid = numVrtx;
    }

    public int getVID() {
        return vid;
    }
}
