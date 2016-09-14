import java.util.*;

public class ContainsDuplicate {

  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<Integer>();

    for (int i = 0; i < nums.length; ++i) {
      if (set.contains(nums[i])) {
        return true;
      } else {
        set.add(nums[i]);
      }
    }

    return false;
  }

  public static void main(String args[]) {

    ContainsDuplicate instance = new ContainsDuplicate();
    System.out.println(instance.containsDuplicate(new int[]{1,2,3,4,5}));
    System.out.println(instance.containsDuplicate(new int[]{1,2,3,4,5,10,2}));
  }
}
