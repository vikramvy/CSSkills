package com.ds;

import java.nio.file.WatchService;
import java.util.Stack;

class Vertex{
	public char label;
	public boolean wasVisited;
	
	public Vertex(char label)
	{
		this.label = label;
		wasVisited = false;
	}
}
public class Graph {
	
	private final int MAX_VERTS = 10;
	private Vertex vertexList[] ;
	private int adjMatrix[][];
	private int nVerts; //current number of vertices
	private int nEdges;
	private Stack<Integer> stack;
	
	public Graph()
	{
		vertexList = new Vertex[MAX_VERTS]; //Array initialization
		adjMatrix = new int[MAX_VERTS][MAX_VERTS]; //max adj matrix size 
		nVerts = 0; //set the adjacency matrix to 0,0 
		nEdges=0;
		
		for(int i = 0; i<MAX_VERTS;i++)
			for(int j =0; j<MAX_VERTS;j++)
				adjMatrix[i][j] = 0;
	
		stack = new Stack<Integer>();
	}
	public void addVertex(char name)
	{
		vertexList[nVerts++] = new Vertex(name);	
	}
	public void addEdge(int start, int end)
	{
		adjMatrix[start][end]=1;
		adjMatrix[end][start]=1;
		nEdges++;
	}
	public void removeEdge(int start, int end)
	{
		adjMatrix[start][end]=0;
		adjMatrix[end][start]=0;
		nEdges--;
	}
	public int getAdjUnvisitedVertex(int v) {
		for(int j =0; j<nVerts;j++)
		{
			if(adjMatrix[v][j] == 1 && vertexList[j].wasVisited==false)
				return j;
		}
		return -1;
	}
	public int totalEdges()
	{
		return nEdges;
	}
	public void displayVertex(int v)
	{
		System.out.print(vertexList[v].label);
	}
	public void displayAdjMatrixGraph()
	{
		System.out.println("The adjacency matrix for the given graph is: ");
        System.out.print("  ");
        for (int i = 0; i <nVerts; i++)
            System.out.print(vertexList[i].label + " ");
        System.out.println();

        for (int i = 0; i <nVerts; i++) 
        {
            System.out.print(vertexList[i].label + " ");
            for (int j = 0; j <nVerts; j++) 
                System.out.print(adjMatrix[i][j] + " ");
            System.out.println();
        }
	}
	public void dfs()
	{
		//start with first vertex set that as visited
		vertexList[0].wasVisited=true;
		displayVertex(0);;
		stack.push(0);
		
		while(!stack.isEmpty())
		{
			//get all unvisited nodes
			int unvisited = getAdjUnvisitedVertex(stack.peek());
			if(unvisited == -1)//if no such vertex
			{
				stack.pop(); //pop next one
			}else
			{
				vertexList[unvisited].wasVisited = true; //mark it
				displayVertex(unvisited); //print
				stack.push(unvisited);//push in stack
				
			}
			printStack();
		}//end while
		//stack should be empty after while loop so reset all Adj Matrix nodes as visited to false
		for(int i = 0; i<nVerts;i++)
		{
			vertexList[i].wasVisited = false;
		}
		//end dfs
	}

	public void printStack()
	{
		stack.forEach(s->System.out.print(s));
	}

	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args)
	{
		Graph g = new Graph();
		g.addVertex('a');
		g.addVertex('b');
		g.addVertex('c');
		g.addVertex('d');
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(0, 3);
		g.addEdge(2,3);
		
		System.out.println("Total Numbner of Edges: "+g.totalEdges());
		g.displayAdjMatrixGraph();
		/*g.removeEdge(1, 2);
		System.out.println("Total Numbner of Edges: "+g.totalEdges());
		g.displayAdjMatrixGraph();*/
		System.out.println();
		System.out.println("Visits DFS ");
		g.dfs();
		System.out.println();
		
	}
	
	
	
}