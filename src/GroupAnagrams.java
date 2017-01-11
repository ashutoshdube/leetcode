
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Ashutosh on 1/8/17.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<List<Integer>, List<String>> hashMap = new HashMap<>();

        for(String str : strs) {

            List<Integer> list = new ArrayList<>(Collections.nCopies(26, 0));

            for(int i = 0; i < str.length(); i++) {
                list.set(str.charAt(i) - 'a', list.get(str.charAt(i) - 'a') + 1);
            }

            List<String> strings;
            if(hashMap.get(list) == null) {
                strings = new ArrayList<>();
                strings.add(str);
                hashMap.put(list, strings);
            } else {
                strings = hashMap.get(list);
                strings.add(str);
                hashMap.put(list, strings);
            }
        }

        return new ArrayList<>(hashMap.values());

    }

    public static void main(String[] args) {

        GroupAnagrams obj = new GroupAnagrams();
        obj.groupAnagrams(new String[]{"and", "dan"});

    }

}
