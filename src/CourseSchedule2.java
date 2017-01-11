import java.util.*;

/**
 * Created by Ashutosh on 12/29/16.
 */
//leetcode : 210

public class CourseSchedule2 {

    List<Integer> finalCourses = new ArrayList<>();
    HashSet<Integer> localTrack;
    HashMap<Integer, List<Integer>> graph = new HashMap<>();

    public int[] canFinish(int numCourses, int[][] prerequisites) {

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
            if (!DFS(key)) {
                int[] ret = new int[1];
                ret[0] = 0;
                return ret;
            }

            if(finalCourses.size() > numCourses){
                int[] ret = new int[1];
                ret[0] = 0;
                return ret;
            }
        }

        int length = finalCourses.size();
        int[] output = new int[length];
        for(int i = 0; i< length; i++) {
            output[i] = finalCourses.get((length - 1) - i);
        }

        System.out.println(Arrays.toString(output));

        return output;
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
            finalCourses.add(0,key);
            localTrack.remove(key);
        }
        return true;
    }

    public static void main(String[] args) {

        CourseSchedule2 obj = new CourseSchedule2();
        int[][] test = new int[][]{
                {1,0}
        };
        obj.canFinish(2, test);

    }

}
