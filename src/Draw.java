import java.util.Scanner;

/**
 * Author: Marc Alejandro
 * Date: 02/14/2019
 * Purpose: Using static methods within the Draw class, the user inputs a number to
 *          print a triangle or square that number of size.
 */
public class Draw {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // initialize a scanner object

        int size = 1;

        while(size > 0){

            System.out.print("How many stars? (-1 to quit) :");
            //Use a scanner to read in values from the user
            size = sc.nextInt();

            Draw.square(size);
            Draw.triangle(size);

        }
    }//end main

    /**
     * square
     * @param size
     *
     * square takes an int, size, and draws a
     * square on the screen i.e.
     * 3 ==
     *      * * *
     *      * * *
     *      * * *
     */
//start the static method here

    public static void square(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }

        System.out.println("");
    }

    /**
     * triangle
     * @param size
     * Takes an int, size, and returns a triangle with side
     * length == size. The side is on the left i.e.
     *  3 ==     *
     *         * *
     *       * * *
     */




// start the static method here.


    public static void triangle(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j >= size - 1 - i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }

}