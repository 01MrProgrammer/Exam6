import nltk
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize

# Text paragraph
text_paragraph = "Hello all, Welcome to Python Programming Academy. Python Programming Academy is a nice platform to learn new programming skills. It is difficult to get enrolled in this Academy."

# Tokenize the paragraph into words
words = word_tokenize(text_paragraph)

# Get the list of stopwords
stop_words = set(stopwords.words('english'))

# Remove stopwords
filtered_words = [word for word in words if word.lower() not in stop_words]

# Join the filtered words back into a paragraph
filtered_paragraph = ' '.join(filtered_words)

print("Original Text Paragraph:")
print(text_paragraph)
print("\nText Paragraph after Removing Stopwords:")
print(filtered_paragraph)
