package contest._107;

/**
 * 925. Long Pressed Name
 */
public class LongPressedName {
    /**
     * 滑动窗口 同时执行
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {

        int p = 0;
        int q = 0;

        char[] origin = new char[name.length()];

        for (int i = 0; i < name.length(); i++) {
            origin[i] = name.charAt(i);
        }
        while (p<name.length()&&q<typed.length()){
            if(name.charAt(p)==typed.charAt(q)){
                if(p==name.length()-1){
                    return true;
                }else {
                    p++;
                    q++;
                }

            }else if(name.charAt(p)!=typed.charAt(q)){
                q++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        LongPressedName solution = new LongPressedName();
/*"pyplrz"
"ppyypllr"*/
        String name = "laiden";
        String typed = "laiden";
        System.out.println(solution.isLongPressedName(name,typed));
    }

}
