package cn.org.citycloud.zwhs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.org.citycloud.zwhs.entity.CashRecoder;

public interface CashRecoderDao extends JpaRepository<CashRecoder, Integer>, JpaSpecificationExecutor<CashRecoder> {

	List<CashRecoder> findByRetailMemberIdAndConfirmStat(int retailMemberId, int confirmStatus);
	
	
	List<CashRecoder> findByRetailMemberId(int retailMemberId);
}
