package com.thanhtan.identity.repository;

import com.thanhtan.identity.entity.Notification;
import com.thanhtan.identity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserOrderByCreatedDateDesc(User user);
}
