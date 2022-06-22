package com.boot.booking.restaurantapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.booking.restaurantapi.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{
	Optional<Notification>findByTemplateType(String templateType);
}


	
