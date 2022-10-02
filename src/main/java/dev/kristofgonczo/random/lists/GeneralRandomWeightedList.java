package dev.kristofgonczo.random.lists;

import java.util.Optional;

public class GeneralRandomWeightedList<E> extends AbstractRandomWeightedList<E> {

    public GeneralRandomWeightedList() {
        super();
    }

    public GeneralRandomWeightedList(int seed) {
        super(seed);
    }

    @Override
    public Optional<E> next() {
        int targetValue = random.nextInt(weight);
        int currentValue = 0;

        for (WeightedItem<E> weightedItem : list) {
            currentValue += weightedItem.getWeight();
            if (targetValue <= currentValue) {
                return Optional.of(weightedItem.getItem());
            }
        }
        return Optional.empty();
    }
}
