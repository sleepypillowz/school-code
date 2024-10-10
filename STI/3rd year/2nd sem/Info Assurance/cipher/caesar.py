# Function to apply Caesar cipher
def caesar_cipher(text, shift):
    result = ""
    for char in text:
        if char.isalpha():  # Check if it's a letter
            shift_char = 'a' if char.islower() else 'A'
            result += chr((ord(char) - ord(shift_char) + shift) % 26 + ord(shift_char))
        else:
            result += char  # Non-alphabet characters remain the same
    return result

words = ["assurance", "cybersecurity", "infinity", "sampling", "morning", "examination", "master", "system", "visual studio", "bachelor of science in information technology"]

# Shift by 3
shift = 3

# Encrypt and print each word
for word in words:
    encrypted_word = caesar_cipher(word, shift)
    print(f"Original: {word}, Encrypted: {encrypted_word}")
