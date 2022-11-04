package com.bptn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"ImageMetaData\"")
public class ImageMetaData {
	
	@Id
	@Column(name = "\"imageID\"")
	private String imageID;
	
	@Column(name = "\"imageName\"")
	private String imageName;
	
	@Column(name = "\"imageSize\"")
	private String imageSize;
	
	@Column(name = "\"imageFormat\"")
	private String imageFormat;
	
	@Column(name = "\"imageDate\"")
	private String imageDate;
	
	@Column(name = "\"resolution\"")
	private String resolution;
	
	@Column(name = "\"postKey\"")
	private String postKey;
	
	
	public ImageMetaData() {
		
		super();
	}
	
	public ImageMetaData(String imageID, String imageName, String imageSize, String imageFormat, String imageDate, String resolution, String postKey) {
		
		super();
		
		this.imageID = imageID;
		this.imageName = imageName;
		this.imageSize = imageSize;
		this.imageFormat = imageFormat;
		this.imageDate = imageDate;
		this.resolution = resolution;
		this.postKey = postKey;
	}

	public String getImageID() {
		return this.imageID;
	}

	public void setImageID(String imageID) {
		this.imageID = imageID;
	}

	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageSize() {
		return this.imageSize;
	}

	public void setImageSize(String imageSize) {
		this.imageSize = imageSize;
	}

	public String getImageFormat() {
		return this.imageFormat;
	}

	public void setImageFormat(String imageFormat) {
		this.imageFormat = imageFormat;
	}

	public String getImageDate() {
		return this.imageDate;
	}

	public void setImageDate(String imageDate) {
		this.imageDate = imageDate;
	}

	public String getResolution() {
		return this.resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getPostKey() {
		return this.postKey;
	}

	public void setPostKey(String postKey) {
		this.postKey = postKey;
	}
		
}
