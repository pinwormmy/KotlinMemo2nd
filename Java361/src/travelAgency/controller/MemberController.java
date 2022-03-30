package travelAgency.controller;

import travelAgency.model.MemberDTO;
import travelAgency.model.Util;
import travelAgency.model.TravelModel;

public class MemberController{
    
    
    public static void signUp() {        
        
        MemberDTO newMember = new MemberDTO();
                
        System.out.println("=============회원가입==============");
        
        
        while(true) {
            
            String userId = Util.scanString("ID 입력하시오");
                        
                        
            if(TravelModel.CheckDuplicatedId(userId, MainController.memberList)) 
                System.out.println("이미 있는 ID입니다. 다른 걸로 하세요");
            else {
                System.out.println("사용 가능한 ID입니다. ㄱㄱㄱ");
                newMember.setUserId(userId);
                newMember.setUserNumber(MainController.userNumberSet++);
                
                break;
            }
                
        }
                       
        while(true) {
            String password1 = Util.scanString("비밀번호 입력하시오");
            String password2 = Util.scanString("확인차 같은 비밀번호 다시 입력하시오");
            
            if(password1.equals(password2)) {
                newMember.setUserPassword(password1);
                break;
            }
            else {
                System.out.println("비밀번호 입력 오류!!!");
            }
        }
        
        newMember.setUserNickname(Util.scanString("닉네임 입력하시오"));
                
        System.out.println("여행객 계정으로 등록됩니다~~~");
        newMember.setUserLevel(0);
        
        
        System.out.println("=============가입 완료. 환영합니다~=============");
        
        MainController.memberList.add(newMember);
        MainController.memberDTO = newMember; // 회원가입 완료하면 로그인 처리까지 해줌
        
    }
    
    static MemberDTO login() {
        
        while(true) {
            String userId = Util.scanString("ID 입력");
            if(TravelModel.CheckDuplicatedId(userId, MainController.memberList)) {
                while(true) {
                    String userPassword = Util.scanString("비밀번호 입력");
                    
                    if(TravelModel.CheckPassword(userId, userPassword, MainController.memberList)) {
                        System.out.println("로그인 성공! 환영합니다.");
                        
                        return TravelModel.loginUserData(userId, MainController.memberList);
                    }
                    else
                        System.out.println("비밀번호 입력오류. 확인 바랍니다.");
                }
            }
                
            else {
                System.out.println("존재하지 않는 ID입니다. 확인 바랍니다.");
            }
        }       
    }

    public static void upgradeRequest() {
        // TODO Auto-generated method stub
        
    }
    
    
}
