public class Homework {

    //LAB 1 HOMEWORK
    public static int[][] create_matrix(int n)
    {
        int[][] matrix = new int[n][n];

        //the first line
        for (int i = 0; i < n; i++)
        {
            matrix[0][i] = i + 1;
        }

        int line = 1;
        //how many digits we place from back or "cut point"
        for (int k = 1; k < n; k++) {
            int j;
            //complete from cutting point to right
            for (j = 0; j < k; j++) {
                matrix[k][j] = matrix[0][n - k + j];
            }

            for(int i = 0 ;i<n-k;i++)
                matrix[k][j+i] = matrix[0][i];

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

    public static void  DisplayConcatString(int [][] matrix)
    {
        //for every line concatenate the numbers
        System.out.println("Line concantenation:");
        for (int i = 0; i < matrix.length; i++) {
            String line = "";
            for (int j = 0; j < matrix.length; j++) {
                line += matrix[i][j];
            }
            System.out.println(line);
        }

        //for every column concatenate the numbers
        System.out.println("Column concatenation:");
        for (int i = 0; i < matrix.length; i++) {
            String column = "";
            for (int j = 0; j < matrix.length; j++) {
                column+= matrix[j][i];
            }
            System.out.println(column);
        }

    }
}
