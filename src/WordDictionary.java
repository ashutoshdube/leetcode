import java.util.Stack;

/**
 * Created by Ashutosh on 12/20/16.
 */
public class WordDictionary {

    public Node root;

    private class Node {

        Character ch;
        Node[] links = new Node[26];

        public Node(Character ch) {
            this.ch = ch;
        }

        public Node addLink(Character ch) {

            if(ch == null) {

                links = null;
                return null;
            }

            if(links[ch - 'a'] == null) {
                links[ch - 'a'] = new Node(ch);
            }

            return links[ch - 'a'];
        }
    }

    public void addWord(String word) {

        if(root == null) {
            root = new Node(null);
        }

        Node node = root;

        for(int i = 0; i < word.length(); i++) {
            node = node.addLink(word.charAt(i));
        }
        node.addLink(null);
    }

    public boolean search(String word) {

        return match(word, 0, root);
    }

    private boolean match(String word, int index, Node node) {

        if(index == word.length()) {
            if(node == null) {
                return false;
            }
            return node.links == null;
        }

        if(word.charAt(index) != '.') {
            return node != null && node.links != null & node.links[word.charAt(index) - 'a'] != null && match(word, index + 1, node.links[word.charAt(index) - 'a']);
        } else {

            if(node == null) {
                return false;
            }

            for(Node nd : node.links) {

                if(match(word, index + 1, nd)) {
                    return true;
                }

            }

            return false;
        }
    }

    public void printDictionary(Node node) {

        System.out.println(node.ch);
        if(node.links != null) {
            for (int i = 0; i < node.links.length; i++) {
                if (node.links[i] != null) {
                    printDictionary(node.links[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        WordDictionary obj= new WordDictionary();
        obj.addWord("abc");
        obj.addWord("abd");
        obj.addWord("dfg");
        System.out.println(obj.search("a..d"));
        //obj.printDictionary(obj.root);
    }

}
