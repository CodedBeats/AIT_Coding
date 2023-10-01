using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace testing
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Random r1 = new Random();

            Console.WriteLine($"The remainder of 9 / 4 is {r1.getRemainder(9, 4)}");
            Console.WriteLine("========");
            r1.getDays();
            Console.WriteLine("========");
            r1.collectionsEx();
            Console.WriteLine("\n========");
            r1.dictionaryEx();
            Console.WriteLine("\n========");
            r1.createArrFromCol();
            Console.WriteLine("\n========");

            // Create a Person object
            Person person = new Person("John Doe", 30);
            person.DisplayInfo();

            // Create an Employee object
            Employee employee = new Employee("Jane Smith", 25, 1001, 50000.0);
            employee.DisplayInfo();
            employee.DisplayEmployeeInfo();


            Console.ReadLine();
        }
    }
}