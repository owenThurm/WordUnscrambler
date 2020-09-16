"""
a python script to check which words in a file are english words
"""
import ssl
import nltk

try:
    _create_unverified_https_context = ssl._create_unverified_context
except AttributeError:
    pass
else:
    ssl._create_default_https_context = _create_unverified_https_context


from nltk.corpus import words

print('mead' in words.words())

english_words = []
i=1
with open('/Users/othurm/desktop/repos/WordUnscrambler/Strings.txt', 'r') as permutations:
    for line in permutations:
        print(line)
        for word in line.split("]["):
            print(word)
            print(i)
            i = i+1
            if(word in words.words()):
                english_words.append(word)

print(english_words)