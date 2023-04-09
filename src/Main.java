public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        int[] unsorted = {99, 34, 777, 420, 360, 720, 808, 10, 1, 21};

        MergeSort sort = new MergeSort(unsorted);

        //printing
        System.out.println("Before Sorting: ");
        sort.toString(sort.head);

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

class MergeSort
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
            else
            {
                Node newNode = new Node(a);
                tail.next = newNode;
                tail = newNode;
            }
        }
    }

    public void toString(Node input)
    {
        for(; input != null; input = input.next)
        {
            System.out.print(input.data + " ");
        }
        System.out.println();
    }
}
