import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression

# Load data (replace 'path/to/your/data.csv' with the actual path to your data)
data = pd.read_csv('path/to/your/data.csv')

# Assuming 'Weight' is the target variable and other columns contain features
features = data.drop('Weight', axis=1)  # Select all columns except 'Weight'
target = data['Weight']

# Split data into training and testing sets (70% training, 30% testing)
X_train, X_test, y_train, y_test = train_test_split(features, target, test_size=0.3, random_state=42)

# Create the linear regression model
model = LinearRegression()

# Train the model on the training data
model.fit(X_train, y_train)

# Make predictions on the testing data
y_pred = model.predict(X_test)

# Evaluate model performance (optional)
# You can use metrics like R-squared or mean squared error to evaluate the model

# Print predictions (or use them for other purposes)
print("Predicted weights:", y_pred)
