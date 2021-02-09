import java.util.*;

class PeekingIteratorRunner {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
        PeekingIterator peekIte = new PeekingIterator(list.iterator());
        System.out.println("next: " + peekIte.next()); // 1
        System.out.println("peek: " + peekIte.peek()); // 2
        System.out.println("next: " + peekIte.next()); // 2
        System.out.println("next: " + peekIte.next()); // 3
        System.out.println("hasNext: " + peekIte.hasNext()); // false

    }
}

class PeekingIterator implements Iterator<Integer> {
    Queue<Integer> next;
    Iterator<Integer> ite;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        next = new LinkedList<>();
        ite = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(next.isEmpty()) next.add(ite.next());

        return next.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(next.isEmpty()) next.add(ite.next());

        return next.remove();
    }

    @Override
    public boolean hasNext() {
        return !next.isEmpty() || ite.hasNext();
    }
}
