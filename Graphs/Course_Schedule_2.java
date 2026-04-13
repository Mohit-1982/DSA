Leetcode - 210
  class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> list = canFinish(numCourses, prerequisites);
        if (list.size() == 0) return new int[0];
        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
    public List<Integer> canFinish(int numCourses, int[][] prerequisites) {
        //kahn's Algorithm + cycle detection logic
        List<List<Integer>> adj = adjBuild(prerequisites, numCourses);
        List<Integer> list = new ArrayList<>();
        int[] indeg = new int[numCourses];

        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                indeg[adj.get(i).get(j)]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int front = q.remove();
            list.add(front);

            for (int node : adj.get(front)) {
                indeg[node]--;

                if (indeg[node] == 0) {
                    q.add(node);
                }
            }
        }

        return (list.size() == numCourses) ? list : new ArrayList<>();
    }

    public List<List<Integer>> adjBuild(int[][] prerequisites, int numCourses) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {

            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(v).add(u);
        }

        return adj;
    }
}
