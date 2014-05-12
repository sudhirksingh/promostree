package com.promostree.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.EventType;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserAuditLog;



public interface UserAuditLogRepository  extends JpaRepository<UserAuditLog, Long> {

List<UserAuditLog>	findByUserAndType(User user,EventType eventType);
	
}
