using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace testing
{
    internal class Random
    {
        // create set arr from collection
        public void createArrFromCol()
        {
            // Creating a collection of strings
            Collection<string> myColl = new Collection<string>();

            myColl.Add("A");
            myColl.Add("B");
            myColl.Add("C");
            myColl.Add("D");
            myColl.Add("E");

            // Creating a string array
            string[] myArr = new string[myColl.Count];

            // Copying the entire Collection to a compatible one-dimensional Array,
            // starting at the specified index of the target array
            myColl.CopyTo(myArr, 0);

            // Displaying the elements in myArr
            foreach (string str in myArr)
            {
                Console.WriteLine(str);
            }
        }

        // operation using parameter example
        public int getRemainder(int num1, int num2)
        {
            int remainder = num1 % num2;
            return remainder;
        }

        // print all values in arr
        public void getDays()
        {
            string[] weekDays = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
            for (int i = 0; i < weekDays.Length; i++)
            {
                Console.WriteLine($"Today is {weekDays[i]}");
            }
        }

        // simple list
        public void collectionsEx()
        {
            // create list
            List<string> colors = new List<string> { "red", "green", "blue" };

            // Iterate through the list.
            Console.Write("Initial list:\n");
            foreach (string color in colors)
            {
                Console.Write($"{color}, ");
            }

            // remove item from list
            colors.Remove("red");
            Console.Write("\n\nList after removed item:\n");
            // Iterate through the list in a different way
            for (int i = 0; i < colors.Count; i++)
            {
                Console.Write($"{colors[i]}, ");
            }

            // add removed item back
            colors.Add("red");
            // Iterate through the list.
            Console.Write("\n\nList after added item:\n");
            foreach (string color in colors)
            {
                Console.Write($"{color}, ");
            }
        }

        // dictionary example
        public void dictionaryEx()
        {
            Dictionary<int, string> dict1 = new Dictionary<int, string>();

            // Adding key/value pairs in the Dictionary
            dict1.Add(1, "hello");
            dict1.Add(2, "world");
            dict1.Add(3, "!");

            foreach (KeyValuePair<int, string> ele1 in dict1)
            {
                Console.WriteLine("{0} and {1}", ele1.Key, ele1.Value);
            }
        }
    }
}