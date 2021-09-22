package test.EE308_Lab2; 

import EE308_Lab2.EE308_Lab2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* EE308_Lab2 Tester. 
* 
* @author <Authors name> 
* @since <pre>9ÔÂ 22, 2021</pre> 
* @version 1.0 
*/ 
public class EE308_Lab2Test { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: InitKeyWordUtil(HashSet<String> keywords) 
* 
*/ 
@Test
public void testInitKeyWordUtil() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: IsWord(char c) 
* 
*/ 
@Test
public void testIsWord() throws Exception { 
//TODO: Test goes here...

    Assert.assertEquals(true,EE308_Lab2.IsWord('s'));
    Assert.assertEquals(false,EE308_Lab2.IsWord('+'));
} 

/** 
* 
* Method: WorkOnStack() 
* 
*/ 
@Test
public void testWorkOnStack() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: DeleteLineAnnotation(String str) 
* 
*/ 
@Test
public void testDeleteLineAnnotation() throws Exception { 
//TODO: Test goes here...
    Assert.assertEquals("   123rj210f321", EE308_Lab2.DeleteLineAnnotation
            ("   123rj210f321//w221d21d21r"));
} 

/** 
* 
* Method: DeleteBarAnnotation(String str) 
* 
*/ 
@Test
public void testDeleteBarAnnotation() throws Exception { 
//TODO: Test goes here...
    Assert.assertEquals("22f2f2f2f12f",EE308_Lab2.DeleteBarAnnotation
            ("22f2f2f2f/*21f212f*/12f"));
    Assert.assertEquals("22f2f2f2f",EE308_Lab2.DeleteBarAnnotation
            ("22f2f2f2f/*21f212f12f"));
} 

/** 
* 
* Method: DeleteInsideString(String str) 
* 
*/ 
@Test
public void testDeleteInsideString() throws Exception {
//TODO: Test goes here...
    Assert.assertEquals("22f2f2f2f12f",EE308_Lab2.DeleteInsideString
            ("22f2f2f2f12f\"222222\""));
} 

/** 
* 
* Method: HandleLine(String line, HashSet <String> keywords) 
* 
*/ 
@Test
public void testHandleLine() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here... 
} 


} 
