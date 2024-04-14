import re
import nltk
from nltk.tokenize import sent_tokenize

# Text paragraph
text = """Hello all, Welcome to Python Programming Academy. Python Programming Academy is a nice platform to learn new programming skills. It is difficult to get enrolled in this Academy."""

# Preprocess the text to remove special characters and digits
cleaned_text = re.sub(r'[^a-zA-Z\s]', '', text)

# Tokenize the text into sentences
sentences = sent_tokenize(cleaned_text)

# Calculate the importance score for each sentence (for simplicity, let's assume the length of each sentence as its importance score)
importance_scores = [len(sentence.split()) for sentence in sentences]

# Select the top-ranking sentences to form the summary
num_sentences_in_summary = 2
top_sentences_indices = sorted(range(len(importance_scores)), key=lambda i: importance_scores[i], reverse=True)[:num_sentences_in_summary]
summary = ' '.join(sentences[i] for i in top_sentences_indices)

print("Original Text:")
print(text)
print("\nCleaned Text:")
print(cleaned_text)
print("\nSummary:")
print(summary)
