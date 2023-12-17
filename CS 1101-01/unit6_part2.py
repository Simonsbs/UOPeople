def sentence_to_reversed_wordlist(sentence):
    # Converting the sentence into a word list
    word_list = sentence.split()

    # Reversing the word list
    reversed_word_list = word_list[::-1]

    return reversed_word_list


# Input sentence [source: Blade Runner (1982)]
sentence = "All those moments will be lost in time, like tears in rain."

# Getting the reversed word list
reversed_word_list = sentence_to_reversed_wordlist(sentence)

# Output
print(f'Reversed Word List: {reversed_word_list}')
