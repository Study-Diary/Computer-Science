package com.study.staticfinal.javafinal;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.study.staticfinal.common.MapRepository;
import com.study.staticfinal.domain.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class FinalMemberRepository implements MapRepository<Member> {
	private final Map<Long, Member> members = new ConcurrentHashMap<>();
	private final AtomicLong lastId = new AtomicLong(1L);

	@Override
	public Member save(final Member entity) {
		Member saveMember = entity;
		if (entity.getId() == null) {
			saveMember = convert(entity);
		}
		members.put(saveMember.getId(), saveMember);
		log.info("Saved Member : {}", saveMember);
		return saveMember;
	}

	private Member convert(final Member entity) {
		return Member.builder()
				.id(lastId.getAndIncrement())
				.email(entity.getEmail())
				.password(entity.getPassword())
				.name(entity.getName())
				.gender(entity.getGender())
				.age(entity.getAge())
				.build();
	}

	@Override
	public Member findById(long id) {
		if (members.containsKey(id)) {
			Member findMember = members.get(id);
			log.info("Found Member : {}", findMember);
			return findMember;
		}
		throw new NoSuchElementException("데이터가 존재하지 않습니다.");
	}

	@Override
	public List<Member> findAll() {
		return members.values().stream().toList();
	}

	@Override
	public boolean deleteById(long id) {
		Member findMember = findById(id);
		log.info("Deleted Member : {}", findMember);
		return members.remove(id, findMember);
	}
}
