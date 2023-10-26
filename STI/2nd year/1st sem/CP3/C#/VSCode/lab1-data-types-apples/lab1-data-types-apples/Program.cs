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
            Console.Write("How many apple(s) do you have? ");
            double applesum;
            applesum = Convert.ToDouble(Console.ReadLine());       

            Console.Write("How much is each apple(s)? ");
            double appleprice;
            appleprice = Convert.ToDouble(Console.ReadLine());       

            double applepricetotal = (applesum * appleprice);

            Console.WriteLine("The Total price of " + applesum + " apple(s) with decimals is " + applepricetotal);

            applepricetotal = Math.Round(applepricetotal, MidpointRounding.AwayFromZero);

            Console.WriteLine("The Total price of " + applesum + " apple(s) as an Integer is " + applepricetotal);

            Console.Write("BS301 Alexander Acojido");

            Console.Write("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}
