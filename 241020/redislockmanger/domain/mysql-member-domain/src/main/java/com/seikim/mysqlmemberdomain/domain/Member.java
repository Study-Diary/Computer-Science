package com.seikim.mysqlmemberdomain.domain;

import com.seikim.mysqldomain.entity.SoftDeleteBaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member_tbl")
public class Member extends SoftDeleteBaseEntity {
	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "username", length = 20, nullable = false)
	private String username;

	@Column(name = "profile_image")
	private String profileImage;

	@Column(name = "introduction", length = 50)
	private String introduction;

	@Column(name = "like_count")
	private int likeCount;

	public Member(String email, String username) {
		this.email = email;
		this.username = username;
	}

	public void addLikeCount() {
		this.likeCount++;
	}
}
