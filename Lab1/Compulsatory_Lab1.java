

public class Main {

    public static int[][] create_matrix(int n)
    {
        int[][] matrix = new int[n][n];


        //the first line
        for (int i = 0; i < n; i++) {
            matrix[0][i] = i + 1;
        }

        int line = 1;
        //how many digits we place from back or "cut point"
        for (int k = 1; k < n; k++) {
            // 1 2 3 4
            // 4 2 3 4
            // 3 4 1 2
            int j = 0;
            //complete from cutting point to right
            for (j = 0; j < k; j++) {
                matrix[line][j] = matrix[0][n - k + 1];
            }

            //complete until the cutting point

            for (; j < n - k + 1; j++) {
                matrix[line][j] = matrix[0][j];
            }

        }
        return matrix;
    }


    public static void PrintMatrix(int [][]matrix )
    {
        //print the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 10);


        n *= 3;
        n += Integer.parseInt("10101", 2);
        n += Integer.parseInt("FF", 16);
        n *= 6;


        int res;
        if (n % 9 == 0)
            res = 9;
        else
            res = n % 9;

        System.out.println(res);
        System.out.println("Willy-nilly, this semester I will learn " + languages[res]);

       // int[][] matrix = create_matrix(5);
//         printMatrix(matrix);
    }



}
