package com.promostree.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.Notification;
import com.promostree.domain.user.UserShare;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

	List<Notification> findByRecipientUserId(Long userId);
}
