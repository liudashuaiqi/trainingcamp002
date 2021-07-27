package class09打表技巧和矩阵处理技巧;
//通过主函数测试 正确
public class Code06_ZigZagPrintMatrix {
    public static void printMatrixZigZag(int[][] matrix) {
        //A
        int tR = 0;
        int tC = 0;
        //B
        int dR = 0;
        int dC = 0;

        int endR = matrix.length-1;
        int endC = matrix[0].length-1;

        boolean fromUp = false;
        while(tR <= endR){
            printLevel(matrix,tR,tC,dR,dC,fromUp);
            tR = tC == endC? tR+1:tR;
            tC = tC == endC? tC:tC+1;
            dC = dR == endR? dC+1:dC;
            dR = dR == endR? dR:dR+1;
            fromUp = !fromUp;
        }
        System.out.println();
    }
    public static void printLevel(int[][] matrix,int tR,int tC,int dR,int dC,boolean fromUp){
        if(fromUp){
            while(tR <= dR){
                System.out.print(matrix[tR++][tC--]+ " ");
            }
        }else{
            while(dR >= tR){
                System.out.print(matrix[dR--][dC++] + " ");
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);

    }
}
