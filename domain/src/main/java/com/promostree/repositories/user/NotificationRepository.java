package com.promostree.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.promostree.domain.solr.SolrVenue;
import com.promostree.domain.user.Notification;
import com.promostree.domain.user.UserShare;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
public List<Notification> findById(Long id);
public List<Notification> findByUserId(long userId);
public UserShare findByUserShareId(long userShareId);

}
