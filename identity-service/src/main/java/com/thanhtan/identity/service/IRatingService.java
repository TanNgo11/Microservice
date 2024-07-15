package com.thanhtan.identity.service;

import com.thanhtan.identity.dto.request.RatingRequest;
import com.thanhtan.identity.dto.response.RatingResponse;

public interface IRatingService {

    RatingResponse createRating(RatingRequest ratingRequest);

    double getAverageRating(Long productId);


}
