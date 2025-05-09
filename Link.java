class LinkListMain {
    public static void main(String[] args){
        LinkList theList = new LinkList();

        theList.insertFirst(8);
        theList.insertFirst(7);
        theList.insertFirst(6);
        theList.insertFirst(5);
        theList.insertFirst(4);
        theList.insertFirst(3);
        theList.insertFirst(2);
        theList.insertFirst(1); 

        System.out.println("Original List: ");
        theList.displayList();

        theList.groupOddEven();
        System.out.println("After grouping odd-even: ");
        theList.displayList();

    }
}

public class Link{
    public int iData;
    public Link next;

    public Link(int id){
        iData = id;
    }

    public void displayLink(){
        System.out.print("[" + iData + "] ");
    }
}

class LinkList{
    private Link first;
    
    public LinkList(){
        first = null;
    }
    
    public boolean isEmpty(){
        return (first==null);
    }

    public void insertFirst(int id){
        Link newLink = new Link(id);
        newLink.next = first;
        first = newLink;
    }

    public void displayList(){
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public void groupOddEven(){
        if (first == null || first.next == null) return;

        Link odd = first;
        Link even = first.next;
        Link evenHead = even;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
    }
}