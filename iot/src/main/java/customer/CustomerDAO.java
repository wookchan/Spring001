package customer;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO implements CustomerService {
	
	// 오라클 드라이버로 연결  
	// 기존 데이터베이스 처리 Prepare 머시기,resultset 이 필요없음
	
	@Override
	public void customer_insert(CustomerVO vo) {
		sql.insert("customer.mapper.insert", vo);

	}
	@Autowired @Qualifier("hanul") private SqlSession sql;
	
	@Override
	public List<CustomerVO> customer_list() {
		return sql.selectList("customer.mapper.list");
	}

	@Override
	public CustomerVO customer_detail(int id) {
		// 파라미터를 전송함,해당 값과 함꼐
		return sql.selectOne("customer.mapper.detail",id);
	}

	@Override
	public void customer_update(CustomerVO vo) {
		sql.update("customer.mapper.update",vo);
	}

	@Override
	public void customer_delete(int id) {
		sql.delete("customer.mapper.delete",id);
	}

}
