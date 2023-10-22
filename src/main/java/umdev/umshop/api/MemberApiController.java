package umdev.umshop.api;

import umdev.umshop.domain.Address;
import umdev.umshop.domain.Member;
import umdev.umshop.dto.MemberDto;
import umdev.umshop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/member/join")
    public MemberDto createMember(@RequestBody MemberDto memberDto){

        Member member = new Member();

        Address address = new Address(memberDto.getCity(), memberDto.getStreet(), memberDto.getStreet());
        member.setId(memberDto.getMemberId());
        member.setName(memberDto.getName());
        member.setPassword(memberDto.getPassword());
        member.setAddress(address);

        String id = memberService.join(member);

        return new MemberDto(member);
    }

    @GetMapping("/api/members")
    public Result members(){
        List<Member> findMember = memberService.findMembers();

        List<MemberDto> memberDtos = findMember.stream()
                .map( m -> new MemberDto(m))
                .collect(Collectors.toList());
        return new Result(memberDtos);
    }
    @Data
    @AllArgsConstructor
    static class Result<T>{
        private T data;
    }

}
