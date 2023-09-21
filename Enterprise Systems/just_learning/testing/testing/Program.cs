using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dotnetApp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine($"The remainder of 9 / 4 is {getRemainder(9, 4)}");
            Console.WriteLine("========");
            getDays();
            Console.WriteLine("========");
            collectionsEx();
            Console.WriteLine("\n========");
            dictionaryEx();



            Console.ReadLine();
        }
        
        // operation using parameter example
        static int getRemainder(int num1, int num2)
        {
            int remainder = num1 % num2;
            return remainder;
        }

        // print all values in arr
        static void getDays()
        {
            string[] weekDays = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            for (int i = 0; i < weekDays.Length; i++)
            {
                Console.WriteLine($"Today is {weekDays[i]}");
            }
        }

        // simple list
        static void collectionsEx()
        {
            // create list
            List<string> colors = new List<string> { "red", "green", "blue"};

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
        static void dictionaryEx()
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