package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        assertThat(member).isEqualTo(findMember);
    }

    @Test
    void findMember() {
        //given
        Member member1 = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member1);
        Member member2 = new Member(2L, "memberB", Grade.VIP);
        memberService.join(member2);
        //when
        Member findMember = memberService.findMember(member1.getId());

        //then
        assertThat(findMember).isEqualTo(member1);
    }
}