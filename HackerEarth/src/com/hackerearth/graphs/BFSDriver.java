package com.hackerearth.graphs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Implementation of BFS using Adjecency list representation of 
 * graphs
 * @author Prashank Jauhari
 */

public class BFSDriver {
	
	public static void main(String args[]){
		
		Graph<Integer> graph=new Graph<Integer>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter total number of verticies :");
		Integer v=Integer.parseInt(sc.nextLine());
		for(int i=0;i<v;i++){
			System.out.println("Enter Vertex :");
			Integer u=Integer.parseInt(sc.nextLine());
			Graph<Integer>.Vertex vertex=graph.new Vertex(u);
			System.out.println("Enter its neighbour : ");
			String adjecents[]=sc.nextLine().split(" ");
			for(String w:adjecents){
				vertex.getAdjacencyList().add(Integer.parseInt(w));
			}
			graph.getVertexes().put(u, vertex);
		}
		System.out.println("Enter source :");		
		Integer source=Integer.parseInt(sc.nextLine());
		Map<Integer,Boolean> visited=new HashMap<Integer,Boolean>();
		Set<Integer> keys=graph.getVertexes().keySet();
		Iterator<Integer> itr=keys.iterator();
		while(itr.hasNext()){
			visited.put(itr.next(), false);
		}
		System.out.println(graph.BFS(source,visited));
		sc.close();
	}

}
