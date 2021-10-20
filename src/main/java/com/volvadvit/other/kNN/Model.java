package com.volvadvit.other.kNN;

public class Model {
    String name;

    // some params to classify model
    int action;
    int comedy;
    int drama;

    public Model(String name, int action, int comedy, int drama) {
        this.name = name;
        this.action = action;
        this.comedy = comedy;
        this.drama = drama;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
