/**** Method 1 ****/
//Time Complexity: O(V+E)
//Space Complexity: O(V+E)

//Successfully submitted in LeetCode

//We use BFS to perform topological sort by starting with nodes that have zero incoming edges (indegree 0). As we visit each course, we reduce the indegree of its dependents and add them to the queue if their indegree becomes zero. If we can visit all courses this way, there's no cycle, and the courses can be completed.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _207_Course_Schedule {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses == 0) return true;

    HashMap<Integer, List<Integer>> map = new HashMap<>();

    int[] indegreeArr = new int[numCourses];
    int count = 0;

    Queue<Integer> que = new LinkedList<>();

    for (int[] arr : prerequisites) {
      int to = arr[0];
      int from = arr[1];
      //this is test

      if (!map.containsKey(from)) {
        map.put(from, new ArrayList<>());
      }

      map.get(from).add(to);

      indegreeArr[to]++;
      count++;
    }

    for (int i = 0; i < numCourses; i++) {
      if (indegreeArr[i] == 0) {
        que.add(i);
      }
    }

    while (!que.isEmpty()) {
      int popped = que.poll();
      if (map.containsKey(popped)) {
        for (int i : map.get(popped)) {
          indegreeArr[i]--;
          count--;
          if (indegreeArr[i] == 0) {
            que.add(i);
          }
        }
        map.remove(popped);
      }
    }

    if (count == 0 && que.isEmpty()) {
      return true;
    }

    return false;
  }
}
