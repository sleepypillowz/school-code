using System;

namespace GuessingGame
{
    class Game
    {
        int Guess = 0;
        int Target = 5;
        string Input = "";
        string[] Words = { "cat", "hat", "rat" };
        Random RandomNumber = new Random();

        public void Play()
        {
            Target = RandomNumber.Next(Words.Length);


            Console.Write(" Guess which word I am thinking of... is it ");
            for (int i = 0; i < Words.Length; i++)
            {
                if (i == (Words.Length - 1))
                    Console.Write("or " + Words[i] + "? ");
                else
                    Console.Write(Words[i] + ", ");
            }

            Input = Console.ReadLine();

            if (Input == Words[Target])
            {
                Console.WriteLine("Congratulations! You guessed it!");
            }
            else
            {
                Console.WriteLine("Not a match. Try again!");
                Console.WriteLine("Press enter to continue...");
                Console.ReadLine();
                Play();
            }


            Console.ReadKey();
        }
    }
    class Program
    {
        static void Main()
        {
            Game theGame = new Game();
            theGame.Play();
        }
    }
}