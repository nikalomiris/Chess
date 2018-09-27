package com.kalomiris.model;

public enum Player {
    WHITE("White"), BLACK("Black");

    private final String stringRepresentation;

    Player(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }


    @Override
    public String toString() {
        return stringRepresentation;
    }
}
