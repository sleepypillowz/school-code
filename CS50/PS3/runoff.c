#include <cs50.h>
#include <stdio.h>
#include <string.h>

#define MAX_VOTERS 100
#define MAX_CANDIDATES 9

// preferences[i][j] is the jth preference for voter i
int preferences[MAX_VOTERS][MAX_CANDIDATES];

// Define the structure for candidates
typedef struct
{
  string name;
  int votes;
  bool eliminated;
} candidate;

// Array to store candidates
candidate candidates[MAX_CANDIDATES];

int voter_count;
int candidate_count;

// Function prototypes
bool vote(int voter, int rank, string name);
void tabulate(void);
bool print_winner(void);
int find_min(void);
bool is_tie(int min);
void eliminate(int min);

int main(int argc, string argv[])
{
  // Check for invalid usage
  if (argc < 2)
  {
    printf("Usage: runoff [candidate ...]\n");
    return 1;
  }

  // Populate array of candidates
  candidate_count = argc - 1;
  if (candidate_count > MAX_CANDIDATES)
  {
    printf("Maximum number of candidates is %i\n", MAX_CANDIDATES);
    return 2;
  }

  // Initialize candidate information
  for (int i = 0; i < candidate_count; i++)
  {
    candidates[i].name = argv[i + 1];
    candidates[i].votes = 0;
    candidates[i].eliminated = false;
  }

  // Get the number of voters
  voter_count = get_int("Number of voters: ");
  if (voter_count > MAX_VOTERS)
  {
    printf("Maximum number of voters is %i\n", MAX_VOTERS);
    return 3;
  }

  // Collect votes from each voter
  for (int i = 0; i < voter_count; i++)
  {
    // Query for each rank
    for (int j = 0; j < candidate_count; j++)
    {
      string name = get_string("Rank %i: ", j + 1);

      // Record vote, unless it's invalid
      if (!vote(i, j, name))
      {
        printf("Invalid vote.\n");
        return 4;
      }
    }

    printf("\n");
  }

  // Conduct runoffs until a winner is determined
  while (true)
  {
    // Calculate votes given remaining candidates
    tabulate();

    // Check if any candidate has won
    bool won = print_winner();
    if (won)
    {
      break;
    }

    int min = find_min();
    bool tie = is_tie(min);

    // If there's a tie, print the names of tied candidates
    if (tie)
    {
      for (int i = 0; i < candidate_count; i++)
      {
        if (!candidates[i].eliminated)
        {
          printf("%s\n", candidates[i].name);
        }
      }
      break;
    }

    // Eliminate candidates with the minimum number of votes
    eliminate(min);

    // Reset vote counts back to zero
    for (int i = 0; i < candidate_count; i++)
    {
      candidates[i].votes = 0;
    }
  }
  return 0;
}

bool vote(int voter, int rank, string name)
{
  for (int i = 0; i < candidate_count; i++)
  {
    if (strcmp(name, candidates[i].name) == 0)
    {
      preferences[voter][rank] = i; // Store the index of the candidate in the preferences array
      return true;
    }
  }
  return false;
}

void tabulate(void)
{
  for (int i = 0; i < voter_count; i++)
  {
    for (int j = 0; j < candidate_count; j++)
    {
      int preference = preferences[i][j];     // Get the index of the candidate in the preference list
      if (!candidates[preference].eliminated) // Check if the candidate is not eliminated
      {
        candidates[preference].votes += 1; // Increment the candidate's vote count
        break;                             // Move on to the next voter
      }
    }
  }
}

bool print_winner(void)
{
  for (int i = 0; i < candidate_count; i++)
  {
    if (candidates[i].votes > voter_count / 2) // Check if a candidate has more than half of the total votes
    {
      printf("%s\n", candidates[i].name); // Print the name of the winning candidate
      return true;
    }
  }
  return false;
}

int find_min(void)
{
  int min_votes = voter_count; // Initialize min_votes with the maximum possible value

  for (int i = 0; i < candidate_count; i++)
  {
    if (!candidates[i].eliminated && candidates[i].votes < min_votes)
    {
      min_votes = candidates[i].votes; // Update min_votes if a lower vote count is found
    }
  }

  return min_votes;
}

bool is_tie(int min)
{
  for (int i = 0; i < candidate_count; i++)
  {
    if (!candidates[i].eliminated && candidates[i].votes != min)
    {
      return false;
    }
  }
  return true;
}

void eliminate(int min)
{
  for (int i = 0; i < candidate_count; i++)
  {
    if (candidates[i].votes == min)
    {
      candidates[i].eliminated = true;
    }
  }
}
