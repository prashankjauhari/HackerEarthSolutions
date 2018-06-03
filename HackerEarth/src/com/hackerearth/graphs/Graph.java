package com.hackerearth.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * This is source file contains graph data structure
 * which can be used for both directed and undirected
 * graph.It contains useful algorithm which can be
 * used to solve graph based problem.
 * @author root
 *
 * @param <T>
 */
public class Graph<T> {

	private Map<T,Vertex> vertexes;

	public Graph(){
		this.vertexes=new HashMap<T,Vertex>();
	}


	public Map<T, Vertex> getVertexes() {
		return vertexes;
	}

	public void setVertexes(Map<T, Vertex> vertexes) {
		this.vertexes = vertexes;
	}


	class Vertex{

		private T data;

		private List<T> adjacencyList;

		public Vertex(T data){
			this.data=data;
			this.adjacencyList=new LinkedList<T>();
		}

		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public List<T> getAdjacencyList() {
			return adjacencyList;
		}
		public void setAdjacencyList(List<T> adjacencyList) {
			this.adjacencyList = adjacencyList;
		}

	}

	/**
	 * source vertex is the vertex from where search is started.
	 * visited is the map to maintain the state of vertex(visited or not).
	 * in case some vertex is added into the adjacency list but 
	 * not present in the vertex list then this method will
	 * throw RuntimeException stating that 'Vertex not present in vertex set'
	 * 
	 * Time complexity is O(V+E)
	 * space complexity is O(V)
	 * 
	 * Note as i am using adjacency list representation of graph that's why
	 * its time complexity is O(V+E) but if you use adjacency matrix rep-
	 *  presentation then its time complexity will be O(V+E^2)
	 * 
	 * @param source
	 * @param visited
	 * @return sequence of visited vertex
	 * @throws RuntimeException
	 */
	public String BFS(T source,Map<T,Boolean> visited) throws RuntimeException{
		Vertex v=null;
		StringBuffer visitedSequence=new StringBuffer();
		Queue<T> q=new LinkedList<T>();
		q.add(source);
		visited.put(source, true);
		visitedSequence.append(source+" ");
		do{
			if(!q.isEmpty()){
				v=this.vertexes.get(q.remove());
				if(v==null){
					throw new RuntimeException("Vertex not present in vertex set.");
				}
			}

			for(int i=0;i<v.getAdjacencyList().size();i++){
				T w=v.getAdjacencyList().get(i);
				if(!visited.get(w)){
					visited.put(w, true);
					q.add(w);
					visitedSequence.append(w+" ");

				}

			}
		}while(!q.isEmpty());
		return visitedSequence.toString();
	}
	
	public StringBuffer DFS(T data,Map<T,Boolean> visited,StringBuffer visitedSequence) throws RuntimeException{
		Vertex v=this.getVertexes().get(data);
		if(v==null)
			throw new RuntimeException("Vertex not present in the vertex set.");
		
		for(int i=0;i<v.getAdjacencyList().size();i++){
			if(!visited.get(v.getAdjacencyList().get(i))){
				visited.put(v.getAdjacencyList().get(i), true);
				visitedSequence.append(v.getAdjacencyList().get(i)+" ");
				this.DFS(v.getAdjacencyList().get(i), visited, visitedSequence);
			}
		}
		return visitedSequence;
	}

}
