package ap.graph;

import java.util.*;

public class PathExists {

    Set<Integer> visited = new HashSet<>();
    List<List<Integer>> adjList;

    public List<List<Integer>> getAdjacencyList(int n, int[][] edges) {

        adjList = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            adjList.add(i, list);
        }


        for(int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i  + "-->" + adjList.get(i).toString());
            System.out.println();

        }
        return adjList;



    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        List<List<Integer>> adjList = getAdjacencyList(n, edges);
        System.out.println("Check Path----");
        return dfs(source, destination);


    }

    public boolean dfs(int n, int destination) {

        if(n == destination) { return true;}

        visited.add(n);
        System.out.println(n);
        List<Integer> children = adjList.get(n);

        for(int child: children) {
            if(!visited.contains(child)) {
                if(dfs(child, destination)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int [][] edges =   {{0,1},{3,0},{2,0},{4,4}};
        int source = 0;
         int dest   = 4;
         PathExists pe = new PathExists();
         boolean res = pe.validPath(4,edges, source, dest);
        System.out.println(res);




    }
}



