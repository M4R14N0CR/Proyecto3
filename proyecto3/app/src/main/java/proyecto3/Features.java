package proyecto3;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Features {
  
	private ArrayList<String> features = new ArrayList<>();
  
  
  
	public void  setFeatures(String pImgageDirection) throws Exception{
    
    
		ArrayList<String> auxFeatures = new ArrayList<>(); 
      
		try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {

			// The path to the image file to annotate
			String fileName = pImgageDirection;
			//POR AQUI
			
        // Reads the image file into memory
        Path path = Paths.get(fileName);
        byte[] data = Files.readAllBytes(path);
        ByteString imgBytes = ByteString.copyFrom(data);

        // Builds the image annotation request
        List<AnnotateImageRequest> requests = new ArrayList<>();
        Image img = Image.newBuilder().setContent(imgBytes).build();
        Feature feat = Feature.newBuilder().setType(Type.LABEL_DETECTION).build();
        AnnotateImageRequest request =
            AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);

        // Performs label detection on the image file
        BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
        List<AnnotateImageResponse> responses = response.getResponsesList();

        for (AnnotateImageResponse res : responses) {
          if (res.hasError()) {
            System.out.format("Error: %s%n", res.getError().getMessage());
            return;
          }

          for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
            annotation
                .getAllFields()
                .forEach((k, v) -> auxFeatures.add(v.toString()));
          }
        }
        
      }
      for(int i = 0; i<auxFeatures.size();i++) {
        
        if(auxFeatures.get(i).charAt(0) == '/' || auxFeatures.get(i).charAt(0) == '0') {
          continue;
        }
        else {
          this.features.add(auxFeatures.get(i));
        }
      }
      
    }
  
  public ArrayList<String> getFeatures(){
    
    return this.features;
  }
  
}