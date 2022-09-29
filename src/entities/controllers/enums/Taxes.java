package entities.controllers.enums;

public enum Taxes {
    INSS(0.1),
    INPS(0.1),
    SO(0.1),
    SINDICATE(0.1);

    private double values;

    Taxes(double values) {
        this.values = values;
    }

    public double getValues() {
        return values;
    }
}
