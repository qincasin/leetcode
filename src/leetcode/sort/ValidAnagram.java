package sort;

import java.util.Arrays;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 */
public class ValidAnagram {
    /**
     * 排序直接两两比较
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) {
            return false;
        }
        char[] s1 = new char[s.length()];
        char[] t1 = new char[t.length()];
        for (int i = 0; i < s.length(); i++) {
            s1[i] = s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            t1[i] = t.charAt(i);
        }
        Arrays.sort(s1);
        Arrays.sort(t1);
        int len = s.length()==t.length()?s.length():t.length();
        for (int i = 0; i < len; i++) {
            if(s1[i]!=t1[i]){
                return false;
            }
        }
        return true;

    }

    /**
     * 使用数组来 s进行+1  t进行-1
     * 执行到最后如果原数据中的值都为0则为true 否则false
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] arr = new int[256];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]+=1;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i)]-=1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                return false;
            }
        }
        return true;

    }


    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram() ;
        Boolean result = validAnagram.isAnagram("ab","a");
        System.out.println(result);
    }

}
