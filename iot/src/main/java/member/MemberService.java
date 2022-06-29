package member;

import java.util.HashMap;

public interface MemberService {
	//로그인 처리
	//CRUD
	boolean member_join(MemberVO vo); // 회원 가입

	MemberVO member_login(HashMap<String, String> map); // 로그인처리
	
	MemberVO member_myinfo(String id); // 내정보보기 
	
	boolean member_id_check(String id);	//아이디 중복 확인
	
	boolean member_update(MemberVO vo);	// 회원의 정보를 변경
	
	boolean memeber_delete(String id); // 회원 탈퇴
	
	String member_salt(String id); // 회원 id에 해당하는 솔트 id 조회
	
	//비밀번호 변경하기
	boolean member_reset_password(MemberVO vo);
}
