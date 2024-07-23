package Enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public enum Role {
    ADMIN(0),
    STUDENT(1);

    private final int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static String[] getStringValues() {
        ArrayList<String> out = new ArrayList<>();
        for (Role role : values()) {
            out.add(role.name());
        }
        return out.toArray(new String[0]);
    }

    // Mapping of role names to Role enum values
    private static final Map<String, Role> stringToEnum = new HashMap<>();
    static {
        for (Role role : Role.values()) {
            stringToEnum.put(role.name(), role);
        }
    }

    /**
     * Convert a string representation of a role to the corresponding Role enum
     * value.
     * Throws IllegalArgumentException if the string does not match any role.
     *
     * @param roleName The name of the role (case-sensitive).
     * @return The Role enum value corresponding to the given name.
     */
    public static Role fromString(String roleName) {
        if (roleName == null) {
            throw new IllegalArgumentException("Role name cannot be null");
        }
        Role role = stringToEnum.get(roleName);
        if (role == null) {
            throw new IllegalArgumentException("No such role with name: " + roleName);
        }
        return role;
    }

}
