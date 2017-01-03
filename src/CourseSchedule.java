import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Ashutosh on 12/29/16.
 */
public class CourseSchedule {

    HashSet<Integer> finalCourses = new HashSet<>();
    HashSet<Integer> localTrack;
    HashMap<Integer, List<Integer>> graph = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < prerequisites.length; i++) {
            if(!graph.containsKey(prerequisites[i][0])) {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][1]);
                graph.put(prerequisites[i][0], list);
            }
            else{
                graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
        }

        for(Integer key : graph.keySet()) {
            localTrack = new HashSet<>();
            if (!DFS(key))
                return false;

            if(finalCourses.size() > numCourses) {
                return false;
            }
        }

        return true;
    }

    public boolean DFS(Integer key) {

        if(localTrack.contains(key)) return false;
        if(!finalCourses.contains(key)) {
            localTrack.add(key);
            if(graph.containsKey(key)) {
                for (Integer k : graph.get(key)) {
                    if (!DFS(k)) {
                        return false;
                    }
                }
            }
            finalCourses.add(key);
            localTrack.remove(key);
        }
        return true;
    }

    public static void main(String[] args) {

        CourseSchedule obj = new CourseSchedule();
        int[][] test = new int[][]{
                {0,1},{0,2},{1,2}
        };
        System.out.println(obj.canFinish(3, test));

    }

}
