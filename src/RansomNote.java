import java.util.HashMap;

/**
 * Created by Ashutosh on 12/28/16.
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> note = new HashMap<>();
        char[] noteChars = ransomNote.toCharArray();

        for(char c : noteChars) {
            note.put(c, note.getOrDefault(c, 0) + 1);
        }

        int i;
        for(i = 0; i < magazine.length() && note.size() != 0; i++) {
            if(note.containsKey(magazine.charAt(i))) {

                note.put(magazine.charAt(i), note.get(magazine.charAt(i)) - 1);
                if(note.get(magazine.charAt(i)) == 0) {
                    note.remove(magazine.charAt(i));
                }

            }
        }

        if(note.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {



    }

}
