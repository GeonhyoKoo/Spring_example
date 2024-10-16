package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {

	// input : x
	// output : Review 단건 or null 단건일땐 채워져있거나 null이거나 리턴이 된다
	public Review selectReviewById(int id);
	
	// input : Review
	// output : void -> 필요없어, int (mybatis 에서 채워주는 수행되는 행의 개수를 준다)
	public int insertReview(Review review);
	
	
	// input : 파라미터들
	// output : int 
	public int insertReviewAsField(
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);
	
	
	// input : id , review
	// output : int(수행된 행의 개수)
	public int updateReviewById(
			@Param("id") int id, 
			@Param("review")  String review
			);
	
	// input : id
	// output: int
	public int deleteReviewById(int id);
}
