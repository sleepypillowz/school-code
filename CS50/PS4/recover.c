#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
  // Check for correct command line usage
  if (argc != 2)
  {
    printf("Usage: recover [card]\n");
    return 1;
  }

  // Open memory card file in read mode
  FILE *input_file = fopen(argv[1], "r");
  if (input_file == NULL)
  {
    printf("Could not open %s.\n", argv[1]);
    return 1;
  }

  // Initialize variables
  unsigned char buffer[512]; // Buffer to hold a block of data
  int jpg_count = 0;         // Count of recovered JPEG images
  FILE *output_file = NULL;  // Pointer to the current output JPEG file

  // Read 512 bytes at a time from the input file
  while (fread(buffer, 512, 1, input_file))
  {
    // Check if it's the start of a new JPEG
    if (buffer[0] == 0xff && buffer[1] == 0xd8 && buffer[2] == 0xff && (buffer[3] & 0xf0) == 0xe0)
    {
      // Close previous output file if one was open
      if (output_file != NULL)
      {
        fclose(output_file);
      }

      // Create a new output file for the current JPEG
      char filename[8]; // Buffer to hold the output filename
      sprintf(filename, "%03i.jpg", jpg_count);
      output_file = fopen(filename, "w");
      if (output_file == NULL)
      {
        fclose(input_file);
        printf("Could not create %s.\n", filename);
        return 1;
      }

      jpg_count++; // Increment the JPEG count
    }

    // Write the data into the output file if it's open
    if (output_file != NULL)
    {
      fwrite(buffer, 512, 1, output_file);
    }
  }

  // Close files
  if (output_file != NULL)
  {
    fclose(output_file);
  }
  fclose(input_file);

  return 0;
}
