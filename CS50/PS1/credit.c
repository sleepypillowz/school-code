#include <cs50.h>
#include <stdio.h>

int main(void)
{
  long cardNumber; // Variable to store the card number
  long VISA;       // Variable to store the card number for VISA check
  long amex;       // Variable to store the card number for AMEX check
  long master;     // Variable to store the card number for Mastercard check
  int counter = 0; // Counter for tracking the position of the digits
  int total = 0;   // Variable to store the sum of the card number digits
  bool valid = false;

  // Get the card number from the user
  cardNumber = get_long("Enter the card number: ");
  VISA = cardNumber;   // Save a copy of the card number for VISA check
  amex = cardNumber;   // Save a copy of the card number for AMEX check
  master = cardNumber; // Save a copy of the card number for Mastercard check

  while (cardNumber > 0)
  {
    if (counter % 2 == 1) // Check if the digit is at an odd position
    {
      int num2 = (cardNumber % 10) * 2; // Double the digit at odd position
      total += num2 % 10;               // Add the individual digits of the doubled number
      total += num2 / 10;               // Add the tens place of the doubled number
    }
    else // Digit is at an even position
    {
      total += cardNumber % 10; // Add the digit directly to the total
    }

    cardNumber /= 10; // Remove the rightmost digit from the card number
    counter++;        // Increment the counter to move to the next digit
  }

  if (total % 10 == 0) // Check if the total is divisible by 10
  {
    while (VISA >= 10)
    {
      VISA /= 10; // Remove the rightmost digit from VISA card number
    }
    if ((VISA == 4) && (counter == 13 || counter == 16)) // Check VISA card conditions
    {
      printf("VISA\n");
      valid = true;
    }

    while (amex >= 10000000000000)
    {
      amex /= 10000000000000; // Remove the rightmost 5 digits from AMEX card number
    }
    if ((amex == 34 || amex == 37) && (counter == 15)) // Check AMEX card conditions
    {
      printf("AMEX\n");
      valid = true;
    }

    while (master >= 100000000000000)
    {
      master /= 100000000000000; // Remove the rightmost 6 digits from Mastercard number
    }
    if ((master >= 51 && master <= 55) && (counter == 16)) // Check Mastercard conditions
    {
      printf("MASTERCARD\n");
      valid = true;
    }
  }

  if (valid == false)
  {
    printf("INVALID\n"); // The card number is invalid
  }

  return 0;
}