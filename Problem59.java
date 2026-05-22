// Time Complexity : O(V+E)
// Space Complexity : O(V+E)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        Map<Integer, List<Integer>> coursesMap = new HashMap<>();

        for (int[] prerequisit: prerequisites) {
            // prerequisit[0] - dependent; prerequisit[1] - inDependent
            inDegrees[prerequisit[0]]++;
            coursesMap.putIfAbsent(prerequisit[1], new ArrayList<>());
            coursesMap.get(prerequisit[1]).add(prerequisit[0]);
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                q.offer(i);
                count++;
            }
        }

        if (q.isEmpty()) return false;
        if (count == numCourses) return true;

        while (!q.isEmpty()) {
            int inDependentCourse = q.poll();
            List<Integer> dependentCourses = coursesMap.get(inDependentCourse);
            if (dependentCourses != null) {
                for (int dependentCourse: dependentCourses) {
                    inDegrees[dependentCourse]--;
                    if (inDegrees[dependentCourse] == 0) {
                        q.offer(dependentCourse);
                        count++;
                        if (count == numCourses) return true;
                    }
                }
            }
        }

        return false;
    }
}