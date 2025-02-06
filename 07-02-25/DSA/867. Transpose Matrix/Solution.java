class Solution {
  public int[][] transpose(int[][] matrix) {
      int rows = matrix.length;
      int cols = matrix[0].length;
      int[][] transposed = new int[cols][rows]; // Swapping dimensions

      for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
              transposed[j][i] = matrix[i][j]; // Swapping indices
          }
      }
      return transposed;
  }
}
