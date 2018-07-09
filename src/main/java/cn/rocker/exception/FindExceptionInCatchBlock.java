package cn.rocker.exception;

import org.junit.Test;

/**
 * @author rocker
 * @version V1.0
 * @Description:
 * @date 2018/7/9 18:12
 */
public class FindExceptionInCatchBlock {

    @Test
    public void testFindExceptionInCatchBlock(){
        System.out.println(getString());
    }


    public String getString(){
        String result = null;
        try {
            new String(result.getBytes(),"utf-8");
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

}
