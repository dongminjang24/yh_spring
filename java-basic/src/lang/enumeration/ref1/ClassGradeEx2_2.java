package lang.enumeration.ref1;



public class ClassGradeEx2_2 {
    public static void main(String[] args) {
        int price = 10000;
        DiscountService discountService = new DiscountService();
        int result = discountService.discount(Grade.BASIC, price);


        System.out.println("result = " + result);
    }

}
