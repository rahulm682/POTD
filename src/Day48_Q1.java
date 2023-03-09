import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Day48_Q1 {
    static HashMap<Integer, Integer> mp = new HashMap<>();

    public static void main(String[] args) {

    }

    public static void findAll() {
        for (int i = 1; i <= 1000000; i++) {
            char[] arr = (i + "").toCharArray();
            Set<Character> st = new HashSet<>();
            for (char ch : arr) st.add(ch);

            if (st.size() == 1) {
                if (st.contains('1') || st.contains('2') || st.contains('3')) {
                    mp.put(i, 1);
                }
            } else if (st.size() == 2) {
                if ((st.contains('1') && st.contains('2')) || (st.contains('1') && st.contains('3')) || (st.contains('3') && st.contains('2'))) {
                    mp.put(i, 1);
                }
            } else if (st.size() == 3) {
                if (st.contains('1') && st.contains('2') && st.contains('3')) mp.put(i, 1);
            }
        }
    }
}
