public class Matrix {
    Vector[] columns;
    int colLength;
    int rowLength;

    public Matrix() {
        this.columns = null;
        this.colLength = 0;
        this.rowLength = 0;
    }

    public Matrix(Vector... columns) throws IncompatibleError {
        int dimension = columns[0].elements.length;
        for (int i = 1; i < columns.length; i++) {
            if (columns[i].elements.length != dimension) {
                throw new IncompatibleError("All vectors are not of same dimension.");
            }
        }
        this.columns = columns;
        this.rowLength = dimension;
        this.colLength = columns.length;
    }


    // returns matrix with all 0s in cols and rows
    public Matrix(int col, int row) {
        this.columns = new Vector[col];
        for (int i = 0; i < col; i++) {
            columns[i] = new Vector(row);
        }

        this.colLength = col;
        this.rowLength = row;
    }

    public int getColLength() {
        return colLength;
    }

    public int getRowLength() {
        return rowLength;
    }

    // function to check if matrix has vector columns which are linearly independent, uses determinant function
    public boolean isLinearlyIndependent() throws IncompatibleError {
        if (this.determinant() == 0) {
            return false;
        }
        return true;
    }

    /**
     * returns the determinant score for this matrix. returns 0 if not linearly independent.
     * determinant function is a recursive function
     * @return determinant score
     */

    /** ACTUAL LINEAR ALGEBRA NOTES IN WHY DETERMINANT WORKS
     * All matrices has a row reduced echelon form (RREF). Reducing a matrix to this state makes it incredibly easy to see if vectors in a matrix
     * are linearly independent or not (just check if all columns have pivot numbers). For a matrix that is linearly independent, its RREF form
     * will be the identity matrix. We know that one of the properties of the determinant is that when it is acted on the identity matrix, it
     * returns 1. For any other matrix not linearly independent (meaning it is linearly dependent), there will be a zero vector as a column (as
     * it the matrix loses a piece of information to capture full its rank/dimension. You can use inductive reasoning starting from the calculations
     * of the 2 x 2 matrix to argue that for any k x k matrix (with one of the columns as a zero vector) the determinant calculation will return 0 because
     * the 2 x 2 matrix scenario returns 0. Likewise, for an identity matrix with size k x k, you can also use inductive reasoning starting from 2 x 2 case
     * that the determinant will be 1.
     *
     */
    public double determinant() throws IncompatibleError {
        // base cases
        // negative base case (to fail)
        if (this.colLength != this.rowLength) {
            throw new IncompatibleError("Matrix is rectangular. Determinant function can only be applied on square matrices.");
        }

        // important base case
        // A = {[a,b], [c,d]}
        // det(A) = ad - bc
        if (this.colLength == 2 && this.rowLength == 2) {

            // these two vectors are guaranteed to be R2 vectors
            double[] column1 = this.columns[0].getElements();
            double[] column2 = this.columns[1].getElements();

            return column1[0] * column2[1] - column1[1] * column2[0];
        }

        // first column is special in that it determines the procedure of determinant function
        Vector column1 = this.columns[0];
        double[] column1_elements = column1.getElements();


        return this.determinantHelper(column1_elements, column1_elements.length);
    }

    /**
     * helper method for determinant function. the purpose of this function is because it was hard to write a return statement with an unsepcified
     * number of pending operations
     * @param columns the first column of matrix
     * @param n the length of the first column of the matrix
     * @return
     * @throws IncompatibleError
     */
    public double determinantHelper(double[] columns, int n) throws IncompatibleError {
        if (n == 0) {
            return 0;
        }
        return columns[n-1] * ((n-1) % 2 == 0 ? 1 : -1) * this.omitRowColumn(0,n-1).determinant() + determinantHelper(columns, n-1);
    }

    /**
     * helper method for determinant function. omits a row and column of a matrix
     * @return
     */
    public Matrix omitRowColumn(int omitColumn, int omitRow) throws IncompatibleError {
        Matrix omittedMatrix = new Matrix(this.colLength - 1, this.rowLength - 1);
        int index = 0;
        for (int i = 0; i < this.colLength; i++, index++) {
            if (i != omitColumn) {
                omittedMatrix.columns[index] = columns[i].ignoreSpecificRow(omitRow);
            } else {
                index = index - 1;
            }
        }

        return omittedMatrix;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < this.columns.length; i++) {
            str.append(columns[i].toString());
            str.append(", ");
        }

        str.delete(str.length() - 2, str.length());
        return str.toString();
    }

}

