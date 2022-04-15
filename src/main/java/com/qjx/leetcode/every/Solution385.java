package com.qjx.leetcode.every;

import java.util.List;
import java.util.Stack;

public class Solution385 {
    public static void main(String[] args) {
        
    }

    /**
     * "[123,[456,[789]]]"
     * @param s
     * @return
     */
    public NestedInteger deserialize(String s) {
        if (s.charAt(0)!='['){
//            return new NestedInteger(Integer.parseInt(s));
        }
        if (s.length()<=2){
//            return new NestedInteger();
        }
        Stack<NestedInteger> stack =new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='['){
                //表示的是nestedList的开始，需要建立一个包裹，注意，栈顶的永远都是待填满的nest
//                stack.add(new NestedInteger());
            }else if (c==']'||c==','){
                //此时代表的，
                // 1、要么是栈顶的nest遇到了末尾（前一个二级nest已经放进去了）；
                // 2、要么是前一个对象刚刚解析完，需要装到更高一级的nest中
                if (s.charAt(i-1)==']'){
                    //此时是情况2
                    NestedInteger pop = stack.pop();
                    stack.peek().add(pop);
                }
            } else {
                    int positive = 1;
                    int num = 0;
                    if (c=='-'){
                        positive = -1;
                        i++;
                    }
                    while (Character.isDigit(s.charAt(i))){
                       num = num * 10 + s.charAt(i) - '0' ;
                       i++;
                    }
                    i--;
//                    stack.peek().add(new NestedInteger(positive * num));
                }
        }
        return stack.pop();
    }

    
    
}


  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  interface NestedInteger {
      // Constructor initializes an empty nested list.
//      public NestedInteger();

      // Constructor initializes a single integer.
//      NestedInteger(int value);

      // @return true if this NestedInteger holds a single integer, rather than a nested list. 123 = 123
      public abstract boolean isInteger();
 
      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public abstract Integer getInteger();
 
      // Set this NestedInteger to hold a single integer.
      public abstract void setInteger(int value);
 
      // set this Nestedinteger to hold a nested list and adds a nested integer to it.
      public void add(NestedInteger ni);
 
      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }
