package utilities;

import java.util.BitSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Calculate all the subsets of a given set.
 * @param <E> Template element for defining the data type of the assembly
 */
public class PowerSet<E> implements Iterator<Set<E>>, Iterable<Set<E>> {

    private E[] arr = null;
    private BitSet bset = null;

    @SuppressWarnings("unchecked")
    public PowerSet(Set<E> set) {
        this.arr = (E[]) set.toArray();
        this.bset = new BitSet(this.arr.length + 1);
    }

    @Override
    public boolean hasNext() {
        return !this.bset.get(this.arr.length);
    }

    @Override
    public Set<E> next() {
        Set<E> returnSet = new TreeSet<>();
        for (int i = 0; i < this.arr.length; i++) {
            if (this.bset.get(i)) {
                returnSet.add(this.arr[i]);
            }
        }
        for (int i = 0; i < this.bset.size(); i++) {
            if (!this.bset.get(i)) {
                this.bset.set(i);
                break;
            } else {
                this.bset.clear(i);
            }
        }
        return returnSet;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not Supported!");
    }

    @Override
    public Iterator<Set<E>> iterator() {
        return this;
    }
}