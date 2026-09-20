public enum MediaType {
    BOOK("Book"),
    DVD("Dvd"),
    MAGAZINE("Magazine");

    private final String description;

    private MediaType(String description) {
        this.description = description;
    }

    public String getMediaDescription() {
        return description;
    }

    public static MediaType fromString(String input) {
        if(input == null) {
            return null;
        }
        String trimmed = input.trim();
        if(trimmed.equalsIgnoreCase("Book") || trimmed.equals("1")) {
            return BOOK;
        }
        if(trimmed.equalsIgnoreCase("Dvd") || trimmed.equals("2")) {
            return DVD;
        }
        if(trimmed.equalsIgnoreCase("Magazine") || trimmed.equals("3")) {
            return MAGAZINE;
        }
        return null;
    }
}