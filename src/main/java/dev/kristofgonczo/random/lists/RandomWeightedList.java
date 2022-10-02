package dev.kristofgonczo.random.lists;

/**
 * Interface for a random list, that can remove elements randomly.
 *
 * @param <E> The type of the elements the list contains.
 */
public interface RandomWeightedList<E> {

    /**
     * Appends the specified element to the end of this list (optional operation).
     *
     * @param e      The element to add.
     * @param weight The weight of the element to add.
     * @return true, if the element is added successfully, false if the element could not be added.
     */
    boolean add(E e, int weight);

    /**
     * Removes all of the elements from this list (optional operation).
     */
    void clear();

    /**
     * Returns true if this list contains the specified element.
     *
     * @param o Element whose presence in this list is to be tested.
     * @return true if this list contains the specified element.
     */
    boolean contains(Object o);

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements.
     */
    boolean isEmpty();

    /**
     * Removes the first occurrence of the specified element from this list, if it is present (optional operation).
     *
     * @param o Element to be removed from this list, if present.
     * @return true if this list contained the specified element.
     */
    boolean remove(Object o);

    /**
     * Returns the number of elements in this list. If this list contains more than Integer.MAX_VALUE elements,
     * returns Integer.MAX_VALUE.
     *
     * @return The number of elements in this list.
     */
    int size();

    /**
     * Removes a random element from the list and returns it. The more wight of an element has, the more likely to
     * get picked.
     *
     * @return A random element from the list.
     */
    E next();
}
