public class Book extends Media{

    public Book(String name, String author, String id) {
        super(name, author, id);
    }

    @Override
    public MediaType getMediaType() {
        return MediaType.BOOK;
    }

}
