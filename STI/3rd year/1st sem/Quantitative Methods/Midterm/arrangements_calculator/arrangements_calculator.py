def count_arrangements(choices):
    # Multiply the number of choices in each category to find the total number of arrangements
    total_arrangements = 1
    for choice in choices:
        total_arrangements *= choice
    return total_arrangements

sample_problems = [
    {
        "description": "College freshman's program",
        "choices": [4, 3, 2]
    },
    {
        "description": "Clothing store's sweatshirts",
        "choices": [4, 3]
    },
    {
        "description": "Karla's new outfits",
        "choices": [5, 3, 2, 3]
    }
]

for problem in sample_problems:
    total_arrangements = count_arrangements(problem["choices"])
    print(f"{problem['description']}: {total_arrangements} ways.")
