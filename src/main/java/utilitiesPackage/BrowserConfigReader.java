package utilitiesPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BrowserConfigReader {
	
	private Properties properties;
	
	private String PATH = "/Users/arkobiswas/Developer/eclipse-workspace/Amazon_Login_Automation/src/test/resources/browserConfigPackage/browserConfig.properties";
	
	public Properties InitialiseProperties() {
		
		properties = new Properties();
		
		try {
			
			FileInputStream input = new FileInputStream(PATH);
			
			properties.load(input);
			
		}catch(FileNotFoundException e) {
			
			System.out.println("!!! File not found to initialise Web Driver Properties");
			e.printStackTrace();
			
		}catch(IOException e) {
			
			System.out.println("!!! I/O exception");
			e.printStackTrace();
			
		}
		
		return properties;
		
	}
	

}
