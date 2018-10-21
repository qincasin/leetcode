package leetcode.contest._107;

/**
 * 926. Flip String to Monotone Increasing
 */
public class FlipStringtoMonotoneIncreasing {
    public int minFlipsMonoIncr(String S) {
        int zeros = 0;
        int ones = 0;

        int l0 = 0;
        int l1 = 0;
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i)=='0'){
                zeros++;
            }else {
                ones++;
            }
        }
        int res = zeros;
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i)=='0'){
                zeros--;
                l0++;
            }else {
                ones--;
                l1++;
            }
            res = Math.min(l1+zeros,res);
            System.out.println(res);

        }


        return res;
    }

    public static void main(String[] args) {
        FlipStringtoMonotoneIncreasing solution = new FlipStringtoMonotoneIncreasing();
        String s = "00011000";
        System.out.println(solution.minFlipsMonoIncr(s));
//        int one = 0;
//        int zero = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i)=='1'){
//                one++;
//            }
//        }
//        System.out.println("00000000000000");
//        System.out.println(one);
//        System.out.println(s.length()-one);

    }


}
