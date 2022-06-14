package models;

import java.util.ArrayList;

import helpers.IAppGaleryModel;
import views.JpanelWithImage;

public class AppGaleryModel implements IAppGaleryModel {

	private  ArrayList<JpanelWithImage> images = new ArrayList<>();
    private  ArrayList<JpanelWithImage> searchResults = new ArrayList<>();
    
    
    
    @Override
	public void addImage(JpanelWithImage pImage) {
		this.images.add(pImage);
		
	}

	@Override
	public void addResults(JpanelWithImage pImage) {
		this.searchResults.add(pImage);
		
	}
	
	@Override 
	public ArrayList<JpanelWithImage> getImages() {
		
		return this.images;
	}
	
	@Override
	public ArrayList<JpanelWithImage> getResults() {
		return this.searchResults;
	}
	

	
}
