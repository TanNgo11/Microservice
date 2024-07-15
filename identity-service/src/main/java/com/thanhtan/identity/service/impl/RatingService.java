package com.thanhtan.identity.service.impl;

import com.thanhtan.identity.dto.request.RatingRequest;
import com.thanhtan.identity.dto.response.RatingResponse;
import com.thanhtan.identity.entity.Product;
import com.thanhtan.identity.entity.Rating;
import com.thanhtan.identity.exception.ErrorCode;
import com.thanhtan.identity.exception.ResourceNotFound;
import com.thanhtan.identity.mapper.RatingMapper;
import com.thanhtan.identity.repository.ProductRepository;
import com.thanhtan.identity.repository.RatingRepository;
import com.thanhtan.identity.service.IRatingService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RatingService implements IRatingService {

    RatingRepository ratingRepository;

    RatingMapper ratingMapper;

    ProductRepository productRepository;

    @Override
    public RatingResponse createRating(RatingRequest ratingRequest) {
        Rating newRating = ratingMapper.toRating(ratingRequest);

        Product product = productRepository.findById(ratingRequest.getProductId())
                .orElseThrow(() -> new ResourceNotFound(ErrorCode.RESOURCE_NOT_FOUND));
        newRating.setProduct(product);

        Optional<Rating> existingRating =
                ratingRepository.findByProductIdAndUserId(product.getId(), newRating.getUserId());

        if (existingRating.isPresent()) {
            ratingRepository.updateRate(newRating.getRate(), existingRating.get().getId());
        } else {
            newRating = ratingRepository.save(newRating);
        }

        RatingResponse ratingResponse = ratingMapper.toRatingResponse(newRating);
        ratingResponse.setProductId(newRating.getProduct().getId());

        return ratingResponse;
    }


    @Override
    public double getAverageRating(Long productId) {
        return ratingRepository.getAverageRating(productId);
    }
}
