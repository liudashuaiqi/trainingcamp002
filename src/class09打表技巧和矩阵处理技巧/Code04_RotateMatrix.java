package class09打表技巧和矩阵处理技巧;
//主函数测试 正确
public class Code04_RotateMatrix {
    public static void rotate(int[][] matrix) {
        //左上角A
        int a = 0;
        int b = 0;
        //右下角B
        int c = matrix.length-1;
        int d = matrix[0].length-1;
        while(a < c){
            rotateEdge(matrix,a++,b++,c--,d--);
        }
        System.out.println();
    }
    public static void rotateEdge(int[][] m, int a, int b, int c, int d) {
        int temp =  0;
        for(int i = 0;i < d-b;i++){
            temp = m[a][b+i];
            m[a][b+i] = m[c-i][b];
            m[c-i][b] = m[c][d-i];
            m[c][d-i] = m[a+i][d];
            m[a+i][d] = temp;
        }
    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }
}
