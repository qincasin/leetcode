package learning.tool;

import java.util.*;
import java.util.stream.Collectors;

public class MapUtils {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        System.out.println(sortByValueOrder2(map));
    }

    /**
     * 按照value 排序 方式1
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueOrderReverse(Map<K, V> map) {
        List<Map.Entry<K,V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Map<K,V> res = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            res.put(entry.getKey(),entry.getValue());
        }
        return res;
    }

    /**
     * 按照value 排序 方式1  -- 逆序
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueOrder(Map<K, V> map) {
        List<Map.Entry<K,V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        Map<K,V> res = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            res.put(entry.getKey(),entry.getValue());
        }
        return res;
    }

    /**
     * 按照value 排序 方式2  -- 逆序
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueOrder2(Map<K, V> map) {
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
