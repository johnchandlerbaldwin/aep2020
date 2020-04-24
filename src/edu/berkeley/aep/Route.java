package edu.berkeley.aep;

import java.util.LinkedList;
import java.util.Iterator;

public class Route {

//    //initialize map to zeros
//    private int[][] map = new int[7][7];
//
//    //input directed edges
//    //a
//    public Route() {
//
//        map[0][5] = 1;
//
//        //b
//        map[1][0] = 1;
//        map[1][2] = 1;
//
//        //c
//        map[2][3] = 1;
//        map[2][4] = 1;
//
//        //d
//        map[3][4] = 1;
//
//        //e
//        map[4][1] = 1;
//
//        //f
//
//        //g
//
//        //h
//        map[7][1] = 1;
//    }

    //// https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/

    private LinkedList<Integer> edges[]; //Edges

    // Constructor
    Route() {
        edges = new LinkedList[8];
        for (int i=0; i<edges.length; ++i)
            edges[i] = new LinkedList();

        //initialize edges
        edges[0].add(5);
        edges[1].add(0);
        edges[1].add(2);
        edges[2].add(3);
        edges[2].add(4);
        edges[3].add(4);
        edges[4].add(1);
        edges[7].add(1);
    }

    // prints BFS traversal from a given source s
    private LinkedList<Integer> BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[8];
        int numHops[] = new int[8];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        numHops[s]=0;
        queue.add(s);

        LinkedList<Integer> nodesList = new LinkedList<Integer>();

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            //System.out.print(s+" ");
            nodesList.add(s);

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = edges[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;

                    //update number of hops to i
                    //numHops[];

                    queue.add(n);
                }
            }
        }

        return(nodesList);

    }

    public boolean canReach(char startNode, char endNode){
        //convert chars to integers
        int startInt = startNode - 'a';
        int endInt = endNode - 'a';

        LinkedList<Integer> connectedNodes = new LinkedList<Integer>();
        connectedNodes = BFS(startInt);

        if(connectedNodes.contains(endInt)){
            return(true);
        }

        else{
            return(false);
        }
    }

//    public static void main(String[] args){
//        Route rt = new Route();
//
//        System.out.println(rt.canReach('e','b'));
//    }

}
