package utils;
import java.util.Objects;

/**
 * This class allows the generation of pairs of template type objects.
 * @param <F> Template first element
 * @param <S> Template second element
 */
public class Pair<F, S> {
    public final F first;
    public final S second;

    /**
     * Class constructor overloading
     * @param first First element of the pair
     * @param second Second element of the pair
     */
    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Compares whether two pairs of values are equal
     * @param o Element to be compared with the invoking pair object
     * @return Result of the comparison between 2 pairs
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> p = (Pair<?, ?>) o;
        return Objects.equals(p.first, first) && Objects.equals(p.second, second);
    }

    /**
     * Returns an integer representing the current instance of the class.
     * @return the current instance of the class
     */
    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
    }

    /**
     * Static method for pair creation
     * @param a Pair first element
     * @param b Pair second element
     * @return new Pair
     * @param <A> Template first element
     * @param <B> Template first element
     */
    public static <A, B> Pair <A, B> create(A a, B b) {
        return new Pair<A, B>(a, b);
    }
}
