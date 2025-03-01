**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:  2    |     |
| -------------- | --- |
| Student Names: |     |
| Qasim Amar               |     |
| Said Rahmani|     |
| Ahmed Abdullah   |     |
| Muhammad Bilal   |     |

# 1 Introduction

This test design will cover 5 methods from org.jfree.data.Range and 5 methods from org.jfree.data.DataUtilities. The 5 methods from the range class are: Constrain, Contains, Equals, getLowerBound and getLength and the 5 methods from DataUtilities are calculateColumnTotal, calculateRowTotal, createNumberArray, createNumberArray2D and 	getCumulativePercentages. The test will make sure that the methods in the Range and DataUtilities class behave as expected and according to its requirements. The testing will focus on black-box testing techniques, such as equivalence partitioning and boundary value analysis. 
# 2 Detailed description of unit test strategy

Our unit testing strategy is defined using black-box testing principles that focus on testing the software functionality against its specifications and requirements and not the implementation inside. Since we are just given the method requirements, the most appropriate strategy to adopt is black-box testing. The strategy guarantees the methods satisfy the required output for all valid inputs, boundary cases, and edge cases.

Equivalence Partitioning:
The input domain of every method is divided into equivalence classes with each equivalence class being a group of inputs which must produce the same output. For example, in the case of the constrain method in Range class, the input domain is divided into three equivalence classes: values within the range, values less than the lower bound, and values more than the upper bound. Each equivalence class is also tested with at least one representative input to ensure that the method behaves properly for that class.

Boundary:
Boundary values are specific inputs on the edges of the input range. For example, for the contains method, boundary values are the lower bound (5.0) and the upper bound (10.0). Testing boundary values ensures that the method works as expected for edge cases, i.e., values precisely on the lower or upper bounds.

Test Cases:
Test cases are designed to cover all equivalence classes and boundary values. Each test case includes:
  - Input: A specific value or object to be passed to the method.
  - Expected Output: The expected result based on the requirements.
  - Actual Output: The result produced by the method during testing and pass/fail.


# 3 Test cases developed

## Methods to be tested for Range:
1. constrain(double value)
2. contains(double value)
3. equals(Object obj)
4. getLowerBound(Range range)
5. getLength()

## Test Cases Range:
### **Method: `constrain(double value)`**
**Purpose:**  
Returns the value within the range that is closest to the specified value.

**Input Domain:**  
Real numbers.

**Equivalence Classes:**  
- Value within the range (`5.0 <= value <= 10.0`).
- Value less than the lower bound (`value < 5.0`).
- Value greater than the upper bound (`value > 10.0`).

**Boundary Values:**  
- Lower bound (`5.0`).
- Upper bound (`10.0`).

**Test Cases:**
- Value within range: 6.0.  Expected: 6.0. Actual: Test Passes
- Value less than lower bound: 1.0 . Expected: 5.0. Actual: Test Fails, return 7.5 instead of 5.0
- Value greater than upper bound: 11.0. Expected: 10.0. Actual: Test Passes

### **Method: `contains(double value)`**
**Purpose:**  
Returns true if the specified value is within the range and false otherwise.

**Input Domain:**  
Real numbers.

**Equivalence Classes:**  
- Value within the range (5.0 <= value <= 10.0).
- Value less than the lower bound (value < 5.0).
- Value greater than the upper bound (value > 10.0).

**Boundary Values:**  
- Lower bound (`5.0`).
- Upper bound (`10.0`).

**Test Cases:**
- Value within range: 6.0.  Expected: True. Actual: Test Passes
- Value outside range: 11.0. Expected False. Actual: Test Passes
- Value on lower boundary value = 5.0. Expected: True. Actual: Test Passes
- Value on upper boundary value = 10.0. Expected: True. Actual: Test Passes

### **Method: `equals(Object obj)`**
**Purpose:**  
Tests this object for equality with an arbitrary object.

**Input Domain:**  
Range object

**Equivalence Classes:**  
- Equivalent ranges (same lower and upper bounds).
- Non-equivalent ranges (different lower or upper bounds).

**Test Cases:**
- Equivalent ranges: Range(1.0, 3.0) and Range(1.0, 3.0). Expected: True. Actual: Test Passes
- Non-equivalent ranges: Range(1.0, 3.0) and Range(2.0, 3.0). Expected: False. Actual: Test Passes

