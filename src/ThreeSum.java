import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

 注意：答案中不可以包含重复的三元组。

 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 * Created by wangqianjun on 2019/4/26.
 */
public class ThreeSum {


    public static void main(String[] args) {
        ThreeSum t=new ThreeSum();
        int [] nums={-1, 0, 1, 2, -1, -4,2,2,2,-1,-1,-1,1};
        List<List<Integer>> result=t.threeSum(nums);
        System.out.println(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        if(nums==null||nums.length<3){
            return lists;
        }
        Arrays.sort(nums);
        int len=nums.length;
        int j;
        int k;

        for(int i=0;i<len-2;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            j=i+1;
            k=len-1;
            while (j<k){
                int value=nums[i]+nums[j]+nums[k];
                if(value==0){
                    List<Integer> slot=new ArrayList<>(3);
                    slot.add(nums[i]);
                    slot.add(nums[j]);
                    slot.add(nums[k]);
                    lists.add(slot);
                    while (nums[j++]==nums[j]&&j<k){}
                    while (nums[k--]==nums[k]&&j<k){}
                }else if(value<0){
                    while (nums[j++]==nums[j]&&j<k){}
                }else{
                    while (nums[k--]==nums[k]&&j<k){}
                }
            }
        }
        return lists;
    }
}
