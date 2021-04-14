import java.util.Scanner;

class Triangle {

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the sides' length of triangle you want to build: ");

        try {

            int a = sc.nextInt(); //first side of triangle
            int b = sc.nextInt(); //second side of triangle
            int c = sc.nextInt(); //third side of triangle


            /*I am going to calculate before each angle A, B & C using cosine formula and the angles
            will be calculated in doubles to make sure that the sum of them will coincide
            with the needed result in order to check the conditions */

            double A = calculateDegrees('A', a, b, c);
            double B = calculateDegrees('B', a, b, c);
            double C = calculateDegrees('C', a, b, c);


            /*Since I have to check their sum to be 180 I had to round the results*/

            double sum = (Math.round(A * 100) / 100.0) + (Math.round(B * 100) / 100.0) + (Math.round(C * 100) / 100.0);

            /*As soon as we know that the third side is bigger or equal to the sum of the other 2,
             then we know that the sides do not make up a triangle*/

            if (a >= (b + c) || c >= (b + a) || b >= (a + c)) {
                System.out.println("Not a Triangle");
            } else if (sum == 180){
                if (A == B && B == C && C == A) {
                    System.out.println("The triangle is an equilateral one");
                } else if (A == B || A == C || B == C){
                    System.out.println("The triangle is an isosceles one");
                } else if (A != C && A != B && B != C) {
                    System.out.println("The triangle is a scalene one");
                }
            }
        } catch (Exception e){
            System.out.println("Error: enter a number!");
        }
    }

    
    public static double calculateDegrees(char targetDegree, int a, int b, int c){
        switch (targetDegree){
            case 'A': return
                    Math.toDegrees(Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c)));
            case 'B': return
                    Math.toDegrees(Math.acos((Math.pow(c, 2) + Math.pow(a, 2) - Math.pow(b, 2)) / (2 * c * a)));
            case 'C': return
                    Math.toDegrees(Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b)));
        }
        return targetDegree;
    }

}
