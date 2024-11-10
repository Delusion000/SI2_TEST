package businesslogic;

import java.util.List;
import java.util.ListIterator;

public class AdapterExtendedIterator<T> implements ExtendedIterator<T> {
    private ListIterator<T> iterator;
    private List<T> list;

    public AdapterExtendedIterator(List<T> list) {
        this.list = list;
        this.iterator = list.listIterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public T next() {
        return iterator.next();
    }

    @Override
    public T previous() {
        return iterator.previous();
    }

    @Override
    public boolean hasPrevious() {
        return iterator.hasPrevious();
    }

    @Override
    public void goFirst() {
        iterator = list.listIterator(0);
    }

    @Override
    public void goLast() {
        iterator = list.listIterator(list.size());
    }
}
