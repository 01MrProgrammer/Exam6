from mlxtend.preprocessing import TransactionEncoder
from mlxtend.frequent_patterns import apriori, association_rules
import pandas as pd

# Create the dataset
dataset = [
    ['eggs', 'milk', 'bread'],
    ['eggs', 'apple'],
    ['milk', 'bread'],
    ['apple', 'milk'],
    ['milk', 'apple', 'bread']
]

# Convert categorical values into numeric format
te = TransactionEncoder()
te_ary = te.fit(dataset).transform(dataset)
df = pd.DataFrame(te_ary, columns=te.columns_)

# Apply Apriori algorithm with different min_sup values
min_sup_values = [0.2, 0.3, 0.4]

for min_sup in min_sup_values:
    print(f"\nFrequent Itemsets with min_sup = {min_sup}:")
    frequent_itemsets = apriori(df, min_support=min_sup, use_colnames=True)
    print(frequent_itemsets)

    print(f"\nAssociation Rules with min_sup = {min_sup}:")
    rules = association_rules(frequent_itemsets, metric="confidence", min_threshold=0.7)
    print(rules)
