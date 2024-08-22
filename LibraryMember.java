import java.util.*;

public class LibraryMember
{
	public String memberID;
    public String name;
    public List<LibraryItems> borrowedItems;

    public LibraryMember(String memberID, String name){
        this.memberID=memberID;
        this.name=name;
        this.borrowedItems=new ArrayList<>();
    }

    public String getMemberID(){
        return memberID;
    }

    public String getName(){
        return name;
    }

    public void borrowItem(LibraryItem Item){
        borrowedItems.add(Item);
    }
    
    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public void returnItem(LibraryItem item) {
        borrowedItems.remove(item);
    }
}
