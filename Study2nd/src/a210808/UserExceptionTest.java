package a210808;

public class UserExceptionTest {
	
	public void test1(String n) throws UserException{
		System.out.println("Test2");
		if(n.length() < 1)
			throw new UserException("�ƹ��͵� ����");
		else
			throw new UserException("���� ����", 703);
	}
	
	public static void main(String[] args) {
		UserExceptionTest ut = new UserExceptionTest();
		try {
			ut.test1("te");
		}catch(UserException ue) {
			//System.out.println(ue.getMessage());
			ue.printStackTrace();
		}
	}

}
