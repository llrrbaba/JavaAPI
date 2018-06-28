package cn.rocker.rule;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rocker
 * @version V1.0
 * @Description:
 * @date 2018/6/28 11:08
 */
public class MakeOneReferenceWhenIter {

    /**
     * 在遍历集合的外部创建Map的引用
     * 这样的话，内存中只有一份Map对象引用，
     * 每次new HashMap<>()的时候，Map对象引用指向不同的Map罢了，
     * 但是内存中只有一份，这样就大大节省了内存空间了
     */
    @Test
    public void makeOneReference(){
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = null;

        for(int i=0;i<6;i++){
            map = new HashMap<>();
            map.put("i",i);
            list.add(map);
        }
        System.out.println(StringUtils.join(list,","));
    }


    /**
     * 这种做法会导致内存中有i份Map对象引用存在，i很大的话，就耗费内存了
     */
    @Test
    public void makeManyReference(){
        List<Map<String, Object>> list = new ArrayList<>();

        for(int i=0;i<6;i++){
            Map<String, Object> map = new HashMap<>();
            map.put("i",i);
            list.add(map);
        }
        System.out.println(StringUtils.join(list,","));
    }

}
