package com.jamesobin.spring.ex.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamesobin.spring.ex.database.domain.UsedGoods;
import com.jamesobin.spring.ex.database.repository.UsedGoodsRepository;

// 로직(business)을 담당한다
// 데이터 수정 가공
// 그외 복잡한 기능 수행
@Service
public class UsedGoodsService {

	@Autowired
	private UsedGoodsRepository usedGoodsRepository;
	
	// 중고물품 게시글 모두 얻어 오기
	public List<UsedGoods> getUsedGoodsList() {
		// usedgoods 테이블 조회 결과 얻어오기
		List<UsedGoods> usedGoodsList = usedGoodsRepository.selectUsedGoodsList();
		
		return usedGoodsList;
		
	}
	
}
