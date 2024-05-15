package com.multi.jdbc.member.controller;

import com.multi.jdbc.common.exception.MemberException;
import com.multi.jdbc.member.model.dto.Member;
import com.multi.jdbc.member.service.MemberService;
import com.multi.jdbc.member.view.MemberMenu;

import java.util.ArrayList;

public class MemberController {
    private MemberService memberService = new MemberService();

    public void selectAll() {
        MemberMenu menu = new MemberMenu();
        ArrayList<Member> list;

        try {
            list = memberService.selectAll();

            if (!list.isEmpty()){
                menu.displayMemberList(list);
            } else {
                menu.displayNoData();
            }
        } catch (MemberException e) {
            menu.displayError("회원 전체 조회 실패, 관리자에 문의하세요. ");
            e.printStackTrace();
        }

    }

    public void selectOne(String s) {
        Member member = null;
        MemberMenu menu = new MemberMenu();

        try {
            member = memberService.selectOne(s);

            if (member != null) {
                menu.displayMember(member);
            } else {
                menu.displayNoData();
            }
        } catch (MemberException e) {
            menu.displayError("회원 아이디 조회 실패, 관리자에 문의하세요. ");
            e.printStackTrace();
        }
    }

    public void insertMember(Member member) {
        int result = 0;
        try {
            result = memberService.insertMember(member);

            if (result > 0) {
                new MemberMenu().displaySuccess("회원 가입 성공");
            }
        } catch (MemberException e) {
            new MemberMenu().displayError("회원 가입 실패, 관리자에 문의하세요.");
            e.printStackTrace();
        }


    }

    public void updateMember(Member member) {

        int result = 0;
        try {
            result = memberService.updateMember(member);

            if (result > 0) {
                new MemberMenu().displaySuccess("회원 수정 성공");
            }
        } catch (MemberException e) {
            new MemberMenu().displayError("회원 수정 실패, 관리자에 문의하세요.");
            e.printStackTrace();
        }
    }

    public void deleteMember(String memberId) {
        int result = 0;
        try {
            result = memberService.deleteMember(memberId);

            if (result > 0) {
                new MemberMenu().displaySuccess("회원 삭제 성공");
            }
        } catch (MemberException e) {
            new MemberMenu().displayError("회원 삭제 실패, 관리자에 문의하세요.");
            e.printStackTrace();
        }
    }

    public void exitProgram() {
        memberService.exitProgram();
    }
}
