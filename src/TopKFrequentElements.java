import java.util.*;

/**
 * Created by Ashutosh on 12/19/16.
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> countMap = new HashMap<>();
        List<Integer>[] rankMap = new List[nums.length + 1];

        for(int i = 0 ; i < nums.length; i++) {

            countMap.put(nums[i], countMap.getOrDefault(nums[i],0) + 1);

        }

        for(Integer key : countMap.keySet()) {

            int count = countMap.get(key);
            if(rankMap[count] == null) {

                rankMap[count] = new ArrayList<>();

            }

            rankMap[count].add(key);

        }

        List<Integer> output = new ArrayList<>();
        for(int j = rankMap.length - 1; j >= 0 && k > 0; j--) {

            if(rankMap[j] != null) {
                output.addAll(rankMap[j]);
                k -= rankMap[j].size();
            }

        }

        return output;
    }

    public static void main(String[] args) {

        TopKFrequentElements obj = new TopKFrequentElements();
        int[] test = {};
        System.out.println(Arrays.toString(obj.topKFrequent(test, 2).toArray()));

    }
}
