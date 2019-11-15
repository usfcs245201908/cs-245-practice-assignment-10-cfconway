import java.lang.Exception;
import java.util.List;
import java.util.*;

public class GraphImplementation implements Graph
{
	int vertices;
	int[][] matrix;

	public GraphImplementation(int vertices)
	{
		this.vertices = vertices;


	
	}

	public void addEdge(int v1, int v2) throws Exception
	{
		if(v1>=0 && v2<vertices)
		{
			matrix[v1][v2]=1;
		}
		else
			throw new Exception("Error");


	}

	public List<Integer> topologicalSort()
	{
		int[] sum = new int[vertices]; //now we need to sum up the columns (i.e # 1s in columns)
		for(int i=0; i<vertices; i++)
			for(int j=0; j<vertices;j++)
				sum[i]+=matrix[i][j];
		int next = findZero(sum);	
		sum[next]=-1;
		//loop through matrix, and find where in the correspoinding row there are ones
		for(int i=0; i<vertices; i++)
		{
			sum[i]-=matrix[next][i];
		}

	}

	public int findZero(int[] sum)
	{
		for(int i=0; i<sum.length; i++)
			if(sum[i]==0)
				return i;
	}
	public List<Integer> neighbors(int vertex) throws Exception
	{ 	List neighbors = new ArrayList();
		for(int i = 0; i<vertices; i++)
		{
			if(vertex == matrix[i])
				neighbors.add(matrix[i]);
			
		}
		return neighbors;
	}
}