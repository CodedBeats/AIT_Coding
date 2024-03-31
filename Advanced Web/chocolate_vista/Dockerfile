# Use an official Node runtime as the base image
FROM node:14-alpine

# Set the working directory in the container
WORKDIR /app

# Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Install project dependencies
RUN npm install

# Copy the entire project directory into the container
COPY . .

# Build your React app
RUN npm run build

# Expose the port your app runs on
EXPOSE 3000

# Set the command to run your app
CMD ["npm", "start"]
