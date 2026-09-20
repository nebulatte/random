public abstract class Media {
    private final String name;
    private final String author;
    private final String id;

    // CONSTRUCTOR
    public Media(String name, String author, String id) {
        this.name = formatName(name);
        this.author = formatAuthor(author);
        this.id = formatId(id);
    }
    
    // GETTERS
    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public String getId() {
        return id;
    }

    // ABSTRACTION
    public abstract MediaType getMediaType();

    // FORMATTERS
    private String formatName(String name) {
        return name.toUpperCase();
    }
    private String formatAuthor(String author) {
        return author.toUpperCase();
    }
    private String formatId(String id) {
        return id.toUpperCase();
    }

}
