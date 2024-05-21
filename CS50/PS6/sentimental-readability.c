def count(text):
    words = 1
    letters = 0
    sentences = 0

    for char in text:
        if char.isalpha():
            letters += 1
        elif char.isspace():
            words += 1
        elif char == "." or char == "?" or char == "!":
            sentences += 1

    return letters, words, sentences


def grade_lvl(text):
    letters, words, sentences = count(text)
    output = ""

    avg_letters = (letters / words) * 100
    avg_words = (sentences / words) * 100
    level = round(0.0588 * avg_letters - 0.296 * avg_words - 15.8)

    if level >= 16:
        output = "Grade 16+"
    elif level < 1:
        output = "Before Grade 1"
    else:
        output = "Grade " + str(level)

    return output


text = input("Text: ")
print(grade_lvl(text))
