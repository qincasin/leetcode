package learning.lambda;

import java.util.function.DoubleBinaryOperator;

/**
 * lambda实现的加减乘除
 *
 * @author: qincasin
 * @date: 2019/7/10/ 19:12
 */
public enum Operation {
  PLUS("+", (x, y) -> x + y),
  MINUS("-", (x, y) -> x - y),
  TIMES("-", (x, y) -> x * y),
  DIVIDE("-", (x, y) -> x / y);

  private final String symbol;

  private final DoubleBinaryOperator op;

  Operation(String symbol, DoubleBinaryOperator op) {
    this.symbol = symbol;
    this.op = op;
  }

  @Override
  public String toString() {
    return "Operation{" +
        "symbol='" + symbol + '\'' +
        ", op=" + op +
        '}';
  }

  public double apply(double x, double y) {
    return op.applyAsDouble(x, y);
  }


}
