import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        MediaManager manager = new MediaManager();
        boolean running = true;

        while(running) {
            printMainMenu();
            int choice = Utils.readValidInt(scanner, "Enter your choice: ", 1, 5, 
            "Invalid input. Enter a number from 1 to 5.");
            System.out.println();
            switch(choice) {
                case 1 -> addMedia(scanner, manager);
                case 2 -> deleteMedia(scanner, manager);
                case 3 -> displayAllMedia(manager);
                case 4 -> displayMediaByType(scanner, manager);
                case 5 -> { 
                    System.out.print("Exiting the program...");
                    running = false;
                }
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void printMainMenu() {
        Utils.displayHeader("MAIN MENU");
        System.out.println("1 - Add Media");
        System.out.println("2 - Delete Media");
        System.out.println("3 - Display All Media");
        System.out.println("4 - Display Media by Type");
        System.out.println("5 - Exit Program");
    }

    private static void printMediaTypes() {
        System.out.println("Media Types:");
        System.out.println("1 - Book");
        System.out.println("2 - DVD");
        System.out.println("3 - Magazine");
    }

    // ==================================================================================================

    private static void addMedia(Scanner scanner, MediaManager manager) {
        Utils.displayHeader("ADDING MEDIA");
        printMediaTypes();
        String choice = Utils.readNonEmptyString(scanner, "Enter your choice: ");
        MediaType type = MediaType.fromString(choice);
        if(type == null) {
            System.out.println("Media \"" + choice.toUpperCase() + "\" does not exist!");
            return;
        }

        String name = Utils.readValidString(scanner, 100, "Enter the media's name: ", 
        "[a-zA-Z0-9 ]+", "Invalid input. Try again.");
        String author = Utils.readValidString(scanner, 100, "Enter the media's author: ", 
        "[a-zA-Z0-9 ]+", "Invalid input. Try again.");
        String id = Utils.readValidString(scanner, 6, "Enter the id: ", 
            "[a-zA-Z]{2}[0-9]{4}", "Invalid ID. Follow the format [AB1234].");
        if(manager.idExists(id) == true) {
            System.out.println("This id already exists!");
            return;
        }

        Media media = manager.createMedia(type, name, author, id);
        manager.addMedia(media);
        System.out.printf("%s: %s by %s has been added successfully!%n", media.getMediaType(), media.getName(), media.getAuthor());
    }

    // ==================================================================================================

    private static void deleteMedia(Scanner scanner, MediaManager manager) {
        Utils.displayHeader("DELETING MEDIA");
        if(manager.isEmpty()) {
            System.out.println("The inventory is currently empty. Nothing to delete here.");
            return;
        }
        String id = Utils.readValidString(scanner, 6, "Enter the id: ", 
            "[a-zA-Z]{2}[0-9]{4}", "Invalid ID. Follow the format [AB1234].");
        boolean deleted = manager.deleteMedia(id);
        if(deleted) {
            System.out.println("The media has been successfully deleted!");
        } else {
            System.out.println("The media was not found or have already been deleted!");
        }
    }

    // ==================================================================================================

    private static void displayAllMedia(MediaManager manager) {
        Utils.displayHeader("DISPLAYING ALL MEDIA");
        ArrayList<Media> placeholderList = manager.getAllMedia();
        if(manager.isEmpty()) {
            System.out.println("The inventory is currently empty. Nothing to display here.");
            return;
        }
        System.out.printf(Utils.tableFormat(true), "NAME", "AUTHOR", "ID", "MEDIA TYPE");
        for(int i = 0; i < placeholderList.size(); i++) {
            Media currentMedia = placeholderList.get(i);
            System.out.printf(Utils.tableFormat(true), currentMedia.getName(), currentMedia.getAuthor(), 
            currentMedia.getId(), currentMedia.getMediaType());
        }
    }

    private static void displayMediaByType(Scanner scanner, MediaManager manager) {
        Utils.displayHeader("DISPLAYING MEDIA BY TYPE");
        if(manager.isEmpty()) {
            System.out.println("The inventory is currently empty. Nothing to display here.");
            return;
        }
        printMediaTypes();
        String choice = Utils.readNonEmptyString(scanner, "Enter your choice: ");
        MediaType type = MediaType.fromString(choice);
        ArrayList<Media> placeholderList = manager.getMediaByType(type);
        if(placeholderList.isEmpty()) {
            System.out.println("The inventory currently does not have a media of this type.");
            return;
        }
        System.out.println(type.getMediaDescription());
        System.out.printf(Utils.tableFormat(false), "NAME", "AUTHOR", "ID");
        for(int i = 0; i < placeholderList.size(); i++) {
            Media currentMedia = placeholderList.get(i);
            System.out.printf(Utils.tableFormat(false), currentMedia.getName(), currentMedia.getAuthor(), 
            currentMedia.getId());
        }
    }

}