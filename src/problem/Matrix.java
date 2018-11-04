package problem;

public class Matrix {
	private int nrows;
	private int ncols;
	private double[][] data;
	// create matrix
	public Matrix(double[][] data) {
		this.data = data;
		this.nrows = data.length;
		this.ncols = data[0].length;
	}
	
	//Create matris r x c
	public Matrix(int nrows, int ncols) {
		this.nrows = nrows;
		this.ncols = ncols;
		data = new double[nrows][ncols];
	}
	
	public int getNcols() {
		return this.ncols;
	}
	
	public int getNrows() {
		return this.nrows;
	}
	
	// get the 2D array
	public double[][] getArray() {
		return this.data;
	}
	
	// set value at (i,j)
	public void setValue(int i, int j, double value) {
		this.data[i][j] = value;
	}
	
	public double getValue(int i, int j) {
		return this.data[i][j];
	}
	
	//Check if matrix is a square matrix
	public boolean isSquare() {
		return this.ncols == this.nrows;
	}
	
	//only use for square
	public int size() {
		return this.ncols;
	}
	
	
	
	//get 1-D columns of the internal array
	public double[] getColumns() {
		double[] values = new double[nrows * ncols];
		for (int i = 0; i < nrows; i++) {
			for (int j = 0; j < ncols; j++) {
				values[i + j*nrows] = this.data[i][j];
			}
		}
		return values;
	}
	
	//get 1-D rows of the internal array
	public double[] getRows () {
	      double[] vals = new double[nrows * ncols];
			for (int i = 0; i < nrows; i++) {
				for (int j = 0; j < ncols; j++) {
	            vals[i*ncols+j] = this.data[i][j];
	         }
	      }
	      return vals;
	   }
	//Transpose a matrix
	public static Matrix transpose(Matrix m) {
		Matrix tMatrix = new Matrix(m.getNcols(), m.getNrows());
		for (int i = 0; i < m.getNrows(); i++) {
			for (int j = 0; j < m.getNcols(); j++) {
				tMatrix.setValue(j, i, m.getValue(i, j));
			}
		}
		return tMatrix;
	}
	
	// create sub matrix knowing the excluding row and col
	public Matrix subMatrix(int exRow, int exCol) {
		Matrix sMatrix = new Matrix(this.nrows - 1, this.ncols - 1);
		int r = -1;
		int c = -1;
		for (int i = 0; i < this.nrows; i++) {
			if (i == exRow) {
				continue;
			}
			r++;
			for (int j = 0; j < this.ncols; j++) {
				if (j == exCol) {
					continue;
				}
				c++;
				sMatrix.setValue(r, c, this.data[i][j]);
			}
		}
		return sMatrix;
	}
	
	//Sign for determinant 1 if even, -1 if odd
	public static int signAt(int i) {
		if (i%2 == 0) {
			return 1; 
		} else {
			return -1;
		}
	}
	
	//determinant of a square matrix
	public static double determinant(Matrix m) throws NoSquareException {
		if(!m.isSquare()) {
			throw new NoSquareException("Matrix is not square");
		}
		if (m.size() == 1) {
			return m.getValue(0, 0);
		}
		
		if(m.size() == 2) {
			return m.getValue(0, 0) * m.getValue(1, 1) 
					- (m.getValue(0, 1) * m.getValue(1, 0));
		}
		double sum = 0.0;
		for (int i = 0; i < m.getNcols(); i++ ) {
			sum+= signAt(i) * m.getValue(0, i) * determinant(m.subMatrix(0, i));
		}
		
		return sum;
	}
	
	public static Matrix identity(int m, int n) {
		Matrix A = new Matrix(m, n);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				A.setValue(i, j, i == j ? 1.0 : 0.0);
			}
		}
		return A;
	}
	
	/*
	 * Private functions
	 */
	@SuppressWarnings("unused")
	private void checkMatrixDimensions (Matrix B) {
      if (B.ncols != this.ncols || B.nrows != this.nrows) {
         throw new IllegalArgumentException("Matrix dimensions must agree.");
      }
   }
}








