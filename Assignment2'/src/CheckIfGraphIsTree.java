
import java.util.LinkedList;

public class CheckIfGraphIsTree {

    static class Graph {
        int vertices;
        LinkedList<Integer>[] adjList;

        public Graph(int vertices) {
            this.vertices = vertices;

            adjList = new LinkedList[vertices];
          
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination) {
       
            adjList[source].addFirst(destination);
            
            adjList[destination].addFirst(source);
        }

        public void checkifTree(){

            printGraph();

            
            boolean [] visited = new boolean[vertices];

          
            boolean isCycle = isCycleUtil(0, visited, -1);

            if(isCycle){
                
                System.out.println("Given Graph is not Tree");
                return;
            }

            for (int i = 0; i <vertices ; i++) {
                if(!visited[i]) {
                    System.out.println("Given Graph is not Tree");
                    return;
                }
            }
      
                System.out.println("Given Graph is Tree");
        }

        boolean isCycleUtil(int currVertex, boolean [] visited, int parent){

    
            visited[currVertex] = true;

            
            for (int i = 0; i <adjList[currVertex].size() ; i++) {
                int vertex = adjList[currVertex].get(i);
               
                if(vertex!=parent) {
                   
                    if(visited[vertex]){
                       
                        return true;
                    }
                    else{
                 
                        if (isCycleUtil(vertex, visited, currVertex)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public void printGraph(){
            for (int i = 0; i <vertices ; i++) {
                LinkedList<Integer> nodeList = adjList[i];
                System.out.println("Vertex connected from vertex: "+i);

                for (int j = 0; j <nodeList.size() ; j++) {
                    System.out.print("->" + nodeList.get(j));
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            Graph graph = new Graph(5);
            graph.addEdge(1,0);
            graph.addEdge(3,1);
            graph.addEdge(3,2);
            graph.addEdge(3,4);
            graph.checkifTree();
            System.out.println("----------------------------");
            Graph graph1 = new Graph(5);
            graph1.addEdge(1,0);
            graph1.addEdge(3,1);
            graph1.addEdge(3,2);
            graph1.addEdge(3,4);
            graph1.addEdge(4,0);
            graph1.checkifTree();
            System.out.println("----------------------------");
            Graph graph2 = new Graph(5);
            graph2.addEdge(1,0);
            graph2.addEdge(3,1);
            graph2.addEdge(3,2);
            graph2.checkifTree();
        }
    }
}
