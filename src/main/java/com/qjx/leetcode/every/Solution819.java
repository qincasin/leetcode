package com.qjx.leetcode.every;


import java.util.*;
import java.util.stream.Collectors;

public class Solution819 {

    public static void main(String[] args) {
        String a = "a  , bb c,";
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
//            System.out.println("a:"+c);
        }
        String paragraph  = "Bob b";
        String[] banned = new String[]{"hit"};
        Solution819 s = new Solution819();
        String resp = s.mostCommonWord(paragraph, banned);
        System.out.println(resp);
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        int fast =0 ,slow = 0;
        Set<Character> set = new HashSet<>();
        set.add(Character.toLowerCase(' '));
        set.add(Character.toLowerCase('!'));
        set.add(Character.toLowerCase('?'));
        set.add(Character.toLowerCase('\''));
        set.add(Character.toLowerCase(','));
        set.add(Character.toLowerCase(';'));
        set.add(Character.toLowerCase('.'));
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (set.contains(c)){
                String word = paragraph.substring(slow, fast).toLowerCase(Locale.ROOT);
                fast = i;
                slow = fast+1;
                if (word.length() > 0) {
                    Integer num = map.get(word);
                    if (num == null) {
                        num = 1;
                    } else {
                        num = num + 1;
                    }
                    map.put(word,  num);
                }
            }
            fast++;
        }
        if (slow != fast) {
            String word = paragraph.substring(slow, fast).toLowerCase(Locale.ROOT);
            Integer num = map.get(word);
            if (num == null) {
                num = 1;
            } else {
                num = num + 1;
            }
            map.put(word,  num);
        }

        //map 排序
        for (String s : banned) {
            Integer value = map.get(s.toLowerCase(Locale.ROOT));
            if (value!=null){
                map.remove(s.toLowerCase(Locale.ROOT));
            }
        }
        Map<String, Integer> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        List<String> s = new ArrayList<>();
        collect.keySet().forEach(a->{
            s.add(a.toLowerCase(Locale.ROOT));
        });

        return s.get(0);
    }

}
