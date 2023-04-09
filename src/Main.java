public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        int[] unsorted = {99, 34, 777, 420, 360, 720, 808, 10, 1, 21};

        MergeSort sort = new MergeSort(unsorted);

    }
}

class Node 
{
    public int data;
    public Node next;
    public Node(int data)
    {
        this.data = data;
    }
}

class Merge 
{
    public Node head;
    private Node tail;

    public MergeSort(int[] unsorted)
    {
        for(int a : unsorted)
        {
            if(head == null)
            {
                Node newNode = new Node(a);
                head = newNode;
                tail = newNode;
            }
        }
    }
}
