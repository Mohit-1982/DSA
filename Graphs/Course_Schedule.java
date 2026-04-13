Leetcode - 207
  class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
                list.add(i);
            }
        }

        while (!q.isEmpty()) {
            int front = q.remove();

            for (int node : adj.get(front)) {
                indeg[node]--;

                if (indeg[node] == 0) {
                    q.add(node);
                    list.add(node);
                }
            }
        }

        return (list.size() == numCourses) ? true : false;
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
