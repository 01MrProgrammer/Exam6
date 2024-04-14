import pandas as pd

# Read the dataset
df = pd.read_csv("INvideos.csv")

# Data cleaning operations
# Remove duplicate rows
df.drop_duplicates(inplace=True)

# Handle missing or null values
# Here, we'll simply drop rows with missing values for simplicity
df.dropna(inplace=True)

# Convert relevant columns to appropriate data types
# Convert views, likes, dislikes, and comment_count columns to numeric type
numeric_columns = ['views', 'likes', 'dislikes', 'comment_count']
df[numeric_columns] = df[numeric_columns].apply(pd.to_numeric, errors='coerce')

# Calculate total views, total likes, total dislikes, and total comment count
total_views = df['views'].sum()
total_likes = df['likes'].sum()
total_dislikes = df['dislikes'].sum()
total_comment_count = df['comment_count'].sum()

# Print the results
print("Total Views:", total_views)
print("Total Likes:", total_likes)
print("Total Dislikes:", total_dislikes)
print("Total Comment Count:", total_comment_count)
