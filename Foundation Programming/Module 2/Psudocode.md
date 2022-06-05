**Psudocode Problem 1**

Write a psuedocode to represent the logic of a program that allows the user to enter values for a salesperson's base salary, total sales, and commission rate. The program computes and outputs the salesperson's pay by adding the base salary to the product of the total sales and commission rate
--------------------
START
    PROMPT operator for baseSalary, totalSales, commissionRate
    GET baseSalary, totalSales, commissionRate
    payValue = baseSalary + (totalSales * commissionRate)
    OUTPUT payValue
STOP


**Psudocode Problem 2**

Write psuedocode to represent the logic of a program that allows the user to enter a value for one edge of a cube. The program calculates the surface area of one side of the cube, the surface area of the cube, and its volume. The program outputs all the results.
--------------------
START
    PROMPT operator for edgeValue
    GET edgeValue
    sideSurfaceArea = edgeValue * edgeValue
    cubeSurfaceArea = sideSurfaceArea * 6
    cubeVolume = sideSurfaceArea * edgeValue
    OUTPUT sideSurfaceArea, cubeSurfaceArea, cubeVolume
STOP


**Psudocode Problem 2**
A. Write a pseudocode to represent the logic of a program that allows the user to enter values for width and length of a wall in feet. The program outputs the area of the wall in square feet

B. Modify A to allow the user to enter the price of a gallon of paint. Assume that gallon of paint covers 350 square feet of the wall. The program outputs the number of gallons needed and cost of the job.
--------------------
> A
START
    PROMPT operator for width, length
    GET width, length
    wallArea = width * length
    OUTPUT wallArea    
STOP

> B
START
    PROMPT operator for width, length, paintPrice
    GET width, length, paintPrice
    wallArea = width * length
    paintArea = 350
    paintGallonsRequired = wallArea / paintArea
    paintCost = paintGallonsRequired * paintPrice  
    OUTPUT paintGallonsRequired, paintCost
STOP
