import pandas as pd
import nltk
from nltk.sentiment.vader import SentimentIntensityAnalyzer

# Read the dataset
url = "https://www.kaggle.com/datasets/seungguini/youtube-comments-for-covid19-related-videos?select=covid_2021_1.csv"
df = pd.read_csv(url)

# Data cleaning (handle missing values, remove duplicates, etc.)
# Example: df.drop_duplicates(inplace=True)

# Tokenize comments
nltk.download("punkt")
df["tokenized_comments"] = df["comment"].apply(nltk.word_tokenize)

# Perform sentiment analysis
sia = SentimentIntensityAnalyzer()
df["sentiment_scores"] = df["comment"].apply(lambda x: sia.polarity_scores(x))
df["sentiment"] = df["sentiment_scores"].apply(lambda x: "positive" if x["compound"] > 0 else ("negative" if x["compound"] < 0 else "neutral"))

# Calculate percentages
total_comments = len(df)
positive_comments = len(df[df["sentiment"] == "positive"])
negative_comments = len(df[df["sentiment"] == "negative"])
neutral_comments = len(df[df["sentiment"] == "neutral"])

positive_percentage = (positive_comments / total_comments) * 100
negative_percentage = (negative_comments / total_comments) * 100
neutral_percentage = (neutral_comments / total_comments) * 100

print(f"Positive comments: {positive_percentage:.2f}%")
print(f"Negative comments: {negative_percentage:.2f}%")
print(f"Neutral comments: {neutral_percentage:.2f}%")
