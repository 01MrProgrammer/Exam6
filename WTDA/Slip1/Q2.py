import pandas as pd
dataset = pd.read_csv('Salary_Data.csv')
dataset.head()

X = dataset.iloc[:, :-1].values  # Independent variable array
y = dataset.iloc[:, 1].values    # Dependent variable vector

from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=0)

from sklearn.linear_model import LinearRegression
regressor = LinearRegression()
regressor.fit(X_train, y_train)

y_pred = regressor.predict(X_test)

