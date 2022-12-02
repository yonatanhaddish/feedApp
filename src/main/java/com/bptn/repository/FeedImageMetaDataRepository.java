package com.bptn.repository;

import com.bptn.model.ImageMetaData;
import com.bptn.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedImageMetaDataRepository extends JpaRepository<ImageMetaData, String> {
    
	ImageMetaData findById(long imageId);

    List<ImageMetaData> findAllByPostKey(Post post);
}

//package com.bptn.repository;
//
//import com.bptn.model.ImageMetaData;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface FeedImageMetaDataRepository extends JpaRepository<ImageMetaData, String> {
//	
//	ImageMetaData findByImageID(String imageID);
//	
//	List<ImageMetaData> findByPostKey(String postkey);
//
//}
