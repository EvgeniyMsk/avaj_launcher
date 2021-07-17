package com.school21.Task;

import java.util.List;

public class Tower {
    private List<Flyable> observers;

    public void register(Flyable flyable) {
        observers.add(flyable);
        System.out.println("Tower says: " + flyable.toString() + " registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        System.out.println("Tower says: " + flyable.toString() + " unregistered from weather tower.");
    }

    protected void conditionsChanged() {
        for (Flyable flyable : observers)
            flyable.updateConditions();
    }
}
