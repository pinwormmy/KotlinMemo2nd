package day0314;

import util.ArrayUtil;

// 배열의 동적 할당(Dynamic Allocation)

public class Ex05DAlloc {
    
    public static void main(String[] args) {
        
        int[] intArray = new int[4]; 
       
        intArray[0] = 40;
        intArray[1] = 20;
        intArray[2] = 30;
        intArray[3] = 40;
        
        System.out.println("size : " + ArrayUtil.size(intArray));
        System.out.println("isEmpty : " + ArrayUtil.isEmpty(intArray));
        
        System.out.println("contains : " + ArrayUtil.contains(intArray, 30));
        System.out.println("contains : " + ArrayUtil.contains(intArray, 40));
        System.out.println("indexOf : " + ArrayUtil.indexOf(intArray, 2));
        System.out.println("indexOf : " + ArrayUtil.indexOf(intArray, 30));
        System.out.println("lastIndexOf : " + ArrayUtil.lastIndexOf(intArray, 40));
        System.out.println("lastIndexOf : " + ArrayUtil.lastIndexOf(intArray, 5));
    }

}
