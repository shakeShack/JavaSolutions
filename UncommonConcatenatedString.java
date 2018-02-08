/*
Two strings are given and you have to modify 1st string such that all the common
characters of the 2nd strings have to be removed and the uncommon characters of
the 2nd string have to be concatenated with uncommon characters of the 1st string.

Given s1 = aacdb, s2 = gafd
return cbgf

Given s1 = abcs, s2 = cxzca;
return bsxz
*/
public class UncommonConcatenatedString {
    /*
     * @param : the 1st string
     * @param : the 2nd string
     * @return: uncommon characters of given strings
     */
    public String concatenetedString(String s1, String s2) {

        if(s1 == null || s1.isEmpty()) return s2;
        if(s2 == null || s2.isEmpty()) return s1;

        int[] array1 = new int[256]; //ASCII has 256 characters (0-255);
        int[] array2 = new int[256]; //ASCII has 256 characters (0-255);

        for(int i=0; i < s1.length(); i++){
            int index = s1.charAt(i);
            array1[index] += 1;
        }

        for(int i=0; i < s2.length(); i++){
            int index = s2.charAt(i);
            System.out.println(index);
            if(array1[index] != 0){
                array1[index] = -1;
            } else {
                array2[index] += 1;
            }
        }

        String concatenated = "";
        for(int i=0; i < s1.length(); i++){
            int index = s1.charAt(i);
            if(array1[index] > 0) concatenated += s1.charAt(i);
        }
        for(int i=0; i < s2.length(); i++){
            int index = s2.charAt(i);
            if(array2[index] > 0) concatenated += s2.charAt(i);
        }
        return concatenated;
    }
}
