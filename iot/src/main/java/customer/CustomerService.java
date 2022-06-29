package customer;

import java.util.List;

public interface CustomerService {
	// CRUD
				//	 스프링:데이터베이스언어
	// 신규 고객 등록 (Create:insert)
	public abstract void customer_insert(CustomerVO vo); // 등록을 햇으니 반환할 필요가없음
	
	// 고객 목록 조회 (Read:Select) , 여러 명 반환
	List<CustomerVO> customer_list();
	
	// 고객 상세 조회 (Read:Select) , 단 한명 반환
	CustomerVO customer_detail(int id);	// id는 비울 수 없으며 가장 위에있는 키임
	
	// 고객 정보 변경 저장 (Update:update)
	void customer_update(CustomerVO vo);
	
	// 고객 정보 삭제 (Delete : delete)
	void customer_delete(int id);	// 
}
