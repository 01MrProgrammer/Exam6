import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression

# Creating the Salary dataset
years_of_experience = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]).reshape(-1, 1)
salaries = np.array([45000, 50000, 60000, 80000, 110000, 150000, 200000, 300000, 500000, 1000000])

# Identifying independent and target variables
X = years_of_experience
y = salaries

# Splitting the dataset into training and testing sets (80% training, 20% testing)
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Print the training and testing sets
print("Training set (X_train):")
print(X_train)
print("Training set (y_train):")
print(y_train)
print("\nTesting set (X_test):")
print(X_test)
print("Testing set (y_test):")
print(y_test)

# Building a simple linear regression model
model = LinearRegression()
model.fit(X_train, y_train)

# Print the coefficients
print("\nIntercept:", model.intercept_)
print("Coefficient (slope):", model.coef_)

