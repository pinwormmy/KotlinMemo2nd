package movieManager.controller;

import movieManager.model.MemberDTO;
import movieManager.model.MovieModel;
import movieManager.model.Util;

public class MemberController{
    
    
    public static void signUp() {        
        
        MemberDTO newMember = new MemberDTO();
                
        System.out.println("=============회원가입==============");
        
        
        while(true) {
            
            String userId = Util.scanString("ID 입력하시오");
                        
                        
            if(MovieModel.CheckDuplicatedId(userId, MovieController.memberList)) 
                System.out.println("이미 있는 ID입니다. 다른 걸로 하세요");
            else {
                System.out.println("사용 가능한 ID입니다. ㄱㄱㄱ");
                newMember.setUserId(userId);
                newMember.setUserNumber(MovieController.userNumberSet);
                MovieController.userNumberSet++;
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
                
        while(true) {
            
            String ruCritic = Util.scanString("혹시 당신은 영화평론가입니까?(y/n)");
            
            if(ruCritic.equalsIgnoreCase("y"))
            {
                System.out.println("영화평론가 계정으로 등록됩니다.====");
                newMember.setUserLevel(1);
                break;
            }
            else if(ruCritic.equalsIgnoreCase("n"))
            {
                System.out.println("관람객 계정으로 등록됩니다~~~");
                newMember.setUserLevel(0);
                break;
            }
            else
                System.out.println("입력 오류. y나 n 중 입력하세요.");
        }
        
        System.out.println("=============가입 완료. 환영합니다~=============");
        MovieController.memberList.add(newMember);
        MovieController.memberDTO = newMember; // 회원가입 완료하면 로그인 처리까지 해줌
        
    }
    
    static MemberDTO login() {
        
        while(true) {
            String userId = Util.scanString("ID 입력");
            if(MovieModel.CheckDuplicatedId(userId, MovieController.memberList)) {
                while(true) {
                    String userPassword = Util.scanString("비밀번호 입력");
                    
                    if(MovieModel.CheckPassword(userId, userPassword, MovieController.memberList)) {
                        System.out.println("로그인 성공! 환영합니다.");
                        
                        return MovieModel.loginUserData(userId, MovieController.memberList);
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
    
    
}
