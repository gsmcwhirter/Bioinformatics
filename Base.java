
/**
 * FASTA DNA/RNA base notations
 * 
 * @author Gregory McWhirter
 * @version 0.1
 */
public enum Base
{
    /**
     * Adenine
     */
    A,
    /**
     * Thymine
     */
    T,
    /**
     * Guanine
     */
    G,
    /**
     * Cytosine
     */
    C,
    /**
     * Uracil
     */
    U,
    /**
     * Adenine or Guanine (puRines)
     */
    R,
    /**
     * Cytosine, Thymine, or Uracil (pYrimidines)
     */
    Y,
    /**
     * Guanine, Thymine, or Uracil (Keytones)
     */
    K,
    /**
     * Adenine or Cytosine (aMino Groups)
     */
    M,
    /**
     * Cytosine or Guanine (Strong interactions)
     */
    S,
    /**
     * Adenine, Thymine, or Uracil (Weak interactions)
     */
    W,
    /**
     * Not Adenine (B is after A)
     */
    B,
    /**
     * Not Cytosine (D is after C)
     */
    D,
    /**
     * Not Guanine (H is after G)
     */
    H,
    /**
     * Not Thymine or Uracil (V is after U)
     */
    V,
    /**
     * Any base (aNy / Nucleotide)
     */
    N,
    /**
     * Gap / other
     */
    X 
}
