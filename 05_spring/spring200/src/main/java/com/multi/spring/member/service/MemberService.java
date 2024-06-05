package com.multi.spring.member.service;

import java.util.List;

import com.multi.spring.member.model.dto.MemberDTO;

public interface MemberService {
	public void insertMember(MemberDTO memberDTO) throws Exception ;

	public List<MemberDTO> selectList() throws Exception ;
	
	public void deleteMember(String id) throws Exception ;
	
	public void updateMember(MemberDTO memberDTO) throws Exception ;
	
	public MemberDTO selectMember(String id) throws Exception ;

	public MemberDTO loginMember(MemberDTO memberDTO) throws Exception ;
}
