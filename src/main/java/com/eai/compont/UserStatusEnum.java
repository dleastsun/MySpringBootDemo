package com.eai.compont;

public enum UserStatusEnum {
    DISABLE("disable"), ENABLE("enable");

    private String value;

    UserStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return value;
    }

    public static UserStatusEnum getByValue(String value) {
        for (UserStatusEnum v : values()) {
            if (v.getValue() == value) {
                return v;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(UserStatusEnum.DISABLE);

        String convertPatternNumber = "disable";
        switch (UserStatusEnum.getByValue(convertPatternNumber)) {
        case DISABLE:
            System.out.println("disable");
            break;
        case ENABLE:
            System.out.println("enable");
            break;
        default:
            System.out.println("default");
            break;
        }
    }
}