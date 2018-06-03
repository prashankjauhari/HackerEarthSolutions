package com.hackerearth.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
	 * throw RuntimeException
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
					throw new RuntimeException("Vertex not present in vertex set");
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

}
