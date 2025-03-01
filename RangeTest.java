package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(-1, 1);
    }


    @Test
    public void testConstrain() {
        // Test Strategy: Equivalence Partitioning - Normal Value
        // Description: Tests the constrain method with a value within the range.
        // Input: value = 6.0 (within the range [5.0, 10.0])
        // Expected Output: 6.0
        Range range1 = new Range(5.0, 10.0);
        assertEquals("The value should just return itself", 6.0, range1.constrain(6.0), 1e-9);
    }

    @Test
    public void testConstrain_LessThanLowerBound() {
        // Test Strategy: Boundary Value Analysis - Below Lower Bound
        // Description: Tests the constrain method with a value less than the lower bound.
        // Input: value = 1.0 (less than the lower bound 5.0)
        // Expected Output: 5.0 (lower bound)
        Range range1 = new Range(5.0, 10.0);
        assertEquals("The value less than the lower bound should return the lower bound", 5.0, range1.constrain(1.0), 1e-9);
    }

    @Test
    public void testConstrain_GreaterThanUpperBound() {
        // Test Strategy: Boundary Value Analysis - Above Upper Bound
        // Description: Tests the constrain method with a value greater than the upper bound.
        // Input: value = 11.0 (greater than the upper bound 10.0)
        // Expected Output: 10.0 (upper bound)
        Range range1 = new Range(5.0, 10.0);
        assertEquals("The value greater than the upper bound should return the upper bound", 10.0, range1.constrain(11.0), 1e-9);
    }

    @Test
    public void testContains_WithinRange() {
        // Test Strategy: Equivalence Partitioning - Value Within Range
        // Description: Tests the contains method with a value within the range.
        // Input: value = 6.0 (within the range [5.0, 10.0])
        // Expected Output: true
        Range range1 = new Range(5.0, 10.0);
        assertTrue("Should return true because value is within range", range1.contains(6.0));
    }
    @Test
    public void testContains_AtLowerBoundary() {
        // Test Strategy: Equivalence Partitioning - Value Within Range
        // Description: Tests the contains method with a value within the range.
        // Input: value = 5.0 (within the range [5.0, 10.0])
        // Expected Output: true
        Range range1 = new Range(5.0, 10.0);
        assertTrue("Should return true because value is within range", range1.contains(5.0));
    }
    @Test
    public void testContains_AtUpperBoundary() {
        // Test Strategy: Equivalence Partitioning - Value Within Range
        // Description: Tests the contains method with a value within the range.
        // Input: value = 10.0 (within the range [5.0, 10.0])
        // Expected Output: true
        Range range1 = new Range(5.0, 10.0);
        assertTrue("Should return true because value is within range", range1.contains(10.0));
    }

    @Test
    public void testContains_OutsideRange() {
        // Test Strategy: Equivalence Partitioning - Value Outside Range
        // Description: Tests the contains method with a value outside the range.
        // Input: value = 11.0 (outside the range [5.0, 10.0])
        // Expected Output: false
        Range range1 = new Range(5.0, 10.0);
        assertFalse("Should return false because value is outside range", range1.contains(11.0));
    }

    @Test
    public void testEquals_EquivalentRanges() {
        // Test Strategy: Equivalence Partitioning - Equivalent Ranges
        // Description: Tests the equals method with two equivalent ranges.
        // Input: range1 = [1.0, 3.0], range2 = [1.0, 3.0]
        // Expected Output: true
        Range range1 = new Range(1.0, 3.0);
        Range range2 = new Range(1.0, 3.0);
        assertTrue("The ranges are equal and should return true", range1.equals(range2));
    }

    @Test
    public void testEquals_NonEquivalentRanges() {
        // Test Strategy: Equivalence Partitioning - Non-Equivalent Ranges
        // Description: Tests the equals method with two non-equivalent ranges.
        // Input: range1 = [1.0, 3.0], range2 = [2.0, 3.0]
        // Expected Output: false
        Range range1 = new Range(1.0, 3.0);
        Range range2 = new Range(2.0, 3.0);
        assertFalse("The ranges are not equal and should return false", range1.equals(range2));
    }

    
    @Test
    public void testGetLowerBound() {
        // Test Strategy: Equivalence Partitioning - Valid Range
        // Description: Tests the getLowerBound method to ensure it returns the correct lower bound of the range.
        // Input: range = [1.0, 5.0]
        // Expected Output: 1.0 (the lower bound of the range)
    	Range range1=new Range(1.0,5.0);
    	
    	assertEquals("The lowerbound should be 1.0",1,range1.getLowerBound(),.000000001d);
    
    }

    @Test
    public void testExpandToInclude() {
        // Test Strategy: Equivalence Partitioning - Value Outside Range
        // Description: Tests the expandToInclude method with a value outside the range.
        // Input: range = [2.0, 6.0], value = 8.0
        // Expected Output: Expanded range includes 8.0
        Range range1 = new Range(2.0, 6.0);
        Range expandedRange = Range.expandToInclude(range1, 8.0);
        assertTrue("The range does not contain the included value", expandedRange.contains(8.0));
    }

    @Test
    public void testGetLength() {
        // Test Strategy: Equivalence Partitioning - Valid Range
        // Description: Tests the getLength method with a valid range.
        // Input: range = [1.0, 5.0]
        // Expected Output: Length = 4.0
        Range range1 = new Range(1.0, 5.0);
        assertEquals("The length of the range should be 4", 4, range1.getLength(), .000000001d);
    }
 
    
    
    
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
