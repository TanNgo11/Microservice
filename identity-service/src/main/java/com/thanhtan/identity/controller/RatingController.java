package com.thanhtan.identity.controller;

import com.thanhtan.identity.dto.request.RatingRequest;
import com.thanhtan.identity.dto.response.ApiResponse;
import com.thanhtan.identity.dto.response.RatingResponse;
import com.thanhtan.identity.service.IRatingService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.thanhtan.identity.constant.PathConstant.API_V1_RATING;
@RestController
@RequestMapping(API_V1_RATING)
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RatingController {

    IRatingService ratingService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ApiResponse<RatingResponse> createRating(@RequestBody @Valid RatingRequest ratingRequest) {
        return ApiResponse.success(ratingService.createRating(ratingRequest));
    }

    @GetMapping("/average/{productId}")
    public ApiResponse<Double> getAverageRating(@PathVariable Long productId) {
        return ApiResponse.success(ratingService.getAverageRating(productId));
    }
}
