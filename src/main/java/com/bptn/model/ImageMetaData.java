package com.bptn.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "\"ImageMetaData\"")
@NamedQuery(name="ImageMetaData.findAll", query="SELECT i FROM ImageMetaData i")
public class ImageMetaData implements Serializable {
	private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"imageID\"", nullable = false)
    private Long id;

    
    @Column(name = "\"imageName\"", nullable = false)
    private String imageName;

    
    @Column(name = "\"imageSize\"", nullable = false)
    private String imageSize;

    
    @Column(name = "\"imageFormat\"", nullable = false)
    private String imageFormat;

    
    @Column(name = "\"imageDate\"", nullable = false)
    private String imageDate;

    
    @Column(name = "resolution", nullable = false)
    private String resolution;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"postKey\"", nullable = false)
    @JsonBackReference
    private Post postKey;

    public Post getPostKey() {
        return postKey;
    }

    public void setPostKey(Post postKey) {
        this.postKey = postKey;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getImageDate() {
        return imageDate;
    }

    public void setImageDate(String imageDate) {
        this.imageDate = imageDate;
    }

    public String getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }

    public String getImageSize() {
        return imageSize;
    }

    public void setImageSize(String imageSize) {
        this.imageSize = imageSize;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

//package com.bptn.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "\"ImageMetaData\"")
//public class ImageMetaData {
//	
//	@Id
//	@Column(name = "\"imageID\"")
//	private String imageID;
//	
//	@Column(name = "\"imageName\"")
//	private String imageName;
//	
//	@Column(name = "\"imageSize\"")
//	private String imageSize;
//	
//	@Column(name = "\"imageFormat\"")
//	private String imageFormat;
//	
//	@Column(name = "\"imageDate\"")
//	private String imageDate;
//	
//	@Column(name = "\"resolution\"")
//	private String resolution;
//	
//	@Column(name = "\"postKey\"")
//	private String postKey;
//	
////	constructor
//	public ImageMetaData() {
//		
//		super();
//	}
////	constructor with parameters
//	public ImageMetaData(String imageID, String imageName, String imageSize, String imageFormat, String imageDate, String resolution, String postKey) {
//		
//		super();
//		
//		this.imageID = imageID;
//		this.imageName = imageName;
//		this.imageSize = imageSize;
//		this.imageFormat = imageFormat;
//		this.imageDate = imageDate;
//		this.resolution = resolution;
//		this.postKey = postKey;
//	}
//// imageID getter method
//	public String getImageID() {
//		return this.imageID;
//	}
////imageID setter method
//	public void setImageID(String imageID) {
//		this.imageID = imageID;
//	}
////imageName getter method
//	public String getImageName() {
//		return this.imageName;
//	}
////imageName setter method
//	public void setImageName(String imageName) {
//		this.imageName = imageName;
//	}
////imageSize getter method
//	public String getImageSize() {
//		return this.imageSize;
//	}
////imageSize setter method
//	public void setImageSize(String imageSize) {
//		this.imageSize = imageSize;
//	}
////imageFormat getter method
//	public String getImageFormat() {
//		return this.imageFormat;
//	}
////imageFormat setter method
//	public void setImageFormat(String imageFormat) {
//		this.imageFormat = imageFormat;
//	}
////imageDate getter method
//	public String getImageDate() {
//		return this.imageDate;
//	}
////imageDate setter method
//	public void setImageDate(String imageDate) {
//		this.imageDate = imageDate;
//	}
////resolution getter method
//	public String getResolution() {
//		return this.resolution;
//	}
////resolution setter method
//	public void setResolution(String resolution) {
//		this.resolution = resolution;
//	}
////postKey getter method
//	public String getPostKey() {
//		return this.postKey;
//	}
////postKey setter method
//	public void setPostKey(String postKey) {
//		this.postKey = postKey;
//	}
//		
//}
