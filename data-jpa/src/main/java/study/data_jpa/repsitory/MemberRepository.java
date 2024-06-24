package study.data_jpa.repsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import study.data_jpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {

	List<Member> findByUsernameAndAgeGreaterThan(String username,int age);

	// @Query(name = "Member.findByUsername")
	List<Member> findByUsername(@Param("username") String username);



}
