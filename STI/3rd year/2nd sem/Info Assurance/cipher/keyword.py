def create_keyword_alphabet(keyword):
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    seen = set()
    substitution = ""

    # Add unique letters from the keyword
    for char in keyword:
        if char not in seen and char in alphabet:
            seen.add(char)
            substitution += char

    # Add the remaining letters of the alphabet
    for char in alphabet:
        if char not in seen:
            substitution += char

    return substitution

def keyword_cipher(text, keyword):
    substitution = create_keyword_alphabet(keyword)
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    encrypted_text = ""

    for char in text.lower():
        if char in alphabet:
            index = alphabet.index(char)
            encrypted_text += substitution[index]
        else:
            encrypted_text += char  # Non-alphabet characters remain unchanged

    return encrypted_text

# List of words
words = ["assurance", "cybersecurity", "infinity", "sampling", "morning", "examination", "master", "system", "visual studio", "bachelor of science in information technology"]
keyword = "methods"

# Encrypt each word in the list
for word in words:
    encrypted_word = keyword_cipher(word, keyword)
    print(f"Original: {word}, Encrypted: {encrypted_word}")
