import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String [] args) {
       int nums[] = new int[] {2, 2, 2, 2, 2};
        List<List<Integer>> result  = new FourSum().fourSum(nums, 8);
        System.out.println(result);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int t1 = target - nums[i];
            //find 3 sum
            for (int j = i+1; j < nums.length - 2; j++) {
                if (j != i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                //
                // find 2 sum
                int startIndex = j+1;
                int endIndex = nums.length - 1;
                int t2 = target - (nums[i] + nums[j]);
                int k = 0;
                while(startIndex < endIndex) {
                    if(nums[startIndex] + nums[endIndex] == t2) {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[startIndex], nums[endIndex])));
                        startIndex++;
                        endIndex--;
                    } else if (nums[startIndex] + nums[endIndex] < t2) {
                        startIndex++;
                    }else if (nums[startIndex] + nums[endIndex] > t2){
                        endIndex--;
                    }
                    while(endIndex != nums.length -1 && endIndex > startIndex && nums[endIndex+1] == nums[endIndex]) {
                        endIndex--;
                    }
                }

            }

        }
        return result;
    }
}
