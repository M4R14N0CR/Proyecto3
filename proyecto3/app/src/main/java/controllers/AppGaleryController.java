package controllers;

import java.util.ArrayList;

import helpers.IAppGaleryModel;
import models.AppGaleryModel;
import views.Grid;
import views.JpanelWithImage;

public class AppGaleryController {
	Grid appGrid;
	IAppGaleryModel appGaleryModel;
	
	public AppGaleryController() {
		
		appGaleryModel = new AppGaleryModel();
		
		
	}
	
	public void setGrid(Grid pAppGrid) {
		
		this.appGrid = pAppGrid;
	}
	
	public void addImage(JpanelWithImage pImage) {
		
		this.appGaleryModel.addImage(pImage);
	}
	
	public void addResults(JpanelWithImage pImage) {
		
		this.appGaleryModel.addResults(pImage);
	}
	
	public ArrayList<JpanelWithImage> getImages() {
		
		return this.appGaleryModel.getImages();
	}
	
	public ArrayList<JpanelWithImage> getResults() {
		
		return this.appGaleryModel.getResults();
	}
	
	public void deleteImage(String pDirection) {
		for(int i = 0; i<this.appGaleryModel.getImages().size();i++) {
    		if(pDirection.equals(this.appGaleryModel.getImages().get(i).Ubicacion)) {
    			this.appGaleryModel.getImages().remove(i);
    		}
		}
	}
	
	public void deleteResults() {
		this.appGaleryModel.getResults().clear();
	}

}
