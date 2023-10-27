package com.capstone.snowe.service;

<<<<<<< HEAD
import com.capstone.snowe.domain.MemberRequest;
import com.capstone.snowe.domain.MemberResponse;
import com.capstone.snowe.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

=======
import com.capstone.snowe.dto.MemberRequestDto;
import com.capstone.snowe.dto.MemberResponseDto;

// MemberService.java (인터페이스)
public interface MemberService {
    MemberResponseDto login(String loginId, String password);
>>>>>>> origin/Jang

    String saveMember(MemberRequestDto params);

    MemberResponseDto findMemberByLoginId(String loginId);

<<<<<<< HEAD
    /**
     * 로그인
     * @param loginId - 로그인 ID
     * @param password - 비밀번호
     * @return 회원 상세정보
     */
    public MemberResponse login(final String loginId, final String password) {
        // 1. 회원 정보 조회
        MemberResponse member = findMemberByLoginId(loginId);

        // 2. 회원 정보가 없을 경우 또는 비밀번호가 틀릴 경우 처리
        if (member == null || !passwordEncoder.matches(password, member.getPassword())) {
            return null; // 로그인 실패
        }

        // 3. 회원 응답 객체에서 비밀번호를 제거한 후 회원 정보 리턴
        member.clearPassword();
        return member;
    }


    /**
     * 회원 정보 저장 (회원가입)
     * @param params - 회원 정보
     * @return PK
     */
    @Transactional
    public String saveMember(final MemberRequest params) {
        params.encodingPassword(passwordEncoder);
        System.out.println(params);
        memberMapper.save(params);
        return params.getLoginId();
    }

    /**
     * 회원 상세정보 조회
     * @param loginId - UK
     * @return 회원 상세정보
     */
    public MemberResponse findMemberByLoginId(final String loginId) {
        return memberMapper.findByLoginId(loginId);
    }

    /**
     * 회원 정보 수정
     * @param params - 회원 정보
     * @return PK
     */
    @Transactional
    public String updateMember(final MemberRequest params) {
        params.encodingPassword(passwordEncoder);
        memberMapper.update(params);
        return params.getLoginId();
    }


    /**
     * 회원 수 카운팅 (ID 중복 체크)
     * @param loginId - UK
     * @return 회원 수
     */
    public int countMemberByLoginId(final String loginId) {
        return memberMapper.countByLoginId(loginId);
    }

    public int checkNickname(final String nickname) { return memberMapper.checkNickname(nickname);}
=======
    String updateMember(MemberRequestDto params);

    int countMemberByLoginId(String loginId);

    int checkNickname(String nickname);

>>>>>>> origin/Jang
}