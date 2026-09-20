public class DVD extends Media{

    public DVD(String name, String author, String id) {
        super(name, author, id);
    }

    @Override
    public MediaType getMediaType() {
        return MediaType.DVD;
    }

}
