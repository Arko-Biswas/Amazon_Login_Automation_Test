package utilitiesPackage;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {
	
	public void example() throws IOException, ParseException {
		
		JSONParser JSONParser_obj = new JSONParser();
		
		FileReader FileReader_obj = new FileReader("/Users/arkobiswas/Developer/eclipse-workspace/Amazon_Login_Automation/src/test/resources/testData.json");
		
		Object obj = JSONParser_obj.parse(FileReader_obj); //this obj is a JAVA object
		
		// we need to convert this JAVA object into JSON object and only then would you be able to read from the json file
		
		JSONObject jsonObject = (JSONObject)obj; // typecasting done here
		
		String FirstName = (String)jsonObject.get("firstName"); // typecasting done here
		
		String LastName = (String)jsonObject.get("lastName"); // typecasting done here
		
		System.out.println(">>> First Name: "+ FirstName);
		
		System.out.println(">>> First Name: "+ LastName);
		
		//to input from json array, we need to put the values in the array of the json file into a jsonarray object
		
		JSONArray jsonArray = (JSONArray)jsonObject.get("address");

		System.out.println(">>> Array: "+ jsonArray);
		
		// lets iterate through the array
		
		for(int i = 0; i < jsonArray.size(); i++) {
			
			System.out.println("Address " + i + ":");
			
			JSONObject address = (JSONObject)jsonArray.get(i);
			String city = (String)address.get("city");
			String street = (String)address.get("street");
			
			System.out.println("City: " + city);
			System.out.println("Street: " + street);
		}
		
	}
	
	String getUserName = "";
	String getPassword = "";
	
	public String read_UserName_fromJSON(String Name) throws IOException, ParseException {
		
		
		JSONParser JSONParser_obj = new JSONParser();
		FileReader FileReader_obj = new FileReader("/Users/arkobiswas/Developer/eclipse-workspace/Amazon_Login_Automation/src/test/resources/testData.json");
		Object obj = JSONParser_obj.parse(FileReader_obj);
		
		JSONObject jsonObject = (JSONObject)obj;
		JSONArray jsonArray = (JSONArray)jsonObject.get("loginTest");
		
		for(int i = 0; i < jsonArray.size(); i++) {
			
			JSONObject loginTest = (JSONObject)jsonArray.get(i);
			String nameFromJSON = (String)loginTest.get("name");
			
			if(nameFromJSON.equalsIgnoreCase(Name)) {
				getUserName = (String)loginTest.get("username");
			}
			
		}
		
		return getUserName;
		
	}
	
	public String read_Password_fromJSON(String Name) throws IOException, ParseException {
		
		
		JSONParser JSONParser_obj = new JSONParser();
		FileReader FileReader_obj = new FileReader("/Users/arkobiswas/Developer/eclipse-workspace/Amazon_Login_Automation/src/test/resources/testData.json");
		Object obj = JSONParser_obj.parse(FileReader_obj);
		
		JSONObject jsonObject = (JSONObject)obj;
		JSONArray jsonArray = (JSONArray)jsonObject.get("loginTest");
		
		for(int i = 0; i < jsonArray.size(); i++) {
			
			JSONObject loginTest = (JSONObject)jsonArray.get(i);
			String nameFromJSON = (String)loginTest.get("name");
			
			if(nameFromJSON.equalsIgnoreCase(Name)) {
				getPassword = (String)loginTest.get("password");
			}
			
		}
		
		return getPassword;
		
	}

}
