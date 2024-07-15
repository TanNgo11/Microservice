package com.thanhtan.identity.repository.custom;

import com.querydsl.core.Tuple;

import java.util.Date;
import java.util.List;

public interface CustomProductRepository {
    List<Tuple> findRevenueByCategoryInPeriod(Date startDate, Date endDate);
}
