using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace testing
{
    internal class Employee : Person
    {
        public int EmployeeId { get; set; }
        public double Salary { get; set; }

        public Employee(string name, int age, int employeeId, double salary) : base(name, age)
        {
            EmployeeId = employeeId;
            Salary = salary;
        }

        public void DisplayEmployeeInfo()
        {
            Console.WriteLine($"Employee ID: {EmployeeId}, Salary: {Salary}");
        }
    }
}
