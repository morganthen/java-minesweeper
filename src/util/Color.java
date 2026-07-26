package util;

public enum Color {
    RESET("[0m"),
    RED("[31m"),
    GREEN("[32m"),
    YELLOW("[33m"),
    PURPLE("[35m"),
    CYAN("[36m"),
    GREY("[90m"),
    ORANGE("[38;5;208m");

    private final String code;

    Color(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
