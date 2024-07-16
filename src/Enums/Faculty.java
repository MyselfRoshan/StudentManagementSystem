package Enums;

public enum Faculty {
    SCIENCE(0),
    MANAGEMENT(1),
    HUMANITIES(2),
    LAW(3);

    private final int value;

    Faculty(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Faculty fromInt(int value) {
        for (Faculty faculty : Faculty.values()) {
            if (faculty.getValue() == value) {
                return faculty;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
