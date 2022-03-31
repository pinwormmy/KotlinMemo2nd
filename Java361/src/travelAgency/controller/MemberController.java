package travelAgency.controller;

import travelAgency.model.MemberDTO;
import travelAgency.model.Util;
import travelAgency.view.TravelView;
import travelAgency.model.TravelModel;

public class MemberController{
    
    
    public static void signUp() {        
        
        MemberDTO newMember = new MemberDTO();
                
        System.out.println(TravelView.memberTitle);
        
        
        while(true) {
            
            String userId = Util.scanString(TravelView.pressId);
                        
                        
            if(TravelModel.CheckDuplicatedId(userId, MainController.memberList)) 
                System.out.println(TravelView.alreadyId);
            else {
                System.out.println(TravelView.availableId);
                newMember.setUserId(userId);
                newMember.setUserNumber(MainController.userNumberSet++);
                
                break;
            }
                
        }
                       
        while(true) {
            String password1 = Util.scanString(TravelView.checkPw);
            String password2 = Util.scanString(TravelView.checkPw2);
            
            if(password1.equals(password2)) {
                newMember.setUserPassword(password1);
                break;
            }
            else {
                System.out.println(TravelView.errorPw);
            }
        }
        
        newMember.setUserNickname(Util.scanString(TravelView.pressNick));
                
        System.out.println(TravelView.agencyNotice);
        newMember.setUserLevel(0);
        
        
        System.out.println(TravelView.welcome);
        
        MainController.memberList.add(newMember);
        MainController.memberDTO = newMember; // 회원가입 완료하면 로그인 처리까지 해줌
        
    }
    
    static MemberDTO login() {
        
        while(true) {
            String userId = Util.scanString(TravelView.pressId);
            if(TravelModel.CheckDuplicatedId(userId, MainController.memberList)) {
                while(true) {
                    String userPassword = Util.scanString(TravelView.checkPw);
                    
                    if(TravelModel.CheckPassword(userId, userPassword, MainController.memberList)) {
                        System.out.println(TravelView.loginOk);
                        
                        return TravelModel.loginUserData(userId, MainController.memberList);
                    }
                    else
                        System.out.println(TravelView.errorPw);
                }
            }
                
            else {
                System.out.println(TravelView.checkNoId);
            }
        }       
    }

    public static void upgradeRequest() {
        
        System.out.println(TravelView.noticeUpgradeId);
        while(true) {
            String question = Util.scanString(TravelView.yesOrNo);
            if(question.equalsIgnoreCase("y")) {
                                
                TravelModel.deleteAllReserve(MainController.memberDTO);
                
                MainController.memberDTO.setUserLevel(5);
                break;
            }
            else if(question.equalsIgnoreCase("n")){
                System.out.println(TravelView.cancle);
                break;
            }else
                System.out.println(TravelView.errorYN);
        }                
    }
    
    public static void upgradeToAgency() {
        
        System.out.println(TravelView.agencyRequestList);
        
        System.out.println(TravelView.agencyRequestToolBar);
        
        int index = 0;
        for(MemberDTO member : MainController.memberList) {
            if(member.getUserLevel() == 5) {
                System.out.printf("%d | %s | %s |\n", member.getUserNumber(), member.getUserId(), member.getUserNickname());
                index++;
            }                
        }
        if(index == 0)
            System.out.println(TravelView.noList);    
        
        System.out.println(TravelView.dbar);        
        
        while(true) {
            
            int select = Util.scanInt(TravelView.pressUpMember);
            
            if(select == 0) {
                break;
            }else if(TravelModel.numberToMember(select) == null) {
                System.out.println(TravelView.noList);
                break;
            }else if(TravelModel.numberToMember(select).getUserLevel() == 5) {
                TravelModel.numberToMember(select).setUserLevel(1);
                System.out.printf(TravelView.noticeUpMember, TravelModel.numberToMember(select).getUserNickname());
                break;
            }else {
                System.out.println(TravelView.checkInputNotice);                
            }
        }
    }

    
}
