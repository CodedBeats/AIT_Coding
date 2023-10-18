using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Crapulator;

namespace Crapulator_Controller
{
    public class Crapulator_Controller1
    {
        Calculator c = new Calculator();
        public double handleOperation(string operatorVal)
        {
            double ans = 0;

            if (operatorVal == "+")
            {
                ans = c.Add();
            }
            else if (operatorVal == "-")
            {
                ans = c.Sub();
            }
            else if (operatorVal == "*")
            {
                ans = c.Mul();
            }
            else if (operatorVal == "/")
            {
                ans = c.Div();
            }
            else
            {
                // idk
            }

            return ans;
        }

        public void updateCalcNum(double input, bool isNum1)
        {
            if (isNum1)
            {
                c.Num1 = input;
            }
            else
            {
                c.Num2 = input;
            }
            
        }

        public void clearNums()
        {
            c.Num1 = 0;
            c.Num2 = 0;
        }
    }
}
