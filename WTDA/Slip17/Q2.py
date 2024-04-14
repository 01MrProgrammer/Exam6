import re
import nltk
from nltk.tokenize import sent_tokenize
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity

# Function to preprocess the text
def preprocess_text(text):
    # Remove special characters and digits
    processed_text = re.sub(r'[^a-zA-Z\s]', '', text)
    return processed_text

# Function to generate summary using extractive summarization
def generate_summary(text, num_sentences=2):
    # Preprocess the text
    processed_text = preprocess_text(text)
    
    # Tokenize the text into sentences
    sentences = sent_tokenize(processed_text)
    
    # Create TF-IDF vectorizer
    vectorizer = TfidfVectorizer()
    X = vectorizer.fit_transform(sentences)
    
    # Calculate cosine similarity matrix
    similarity_matrix = cosine_similarity(X, X)
    
    # Calculate sentence importance scores
    sentence_scores = similarity_matrix.sum(axis=1)
    
    # Get indices of top-ranking sentences
    top_sentences_indices = sentence_scores.argsort()[-num_sentences:][::-1]
    
    # Generate summary
    summary = [sentences[i] for i in top_sentences_indices]
    return ' '.join(summary)

# Example text paragraph
text_paragraph = """
Keep working. Keep striving. Never give up. Fall down seven times, get up eight. Ease is a greater threat to progress than hardship. Ease is a greater threat to progress than hardship. So, keep moving, keep growing, keep learning. See you at work.
"""

# Generate summary
summary = generate_summary(text_paragraph)
print("Summary:")
print(summary)
