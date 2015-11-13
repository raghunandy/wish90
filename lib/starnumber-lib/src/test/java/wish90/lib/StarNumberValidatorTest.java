/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wish90.lib;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Siva Kiran
 */
public class StarNumberValidatorTest {
    
    public StarNumberValidatorTest() {
    }
    long[] testNumbers={2345,90393,1234,45563,7777,8888};
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   
    /**
     * Test of isStarNumber method, of class StarNumberValidator.
     */
    @org.junit.Test
    public void testIsStarNumber1234() {
        System.out.println("testIsStarNumber1234");
        for (long testNumber : testNumbers) {
             boolean result = StarNumberValidator.isStarNumber(testNumber);
             System.out.println(testNumber +" = "+result);
        }
   
    }
}
