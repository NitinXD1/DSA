package GFG;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class sortStack {
    public Stack<Integer> sort(Stack<Integer> s) {
        if (!s.isEmpty()) {

            int temp = s.pop();

            sort(s);

            sortedInsert(s, temp);
        }
        return s;
    }

    // Helper function to insert an element in a sorted order
    private void sortedInsert(Stack<Integer> s, int element) {

        if (s.isEmpty() || element > s.peek()) {
            s.push(element);
        } else {

            int temp = s.pop();
            sortedInsert(s, element);

            s.push(temp);
        }
    }
}
