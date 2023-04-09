public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        int[] unsorted = {99, 34, 777, 420, 360, 720, 808, 10, 1, 21};

        MergeSort sort = new MergeSort(unsorted);

        //printing
        System.out.println("Before Sorting: ");
        sort.toString(sort.head);
        System.out.println("After Sort: ");
        sort.toString(sort.sorter(sort.head));

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

    private Node getMid(Node curr)
    {
        if (curr == null)
        {
            return curr;
        }

        //traversal
        Node midNode = curr;

        for(Node endNode = curr.next; endNode != null; endNode = endNode.next)
        {
            if (endNode.next != null)
            {
                midNode = midNode.next;
                endNode = endNode.next;
            }
        }
        return midNode;
    }

    private Node sorter(Node left, Node right)
    {
        if (left == null)
        {
            return right;
        }
        else if (right == null)
        {
            return left;
        }

        Node last = null;

        if(left.data <= right.data) 
        {
            last = left;
            last.next = sorter(left.next, right);
        }
        else if(left.data > right.data)
        {
            last = right;
            last.next = sorter(left, right.next);
        }
        
        return last;
    }

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

    public Node sorter(Node curr)
    {
        if (curr == null || curr.next == null)
        {
            return curr;
        }

        Node mid = getMid(curr); //head => mid
        Node midNext = mid.next; //mid.next => tail

        mid.next = null;

        Node left = sorter(curr);
        Node right = sorter(midNext);

        Node sorted = sorter( left, right);

        return sorted;
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
