package day0321;


public class Circle {
    
    private static final double PI = 3.14;
    private double radius;
    
    public Circle() {
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius =radius;
        
    }
    
    public static double getPi() {
        return PI;
    }
    
    public void draw() {
        System.out.println("반지름" + radius + "인 원 그린다");
    }

}
    
   
