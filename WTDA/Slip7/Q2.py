import pandas as pd
from mlxtend.preprocessing import TransactionEncoder
from mlxtend.frequent_patterns import apriori, association_rules

# Step 1: Read the dataset
# Assuming the dataset is named 'market_basket.csv' and is in the current directory
df = pd.read_csv('market_basket.csv')

# Step 2: Display information about the dataset
print("Information about the dataset:")
print(df.info())

# Step 3: Preprocess the data
# Drop null values if any
df.dropna(inplace=True)

# Step 4: Convert categorical values into numeric format
# Convert the dataset into a list of lists format
transactions = df.values.tolist()

# Use TransactionEncoder to convert categorical values into a numeric format
te = TransactionEncoder()
te_ary = te.fit(transactions).transform(transactions)
df_transformed = pd.DataFrame(te_ary, columns=te.columns_)

# Step 5: Apply Apriori algorithm
# Set minimum support threshold
min_support = 0.05  # Adjust as needed
frequent_itemsets = apriori(df_transformed, min_support=min_support, use_colnames=True)

# Step 6: Generate association rules
association_rules_df = association_rules(frequent_itemsets, metric="confidence", min_threshold=0.7)

# Print the frequent itemsets and association rules
print("\nFrequent Itemsets:")
print(frequent_itemsets)
print("\nAssociation Rules:")
print(association_rules_df)
