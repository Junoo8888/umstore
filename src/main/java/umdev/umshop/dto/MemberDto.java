package umdev.umshop.dto;

import umdev.umshop.domain.Member;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Data
@ToString
public class MemberDto {


    ///Field
    @NotEmpty(message = "회원 이름은 필수 입니다.")
    private String memberId;

    @NotEmpty(message = "회원 이름은 필수 입니다.")
    private String name;

    private String city;
    private String street;
    private String zipcode;
    private String password;
//    private String grade;

    ///Constructor
    public MemberDto(){

    }
    public MemberDto(Member member){
        memberId = member.getId();
        name = member.getName();
        city = member.getAddress().getCity();
        street = member.getAddress().getStreet();
        zipcode = member.getAddress().getZipcode();
    }

}
