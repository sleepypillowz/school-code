#include <cs50.h>
#include <ctype.h>
#include <math.h>
#include <stdio.h>
#include <string.h>

float count_letters(string text);
float count_words(string text);
float count_sentences(string text);
float grade_level(float totalLetters, float totalWords, float totalSentences);

int main(void)
{
  string input = get_string("Text: ");

  float letters = count_letters(input);
  float words = count_words(input);
  float sentences = count_sentences(input);

  float index = grade_level(letters, words, sentences);

  if (index < 1)
  {
    printf("Before Grade 1\n");
  }
  else if (index >= 16)
  {
    printf("Grade 16+\n");
  }
  else
  {
    printf("Grade %.0f\n", index);
  }
}

float count_letters(string text)
{

  float totalLetters = 0;

  for (int i = 0; i < strlen(text); i++)
  {
    if (isalpha(text[i]))
    {
      totalLetters += 1;
    }
  }

  return totalLetters;
}

float count_words(string text)
{

  float totalWords = 1;

  for (int i = 0; i < strlen(text); i++)
  {
    if (isspace(text[i]))
    {
      totalWords += 1;
    }
  }
  return totalWords;
}

float count_sentences(string text)
{

  float totalSentences = 0;

  for (int i = 0; i < strlen(text); i++)
  {
    if (text[i] == '.' || text[i] == '?' || text[i] == '!')
    {
      totalSentences += 1;
    }
  }

  return totalSentences;
}

float grade_level(float totalLetters, float totalWords, float totalSentences)
{

  float averageLetters = totalLetters / totalWords * 100;
  float averageWords = totalSentences / totalWords * 100;

  float index = round(0.0588 * averageLetters - 0.296 * averageWords - 15.8);

  return index;
}