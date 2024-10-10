def create_giovanni_alphabet(keyword):
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    seen = set()
    substitution = ""

    # Add unique letters from the keyword
    for char in keyword.lower():
        if char not in seen and char in alphabet:
            seen.add(char)
            substitution += char

    # Add the remaining letters of the alphabet
    for char in alphabet:
        if char not in seen:
            substitution += char

    return substitution

def giovanni_cipher(text, keyword, key_letter):
    substitution = create_giovanni_alphabet(keyword)
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    encrypted_text = ""

    # Shift the substitution alphabet based on the key letter
    shift = alphabet.index(key_letter.lower())
    shifted_substitution = substitution[shift:] + substitution[:shift]

    for char in text.lower():
        if char in alphabet:
            index = alphabet.index(char)
            encrypted_text += shifted_substitution[index]
        else:
            encrypted_text += char  # Non-alphabet characters remain unchanged

    return encrypted_text

# List of words
words = [
    "assurance", "cybersecurity", "infinity", "sampling", 
    "morning", "examination", "master", "system", 
    "visual studio", "bachelor of science in information technology"
]
keyword = "METHODS"
key_letter = "C"

# Encrypt each word in the list using the Giovanni cipher
for word in words:
    encrypted_word = giovanni_cipher(word, keyword, key_letter)
    print(f"Original: {word}, Encrypted: {encrypted_word}")
