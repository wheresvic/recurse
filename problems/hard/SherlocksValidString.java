import java.io.*;
import java.util.*;

/**
 * Build a counts map
 * Build a count frequency map
 * If more than 2, return false, if 1 return true, if 2 then check
 *  the count frequency keys differ by 1 and the higher frequency key only has a frequency of 1
 *  or, the lower frequency key is 1 with a frequency of 1
 *
 * e.g. aaabbbcccdd
 * a => 3, b => 3, c => 3, d => 2
 * 2 => 1, 3 => 3
 * i.e. false
 * 
 * e.g. abb
 * a => 1, b => 2
 * 1 => 1, 2 => 1
 * i.e. true
 *
 * e.g. abcc
 * a => 1, b => 1, c => 2
 * 1 => 2, 2 => 1
 * i.e. true
 *
 * 2 => 1, 3 => 2, i.e. false
 * 2 => 33, 3 => 1, i.e. true
 * 1 => 1, 2 => 34, i.e. true
 */
public class SherlocksValidString {

    public static <K> void increment(Map<K, Integer> map, K key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }

    public static <K, V> String stringify(Map<K, V> map) {
        String result = "";
        for (K key : map.keySet()) {
            result += key + " => " + map.get(key) + "\n";
        }
        return result;
    }

    public static boolean checkFrequencies(int lower, int higher, int lowerFrequency, int higherFrequency) {
        // System.out.println(lower + " " + higher + " " + lowerFrequency + " " + higherFrequency);

        if (((higher - lower) == 1) && higherFrequency == 1) return true;
        if (lower == 1 && lowerFrequency == 1) return true;
        
        return false;
    }

    public static boolean isValid(String input, boolean debug) {
        int len = input.length();
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        
        for (int i = 0; i < len; ++i) {
            Character c = input.charAt(i);
            increment(counts, c);
        }
        
        if (debug) System.out.println(stringify(counts));
        
        Map<Integer, Integer> countFrequency = new HashMap<Integer, Integer>();
        
        for (Character c : counts.keySet()) {
            increment(countFrequency, counts.get(c));    
        }
        
        if (debug) System.out.println(stringify(countFrequency));
        
        if (countFrequency.size() <= 1) return true;
        if (countFrequency.size() > 2) return false;
        
        Iterator<Integer> it = countFrequency.keySet().iterator();
        int first = it.next();
        int second = it.next();

        if (debug) System.out.println(first + " " + second);

        if (first > second) {
            return checkFrequencies(second, first, countFrequency.get(second), countFrequency.get(first));
        } 
        
        return checkFrequencies(first, second, countFrequency.get(first), countFrequency.get(second));
    }
    
    public static void main(String[] args) {
        /*       
        Scanner in = new Scanner(System.in);
        String input = in.next();
        
        System.out.println(isValid(input));
        */
        
        String inputs[] = {"aabbcd", "aabbb", "abcd", "abcdd", "abcdabcd", "abcdabcde", "eeabcde", "aaaa", "aabbbccc",  "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"};
        
        for (String input : inputs) {
            System.out.println(isValid(input, false));
        }
        
        // isValid(inputs[inputs.length - 1], true);
    }
}
