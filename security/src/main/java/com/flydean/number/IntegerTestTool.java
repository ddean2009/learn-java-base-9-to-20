package com.flydean.number;

/**
 * @author wayne
 * @version IntegerTestTool,  2020/7/23
 */
public class IntegerTestTool {

    static final int safeAdd(int left, int right) {
        if (right > 0 ? left > Integer.MAX_VALUE - right
                : left < Integer.MIN_VALUE - right) {
            throw new ArithmeticException("Integer overflow");
        }
        return left + right;
    }

    static final int safeSubtract(int left, int right) {
        if (right > 0 ? left < Integer.MIN_VALUE + right
                : left > Integer.MAX_VALUE + right) {
            throw new ArithmeticException("Integer overflow");
        }
        return left - right;
    }

    static final int safeMultiply(int left, int right) {
        if (right > 0 ? left > Integer.MAX_VALUE/right
                || left < Integer.MIN_VALUE/right
                : (right < -1 ? left > Integer.MIN_VALUE/right
                || left < Integer.MAX_VALUE/right
                : right == -1
                && left == Integer.MIN_VALUE) ) {
            throw new ArithmeticException("Integer overflow");
        }
        return left * right;
    }

    static final int safeDivide(int left, int right) {
        if ((left == Integer.MIN_VALUE) && (right == -1)) {
            throw new ArithmeticException("Integer overflow");
        }
        return left / right;
    }

    static final int safeNegate(int a) {
        if (a == Integer.MIN_VALUE) {
            throw new ArithmeticException("Integer overflow");
        }
        return -a;
    }
    static final int safeAbs(int a) {
        if (a == Integer.MIN_VALUE) {
            throw new ArithmeticException("Integer overflow");
        }
        return Math.abs(a);
    }
}
