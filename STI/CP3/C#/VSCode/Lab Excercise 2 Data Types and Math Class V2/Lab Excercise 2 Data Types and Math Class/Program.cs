using System;

namespace LabExcercise2DataTypes
{
    class Program
    {
        static void Main(string[] args)
            
        {
            //assigning variables
            double[] grd = new double[5]; //creates an array then tells the array to store 5 double inputs
            int i = 0;
            double avg, dec, whl;

            intro();

            // an array that gets user input which is converted to Double then loops to get 5 user inputs starting at x = 0 to x = 4
            while (i < 5) 
            {
                grd[i] = Convert.ToDouble(Console.ReadLine());
                if (grd[i] > 75 && grd[i] < 100) //checks if user input is greater than 75 and less than 100
                {
                    i++; // x == x + 1 every iteration of while add 1
                }
                else
                {
                    i = 0;
                    Console.Clear();
                    intro();
                }   
            }

            avg = (grd[0] + grd[1] + grd[2] + grd[3] + grd[4]) / 5; //taking inputs from array

            dec = Math.Round(avg,2); //avg rounded to 2 decimal places

            whl = Math.Round(avg, 0); //avg rounded to 0 decimal places or whole number

            Console.Write("GWA: " + dec); //General Weighted Average

            if (whl != avg) //checks if average have decimals
            {
                Console.Write(" ≈ " + whl); // "≈" A wavy equal sign which means Approximately equals to
            }   

            void intro() //used void to display this message to different locations
            {
                Console.WriteLine("Enter five grades:");
            }
        }
    }
}
