package umdev.umshop.controller;

import umdev.umshop.dto.MemberDto;
import umdev.umshop.domain.Address;
import umdev.umshop.domain.Member;
import umdev.umshop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("members/new")
    public String createMember(Model model){
        model.addAttribute("memberForm", new MemberDto());
        return "member/createMemberTest";
    }

    @PostMapping("members/new")
    public String create( MemberDto memberForm){

        Address address = new Address(memberForm.getCity(), memberForm.getStreet(), memberForm.getZipcode());

        System.out.println("memberForm ==> " +  memberForm);

        Member member = new Member();
        member.setId(memberForm.getMemberId());
        member.setName(memberForm.getName());
        member.setPassword(memberForm.getPassword());
        member.setAddress(address);
//        member.setGrade(member.getGrade());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("member", new MemberDto());
        return "/member/login";
    }


    @PostMapping("/login")
    public String login(@RequestParam String memberId,
                        @RequestParam String password,
                        HttpSession session){


        Member member1 = memberService.findOne(memberId);

        if(member1.getPassword().equals(password)){
            session.setAttribute("member", member1);
        }

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "member/memberList";
    }
}
