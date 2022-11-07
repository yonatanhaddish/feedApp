package com.bptn.repository;

import com.bptn.model.Post;

public interface FeedPostRepository extends FeedRepository {
	
	Post save(Post feed);

}
