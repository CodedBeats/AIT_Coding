#  pseudocode 1

# This pseudocode is intended to describe computing the 
# price of an item on sale for 20% off
**Original**
<!-- start
   input origPrice
   set discount = price * 0.20
   set finalPrice = origPrice - discnt
   output finalPrice
stop -->
**Fixed**
start
   input origPrice
   set discount = price * 0.20
   set finalPrice = origPrice - discount
   output finalPrice
stop
|| (or)
start
   input origPrice
   set finalPrice = price * 0.80
   output finalPrice
stop

 
--------------------------------------------------------------------------
# pseudocode 2

# This pseudocode is intended to describe computing the 
# number of miles per gallon you get with your automobile.
**Original**
<!-- start
  input milesTraveled
  input gallonsOfGasUsed
  set milesPerGallon = milesTraveled + gallonsOfGasUsed
  output milesperGallon
start -->
**Fixed**
start
  input milesTraveled
  input gallonsOfGasUsed
  set milesPerGallon = milesTraveled / gallonsOfGasUsed
  output milesPerGallon
stop

 
--------------------------------------------------------------------------
# psuedocode 3

# This pseudocode is intended to describe computing the 
# per day cost of your rent in a 30-day month
**Original**
<!-- start
   input rent
   set costPerDay = rent / 31
   output rent
stop -->
**Fixed**
start
   input rent
   set costPerDay = rent / 30
   output costPerDay
stop