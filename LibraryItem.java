import java.util.*;

public abstract class LibraryItem {
    private String id;
    private String title;
    private boolean available;

    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
        this.available = true;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract String getType();
}

public class Book extends LibraryItem {
    private String author;
    private int pageCount;

    public Book(String id, String title, String author, int pageCount) {
        super(id, title);
        this.author = author;
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String getType() {
        return "Book";
    }
}

public class DVD extends LibraryItem {
    private String director;
    private int duration; // in minutes

    public DVD(String id, String title, String director, int duration) {
        super(id, title);
        this.director = director;
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String getType() {
        return "DVD";
    }
}

public class Journal extends LibraryItem {
    private int volumeNumber;
    private int issueNumber;

    public Journal(String id, String title, int volumeNumber, int issueNumber) {
        super(id, title);
        this.volumeNumber = volumeNumber;
        this.issueNumber = issueNumber;
    }

    public int getVolumeNumber() {
        return volumeNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public String getType() {
        return "Journal";
    }
}

public class Library {
    public List<LibraryItem> items;
    public List<LibraryMember> members;

    public Library() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void removeItem(LibraryItem item) {
        items.remove(item);
    }

    public void addMember(LibraryMember member) {
        members.add(member);
    }

    public void removeMember(LibraryMember member) {
        members.remove(member);
    }

    public void displayBorrowedItems(LibraryMember member) {
        List<LibraryItem> borrowedItems = member.getBorrowedItems();
        if (borrowedItems.isEmpty()) {
            System.out.println("No items currently borrowed by " + member.getName());
        } else {
            System.out.println("Items borrowed by " + member.getName() + ":");
            for (LibraryItem item : borrowedItems) {
                System.out.println(item.getType() + " - " + item.getTitle() + " (" + item.getId() + ")");
            }
        }
    }
}

public class LibraryMember {
    public String memberID;
    public String name;
    public List<LibraryItem> borrowedItems;

    public LibraryMember(String memberID, String name) {
        this.memberID = memberID;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    public String getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public void borrowItem(LibraryItem item) {
        borrowedItems.add(item);
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public void returnItem(LibraryItem item) {
        borrowedItems.remove(item);
    }
}