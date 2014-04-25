package com.promostree.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.Notification;
import com.promostree.domain.user.UserShare;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
public List<Notification> findByUserId(Long userId);
public UserShare findByUserShareId(Long userShareId);
}
