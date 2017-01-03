/**
 * Created by Ashutosh on 1/1/17.
 */
public class ShortestWordDistance {

    public int shortestDistance(String[] words, String word1, String word2) {

        Integer index1 = null;
        Integer index2 = null;
        Integer distance = null;

        for(int i = 0; i < words.length; i++) {

            if(words[i].equals(word1)) {
                index1 = i;
            } else if(words[i].equals(word2)) {
                index2 = i;
            }

            if(index1 != null && index2 != null) {
                if(distance == null || Math.abs(index1 - index2) < distance) {
                    distance = Math.abs(index1 - index2);
                }
            }

        }

        return distance != null ? distance : 0;
    }

    public static void main(String[] args) {

        ShortestWordDistance obj = new ShortestWordDistance();
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(obj.shortestDistance(words, "practice", "coding"));

    }
}
