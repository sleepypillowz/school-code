using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Enter your name: "); //this prints in console
            string name = Console.ReadLine(); //this reads the entered input by user as string
            Console.Write("Enter your age: ");
            int age;
            age = Convert.ToInt32(Console.ReadLine()); //this statement converts string to int
            Console.WriteLine("Hi! Your name is " + name + " and your age is " + age);
            Console.Write("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}
