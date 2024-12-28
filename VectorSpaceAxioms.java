//1. (u + v) + w = u + (v + w).
//2. u + v = v + u.
//3. There exists a unique neutral element in V , denoted 0, such that v + 0= v, for all v in V.
//4. For each v in V , there exists a unique opposite in V , denoted−v, such that v + (−v) = 0.
//5. k(u + v) = ku + kv.
//6. (c + k)v = cv + kv.
//7. c(kv) = (ck)v.
//8. 1v = v.

interface VectorSpaceAxioms {
    boolean isAssociative();
    boolean isCommutative();
    boolean hasZero();
    boolean isNegatable();
    boolean scalarDistributive();
    boolean vectorDistributive();
    boolean scalarIndependent();
    boolean hasIdentity();
}
