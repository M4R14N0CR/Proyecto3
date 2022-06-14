package controllers;

import java.util.ArrayList;
import helpers.IAppGaletyModel;
import models.AppGaleyModel;
import views.Grid;
import views.JpanelWithImage;

public class AppGaleryController {
	Grid appGrid;
	IAppGaletyModel appGaleryModel;
	
	public AppGaleryController() {
		
		appGaleryModel = new AppGaleyModel();
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
	
	
	
	
}