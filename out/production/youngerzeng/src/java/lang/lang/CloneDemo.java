/**
 * Author: youngerzeng
 * Date: 2019/10/3 12:59
 * Description: 深克隆和浅克隆
 */
package java.lang;

import java.util.ArrayList;
import java.util.List;

public class CloneDemo {
    public static void main(String []args){
        System.out.println("hello");
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        System.out.println(nums);
    }
}
