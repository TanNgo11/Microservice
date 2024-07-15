package com.thanhtan.identity.controller;

import com.thanhtan.identity.dto.request.CouponRequest;
import com.thanhtan.identity.dto.response.ApiResponse;
import com.thanhtan.identity.dto.response.CouponResponse;
import com.thanhtan.identity.service.ICouponService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.thanhtan.identity.constant.PathConstant.API_V1_COUPONS;


@RestController
@RequestMapping(API_V1_COUPONS)
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CouponController {

    ICouponService couponService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<List<CouponResponse>> getAllCoupons() {
        return ApiResponse.success(couponService.getAllCoupons());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<CouponResponse> createCoupon(@RequestBody CouponRequest couponRequest) {
        return ApiResponse.success(couponService.createGlobalCoupon(couponRequest));
    }

    @GetMapping("/{id}")
    public ApiResponse<CouponResponse> getCouponById(@PathVariable Long id) {
        return ApiResponse.success(couponService.getCouponById(id));
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<String> deleteCoupon(@RequestParam Long[] ids) {
        couponService.deleteCouponByIds(ids);
        return ApiResponse.success(null);
    }


    @GetMapping("/code/{code}")
    public ApiResponse<CouponResponse> getCouponByCode(@PathVariable String code) {
        return ApiResponse.success(couponService.getCouponByCode(code));
    }

}
