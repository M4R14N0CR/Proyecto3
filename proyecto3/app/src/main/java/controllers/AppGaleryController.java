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
	
	
	
	
}
