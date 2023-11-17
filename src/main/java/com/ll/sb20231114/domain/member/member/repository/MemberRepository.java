package com.ll.sb20231114.domain.member.member.repository;

import com.ll.sb20231114.domain.article.article.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final List<Member> members = new ArrayList<>() {{
        add(new Member(1L, "user1", "1234"));
        add(new Member(2L, "user2", "1234"));
        add(new Member(3L, "user3", "1234"));
    }};

    public Member save(Member member) {
        if (member.getId() == null) {
            member.setId(members.size() + 1L);
        }

        members.add(member);

        return member;
    }

    public List<Member> findAll() {
        return members;
    }

    public Optional<Member> findById(long id) {
        return members.stream()
                .filter(member -> member.getId() == id)
                .findFirst();
    }

    public void delete(long id) {
        members.removeIf(member -> member.getId() == id);
    }
}