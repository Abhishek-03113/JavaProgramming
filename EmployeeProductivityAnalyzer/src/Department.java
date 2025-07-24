import java.util.*;

public enum Department {
    HR("Hiring"),
    ENGINEERING("Technical Team"),
    SALES("Revenue Team"),
    MARKETING("Promotional Team");

    private final String departmentDescription;

    private Department(String description) {
        this.departmentDescription = description;
    }

    public String getDescription() {
        return departmentDescription;
    }

    }