import java.util.*;

/*
        https://leetcode.com/problems/evaluate-division/
*/
public class EvaluateDivision {
    static class Solution {
        Map<String, Map<String, Double>> graph;

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            double[] res = new double[queries.size()];
            graph = new HashMap<>();
            // build graph
            buildGraph(equations, values);

            // do dfs to the graph for each query
            for(int i = 0; i < res.length; i++) {
                String src = queries.get(i).get(0);
                String dest = queries.get(i).get(1);
                res[i] = solveQuery(src, dest);
                // System.out.println("res["+ i +"]: " + res[i]);
            }
            return res;
        }

        double solveQuery(String src, String dest) {
            if(!graph.containsKey(src) || !graph.containsKey(dest)) return -1.0;

            Set<String> visited = new HashSet<>();
            Map<String, Double> cals = new HashMap<>();

            Queue<String> que = new LinkedList<>();
            que.add(src);
            cals.put(src, 1.0);

            while(!que.isEmpty()) {
                String node = que.remove();
                double val = cals.get(node);

                if(node.equals(dest)) return val;
                visited.add(node);

                Map<String, Double> adj = graph.get(node);
                for(String v2 : adj.keySet()) {
                    if(!visited.contains(v2)) {
                        que.add(v2);
                        cals.put(v2, val * adj.get(v2));
                    }
                }
            }
            return -1.0;
        }

        void buildGraph(List<List<String>> equations, double[] values) {
            for(int i = 0; i < values.length; i++) {
                double value = values[i];
                String v1 = equations.get(i).get(0);
                String v2 = equations.get(i).get(1);
                Map<String, Double> adj1 = graph.getOrDefault(v1, new HashMap<String, Double>());
                Map<String, Double> adj2 = graph.getOrDefault(v2, new HashMap<String, Double>());
                adj1.put(v2, value);
                adj2.put(v1, 1 / value);
                graph.put(v1, adj1);
                graph.put(v2, adj2);
            }
            // System.out.println("Graph : " + graph );
        }
    }

    public static void main(String[] args) {
        // input:
        // [["a","b"],["b","c"],["bc","cd"]]
        // [1.5,2.5,5.0]
        // [["a","c"],["c","b"],["bc","cd"],["cd","bc"], ["a", "bc"],["a","x"], ["c","c"]]
        String[][] equationsArr = { {"a","b"},{"b","c"},{"bc","cd"}};
        double[] values = {1.5,2.5,5.0};
        String[][] queriesArr = {{"a","c"},{"c","b"},{"bc","cd"},{"cd","bc"}, {"a", "bc"},{"a","x"}, {"c","c"}};

        List<List<String>> equations = new ArrayList<>();
        for(int i = 0; i < equationsArr.length; i++)
            equations.add(Arrays.asList(equationsArr[i]));
        List<List<String>> queries = new ArrayList<>();
        for(int i = 0; i < queriesArr.length; i++)
            queries.add(Arrays.asList(queriesArr[i]));

        Solution sol = new Solution();
        double[] result = sol.calcEquation(equations, values, queries);
        System.out.println("Result: " + Arrays.toString(result));
        // res: [3.75000,0.40000,5.00000,0.20000,-1.00000,-1.00000,1.00000]
    }
}
