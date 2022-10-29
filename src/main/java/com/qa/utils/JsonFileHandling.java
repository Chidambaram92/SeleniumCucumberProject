package com.qa.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class JsonFileHandling {
    static JsonFileHandling fileObj = new JsonFileHandling();
  public static void main(String[] args) throws IOException, ParseException {
      fileObj.loadJsonMethod();
  }
  private void loadJsonMethod() throws IOException, ParseException {
      JSONParser parser = new JSONParser();
      FileReader reader = new FileReader(System.getProperty("user.dir")+ "/src/test/resources/properties/"
              + "VerifyData.json");
        Object obj= parser.parse(reader);
      JSONObject jsonObject= (JSONObject) obj;
      System.out.println(jsonObject.get("Name"));
      System.out.println(jsonObject.get("Author"));
      JSONArray companyList=(JSONArray) jsonObject.get("Company List");
      for(Object objOne:companyList){
          System.out.println(objOne);
      }
      JSONArray employeeList=(JSONArray) jsonObject.get("Employee List");
      for(Object objTwo:employeeList){
          System.out.println(objTwo);
      }
  }
}
