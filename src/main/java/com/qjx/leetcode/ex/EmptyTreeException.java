package com.qjx.leetcode.ex;

import java.io.Serializable;

/**
 * Title:
 * Description: EmptyTreeException异常
 * Author:qincasin <qinjiaxing@shein.com>
 * Since:2019/5/29 14:55
 * Version:1.1.0
 */
public class EmptyTreeException extends RuntimeException implements Serializable {
    public EmptyTreeException() {
        super();
    }

    public EmptyTreeException(String msg) {
        super(msg);
    }
}
