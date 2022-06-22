package com.boot.booking.restaurantapi.services.impl;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.boot.booking.restaurantapi.dtos.EmailTemplateDto;
import com.boot.booking.restaurantapi.entities.Notification;
import com.boot.booking.restaurantapi.exceptions.BookingExceptions;
import com.boot.booking.restaurantapi.exceptions.InternalServerErrorException;
import com.boot.booking.restaurantapi.exceptions.NotFoundException;
import com.boot.booking.restaurantapi.repositories.NotificationRepository;
import com.boot.booking.restaurantapi.services.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CancelReservationServiceImpl.class);

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private NotificationRepository notificationRepository;

	@Override
	public String processSendEmail(String receiver,  String templateType, String currentName)
			throws BookingExceptions {
		
		final EmailTemplateDto emailTemplateDto =findTemplateAndReplace(templateType, currentName);
		
		this.sendEmail(receiver, emailTemplateDto.getSubject(), emailTemplateDto.getTemplate());
		
		return "EMAIL_SENT";
	}

	private void sendEmail(final String receiver, final String subject, final String template)
			throws InternalServerErrorException {
		final MimeMessage email = javaMailSender.createMimeMessage();
		final MimeMessageHelper content;
		try {
			content = new MimeMessageHelper(email, true);
			content.setSubject(subject);
			content.setTo(receiver);
			content.setText(template, true);
		} catch (Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
	}

	private EmailTemplateDto findTemplateAndReplace(final String templateType, final String currentName)
			throws BookingExceptions {

		final EmailTemplateDto emailTemplateDto = new EmailTemplateDto();

		final Notification notificationTemplate = notificationRepository.findByTemplateType(templateType)
				.orElseThrow(() -> new NotFoundException("TEMPLATE_NOT_FOUND", "CODE_TEMPLATE_NOT_FOUND"));
		emailTemplateDto.setSubject(notificationTemplate.getTemplateType());
		emailTemplateDto.setTemplate(notificationTemplate.getTemplate().replaceAll("\\{"+"name"+"\\}", currentName));

		return emailTemplateDto;
	}
}
