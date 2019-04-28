import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * Created by wangqianjun on 2019/4/28.
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        ThreeSumClosest t=new ThreeSumClosest();
        int [] nums={-1,2,1,-4};
        int divid=t.threeSumClosest(nums,1);
        System.out.println(divid);
    }

    public int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length<3){
            return 0;
        }
        int len=nums.length;
        int divide=Integer.MAX_VALUE;
        int pink=0;
        int j,k;

        int value;
        int sub;
        Arrays.sort(nums);
        for(int i=0;i<len-2;i++){
            if(i>0&&nums[i-1]==nums[i]) continue;
            j=i+1;
            k=len-1;
            while (j<k){
                value=nums[i]+nums[j]+nums[k];
                sub=value-target;
                if(abs(sub)<divide){
                    divide=abs(sub);
                    pink=value;
                    if(sub==0){
                        return pink;
                    }
                }
                if(sub<0){
                    while (nums[j++]==nums[j]&&j<k){}
                }else {
                    while (nums[k--]==nums[k]&&j<k){}
                }
            }
        }
        return pink;
    }


    private int abs(int value){
        if(value<0){
            value=-value;
        }
        return value;
    }
}
