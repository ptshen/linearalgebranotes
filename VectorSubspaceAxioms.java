/**
 * Let V be a R-vector space and a nonempty subset U ⊆V . If U with the operations
 * of V is itself a R-vector space, then U is called a subspace of V
 */

interface VectorSubspaceAxioms extends VectorSpaceAxioms {
    //(U1) if u, v ∈U, then u + v ∈U, (U2) if a ∈R and u ∈U, then au ∈U. (U is closed under vector addition)
    //(U is closed under scalar multiplication)
    boolean closedAddition();
    boolean closedScaling();
}
