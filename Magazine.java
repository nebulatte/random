public class Magazine extends Media{

    public Magazine(String name, String author, String id) {
        super(name, author, id);
    }

    @Override
    public MediaType getMediaType() {
        return MediaType.MAGAZINE;
    }

}
