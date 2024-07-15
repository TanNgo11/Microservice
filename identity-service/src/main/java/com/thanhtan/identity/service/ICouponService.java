package com.thanhtan.identity.service;

import com.thanhtan.identity.dto.request.CouponRequest;
import com.thanhtan.identity.dto.response.CouponResponse;

import java.util.List;

public interface ICouponService {
    List<CouponResponse> getAllCoupons();

    CouponResponse getCouponById(Long id);

    CouponResponse createGlobalCoupon(CouponRequest couponRequest);

    void deleteCouponByIds(Long [] ids);

    CouponResponse getCouponByCode(String code);
}
