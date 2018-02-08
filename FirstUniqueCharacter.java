/*
Given a string, find the first non-repeating character in it and return it's index.
If it doesn't exist, return -1.

Given s = "lintcode", return 0.
Given s = "lovelintcode", return 2.
*/

public class FirstUniqueCharacter {
    /*
     * @param s: a string
     * @return: it's index
     */
    public int firstUniqChar(String s) {
        if(s == null || s.isEmpty()) return -1;

        Set<Character> noRepeatChars = new HashSet<>();
        Set<Character> repeatChars = new HashSet<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(noRepeatChars.contains(c)){
                repeatChars.add(c);
            } else {
                noRepeatChars.add(c);
            }
        }

        noRepeatChars.removeAll(repeatChars);

        for(int i=0; i<s.length(); i++){
            if(noRepeatChars.contains(s.charAt(i))){
                return i;
            }
        }

        return -1;
    }
}
