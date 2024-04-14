import pandas as pd
from mlxtend.preprocessing import TransactionEncoder
from mlxtend.frequent_patterns import apriori, association_rules

transactions = [['eggs','milk','bread'],
                ['eggs','apple'],
                ['mike','bread'],
                ['apple','mile'],
                ['milk','apple','bread']]

te = TransactionEncoder()

te_ary = te.fit(transactions).transform(transactions)

df = pd.DataFrame(te_ary, columns= te.columns_)

frequent_itemset = apriori(df, min_support=0.2, use_colnames=True)

rule= association_rules(frequent_itemset, metric="confidence", min_threshold=0.7)

print("\nFrequent Itemset:")
print(frequent_itemset)

print("\n Association Rules:")
print(rule)
