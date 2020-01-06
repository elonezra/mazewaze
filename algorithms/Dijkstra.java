import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

public class Dijkstra {
	Hashtable<Integer, node_data> vertices;
	int source;
	public Dijkstra(NodeData[] vs, int source){
		this.source = source;
		vertices = new Hashtable<>();
		for (int i=0; i<vs.length; i++){
			vertices.put(vs[i].getKey(),vs[i]);
		}
	}

	public void computePaths(){
		NodeData s = (NodeData) vertices.get(source);
		s.setWeight( 0.);
		HeapMin Q = new HeapMin();
		Q.minHeapInsert(s);
		//Collection<NodeData> temp_node_collection = vertices;


		//O(nlogn)
		for (int i=1; i<vertices.size(); i++){//O(n)
			Q.minHeapInsert(vertices.get(i));//O(logn)
		}
		//O(nlogn) + O(mlogn) = O((m+n)logn)
		while (!Q.isEmpty()) {//O(m)
			NodeData u =(NodeData) Q.heapExtractMin();//O(logn)
			// Visit each edge exiting u

			u.adjacency.forEach((k,e) -> {
				NodeData v = (NodeData) vertices.get(e.getDest());
				if (!v.visited){
					double distU = u.getWeight() + e.getWeight();
					if (distU<v.getWeight()) {//relaxation
						v.setWeight(distU) ;
						v.previous = vertices.get(u.getKey()).getKey();
						Q.heapDecreaseKey(v);//O(logn)
					}
				}
			});

			u.visited = true;
		}
	}

//	public void printWeights(){
//		System.out.print("weights: ");
//
//
//
//		for (NodeData v : vertices) {
//			System.out.printf(v.getWeight() + ", ");
//		}
//		System.out.println();
//	}
	public ArrayList<node_data> getPath(int v, DGraph dGraph){
		int t = v;
		ArrayList<node_data> ans = new ArrayList<node_data>();
		ans.add(dGraph.connectivity.get(t));
		while(t != source){
			t = ((NodeData) vertices.get(t)).previous;
			ans.add(dGraph.connectivity.get(t));
		}
		ArrayList<node_data> ans2 = new ArrayList<node_data>();

		for(int i = 0; i < ans.size();i++)
		{
			ans2.add(ans.get(ans.size() - i-1));
		}
		return ans2;
	}

	//Todo: delete
//	public void printPaths(){
//		for (NodeData v : vertices){
//			//System.out.println("price of " + v.getKey()+" = " + v.getWeight() + ", path: " +  getPath(v.getKey()));
//		}
//		System.out.println();
//	}
}