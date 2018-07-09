package cn.rocker.exception;

import org.junit.Test;

/**
 * @author rocker
 * @version V1.0
 * @Description:    异常的捕捉顺序是？一个catch里嵌套另一个catch，如果抛出异常，堆栈信息的先后顺序是？
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
