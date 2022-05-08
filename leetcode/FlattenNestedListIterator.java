import java.util.*;

/*
	https://leetcode.com/problems/flatten-nested-list-iterator/
*/
class FlattenNestedListIterator {
	public static void main(String args[]) {


 	// NestedIterator i = new NestedIterator(nestedList);
 	// while (i.hasNext()) {
 	// 	System.out.print(i.next());
 	}

}

class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>(); // [1,1], 2, 1, 1
        addToStack(nestedList);
        pointToFirstInteger();
    }

    @Override
    public Integer next() {
        NestedInteger poped = stack.pop();
        pointToFirstInteger();
        return poped.getInteger();
    }

    @Override
    public boolean hasNext() {
        return stack.size() > 0;
    }

    private void pointToFirstInteger() {

        while (hasNext() && !stack.peek().isInteger()) {
            addToStack(stack.pop().getList());
        }
    }

    private void addToStack(List<NestedInteger> list) { // [1, 1]
        for(int i = list.size() - 1; i >= 0; i--) { // -1
            stack.push(list.get(i));
        }
    }
}

interface NestedInteger {

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return empty list if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }
