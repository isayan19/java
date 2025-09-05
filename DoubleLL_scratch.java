public class DoubleLL_scratch {

    //Create the Node Structure
    class Node{
        int data;
        Node prev;
        Node next;
        
        Node(int data){
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }

    Node head;
    Node tail;
    int size=0;

    //function for get size
    public void getSize(){
        System.out.println("Size:"+size);
    }

    //function to print the list
    public void printList(){
        if(head==null){
            System.out.println("List is empty!");
            return;
        }
        Node temp=head;
        System.out.print("null");
        while(temp!=null){
            System.out.print("<-"+temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null\n");
        return;
    }

    //function to add Node at First
    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            size++;
            return;
        }
        head.prev=newNode;
        newNode.next=head;
        head=newNode;
        size++;
        return;
    }

    //function to add Node at Last
    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
        }else{
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }
        size++;
    }

    //function to add Node at position
    public void addIndex(int data, int pos){
        Node newNode=new Node(data);
        if(pos<1 || pos>size+1){
            System.out.println("Invalid Position");
        }else if(pos==1){
            addFirst(data);
        }else if(pos==size+1){
            addLast(data);
        }else{
            Node temp=head;
            for(int i=1;i<pos-1;i++){
                temp=temp.next;
            }
            newNode.prev=temp;
            newNode.next=temp.next;
            temp.next.prev=newNode;
            temp.next=newNode;
        }
        size++;
    }

    //function to delete node from first
    public Integer deleteFirst(){
        int del;
        if(head==null){
            System.out.println("List is Empty");
            return null;
        }else if(head==tail){
            del=head.data;
            head=tail=null;
        }else{
            del=head.data;
            head=head.next;
            head.prev=null;
        }
        size--;
        System.out.println("Delete:"+del);
        return del;
    }

    //function to delete node from end
    public Integer deleteLast(){
        int del;
        if(head==null){
            System.out.println("List is Empty");
            return null;
        }else if(head==tail){
            del=head.data;
            head=tail=null;
        }else{
            del=tail.data;
            tail=tail.prev;
            tail.next=null;
        }
        size--;
        System.out.println("Delete:"+del);
        return del;
    }

    //function to delete node from position
    public Integer deleteIndex(int pos){
        int del;
        if(head==null){
            System.out.println("List is Empty");
            return null;
        }else if(pos<1 || pos>size){
            System.out.println("Invalid Position");
            return null;
        }else if(pos==1){
            return deleteFirst();
        }else if(pos==size){
            return deleteLast();
        }else{
            Node temp=head;
            for(int i=1;i<pos-1;i++){
                temp=temp.next;
            }
            del=temp.next.data;
            temp.next=temp.next.next;
            if (temp.next != null){
                temp.next.prev=temp;
            }
        }
        size--;
        System.out.println("Delete:"+del);
        return del;
    }

    public static void main(String[] args) {
        System.out.println("Double Linked List");
        DoubleLL_scratch list=new DoubleLL_scratch();
        list.printList();
    }
}
