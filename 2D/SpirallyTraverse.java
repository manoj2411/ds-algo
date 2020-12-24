import java.util.*;

class SpirallyTraverse {
	public static void main(String[] args) {
		int[][] m = {
			{6,6,2,28,2},
			{12,26,3,28,7},
			{22,25,3,4,23}
		};

		System.out.println("Matrix: ");
		for(int[] row : m) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("\nSpirall traversal: " + spirallyTraverse(m));
	}

	static ArrayList<Integer> spirallyTraverse(int m[][]) {
		int r = m.length;
		int c = m[0].length;
		return spirallyTraverse(m, r, c);
	}
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
        ArrayList<Integer> res = new ArrayList<>();

        int firstRow = 0, lastRow = r - 1, firstCol = 0, lastCol = c - 1;

        while(firstRow < lastRow && firstCol < lastCol) {

            // System.out.println("Rows " + firstRow + " : " + lastRow);
            // System.out.println("Cols " + firstCol + " : " + lastCol);

            for(int j = firstCol; j < lastCol; j++)
                res.add(matrix[firstRow][j]);

            for(int i = firstRow; i < lastRow; i++)
                res.add(matrix[i][lastCol]);

            for(int j = lastCol; j > firstCol; j--)
                res.add(matrix[lastRow][j]);

            for(int i = lastRow; i > firstRow; i--)
                res.add(matrix[i][firstCol]);

            firstRow++;
            firstCol++;
            lastRow--;
            lastCol--;
        }

        for(int i = firstRow; i <= lastRow; i++)
            for(int j = firstCol; j <= lastCol; j++)
                res.add(matrix[i][j]);

        return res;
    }
}

