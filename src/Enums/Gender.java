package Enums;

import java.util.stream.Stream;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Gender fromString(String gender) {
        for (Gender g : Gender.values()) {
            if (g.value.equalsIgnoreCase(gender)) {
                return g;
            }
        }
        throw new IllegalArgumentException("Invalid gender string: " + gender);
    }

    public static String[] getAllValues() {
        return Stream.of(Gender.values())
                .map(Gender::getValue)
                .toArray(String[]::new);
    }
}
