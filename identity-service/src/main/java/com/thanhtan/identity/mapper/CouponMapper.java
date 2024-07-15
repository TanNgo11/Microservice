package com.thanhtan.identity.mapper;

import com.thanhtan.identity.dto.request.CouponRequest;
import com.thanhtan.identity.dto.response.CouponResponse;
import com.thanhtan.identity.entity.Coupon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CouponMapper {


    @Mapping(target ="users", source = "userIds", ignore = true)
    @Mapping(target = "description", source = "description")
    Coupon toCoupon(CouponRequest couponRequest);


    CouponResponse toCouponResponse(Coupon coupon);

    List<CouponResponse> toOrderResponseList(List<Coupon> allCoupons);

}
