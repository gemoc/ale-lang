package lang;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class DslContent {
	List<String> allSyntaxes;
	List<String> allSemantics;
	
	public DslContent(String dslFile) {
		
		Properties dslProp = new Properties();
		try {
			FileInputStream in = new FileInputStream(dslFile);
			dslProp.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String allSyntaxes = (String) dslProp.get("syntax");
		String allBehaviors = (String) dslProp.get("behavior");
		
		String[] syntaxes = allSyntaxes.split(",");
		String[] behaviors = allBehaviors.split(",");
		
		this.allSyntaxes = Arrays.asList(syntaxes);
		this.allSemantics = Arrays.asList(behaviors);
		
	}
	
	public List<String> getAllSemantics() {
		return allSemantics;
	}
	
	public List<String> getAllSyntaxes() {
		return allSyntaxes;
	}
}
