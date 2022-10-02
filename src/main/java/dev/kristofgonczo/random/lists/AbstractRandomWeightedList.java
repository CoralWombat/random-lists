package dev.kristofgonczo.random.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AbstractRandomWeightedList<E> implements RandomWeightedList<E> {

    static protected class WeightedItem<E> {
        E item;
        int weight;

        public WeightedItem(E item, int weight) {
            this.item = item;
            this.weight = weight;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    List<WeightedItem<E>> list;

    int weight;

    Random random;

    public AbstractRandomWeightedList() {
        this.list = new ArrayList<>();
        this.weight = 0;
        this.random = new Random();
    }

    public AbstractRandomWeightedList(int seed) {
        this.list = new ArrayList<>();
        this.weight = 0;
        this.random = new Random(seed);
    }

    public boolean add(E e, int weight) {
        if (weight <= 0)
            return false;


        boolean added = this.list.add(new WeightedItem<>(e, weight));
        if (added)
            this.weight += weight;

        return added;
    }

    public void clear() {
        this.list.clear();
        this.weight = 0;
    }

    public boolean contains(Object o) {
        return this.list.stream().anyMatch(item -> item.item.equals(o));
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public boolean remove(Object o) {
        WeightedItem<E> foundItem = this.list.stream().filter(item -> item.item.equals(o)).findFirst().orElse(null);
        if (foundItem == null)
            return false;

        boolean removed = this.list.remove(foundItem);
        if (removed)
            this.weight -= foundItem.getWeight();

        return removed;
    }

    public int size() {
        return this.list.size();
    }

    public int weight() {
        return this.weight;
    }
}
