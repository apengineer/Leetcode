package ap.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CItyExcitementScore {

    int[] excitements;
    List<List<Integer>> adjList ;

    Set<Integer> visited = new HashSet<>();

    int maxScore = Integer.MIN_VALUE;
    int curScore = 0;



    public static void main(String[] args) {
        int[] excitements = new int[]{5, 1, 2, 15,20, 100};
        List<List<Integer>> adjList = new ArrayList<>();
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(4);
        adjList.add(list);

        list = new ArrayList();
        list.add(0);
        adjList.add(list);

        list = new ArrayList();
        list.add(3);
        adjList.add(list);

        list = new ArrayList();
        list.add(2);
        list.add(4);
        list.add(4);
        adjList.add(list);

        list = new ArrayList();
        list.add(0);
        list.add(3);
        adjList.add(list);

        list = new ArrayList();
        list.add(3);
        adjList.add(list);


        int score = new CItyExcitementScore().totalExcitementScore(excitements, adjList);
        System.out.println(score);
    }

    public boolean dfs(int city, int numberOfFlights) {

        if(numberOfFlights == 0) {
            return true;
        }
        for(int child: adjList.get(city)){

            if(!visited.contains(child)) {
                curScore += excitements[child];
                numberOfFlights--;
                visited.add(child);
                if(!dfs(child, numberOfFlights)){
                    curScore -= excitements[child];
                    numberOfFlights++;
                }else{
                    maxScore = Math.max(maxScore, curScore);
                }

            }
        }

        return false;

    }


    public int totalExcitementScore(int[] excitements, List<List<Integer>> adjList) {
        this.adjList = adjList;
        this.excitements = excitements;

        for(int i = 0; i < excitements.length; i++) { // all cities


            curScore += excitements[i];
            visited.add(i);
            dfs(i, 3);
            curScore = 0;
            visited = new HashSet<>();

        }

        return maxScore;
    }



    }
