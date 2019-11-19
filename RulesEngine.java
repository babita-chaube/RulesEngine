package src.main.java.rulesEngine;
import java.util.*;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RulesEngine{
@SupressWarnings("unchecked")

public void runRules(Person person,Product product,String stateDisqualifed,double minInterestRate,int minCreditScore,String qualifiedProduct,double productRateAdjust){
product.interest_rate=minInterestRate;
product.disqualified=false;
//Check if state is Florida
if(person.state.equals(stateDisqualifed)){
  product.disqualified=true;
                                    }
          //if product name is "7-1 ARM" 0.5 will be added
 if(product.name.equals(qualifiedProduct)){
 product.interest_rate=product.interest_rate+productRateAdjust;
                                          }
      //if credit score is greater than equal to minimum credit score,interest rate will be adjusted.
 if(person.credit_score >= minCreditScore){
     product.interest_rate=product.interest_rate-0.3;
            }else{
      product.interest_rate=product.interest_rate+0.5;
            }
                                    
                                    }
public static void main(String[] args){
Person person=new Person(720,"Florida");
Product product=new Product("7-1 ARM",5.0);
RulesEngine rulesEngine=new RulesEngine(); 
JSONParser jsonParser =new JSONParser();
try{
FileReader reader =new FileReader("rules.json");
//Read JSON file
Object obj =jsonParser.parse(reader);
JSONObject jsonObject=(JSONObject)obj;
String stateDisqualified=(String)jsonObject.get("stateDisqualified");
String minCreditScore = (String)jsonObject.get("minCreditScore");
String minInterestRate=(String)jsonObject.get("minInterestRate");
String interestRateAdjustment=(String)jsonObject.get("interestRateAdjustment");
String qualifiedProductName=(String)jsonObject.get("qualifiedProductName");
String productNameRateAdjustment=(String)jsonObject.get("productNameRateAdjustment");
int creditScore=Integer.parseInt(minCreditScore);
double minInterest=Double.parseDouble(minInterestRate);
double productRate=Double.parseDouble(productNameRateAdjustment);
rulesEngine.runRules(person,product,stateDisqualified,minInterest,creditScore,qualifiedProductName,productRate);


}catch(FileNotFoundException e){
e.printStackTrace();
}catch(IOException e){
e.printStackTrace();
}catch(ParseException e){
e.printStackTrace();
}

}
