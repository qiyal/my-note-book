package kz.pazyl.mynotebook.model.enums;

public enum BudgetOperationType {
    PLUS("PLUS"),
    MINUS("MINUS");

    private String name;

    BudgetOperationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
