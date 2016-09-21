package cn.org.citycloud.zwhs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.org.citycloud.zwhs.entity.OrderGood;

public interface OrderGoodDao extends JpaRepository<OrderGood, Integer>,
		JpaSpecificationExecutor<OrderGood> {

	public List<OrderGood> findByOrderId(int order_id);
}
