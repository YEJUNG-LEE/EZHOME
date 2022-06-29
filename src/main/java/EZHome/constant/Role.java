package EZHome.constant;

public enum Role {
    USER("일반회원"), LREA("공인중개사");

    private final String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

// ADMIN : 관리자
// USER : 회원
// LREA : 공인중개사