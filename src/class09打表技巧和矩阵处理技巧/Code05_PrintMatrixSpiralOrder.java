package class09打表技巧和矩阵处理技巧;
//通过主函数的矩阵测试 正确
public class Code05_PrintMatrixSpiralOrder {
    public static void spiralOrderPrint(int[][] matrix){
        //左上角A
        int tR = 0;
        int tC = 0;
        //右下角B
        int dR = matrix.length-1;
        int dC = matrix[0].length-1;
        while(tR <= dR && tC <= dC){
            printEdge(matrix,tR++,tC++,dR--,dC--);
        }
        System.out.println();
    }
    public static void printEdge(int[][] matrix,int tR, int tC,int dR,int dC){
        if(tR == dR){
            while(tC <= dC){
                System.out.print(matrix[tR][tC++] + " ");
            }
        }else if(tC == dC){
            while(tR <= dR){
                System.out.print(matrix[tR++][tC] + " ");
            }
        }else{
            int curRow = tR;
            int curCol = tC;
            while(curCol < dC){
                System.out.print(matrix[curRow][curCol] + " ");
                curCol++;
            }
            while(curRow < dR){
                System.out.print(matrix[curRow][curCol] + " ");
                curRow++;
            }
            while(curCol > tC){
                System.out.print(matrix[curRow][curCol] + " ");
                curCol--;
            }
            while(curRow > tR){
                System.out.print(matrix[curRow][curCol] + " ");
                curRow--;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);

    }
}
