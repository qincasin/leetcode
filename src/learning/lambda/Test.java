package learning.lambda;

import java.nio.file.DirectoryStream.Filter;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 测试
 *
 * @author: qincasin
 * @date: 2019/7/10/ 19:21
 */
public class Test {

  public static void main(String[] args) {
    System.out.println(Operation.PLUS.apply(1,2));

    Map<Integer,Integer> map = new HashMap<>();
    map.put(1,-1);
    map.put(2,-2);
    //如果1 存在，则在key的value基础上递增给定的value
    map.merge(3,2,(count,incr)->count+incr);
    System.out.println(map);
    //上述代码等同于如下代码
    map.merge(3,1,Integer::sum);

    System.out.println(map);

    Instant now = Instant.now();
    System.out.println(now);

    Filter<Instant> isAfter = Instant.now()::isAfter;
    System.out.println(isAfter);


  }
}