### **Method: `getLowerBound(Range range)`**
**Purpose:**  
Creates a new range by adding margins to an existing range.

**Input Domain:**  
- Range: A valid Range object.

**Equivalence Classes:**  
- Valid margins

**Test Cases:**
- Range(1.0, 5.0).Expected :1.0 Actual: Test Passes

### **Method: `getLength()`**
**Purpose:**  
Returns the length of the range

**Input Domain:**  
A Range object

**Equivalence Classes:**  
- Range with positive length.

**Test Cases:**
- Valid range: Range(1.0, 5.0) .Expected: 4.0. Actual: Test Passes

## Methods to be tested for DataUtilities:
1. calculateColumnTotal(Values2D data, int column)
2. calculateRowTotal(Values2D data, int row)
3. createNumberArray(double[] data)
4. createNumberArray2D(double[][] data)
5. getCumulativePercentages(KeyedValues data)

## Test Cases DataUtilities:
### **Method: `calculateColumnTotal(Values2D data, int column)`**
**Purpose:**  
Compute the total of values in a specified column of a Value2D Object.

**Input Domain:**  
A valid column index and Value2D object

**Equivalence Classes:**  
- Column with numeric values 
- Column index within bounds
- Column index null

**Boundary Values:**  
- First Column index 0 
- Last column index = columnCount -1
  
**Test Cases:**
- Column with two values (7.5, 2.5) Expected: 10 Test Passed
- Empty Column or Zero rows, Expected 0 Test Passed

### **Method: `calculateRowTotal (Values2D data, int row)`**
**Purpose:**  
Computes the total of all values in a specified row of a Values2D Object

**Input Domain:**  
- A Valid Value 2D object
- A valid row index

**Equivalence Classes:**  
- Row index with null 
- Row with numeric values 
- Row index within bounds

**Boundary Values:**  
- First Row index 0
- Last Row index = rowCount -1

**Test Cases:**
- Row with two values 8.5, 1.5 Expected :10 Test Failed
- Empty row or zero rows, Expected 0 Test Passed

### **Method: `createNumberArray(double[] data)`**
**Purpose:**  
Converts a double[] array into a number[] array.

**Input Domain:**  
- A valid double[] array

**Equivalence Classes:**  
- Array with Multiple values
- Array with one value
- Array with no values

**Test Cases:**
- Double[] Array with values {10, 20, 30} Expected : {10, 20, 30} Test Failed
- Double[] Array with values {10} Expected : {10} Test Failed
- Double[] Array with no value {} Expected {} Test Failed

### **Method: `createNumberArray2D(double[][] data)`**
**Purpose:**  
Converts a double[][] array into a Number[][] array

**Input Domain:**  
- A valid double[][] array

**Equivalence Classes:**  
- 2D array with no arrays 
- 2D array with two arrays

**Test Cases:**
- 2D Array with values {10,20} {11,22} , Expected {10,20} {11,22} Test Failed
- 2D Array with values {}{} Expected {}{} Test Failed

### **Method: ` getCumulativePercentages(KeyedValues data)`**
**Purpose:**  
Computes the cumulative percentage values for the data.

**Input Domain:**  
- A valid KeyedValue instance.

**Equivalence Classes:**  
- KeyedValue instance with valid integers values.
- KeyedValue instance with null values.

**Test Cases:**
- KeyedValue instance with values {0,5}, {1, 9}, {2,2} , Expected {0, 0.313}, {1, 0.875 }, {2, 1.0} Test Failed

# 4 How the team work/effort was divided and managed

We divided the work into pairs where one pair worked on the Range and DataUtilities class respectively. Each pair came up with a test plan and then looked over each other to give feedback and add before coding the tests. Upon completion of the test plan, each pair coded the tests and used pair programming in order to implement successfully. Once completed each pair reviewed the others test code and finalized the tests.

# 5 Difficulties encountered, challenges overcome, and lessons learned

Upon starting the lab we had challenges setting up eclipse and making sure we followed the instructions. Furthermore when writing the test code, using jMock was somewhat challenging due to not using it before, but upon looking into it we figured it out. This lab allowed us to learn more about implementing JUnit tests based on method specifications. We were able to learn how to come up with effective test plans and take advantage of black box testing.

# 6 Comments/feedback on the lab itself

If the lab gave us some instructions on how to download and setup Eclipse, that would have helped a lot.
