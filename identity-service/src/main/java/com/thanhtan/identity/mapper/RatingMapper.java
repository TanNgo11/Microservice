package com.thanhtan.identity.mapper;

import com.thanhtan.identity.dto.request.RatingRequest;
import com.thanhtan.identity.dto.response.RatingResponse;
import com.thanhtan.identity.entity.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RatingMapper {

    @Mapping(target = "product", source = "productId", ignore = true)
    Rating toRating(RatingRequest request);

    @Mapping(target = "productId", source = "product.id")
    RatingResponse toRatingResponse(Rating rating);


}
