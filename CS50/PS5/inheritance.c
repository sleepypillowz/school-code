// Simulate genetic inheritance of blood type

// Libraries
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Each person has two parents and two alleles
typedef struct person
{
  struct person *parents[2]; // each person has a pointer called parents which points to their
                             // parents which will be called parents[0] and parents[1]
  char alleles[2];           // alleles representswhich alleles A B O this person has
} person;

const int GENERATIONS = 3; // child parent grandparent
const int INDENT_LENGTH = 4;

// Function prototypes
person *create_family(int generations);
void print_family(person *p, int generation);
void free_family(person *p);
char random_allele();

int main(void)
{
  // Seed random number generator
  srand(time(0));

  // Create a new family with three generations
  person *p = create_family(GENERATIONS);

  // Print family tree of blood types
  print_family(p, 0);

  // Free memory
  free_family(p);
}

// Create a new individual with `generations`
person *create_family(int generations)
{
  // TODO: Allocate memory for new person the child is created
  person *p = (person *)malloc(sizeof(person));
  /*
  person *p - stores the memory address of the newly allocated person
  (person *) - type cast to tell malloc that they are dealing with a person structure so it can allocate properly
  malloc - allocates a memory for a person or simply memory allocation in which it creates a new person
  sizeof(person) - calculates the size of a person in bytes
  */

  // Generations with Parent Data
  // When generations become less than 1 stop (this is the base case)
  if (generations > 1)
  {
    // TODO: Recursively create blood type histories for parents
    p->parents[0] = create_family(generations - 1); // Create left parent twice when it reaches 1 it stops
                                                    // The next recursive function then goes which is the right
    p->parents[1] = create_family(generations - 1); // Create right parent twice
    /*
    p->parents[0] - access the first element of the parents array within the person
    structure pointed by p
    create_family - call itself to make a new person then check if it has parents or not
    (generations - 1) - current generation is 3 count down to 0 to stop the recursion
    and tell that you've reached the grandparents
    */

    // TODO: Randomly assign child alleles whether left or right allele using a random num generator of 0 or 1
    p->alleles[0] = p->parents[0]->alleles[rand() % 2]; // Inherit allele from left parent
    p->alleles[1] = p->parents[1]->alleles[rand() % 2]; // Inherit allele from right parent
  }

  // Genrations without Parent Data
  // Grandparents
  else
  {
    // TODO: Set parent pointers to NULL since there are no generations left to create
    p->parents[0] = NULL; // No left parent
    p->parents[1] = NULL; // No right parent

    // TODO: Randomly assign alleles to the grandparents
    p->alleles[0] = random_allele(); // Randomly choose first allele
    p->alleles[1] = random_allele(); // Randomly choose second allele
  }

  // TODO: Return the newly created person
  return p;
}

// Free `p` and all ancestors of `p`.
void free_family(person *p)
{
  // TODO: Handle base case (base case - when triggered will terminate the recursive process)
  if (p == NULL)
  {
    return; // Base case: Nothing to free
  }

  // TODO: Free parents
  // recursively
  free_family(p->parents[0]); // Free left parent
  free_family(p->parents[1]); // Free right parent

  // TODO: Free Child
  free(p);
}

// Print each family member and their alleles.
void print_family(person *p, int generation)
{
  if (p == NULL)
  {
    return; // Base case: No person to print
  }

  // Print indentation
  for (int i = 0; i < generation * INDENT_LENGTH; i++)
  {
    printf(" ");
  }

  // Print person
  if (generation == 0)
  {
    printf("Child (Generation %i): blood type %c%c\n", generation, p->alleles[0], p->alleles[1]);
  }
  else if (generation == 1)
  {
    printf("Parent (Generation %i): blood type %c%c\n", generation, p->alleles[0], p->alleles[1]);
  }
  else
  {
    for (int i = 0; i < generation - 2; i++)
    {
      printf("Great-");
    }
    printf("Grandparent (Generation %i): blood type %c%c\n", generation, p->alleles[0], p->alleles[1]);
  }

  // Print parents of the current generation
  print_family(p->parents[0], generation + 1); // Print left parent
  print_family(p->parents[1], generation + 1); // Print right parent
}

// Randomly chooses a blood type allele.
char random_allele()
{
  int r = rand() % 3; // Generate a random number between 0 and 2
  if (r == 0)
  {
    return 'A';
  }
  else if (r == 1)
  {
    return 'B';
  }
  else
  {
    return 'O';
  }
}
