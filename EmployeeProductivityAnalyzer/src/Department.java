import java.util.*;

public enum Department {
    HR("Hiring"),
    ENGINEERING("Technical Team"),
    SALES("Revenue Team"),
    MARKETTING("Promotional Team"),

    private final String departmentDescription;

    private Department(String description) {
        this.departmentDescription = description;
    }

    }