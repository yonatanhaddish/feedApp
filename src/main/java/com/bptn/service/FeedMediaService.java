package com.bptn.service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.exceptions.InvalidImageMetaDataException;
import com.bptn.model.ImageMetaData;
import com.bptn.repository.FeedImageMetaDataRepository;
import com.bptn.request.FeedMediaRequest;

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
	
	public ImageMetaData createNewImage(FeedMediaRequest imageinfo) {
		
			String postkey = imageinfo.getPostKey();
			String imageid = generateFeedMetaDataId(postkey);
		
			Optional<ImageMetaData> image = feedImageMetaDataRepository.findById(imageid);
			
			ImageMetaData imageNew;
			
			if (image.isPresent()) {
				imageNew = image.get();
			}
			else {
				imageNew = new ImageMetaData();
				imageNew.setImageID(imageid);
			}
			
			imageNew.setImageName(imageinfo.getImageName());
			imageNew.setImageSize(imageinfo.getImageFormat());
			imageNew.setImageFormat(imageinfo.getImageFormat());
			imageNew.setImageDate(LocalDate.now() + "");
			imageNew.setResolution(imageinfo.getResolution());
//			imageNew.setPostKey(imageinfo.getPostKey());    the same as the code below.
			imageNew.setPostKey(postkey);
			
			imageNew = feedImageMetaDataRepository.save(imageNew);
			
			return imageNew;
		}
		
	
	
	private String generateFeedMetaDataId(String postkey) {
		
		Random random = new Random(System.currentTimeMillis());
		StringBuilder imageIdBuilder = new StringBuilder();
		
		imageIdBuilder.append(random.nextInt());
		imageIdBuilder.append(Objects.hashCode(postkey));
		String imageId = imageIdBuilder.toString();
		
		if (imageId.startsWith("-")) {
			return imageId.substring(1);
		}
		
		return null;
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
