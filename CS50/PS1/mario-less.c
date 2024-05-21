#include <cs50.h>
#include <stdio.h>

int main(void)
{
  int height;

  do
  {
    height = get_int("Height: ");
  } while (!(height >= 1 && height <= 8));

  for (int i = 0; i < height; i++) // loops until i is equal to height; this tells the height of the object
  {

    for (int j = (height - 1); j > i; j--) // used height so spacing adjusts and -1 to remove space at the bottom
    {
      printf(" ");
    }
    for (int k = 0; k <= i; k++) // loops until j is greater than i; this tells the length of the object
    {
      printf("#");
    }
    printf("\n"); // new line each time it finishes printing "#"
  }
}