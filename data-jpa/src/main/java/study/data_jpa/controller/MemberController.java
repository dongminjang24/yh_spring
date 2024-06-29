package study.data_jpa.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import study.data_jpa.dto.MemberDto;
import study.data_jpa.entity.Member;
import study.data_jpa.repsitory.MemberRepository;

@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberRepository memberRepository;

	@GetMapping("/members/{id}")
	public String findMember(@PathVariable("id") Long id) {
		Member member = memberRepository.findById(id).get();
		return member.getUsername();
	}


	@GetMapping("/members2/{id}")
	public String findMember2(@PathVariable("id") Member member) {
		return member.getUsername();
	}

	@GetMapping("/members")
	public Page<MemberDto> list(Pageable pageable) {
		Page<Member> all = memberRepository.findAll(pageable);
		Page<MemberDto> map = all.map(member -> new MemberDto(member.getId(), member.getUsername(), null));
		return map;
	}

	// @PostConstruct
	// public void init() {
	// 	for (int i = 0; i < 2000; i++) {
	// 		memberRepository.save(new Member("user"+i,i));
	//
	// 	}
	// }

}
