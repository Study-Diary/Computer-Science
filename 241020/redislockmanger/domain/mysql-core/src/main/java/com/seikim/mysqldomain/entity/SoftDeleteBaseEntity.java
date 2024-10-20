package com.seikim.mysqldomain.entity;

import java.time.LocalDateTime;

import com.seikim.mysqldomain.exception.JpaErrorCode;
import com.seikim.mysqldomain.exception.JpaException;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class SoftDeleteBaseEntity extends BaseEntity {
	@Column(name = "deleted_at")
	private LocalDateTime deletedAt;

	public void delete() {
		if (isDelete()) {
			throw new JpaException(JpaErrorCode.ALREADY_DELETED_ENTITY);
		}
		this.deletedAt = LocalDateTime.now();
	}

	public void restore() {
		if (isNotDelete()) {
			throw new JpaException(JpaErrorCode.NO_DELETED_ENTITY);
		}
		this.deletedAt = null;
	}

	public boolean isNotDelete() {
		return deletedAt == null;
	}

	public boolean isDelete() {
		return !isNotDelete();
	}
}
