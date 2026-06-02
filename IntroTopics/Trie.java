package IntroTopics;

public class Trie {
    public static void main(String[] args) {
        TrieNode trie = new TrieNode();
        trie.insert("apple");
        System.out.println("apple present : " + trie.search("apple"));
        System.out.println("app present : " + trie.search("app"));
        System.out.println("starts with app : " + trie.startsWith("app"));
        trie.insert("app");
        System.out.println("app present : " + trie.search("app"));
    }
}

// Implement Trie-2
class TrieNode2 {
    private TrieNode2[] children;
    int countEndsWith;
    int countPrefix;

    public TrieNode2() {
        this.children = new TrieNode2[26];
        this.countEndsWith = 0;
        this.countPrefix = 0;
    }

    private void increaseEndsWith() {
        this.countEndsWith++;
    }

    private void increasePrefix() {
        this.countPrefix++;
    }

    private void deleteEndsWith() {
        this.countEndsWith--;
    }
    
    private void deletePrefix() {
        this.countPrefix--;
    }

    public void insert(String word) {
        TrieNode2 root = this;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(root.children[index] == null) {
                root.children[index] = new TrieNode2();
            }
            root = root.children[index];
            root.increasePrefix();
        }
        root.increaseEndsWith();
    }

    public int countWordsEqualTo(String word) {
        TrieNode2 root = this;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(root.children[index] == null) return 0;
            root = root.children[index];
        }
        return root.countEndsWith;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode2 root = this;
        for(int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(root.children[index] == null) return 0;
            root = root.children[index];
        }
        return root.countPrefix;
    }

    public void erase(String word) {
        TrieNode2 root = this;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(root.children[index] == null) return;
            root = root.children[index];
            root.deletePrefix();
        }
        root.deleteEndsWith();
    }
}

// Implement Trie-1
class TrieNode {
    private TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEndOfWord = false;
    }

    public void insert(String word) {
        TrieNode root = this;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(root.children[index] == null) {
                root.children[index] = new TrieNode();
            }
            root = root.children[index];
        }
        root.setIsEndOfWord(true);
    }

    public boolean search(String word) {
        TrieNode root = this;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(root.children[index] == null) return false;
            root = root.children[index];
        }
        return root.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode root = this;
        for(int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(root.children[index] == null) return false;
            root = root.children[index];
        }
        return root != null;
    }

    private void setIsEndOfWord(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }
}