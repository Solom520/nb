package test.cn.edu.whut.sept.zuul;

import cn.edu.whut.sept.zuul.Main;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/** 
* Login Tester. 
* 
* @author <Authors name> 
* @since <pre>7ÔÂ 8, 2021</pre> 
* @version 1.0 
*/ 
public class LoginTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: setAdmin(Admin admin) 
* 
*/ 
@Test
public void testSetAdmin() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: login(Admin admin) 
* 
*/ 
@Test
public void testLogin() throws Exception { 
//TODO: Test goes here...
    String inputCommand="1\nhzj\n123\nno\n";
    String expectOutput="Do you want to go on?[yes/no]\r";
    System.setIn(new ByteArrayInputStream(inputCommand.getBytes()));
    ByteArrayOutputStream outContent=new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    Main.main(null);

    String[] outputs = outContent.toString().split("\n");
    int outputLength=outputs.length;
    String actual=outputs[outputLength-2];
    Assert.assertEquals(actual,expectOutput);
} 

/** 
* 
* Method: JudgeAdmin() 
* 
*/ 
@Test
public void testJudgeAdmin() throws Exception { 
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
