package cn.rocker.exception;

import org.junit.Test;

/**
 * @author rocker
 * @date 2019/01/21 15:37
 * @since V1.0
 */
public class FinallyTest {

    public int inc() {
        int x;
        try {
            x = 1;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
        return x;
    }

    @Test
    public void testFinally(){
        int inc = inc();
        System.out.println(inc);
    }

}
