package src.test.java;
import org.junit.Test;
import src.main.java.rulesEngine.*;
public class RulesDefinitionTest{
 @Test
 public void testRules(){
  RulesEngine test=new RulesEngine();
  Person testPerson=new Person(600,"Alaska");
  Product testProduct=new Product("7-11 Shell",5.0);
  test.runRules(testPerson,testProduct,"Florida",5.0,620,"7-11 Shell",0.3);
  }
 }
