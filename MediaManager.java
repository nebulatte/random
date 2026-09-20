import java.util.ArrayList;

public class MediaManager {
    private final ArrayList<Media> inventory;

    public MediaManager() {
        inventory = new ArrayList<>();
    }

    public boolean isEmpty() {
        return inventory.isEmpty();
    }

    public Media createMedia(MediaType type, String name, String author, String id) {
        switch(type) {
            case BOOK -> {
                return new Book(name, author, id);
            }
            case DVD -> {
                return new DVD(name, author, id);
            }
            case MAGAZINE -> {
                return new Magazine(name, author, id);
            }
            default -> {
                System.out.println("Unknown Media Type: " + type);
                return null;
            }
        }
    }

    public void addMedia(Media media) {
        inventory.add(media);
    }

    public Media findMediaById(String id) {
        for(int i = 0; i < inventory.size(); i++) {
            Media currentMedia = inventory.get(i);
            if(currentMedia.getId().equalsIgnoreCase(id)) {
                return currentMedia;
            }
        }
        return null;
    }

    public boolean idExists(String id) {
        return findMediaById(id) != null;
    }

    public void updateMedia() {

    }

    public boolean deleteMedia(String id) {
        Media currentMedia = findMediaById(id);
        if(currentMedia != null) {
            inventory.remove(currentMedia);
            return true;
        }
        return false;
    }

    public ArrayList<Media> getAllMedia() {
        return new ArrayList<>(inventory);
    }

    public ArrayList<Media> getMediaByType(MediaType type) {
        ArrayList<Media> result = new ArrayList<>();
        for(int i = 0; i < inventory.size(); i++) {
            Media currentMedia = inventory.get(i);
            if(currentMedia.getMediaType().equals(type)) {
                result.add(currentMedia);
            }
        }
        return result;
    }
}
