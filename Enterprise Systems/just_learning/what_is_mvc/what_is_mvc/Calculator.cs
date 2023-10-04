using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace what_is_mvc
{
    public class Calculator
    {
        public double Num1 { get; set; }
        public double Num2 { get; set; }
        private double ans = 0;

        public double Add()
        {
            ans = Num1 + Num2;
            return ans;
        }

        public double Sub()
        {
            ans = Num1 - Num2;
            return ans;
        }

        public double Mul()
        {
            ans = Num1 * Num2;
            return ans;
        }

        public double Div()
        {
            ans = Num1 / Num2;
            return ans;
        }

        public void DisplayInfo()
        {
            Console.WriteLine($"Answer is {ans}");
        }
    }
}
