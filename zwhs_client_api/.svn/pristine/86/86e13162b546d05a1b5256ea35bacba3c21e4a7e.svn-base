package cn.org.citycloud.zwhs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.org.citycloud.zwhs.entity.FinAcc;

public interface FinAccDao extends JpaRepository<FinAcc, Integer>, JpaSpecificationExecutor<FinAcc> {

	public FinAcc findByAccNo(int no);
	
	public FinAcc findByAccNoAndAccType(int accNo, int accType);
	
}
