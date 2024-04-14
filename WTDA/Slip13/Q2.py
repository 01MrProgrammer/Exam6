import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error

# Step 1: Download the nursery dataset from UCI (https://archive.ics.uci.edu/ml/datasets/Nursery)
# Step 2: Load the dataset into a pandas DataFrame
# Assuming the dataset is named 'nursery_data.csv' and is in the current directory
df = pd.read_csv('nursery_data.csv')

# Step 3: Preprocess the dataset (if necessary)
# (Depending on the dataset, you may need to handle missing values, encode categorical variables, etc.)

# Step 4: Identify the independent variables (features) and the target variable
# Let's assume we want to predict 'purchases'
X = df.drop('purchases', axis=1)  # Independent variables
y = df['purchases']  # Target variable

# Step 5: Split the dataset into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Print the shape of training and testing sets
print("Training set - Features shape:", X_train.shape)
print("Training set - Target shape:", y_train.shape)
print("Testing set - Features shape:", X_test.shape)
print("Testing set - Target shape:", y_test.shape)

# Step 6: Build a simple linear regression model
model = LinearRegression()
model.fit(X_train, y_train)

# Step 7: Evaluate the model
# Predict purchases on the testing set
y_pred = model.predict(X_test)

# Calculate Mean Squared Error (MSE)
mse = mean_squared_error(y_test, y_pred)
print("Mean Squared Error (MSE):", mse)
