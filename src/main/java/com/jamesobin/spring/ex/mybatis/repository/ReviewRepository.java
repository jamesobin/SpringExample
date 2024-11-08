package com.jamesobin.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jamesobin.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	
	// 전달된 id와 일치하는 행 조회 -> 한행을 담기 위해 entity class 생성해야함
	public Review selectReview(@Param("id") int id);
	
	// 전달받은 리뷰 정보를 기반으로 insert 한다.
	public int insertReview(
			@Param("storeId") int storeId
			, @Param("menu") String menu
			, @Param("userName") String userName
			, @Param("point") double point
			, @Param("review") String review);
	
	// 전달받은 Review 객체로 insert 한다
	public int insertReviewByObject(Review review);
	
}
