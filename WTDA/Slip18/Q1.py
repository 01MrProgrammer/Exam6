import re
from collections import Counter
import matplotlib.pyplot as plt
from wordcloud import WordCloud
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize, sent_tokenize

# Sample text paragraph
text_paragraph = """
Consider any text paragraph. Remove the stopwords. Tokenize the paragraph to extract words and sentences. Calculate the word frequency distribution and plot the frequencies. Plot the wordcloud of the text.
"""

# Remove punctuation and lowercase the text
text_paragraph = re.sub(r'[^\w\s]', '', text_paragraph.lower())

# Tokenize the paragraph into words
words = word_tokenize(text_paragraph)

# Remove stopwords
stop_words = set(stopwords.words('english'))
filtered_words = [word for word in words if word not in stop_words]

# Tokenize the paragraph into sentences
sentences = sent_tokenize(text_paragraph)

# Calculate word frequency distribution
word_freq = Counter(filtered_words)

# Plot the word frequency distribution
plt.figure(figsize=(10, 6))
plt.bar(word_freq.keys(), word_freq.values())
plt.title('Word Frequency Distribution')
plt.xlabel('Words')
plt.ylabel('Frequency')
plt.xticks(rotation=45)
plt.show()

# Generate word cloud
wordcloud = WordCloud(width=800, height=400, background_color='white').generate(' '.join(filtered_words))

# Plot the word cloud
plt.figure(figsize=(10, 6))
plt.imshow(wordcloud, interpolation='bilinear')
plt.axis('off')
plt.title('Word Cloud')
plt.show()
