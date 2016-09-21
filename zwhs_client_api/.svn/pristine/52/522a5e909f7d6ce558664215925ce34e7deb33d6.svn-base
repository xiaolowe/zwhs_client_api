package cn.org.citycloud.zwhs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import cn.org.citycloud.zwhs.entity.EvaluateGood;

public interface EvaluateGoodDao extends JpaRepository<EvaluateGood, Integer>, JpaSpecificationExecutor<EvaluateGood> {

	@Query(value="SELECT * FROM evaluate_goods WHERE goods_id = ?1"
			+ " And geval_state = 0 And order_type = ?2 "
			+ " ORDER BY geval_addtime DESC", nativeQuery = true)
	public List<EvaluateGood> findGoodsEvaluate(int goodsId, int orderType);
	
}
