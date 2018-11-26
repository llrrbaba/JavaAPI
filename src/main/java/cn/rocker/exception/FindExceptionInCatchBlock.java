package cn.rocker.exception;

import org.junit.Test;

/**
 * 异常的捕捉顺序是？一个catch里嵌套另一个catch，如果抛出异常，堆栈信息的先后顺序是？
 * 答案是：先抛出内层异常，再抛出外层异常
 *
 * @author rocker
 * @version V1.0
 * @date 2018/7/9 18:12
 */
public class FindExceptionInCatchBlock {

    @Test
    public void testFindExceptionInCatchBlock1() {
        System.out.println(getString1());
    }

    @Test
    public void testFindExceptionInCatchBlock2() throws Exception {
        System.out.println(getString2());
    }

    public String getString1() {
        String result = null;
        try {
            new String(result.getBytes(), "utf-8");
        } catch (Exception e) {
            try {
                int i = 1 / 0;
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return "test";
    }


    public String getString2() throws Exception{
        String result = null;
        new String(result.getBytes(), "utf-8");
        int i = 1 / 0;
        return "test";
    }


}
