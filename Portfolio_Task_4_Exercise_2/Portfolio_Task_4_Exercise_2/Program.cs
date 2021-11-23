using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DoublyLinkedList
{
    class MyDoublyLinkedList
    {
        private string name;
        public MyDoublyLinkedList next;
        public MyDoublyLinkedList prev;
        private MyDoublyLinkedList head;

        //Default Constructor
        public MyDoublyLinkedList()
        {
            name = "";
            next = null;
            prev = null;
        }
        //Constructor with parameter
        public MyDoublyLinkedList(string value)
        {
            name = value;
            next = null;
            prev = null;
        }

        //Assign head pointer to the first node
        //public void AssignHead()
        //{
        //    head = this;
        //}

        //Insert a new node with a value AFTER the current node
        public void InsertNextNode(MyDoublyLinkedList current, string value)
        {
            MyDoublyLinkedList node = new MyDoublyLinkedList(value);
            if (current.next == null)
            {
                //Insert at the end and easy to handle

                //Add your code here
                current.next = node;
                node.prev = current;
            }
            else
            {
                //Insert in the middle               
                //Look lecture slides for the pseudocode for adding node in the middle

                //Add your code here
                MyDoublyLinkedList temp = current.prev;
                current.next = node;
                node.prev = current;
                node.next = temp;
                temp.prev = node;
            }
        }

        //Insert a new node with a value BEFORE the current node
        public void InsertPrevtNode(MyDoublyLinkedList current, string value)
        {
            MyDoublyLinkedList node = new MyDoublyLinkedList(value);
            if (current.prev == null)
            {
                //Insert in the begining 
               // head = node;//Head is updated after inserting in the beginning

                //Add the rest of your code here....
                //Look lecture slides for the pseudocode for adding node in the begining
                current.prev = node;
                node.next = current;

            }
            else
            {
                //Insert in the middle               
                //Look lecture slides for the pseudocode for adding node in the middle

                //Add your code here
                MyDoublyLinkedList temp;
                temp = current.prev;
                current.prev = node;
                node.next = current;
                node.prev = temp;
                temp.next = node;
            }
        }
        public void DeleteNode()
        {
            //Check for ERROR if you are deleting a node which is referred by many pointers.
            //Update all these pointers before deleting (releasing) memory!

            if (next == null)//last node
            {
                //Delete the last node
                //Look lecture slides for the pseudocode for deleting last node 
                MyDoublyLinkedList temp2 = this.prev;
                temp2.next = null;
                this.prev = null;
            }
            else if (prev == null)
            {
                //Delete head node
                //Look lecture slides for the pseudocode for deleting head node 
                MyDoublyLinkedList temp2 = this.prev;
                temp2.next = null;
                this.prev = null;
            }
            else
            {
                //Update the next node pointer and reset the deleted node to null
                //Look lecture slides for the pseudocode for deleting a node in the middle

                //Add your code here
                MyDoublyLinkedList nextNode = this.next;
                MyDoublyLinkedList previousNode = this.prev;
                previousNode.next = nextNode;
                nextNode.prev = previousNode;
                this.prev = null;
                this.next = null;
            }
        }

        //Traverse forward
        public void TraverseForward(MyDoublyLinkedList node)
        {
            //Print the values stored in each node from current to tail
            Console.WriteLine("Traversing in forward direction...");
            while (node != null)//Traverse from the current node
            {
                //Add your code here
                Console.WriteLine(node.name);
                node = node.next;
            }
        }

        //Traverse Backward
        public void TraverseBackward(MyDoublyLinkedList node)
        {
            //Print the values stored in each node from current to head
            Console.WriteLine("Traversing in backward direction...");
            while (node != null)//Traverse from the current node
            {
                //Add your code here
                Console.WriteLine(node.name);
                node = node.prev;
            }
        }

    }
    class Program
    {
        static void Main(string[] args)
        {
            //Create the first node
            MyDoublyLinkedList node = new MyDoublyLinkedList("Ardhendu");
            
            //Assign head
            MyDoublyLinkedList head = node;
            

            //Add 9 more consecutive nodes (Tom, Jones, David, Andrew, Peter, Mark, Collette, Dave, Dan)
            string[] names = { "Tom", "Jones", "David", "Andrew", "Peter", "Mark", "Collette", "Dave", "Dan" };
            for (int i = 0; i <= 8; i++)
            {
                //Add your code here
                head.InsertNextNode(node, names[i]);
                node = node.next;
            }
            
            //Traverse the linked list from head to tail

            //Add your code here
            head.TraverseForward(head);
            Console.WriteLine(" -------------------------- ");

            //Delete Peter node and then traverse forward
            
            //Add your code here
            node = head;
            for (int x = 1; x < 6; x++)
            {
                node = node.next;
            }
            node.DeleteNode();
            Console.WriteLine("Deleting Peter");
            head.TraverseForward(head);
            Console.WriteLine(" ------------------------- ");

            //Insert Peter after Mark and then traverse backward

            //Add your code here
            MyDoublyLinkedList tail = node;
            node = head;
            for (int z = 1; z < 6; z++)
            {
                node = node.next;
            }
            head.InsertNextNode(node, "Peter");
            head.TraverseBackward(tail);
        }
    }
}
