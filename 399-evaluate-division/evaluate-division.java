class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v, val));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair(u, 1.0 / val));
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);
            ans[i] = dfs(src, dst, graph, new HashSet<>());
        }
        return ans;
    }

    private double dfs(String curr, String target, Map<String, List<Pair>> graph, Set<String> seen) {
        if (!graph.containsKey(curr)) return -1.0;
        if (curr.equals(target)) return 1.0;
        seen.add(curr);
        for (Pair p : graph.get(curr)) {
            if (seen.contains(p.node)) continue;
            double res = dfs(p.node, target, graph, seen);
            if (res != -1.0) {
                return p.weight * res;
            }
        }
        return -1.0;
    }

    private static class Pair {
        String node;
        double weight;
        Pair(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
