using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using what_is_mvc;

namespace console_mvc
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Calculator c1 = new Calculator();
            c1.Add();
            c1.DisplayInfo();
            c1.Num1 = 5;
            c1.DisplayInfo();

            Console.ReadLine();
        }
    }
}
