package com.bptn.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.exceptions.InvalidImageMetaDataException;
import com.bptn.model.ImageMetaData;
import com.bptn.repository.FeedImageMetaDataRepository;

@Service
public class FeedMediaService {
	
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FeedImageMetaDataRepository feedImageMetaDataRepository;
	
	public List<ImageMetaData> getImageMediaByPostKey(String postkeyCred) throws InvalidImageMetaDataException {
		
		LOGGER.info("retreiving ImageMedia from DB by postKey");
		
		List<ImageMetaData> media = feedImageMetaDataRepository.findByPostKey(postkeyCred);
		
		if (media == null) {
			
			throw new InvalidImageMetaDataException("Post Key does not exists");
		}
		
		media = removeEmptyImages(media);
		
		LOGGER.debug("FeedImageMetaService = {}", media);
		
		return media;	
	}
	
	public ImageMetaData getPostsImageMediaByImageId(String imageIDCred) throws InvalidImageMetaDataException {
		
		LOGGER.info("retreiving Image information from DB by imageID");
		
		ImageMetaData image = feedImageMetaDataRepository.findByImageID(imageIDCred);
		
		if (image == null) {
			
			throw new InvalidImageMetaDataException("Image ID does not exists");
		}
		
		LOGGER.debug("FeedImageMetaDataService = {}", image);
		
		return image;
	}
	
	public ImageMetaData createNewImage(ImageMetaData imageinfo) {
		
			
			Optional<ImageMetaData> image = feedImageMetaDataRepository.findById(imageinfo.getImageID());
			
			if (image.isPresent()) {
				ImageMetaData imageNew = image.get();
				
				imageNew.setImageID(imageinfo.getImageID());
				imageNew.setImageName(imageinfo.getImageName());
				imageNew.setImageSize(imageinfo.getImageSize());
				imageNew.setImageFormat(imageinfo.getImageFormat());
				imageNew.setImageDate(imageinfo.getImageDate());
				imageNew.setResolution(imageinfo.getResolution());
				imageNew.setPostKey(imageinfo.getPostKey());
				
				imageNew = feedImageMetaDataRepository.save(imageNew);
				
				return imageNew;	
			}
			else {
				imageinfo = feedImageMetaDataRepository.save(imageinfo);
				
				return imageinfo;
			}
			
		}
		
	
	
	private List<ImageMetaData> removeEmptyImages(List<ImageMetaData> media) {
		
		List<ImageMetaData> resultImages = new LinkedList<>();
		
		for (ImageMetaData img : media) {
			
			if (img.getImageID() != null && !img.getImageID().isEmpty()) {
				resultImages.add(img);
			}
		}
		return resultImages;
	}

}
