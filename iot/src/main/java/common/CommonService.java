package common;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.UUID;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;

@Service
public class CommonService {
	
	public String resetPassword(String id ,String name,String email) {
		// mail reposetery 필요
		HtmlEmail mail = new HtmlEmail();
		// 메일 서버 설정
		mail.setHostName("smtp.naver.com");
		mail.setDebug(true);     // 디버그 출력 (기본 false)
		mail.setCharset("utf-8"); // 한글
								//관리자의 이메일, 패스워드
		mail.setAuthentication("darkwan1125","qwe6425456");
		mail.setSSLOnConnect(true);	//접속에 해당함
		
		//setAuthentication name 부분을써도됨, "닉네임"
		// 이메일주소:이메일아이디@naver.com 등
		String pw = "";
		try {
			mail.setFrom("darkwan1125@naver.com","z허욱z");
			// 위,메일 송신자
			// 하,메일 수신자
			mail.addTo(email,name);
			
			// 임시번호를 생성
			pw = UUID.randomUUID().toString();
			// 2번에 걸쳐 - 로 끊어내는 형태 (3등분)
			pw = pw.substring(pw.lastIndexOf("-")+1);
			
			//제목 
			mail.setSubject("비밀번호 재발급");
			StringBuffer msg = new StringBuffer();
			msg.append("<http>");
			msg.append("<body>");
			msg.append("<h3>임시 비밀번호 발급</h3>");
			msg.append("<p>아이디 : ").append(id).append(" 님</p>");
			msg.append("<p>발급된 임시 비밀번호로 로그인 후 비밀번호를 변경해 주십시오</p>");
			msg.append("<p><strong>"+ pw +"</strong></p>");
			msg.append("</body>");
			msg.append("</http>");
			// 메일 내용 압축
			mail.setHtmlMsg(msg.toString());
			
			mail.send();
		}
		catch(Exception e) {
			e.getMessage();
		}
		return pw;
	}
	
	// salt를 사용해 비밀번호를 암호화 하기
	public String getEncrypt(String pw, String salt) {
		pw = pw + salt; 
		
		
		try {
			MessageDigest md =  MessageDigest.getInstance("SHA-256");
			md.update(pw.getBytes());
			byte[] digest =  md.digest();
			StringBuffer sb = new StringBuffer();
			for(byte d : digest) {
				sb.append(String.format("%02x", d));
			}
			pw = sb.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pw;
	}
	
	// 비밀번호를 해시 처리하는 단방향 함수의 랜덤데이터 만들기
	public String generateSalt() {
		SecureRandom sr = new SecureRandom();
		byte[] salt = new byte[24];
		sr.nextBytes(salt);
		
		StringBuffer sb = new StringBuffer();
		for(byte s : salt) {
			sb.append( String.format("%02x",s));
		}
		return sb.toString();
	}
}
