import pandas as pd
from nltk.sentiment.vader import SentimentIntensityAnalyzer
from wordcloud import WordCloud
import matplotlib.pyplot as plt

# Load the dataset
df = pd.read_csv("movie_review.csv")

# Initialize SentimentIntensityAnalyzer
sid = SentimentIntensityAnalyzer()

# Calculate sentiment scores
df['Sentiment'] = df['review'].apply(lambda x: sid.polarity_scores(x)['compound'])

# Plot the distribution of sentiment scores
plt.hist(df['Sentiment'], bins=20, color='skyblue', edgecolor='black')
plt.title('Sentiment Analysis')
plt.xlabel('Sentiment Score')
plt.ylabel('Frequency')
plt.show()

# Create a wordcloud
wordcloud = WordCloud(width=800, height=400, background_color='white').generate(' '.join(df['review']))

# Plot the word cloud
plt.figure(figsize=(10, 6))
plt.imshow(wordcloud, interpolation='bilinear')
plt.axis('off')
plt.title('Word Cloud')
plt.show()
