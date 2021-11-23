using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SinglyLinkedList
{
    class MySinglyLinkedList
    {
        public int val;
        public MySinglyLinkedList next;
        public MySinglyLinkedList head;

        //Default Constructor
        public MySinglyLinkedList()
        {
            val = 0;
            next = null;
        }
        //Constructor with parameter
        public MySinglyLinkedList(int value)
        {
            val = value;
            next = null;
        }

        //Assign head pointer to the first node
        public void AssignHead()
        {
            head = this;
        }

        //Insert a new node with a value after the current node
        public void InsertNode(MySinglyLinkedList current, int value)
        {
            MySinglyLinkedList node = new MySinglyLinkedList(value);
            if (current.next == null)
            {
                //Insert at the end and easy to handle

                //Add your code here
                current.next = node;
            }
            else
            {
                MySinglyLinkedList temp = current.next;
                current.next = node;
                node.next = temp;
            }

        }
        public void DeleteNextNode(MySinglyLinkedList current)
        {          
            if (current.next == null)//there is no next node, we have already reached the end
                return;
            else
            {
                //Update the next node pointer and reset the deleted node to null
                //Look lecture slides for the pseudocode for deleting a node in the middle

                //Add your code here
                MySinglyLinkedList temp = current.next;
                current.next = temp.next;
                temp.next = null;
            }
        }
        public void TraverseList(MySinglyLinkedList node)
        {
            //Print the values stored at the each node in the list from head to tail
            Console.WriteLine("Traversing in forward direction...");
            while (node != null)//Traverse from the current node
            {
                //Add your code here
                Console.WriteLine(node.val);
                node = node.next;               
            }
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello");
            //Create the first node as head
            MySinglyLinkedList head = new MySinglyLinkedList(1);

            //Temporary node to build the list
            MySinglyLinkedList temp = head;

            //Add 9 more consecutive nodes 2-9
            for (int i = 2; i <= 10; i++)
            {
                //Add your code here
                temp.InsertNode(temp, i);
                temp = temp.next;
            }

            //Traverse the linked list from head to tail
            temp = head;
            temp.TraverseList(temp);
            Console.WriteLine(" ");

            //Delete 3rd node and then traverse
            temp = head;
            for (int i = 0; i < 1; i++)
            {
                temp = temp.next;
            }
            
            temp.DeleteNextNode(temp);
            head.TraverseList(head);
            Console.WriteLine(" ");

            //Insert 100 after the node value 7 and then traverse
            temp = head;
            for (int i = 1; i < 6; i++)
            {
                temp = temp.next;
            }
            for (int x = 0; x < 1; x++)
            {
                temp.InsertNode(temp, 100);
                temp = temp.next;
            }
            head.TraverseList(head);
        }
    }
}
