
import java.util.*;

public class CombinationSum3 {

  private void dfs(int k, int n, int start, List<Integer> combo, List<List<Integer>> result) {

    String output = "";

    for (Integer i : combo) {
      output += i + " ";
    }

    System.out.println(output);

    if (n == 0 && combo.size() == k) {

      List<Integer> temp = new ArrayList<Integer>();
      temp.addAll(combo);
      result.add(temp);
    }

    // This was actually rather tricky to figure out...
    for (int i = start; i <= 9; ++i) {
      if (n - i < 0) break;
      if (combo.size() > k) break;

      combo.add(i);
      dfs(k, n-i, i + 1, combo, result);
      combo.remove(combo.size() - 1);

    }

  }

  public List<List<Integer>> combinationSum3(int k, int n) {

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> combo = new ArrayList<Integer>();

    dfs(k, n, 1, combo, result);

    return result;
  }

  public static void main(String args[]) {

    int k = 2;
    int n = 9;

    System.out.println(k + ", " + n);

    CombinationSum3 instance = new CombinationSum3();

    List<List<Integer>> result = instance.combinationSum3(k, n);

    for (List<Integer> combo : result) {
      for (Integer e : combo) {
        System.out.print(e + ", ");
      }
      System.out.println("");
    }

  }

}
