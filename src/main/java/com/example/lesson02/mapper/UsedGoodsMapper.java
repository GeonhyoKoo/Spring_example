package com.example.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson02.domain.UsedGoods;

@Mapper // Mybatis 에 포함된 어노테이션
public interface UsedGoodsMapper {

	// input : BO 한테 받아옴. X
	// output: BO 한테 돌려줌 . List<UsedGoods>
	public List<UsedGoods> selectUsedGoodsList();
	
}
