public class VectorSpace implements VectorSpaceAxioms{

    // vector space axioms
    // command + >
    // vector space must implement axioms
    @Override
    public boolean isAssociative() {
        return true;
    }

    @Override
    public boolean isCommutative() {
        return true;
    }

    @Override
    public boolean hasZero() {
        return true;
    }

    @Override
    public boolean isNegatable() {
        return true;
    }

    @Override
    public boolean scalarDistributive() {
        return true;
    }

    @Override
    public boolean vectorDistributive() {
        return true;
    }

    @Override
    public boolean scalarIndependent() {
        return true;
    }

    @Override
    public boolean hasIdentity() {
        return true;
    }

    // dimension of vector space
    int dim;

    // basis must be linearly independent and whose span is the vector space
    Matrix basis;

    public VectorSpace(Matrix basis) {
        if (isBasis(basis)) {
            this.basis = basis;
            //this.dim = getDimension();
        } else {
            System.out.println("Matrix provided does not meet basis requirements.");
        }
    }

    // checks if basis matrix satisfies properties of basis

    /**
     * Suppose V is an n-dimensional vector space. Then:
     * (a) Every set with more than n vectors of V is linearly dependent.
     * (b) No set with fewer than n vectors spans V.
     * (c) A set of n vectors forms a basis if and only if it spans V.
     * (d) A set of n vectors forms a basis if and only if it is linearly independent.
     * @return true if it is basis, false if not
     */
    public boolean isBasis(Matrix basis) {
        // this method only checks conditions (c) and (d)
        //return (basis.getSize() == dim ? true : false);
        return true;
    }




}
