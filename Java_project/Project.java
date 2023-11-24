import java.util.Scanner;

public class Project {
  public static void main(String[] args) {
    final double ROUBLES_PER_DOLLAR = 72.12; // курс покупки
    
    int dollars; // сумма денег в американских долларах
    double roubles; // сумма денег в российских рублях
    int digit; // последняя цифра dollars
    
    Scanner input = new Scanner(System.in);
    System.out.print("Введите сумму денег в американских долларах: ");
    dollars = input.nextInt();
    
    // С правильным окончанием\
    System.out.print(dollars);
    
    if ( 5 <= dollars && dollars <= 20) {
      System.out.print(" американских долларов равны ");
    } else {
      digit = dollars % 10;
      if ( digit == 1) {
        System.out.print(" американский доллар равен ");
      } else if (2 <= digit && digit <= 4) {
        System.out.print(" американских доллара равны ");
      } else {
        System.out.print(" американских долларов равны ");
      }
    } 
    
    roubles = ROUBLES_PER_DOLLAR * dollars;
    
    System.out.println((int)(roubles * 100) / 100.0 + " российского рубля. ");
  }
}