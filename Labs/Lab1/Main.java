import javax.sound.midi.Soundbank;

public class Main
{
    //-------------------------------------------- LAB PART  --------------------------------------------


    public static void main(String[] args)
    {
          long startTime = System.nanoTime();
//        System.out.println("Hello World!");
//
//        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
//
//        int n = (int) (Math.random() * 10);
//
//        n *= 3;
//        n += Integer.parseInt("10101", 2);
//        n += Integer.parseInt("FF", 16);
//        n *= 6;
//
//
//        int res;
//        if (n % 9 == 0)
//            res = 9;
//        else
//            res = n % 9;
//
//        System.out.println(res);
//        System.out.println("Willy-nilly, this semester I will learn " + languages[res]);


        //-------------------------------------------- HOMEWORK PART  --------------------------------------------

        int dim;

        String arg = args[0]; //get the argument from the command line

        try
        {
            dim = Integer.parseInt(arg); //try to convert it to int
        } catch (NumberFormatException e)
        {
            System.out.println("The argument is not a number");
            return;
        }

        if (dim < 10000)
        {


            //create a new homework object

            int[][] matrix = Homework.create_matrix(dim);
            Homework.printMatrix(matrix);
            Homework.displayConcatString(matrix);
        } else
        {
            System.out.println("The dimension is too big... printing running time");
            System.out.println("Running time: " + (System.nanoTime() - startTime) + " ns");
            //System.out.println("Running time: " + (System.currentTimeMillis() - startTime) + "ms");
        }

    }


}
