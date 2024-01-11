import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class WeightedGraph {
    String name;
    int num_vrtx;
    Vector<Vertex> vrtxArray = new Vector<Vertex>();
    List<WeightedEdge> wedges = new ArrayList<>();
    int[][] distTbl;
    // adjacency list is configured as ArrayList of Vertex List)
    ArrayList<List<Vertex>> adjList = new ArrayList<List<Vertex>>();
    boolean dest_arrived = false; // used in graph search algorithms
    public WeightedGraph(String nm) {
        this.name = nm;
    }
    public Vertex addVertex(String vrtxName) {
        if (this.findVertex(vrtxName) == null) {
            Vertex newVrtx = new Vertex(vrtxName);
            this.vrtxArray.add(newVrtx);
            newVrtx.setVID(this.num_vrtx);
            adjList.add(newVrtx.getVID(), new ArrayList<Vertex>());
            this.num_vrtx++;
            return newVrtx;
        } else {
            return null;
        }
    }
    public Vertex findVertex(String vrtxName) {
        String vname;
        for (Vertex v : this.vrtxArray) {
            vname = v.getName();
            if (vname.equals(vrtxName))
                return v;
        }
        return null;
    }
    public void addWeightedEdge(Vertex vrtx_src, Vertex vrtx_dest, int weight) {
        WeightedEdge wedge = new WeightedEdge(vrtx_src, vrtx_dest, weight);
        this.wedges.add(wedge);
        this.adjList.get(vrtx_src.getVID()).add(vrtx_dest);
        wedge = new WeightedEdge(vrtx_dest, vrtx_src, weight); // bidirectional weighted edge
        this.wedges.add(wedge);
        this.adjList.get(vrtx_dest.getVID()).add(vrtx_src);
    }
    public void initDistTable() {
        this.distTbl = new int[this.num_vrtx][this.num_vrtx];
// initialize distance table
        for (int i=0; i<this.num_vrtx; i++) {
            for (int j=0; j<this.num_vrtx; j++) {
                if (i == j)
                    this.distTbl[i][j] = 0;
                else
                    this.distTbl[i][j] = Integer.MAX_VALUE / 2; // to prevent integer overflow
            }
        }
//set the edges to the undirected graph
        for (WeightedEdge e: wedges) {
//creating a new node (from source to destination) in the adjacency list
            int srcVID = e.getSrcVID();
            int destVID = e.getDestVID();
            distTbl[srcVID][destVID] = e.getWeight();
        }
    }

    public void printDistTable() {
        int edge_weight;
        System.out.printf("Distance Table :\n");
        System.out.print("     |");
        for(int i=0; i<this.num_vrtx; i++) {
            System.out.printf("%5s", this.vrtxArray.get(i).getName() ); }
        System.out.print("\n-----+");
        for(int i=0; i<this.num_vrtx; i++) {
            System.out.print("-----"); }
        System.out.println();
        for (int i=0; i<this.num_vrtx; i++) {
            System.out.printf("%5s|", this.vrtxArray.get(i).getName());
            for (int j=0; j<this.num_vrtx; j++) {
                edge_weight = this.distTbl[i][j];
                if (edge_weight == Integer.MAX_VALUE/2)
                    System.out.printf("   oo"); // simplified infinity symbol
                else
                    System.out.printf("%5d", edge_weight); }
            System.out.println(); }
        System.out.println();
    }

    private void _DFS(Vertex vrtx, Vertex dest, List<Vertex> path) {
        path.add(vrtx);
        if (vrtx.equals(dest)) { // arrived to destination
            dest_arrived = true;
            return;
        }
        for (Vertex v : this.adjList.get(vrtx.vid)) {
            if (path.contains(v))
                continue; // avoid cycle
            if (v.equals(dest)) { // arrived to destination
                path.add(v);
                dest_arrived = true;
                break;
            }
            if (!dest_arrived) {
                _DFS(v, dest, path);
                if (!dest_arrived) {
                    path.remove(path.size() - 1); // pop the last added vertex } }
                    if (dest_arrived)
                        break;
                } // end for
            } // end _DFS()
        }
    }
    public List<Vertex> DepthFirstSearch(Vertex start, Vertex dest) {
        List<Vertex> path = new ArrayList<>();
        dest_arrived = false;
        _DFS(start, dest, path);
        return path;
    }
    public List<Vertex> BreadthFirstSearch(Vertex start, Vertex dest) {
        for(Vertex v : this.vrtxArray) {
            v.visited = false;
            v.prev = null;
            v.level = -1;
        }
        start.level = 0;
        start.visited = true;
        start.prev = start;
        int num_visited = 1; // just including start
        int searchLevel = 0;
        while(num_visited < num_vrtx) {
            //System.out.printf("BFS::searchLevel(%2d) :", searchLevel);
            for(Vertex v : this.vrtxArray) {
                if ((v.visited == true) && (v.level == searchLevel)) {
                    for(Vertex w : this.adjList.get(v.vid)) {
                        if (w.visited == false) {
                            w.visited = true; // set as Visited
                            w.level = searchLevel + 1;
                            w.prev = v;
                            num_visited++;
                            //System.out.print(w); System.out.print(" ");
                        }
                    }
                }
            }
            searchLevel++;
            //System.out.println();
        } // end while Array*/
        List<Vertex> path = new ArrayList<>();
        Vertex v = dest;
        while (!v.equals(start)) {
            path.add(0, v); // put v at front
            v = v.prev;
        }
        path.add(0, v); // put v(start) at front
        return path;
    } // end BreadthFirstSearch()

    public List<Vertex> DijkstraSortestPath(Vertex start, Vertex dest) {
        ArrayList<Vertex> path = new ArrayList<>();
        if (dest.equals(start)) {
            path.add(dest);
            return path;
        }
        ArrayList<Vertex> selectedVrtxs = new ArrayList<>();
        ArrayList<Vertex> remainVrtxs = new ArrayList<>();
        int vid_start = start.vid;
        int vid_dest = dest.vid;
        int minAccDist, vAccDist;
        int minVID;
        Vertex minVrtx = null;
        for(Vertex v : vrtxArray) {
            if (v.equals(start)) {
                selectedVrtxs.add(v); v.visited = true; v.accDist = 0; v.prev = start;
            } else {
                remainVrtxs.add(v); v.visited = false; v.accDist = this.distTbl[vid_start][v.vid]; v.prev = start;
            }
        }
        while(!remainVrtxs.isEmpty()) {
            minAccDist = Integer.MAX_VALUE / 2; // to prevent integer overflow
            minVID = -1;
            minVrtx = null;
            /* find the not-selected vertex with minimum accumulated distance */
            for(Vertex v : remainVrtxs) {
                vAccDist = v.accDist;
                if (vAccDist < minAccDist) {
                    minVID = v.vid;
                    minAccDist = vAccDist;
                    minVrtx = v;
                }
            } // end for
            if (minVID == -1) { // if no vrtx is selected
                System.out.println("Error in selection of vertex with minimum AccDist");
                System.out.println("Graph is not fully connected !!");
                break;
            }
            selectedVrtxs.add(minVrtx);
            remainVrtxs.remove(minVrtx);
            minAccDist = minVrtx.accDist;
            for (Vertex v : remainVrtxs) {
                /* edge relaxation */
                if (v.accDist > (minAccDist + distTbl[minVID][v.vid])) { v.accDist = minAccDist + distTbl[minVID][v.vid]; v.prev = minVrtx; }
            } // end for
            if (minVrtx.equals(dest)) { // if reached to the destination
                break;
            }
        } // end while
        path.clear();
        path.add(dest);
        Vertex v = dest;
        while (!v.equals(start)) {
            v = v.prev;
            path.add(0, v);
        }
        return path;
    }

    public void printWeightedGraph() {
        System.out.printf("Vertices (num_vrtx = %d) : ", num_vrtx);
        for(int i=0; i<vrtxArray.size(); i++) {
            System.out.print(vrtxArray.get(i) + " ");
        }
        System.out.println();
        System.out.println("Adjacency List for the Graph is: ");
        for(int i=0; i<vrtxArray.size(); i++) {
            System.out.print(vrtxArray.get(i) + " -> [ ");
            for(int j=0; j<adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + ", ");
            }
            System.out.println("]");
        }
    }

}
