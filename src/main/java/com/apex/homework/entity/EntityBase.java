package com.apex.homework.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class EntityBase {
	@Getter
	@Setter
	@CreatedDate
	private LocalDate creationDate;
	@Getter
	@Setter
	private boolean deleted = false;
	@Getter
	@Setter
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
	@Id
	private String id;
	@Getter
	@Setter
	@LastModifiedDate
	private LocalDate modifiedDate;
}
