import java.util.Arrays;

public class Vector {
    double[] elements;


    public Vector() {
        this.elements = null;
    }

    public Vector(int length) {
        this.elements = new double[length];
    }

    public Vector(double... elements) {
        this.elements = elements;
    }

    public double[] getElements() {
        return this.elements;
    }

    public double[] getSpecificElements(int start, int end) {
        return Arrays.copyOfRange(this.elements, start, end);
    }

    /**
     * function is used mainly for determinant calculation
     * @param omit
     * @return
     */
    public Vector ignoreSpecificRow(int omit) throws IncompatibleError {
        if (omit > this.elements.length - 1) {
            throw new IncompatibleError("Requested row to omit is out of bounds for vector.");
        }
        double[] omittedVector = new double[this.elements.length - 1];
        for (int i = 0, index = 0, length = this.elements.length; i < length; i++, index++) {
            if (i != omit) {
                omittedVector[index] = this.elements[i];
            } else {
                index--;
            }
        }

        return new Vector(omittedVector);
    }


    /**
     * returns the dot product of two vectors.
     * @param v2 vector you want to compare to
     * @return the dot product
     * @throws IncompatibleError
     */

    /*
    Geometrically, the dot product can be interpreted as |a| * |b| * cos(theta).
    Another way to view it that it is the magnetic of the projection vector of a onto b (vice versa), times the
    magnitude of the vector that got projected onto.
     */
    public double dotProduct(Vector v2) throws IncompatibleError {
        double dotProduct = 0;

        if (this.elements.length == v2.elements.length) {
            for (int i = 0; i < this.elements.length; i++) {
                dotProduct += this.elements[i] + v2.elements[i];
            }
        } else {
            // throw error
            throw new IncompatibleError("Input vectors have different dimensions.");
        }
        return dotProduct;
    }

    /**
     * returns a projection vector. v2 is projected onto this vector.
     * @param v2
     * @return
     */
    public Vector projVector(Vector v2) {
        return null;
    }


    // toString for printing ease
    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append("[");

        for (int i = 0; i < this.elements.length; i++) {
            str.append(this.elements[i]);
            str.append(", ");
        }
        str.delete(str.length() - 2, str.length());
        str.append("]");

        return str.toString();

    }

}

class IncompatibleError extends Exception {
    public IncompatibleError(String err) {
        super(err);
    }
}
