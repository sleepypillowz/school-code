import math

# Perumutation and Combination Calculator

calculate_ways = lambda t, p: (
    math.perm(*p) if t == "perm" else
    math.factorial(len(p[0])) // math.prod(math.factorial(p.count(c)) for c in set(p[0])) if t == "word_arrangement" else
    math.prod(p) if t == "product" else
    math.comb(*p) if t == "comb" else
    math.prod(math.comb(13, x) for x in p) if t == "bridge_hands" else
    "Invalid problem type"
)

# Example usages:
print("Answer (Problem 1):", calculate_ways("perm", (25, 4)))
print("Answer (Problem 2):", calculate_ways("word_arrangement", ("MATHEMATICS",)))
print("Answer (Problem 3):", calculate_ways("product", (3, 8, 7, 6)))
print("Answer (Problem 4):", calculate_ways("comb", (16, 3)))
print("Answer (Problem 5):", calculate_ways("bridge_hands", (4, 6, 1, 2)))
