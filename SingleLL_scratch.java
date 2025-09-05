public class SingleLL_scratch {

    //Create the Node Structure
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    Node head;
    int size=0;

    //Function to get list size
    public void getSize(){
        System.out.println("Size:"+size);
    }

    //Function to print the list
    public void printList(){
        if(head==null){
            System.out.println("List is Empty");
            return;
        }
        Node currNode=head;
        while(currNode!=null){
            System.out.print(currNode.data+"->");
            currNode=currNode.next;
        }
        System.out.print("null\n");
    }

    //Funtion to add node at first
    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            size++;
            return;
        }
        newNode.next=head;
        head=newNode;
        size++;
    }

    //Function to add node at last
    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            size++;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        size++;
    }

    //Function to add Node at Index
    public void addIndex(int data, int pos){
        Node newNode=new Node(data);
        if(pos==1){
            addFirst(data);
            return;
        }else if(pos<1 || pos>size+1){
            System.out.println("Index out of range");
        }else{
            Node temp=head;
            for(int i=1;i<pos-1;i++){
                temp=temp.next;
            }
            newNode.next=temp.next;
            temp.next=newNode;
            size++;
        }
    }
    
    public Integer deleteFirst(){
        if(head==null){
            System.out.println("Nothing to delete");
            return null;
        }
        int temp=head.data;
        head=head.next;
        size--;
        System.out.println("Deleted:"+temp);
        return temp;
    } 
    
    public Integer deleteLast(){
        int del;
        if(head==null){
            System.out.println("Nothing to delete");
            return null;
        }else if(head.next==null){
            del=head.data;
            head=null;
            size--;
            System.out.println("Deleted:"+del);
            return del;
        }
        Node secondLast=head;
        Node last=secondLast.next;
        while(last.next!=null){
            secondLast=secondLast.next;
            last=last.next;
        }
        del=last.data;
        secondLast.next=null;
        size--;
        System.out.println("Deleted:"+del);
        return del;
    }
    
    public Integer deleteIndex(int pos){
        Integer del;
        if(head==null){
            System.out.println("List is Empty");
            return null;
        }else if(pos<1 || pos>size){
            System.out.println("Invaid Index");
            return null;
        }else if(pos==1){
            return deleteFirst();
        }else{
            Node temp=head;
            for(int i=1;i<pos-1;i++){
                temp=temp.next;
            }
            del=temp.next.data;
            temp.next=temp.next.next;
            size--;
            System.out.println("Deleted:"+del);
            return del;
        }
    }
    
    
    public static void main(String[] args) {
        System.out.println("Single Linked List From Scratch");

        SingleLL_scratch list=new SingleLL_scratch();
        list.getSize();
        list.printList();
        list.addFirst(10);
        list.getSize();
        list.printList();
        list.addFirst(20);
        list.addFirst(30);
        list.getSize();
        list.printList();
        list.addLast(50);
        list.addLast(55);
        list.getSize();
        list.printList();
        list.addIndex(5,1 );
        list.printList();
        list.addIndex(60, 5);
        list.printList();
        list.addIndex(70, 3);
        list.printList();
        list.getSize();
        list.deleteFirst();
        list.printList();
        list.getSize();
        list.deleteLast();
        list.printList();
        list.getSize();
        list.deleteIndex(1);
        list.printList();
        list.getSize();
        list.deleteIndex(10);
        list.printList();
        list.getSize();
        list.deleteIndex(5);
        list.printList();
        list.getSize();
        list.deleteIndex(2);
        list.printList();
        list.getSize();
    }
}
