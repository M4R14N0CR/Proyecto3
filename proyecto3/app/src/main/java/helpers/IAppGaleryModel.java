package helpers;



import java.util.ArrayList;

import views.JpanelWithImage;

public interface IAppGaleryModel {
	
	public void addImage(JpanelWithImage pImage);
	
	public void addResults(JpanelWithImage pImage);
	
	public ArrayList<JpanelWithImage> getImages();
	
	public ArrayList<JpanelWithImage> getResults();
	
	
	
}
