package proyecto3;

import java.util.ArrayList;

public class App{
public static void main(String[] args) throws Exception{
    
	ArrayList<String> features = new ArrayList<>(); 
	Features newFeature = new Features();
	
	newFeature.setFeatures("C:/Users/maria/OneDrive/Documentos/AdobeStock_293422760-kvsC--620x349@abc.jpg");
	
	features = newFeature.getFeatures();
	
	for(int i = 0; i<features.size();i++) {
		
		System.out.println(features.get(i));
	}
		
		
		
  }
}
