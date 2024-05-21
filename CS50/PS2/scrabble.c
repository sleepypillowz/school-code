#include <cs50.h>
#include <ctype.h>
#include <stdio.h>
#include <string.h>

int POINTS[] = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

int compute_score(string word);

int main(void)
{
  string word1 = get_string("Player 1: ");
  string word2 = get_string("Player 2: ");
  int score1 = compute_score(word1);
  int score2 = compute_score(word2);

  // Print who won
  if (score1 > score2)
  {
    printf("Player 1 wins!\n");
  }
  else if (score2 > score1)
  {
    printf("Player 2 wins!\n");
  }
  else
  {
    printf("It's a tie!\n");
  }
}

int compute_score(string word)
{
  int totalScore = 0;

  for (int i = 0; i < strlen(word); i++) // loops on every character
  {
    char letter = tolower(word[i]); // Convert to lowercase for case-sensitivity
    if (isalpha(letter))            // checks if its a letter
    {
      int letterIndex = letter - 'a';    // Calculate the index for points array by using ascii
      totalScore += POINTS[letterIndex]; // totalScore = totalScore + POINTS[letterIndex]
    }
  }

  return totalScore;
}