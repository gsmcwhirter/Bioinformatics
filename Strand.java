import java.lang.StringBuilder;
/**
 * This class represents a strand of DNA or RNA
 * 
 * @author Gregory McWhirter and (your name)
 * @version 0.1
 */
public class Strand
{   
    /**
     * Codes the types of Strand that are legal
     * 
     * @author Gregory McWhirter
     * @version 0.1
     */
    public enum Type
    {
        /**
         * Indicates a DNA strand starting at the 3' end
         */
        THREE_PRIME, 
        /**
         * Indicates a DNA strand starting at the 5' end
         */
        FIVE_PRIME, 
        /**
         * Indicates an RNA strand
         */
        RNA
    }
    
    private Base[] seq;
    private Type type;
    private String stringRep;
    
    // STATIC METHODS
    /**
     * Converts string representations of bases to actual Base values
     * 
     * Prerequisites: seqInput is an array of single-character strings
     * 
     * @param seqInput the array of string bases to convert
     * @return the array of converted bases
     */
    public static Base[] stringsToBases(String[] seqInput)
    {
        Base[] seqBases = new Base[seqInput.length];
        for (int i = 0; i < seqInput.length; i++)
        {
            try
            {
                seqBases[i] = Base.valueOf(seqInput[i]);
            }
            catch (IllegalArgumentException e)
            {
                seqBases[i] = Base.X;
            }
        }
        
        return seqBases;
    }
    
    // CONSTRUCTORS
    
    /**
     * Constructs an empty strand of given type and length
     * 
     * @param stype the type of the strand (3', 5', or RNA)
     * @param length the length of the strand (in # of base pairs)
     */
    public Strand(Type stype, int length)
    {
        type = stype;
        //TODO: initialize seq with a new array of Base values
        //Replace the next line -- it is for default compilation purposes
        seq = new Base[]{};
    }
    
    /**
     * Constructs an strand of given type with the given contents
     * 
     * @param stype the type of the strand (3', 5', or RNA)
     * @param seqInput the sequence of base-pairs for the strand
     */
    public Strand(Type stype, String[] seqInput) throws BaseException
    {
        type = stype;
        //TODO: initialize seq with a new array of Base values
        //Replace the next line -- it is for default compilation purposes
        seq = new Base[]{};
        fill(seqInput);
    }
    
    /**
     * Constructs an strand of given type with the given contents
     * 
     * @param stype the type of the strand (3', 5', or RNA)
     * @param seqInput the sequence of base-pairs for the strand
     */
    public Strand(Type stype, Base[] seqInput) throws BaseException
    {
        type = stype;
        //TODO: initialize seq with a new array of Base values
        //Replace the next line -- it is for default compilation purposes
        seq = new Base[]{};
        fill(seqInput);
    }
    
    /**
     * Constructs an strand of given type with the given contents
     * 
     * @param stype the type of the strand (3', 5', or RNA)
     * @param seqInput the sequence of base-pairs for the strand
     */
    public Strand(Type stype, String seqInput) throws BaseException
    {
        type = stype;
        //TODO: initialize seq with a new array of Base values
        //Replace the next line -- it is for default compilation purposes
        seq = new Base[]{};
        fill(seqInput.split(""));
    }
    
    // PRIVATE NON-STATIC METHODS
    
    /**
     * Validates the bases to make sure they are allowed (no T in RNA, for example).
     * 
     */
    private void validate() throws BaseException
    {
        boolean okay = true;

        //TODO: check the bases in seq for validity
        //      If the type is RNA, the base U is not allowed
        //      If the type is DNA, the base T is not allowed
        //      If a disallowed type is present, set okay to false.
        
        if (!okay)
        {
            throw new BaseException();
        }
    }
    
    // PUBLIC NON-STATIC METHODS
    
    /**
     * Determines if two Strands are the same strand or not
     * 
     * @param otherObj the object to compare to the current strand (casted to a Strand inside)
     * @return true if they have the same type, length, and base sequence, false otherwise
     */
    public boolean equals(Object otherObj)
    {
        Strand other = (Strand)otherObj;
        //TODO: determine if the two strands are equal.
        //      Strands are equal if they have the same type,
        //      have the same length, and have identical
        //      sequences.
        
        return false;
    }
    
    /**
     * Returns the array of base pairs.
     * 
     * Warning: DOES NOT RETURN A COPY
     * 
     * @return the sequence of base pairs
     */
    public Base[] getSeq()
    {
        return seq;
    }
    
    /**
     * Returns the type of the strand (3', 5', or RNA)
     * 
     * @return the type of the strand
     */
    public Type getStrandType()
    {
        return type;
    }
    
    /**
     * Returns the number of bases in the strand
     * 
     * @return the number of bases in the strand
     */
    public int getLength()
    {
        return seq.length;
    }
    
    /**
     * Fills the strand with a sequence of base pairs. 
     * 
     * Truncates the input to the length of the internal array if it is longer.
     */
    public void fill(Base[] seqInput) throws BaseException
    {
        stringRep = null;
        
        //TODO: create a variable; its value should be the minimum of seqInput's length and seq's length
        
        //TODO: copy seqInput into seq. If seqInput has more elements,
        //      only copy how many will fit into seq.
        
        validate();
    }
    
    /**
     * Fills the strand with a sequence of base pairs. 
     * 
     * Truncates the input to the length of the internal array if it is longer.
     */
    public void fill(String[] seqInput) throws BaseException
    {
        fill(stringsToBases(seqInput));
    }
    
    /**
     * Fills the strand with a sequence of base pairs. 
     * 
     * Truncates the input to the length of the internal array if it is longer.
     */
    public void fill(String seqInput) throws BaseException
    {
        fill(seqInput.split(""));
    }
    
    /**
     * Gets the base sequence paired to the strand.
     * 
     * @param rna return the pair as RNA, not DNA
     * @return the pairs of the bases in the strand
     */
    public Base[] getPairSeq(boolean rna)
    {
        //TODO: create an array of Bases that is the pair sequence to the
        //      current strand.
        //      Pairings:
        //          C - G
        //          A - T (DNA)
        //          A - U (RNA)
        //          R - Y (R is A or G -- puRine; Y is C, T, or U -- pYrimidines)
        //          K - M (K is G, T, or U -- Keytones; M is A or C -- aMino groups)
        //          S, W, N - self (S is C or G -- Strong interaction; W is A, T, or U -- Weak interaction; N is anything)
        //          B - V (B is not-A; V is not-T/U)
        //          D - H (D is not-C; H is not-G)
        //          otherwise X
        //Replace the next line -- it is there to get it to compile
        return new Base[]{};
    }
    
    /**
     * Gets the base sequence paired to the strand.
     * 
     * If the strand is DNA, it returns the other DNA strand (3' -> 5', or 5' -> 3')
     * If the strand is RNA, it returns the paired RNA strand
     * 
     * @return the pairs of the bases in the strand
     */
    public Base[] getPairSeq()
    {
        return getPairSeq(type == Type.RNA);
    }
    
    /**
     * Gets a strand that is the pair of the current strand.
     * 
     * @param stype The strand type to return (3', 5', or RNA)
     * @return the Strand of the requested type that has a sequence paired to the current one.
     */
    public Strand getPairStrand(Type stype) throws BaseException
    {
        return new Strand(stype, getPairSeq(stype == Type.RNA));
    }
    
    /**
     * Gets a strand that is the pair of the current strand.
     * 
     * @param forceRNA Force the pair to RNA if it isn't going to be already
     * @return the Strand that has a sequence paired to the current one.
     */
    public Strand getPairStrand(boolean forceRNA) throws BaseException
    {
        Type newType;
        if (forceRNA)
        {
            newType = Type.RNA;
        }
        else if (type == Type.RNA)
        {
            newType = Type.RNA;
        }
        else if (type == Type.THREE_PRIME)
        {
            newType = Type.FIVE_PRIME;
        }
        else {
            newType = Type.THREE_PRIME;
        }
        return getPairStrand(newType);
    }
    
    /**
     * Gets a strand that is the pair of the current strand.
     * 
     * @return the Strand that has a sequence paired to the current one (DNA->DNA with 3'/5' swap, RNA->RNA).
     */
    public Strand getPairStrand() throws BaseException
    {
        return getPairStrand(false);
    }
    
    /**
     * Gets the current strand's reverse (so instead of starting at 3', start at 5', or vice-versa)
     * 
     * Note: this does not get the pair, it only reverses the direction.
     * 
     * @return the Strand that is the reverse of the current one.
     */
    public Strand getReverseStrand() throws BaseException
    {
        Type newType;
        
        //TODO: determine the value of newType
        //      If the current type is RNA, keep the new type as RNA
        //      If the current type is 3', change it to 5'
        //      If the current type if 5', change it to 3'
        //Remove the following line -- it is for default compilation
        newType = Type.RNA;
        
        Base[] rev;
        //TODO: create a new array of Bases that is the reverse of the current
        //      sequence. Store the result in rev.
        //Remove the following line -- it is for default compilation
        rev = new Base[]{};
        
        return new Strand(newType, rev);
    }
    
    /**
     * Generate a substrand of the current strand (works like substring)
     * 
     * @param start the index of the base to start the substrand at
     * @param end the index of the base to end the substrand at (does not include this base)
     * @return a new Strand that is a substrand of this one, from start to end
     */
    public Strand getSubStrand(int start, int end) throws BaseException
    {
        Base[] newBases;
        //TODO: create a new array of bases that is a substrand of the
        //      current strand. The index start should be included, but not
        //      end. Don't worry about index out of bounds errors.
        //      Store the result in newBases.
        //Remove the following line -- it is for default compilation.
        newBases = new Base[]{};
        
        return new Strand(type, newBases);
    }
    
    /**
     * Generate a substrand of the current strand (works like substring)
     * 
     * @param start the index of the base to start the substrand at
     * @return a new Strand that is a substrand of this one, from start to the end of the strand
     */
    public Strand getSubStrand(int start) throws BaseException
    {
        return getSubStrand(start, seq.length);
    }
    
    /**
     * Finds where a given base sequence is within the strand
     * 
     * @param subseq the sequence to find
     * @param startAt the index to start looking at
     * @return the index in the strand where the subsequence was found, or -1 if it isn't found.
     */
    public int find(Base[] subseq, int startAt)
    {
        //TODO: Determine if the subsequence is in this strand's sequence or not (at or after startAt).
        //      If the subseq contains a multi-base character (see getPairSeq notes)
        //      any of the bases the multi-base represents should match.
        //      Any multi-bases in this Strands sequence need to match exactly.
        //
        //      Example: N as an element of subseq matches anything, but
        //          N as an element of this strand's sequence is only matched by another N.
        //
        //      If there is a match, return the index of the first location of the match.
        
        return -1;
    }
    
    /**
     * Finds where a given base sequence is within the strand
     * 
     * @param subseq the sequence to find
     * @return the index in the strand where the subsequence was found, or -1 if it isn't found.
     */
    public int find(Base[] subseq)
    {
        return find(subseq, 0);
    }
    
    /**
     * Finds where a given base sequence is within the strand
     * 
     * @param subseq the sequence to find
     * @param startAt the index to start looking at
     * @return the index in the strand where the subsequence was found, or -1 if it isn't found.
     */
    public int find(Strand subseq, int startAt)
    {
        return find(subseq.getSeq(), startAt);
    }
    
    /**
     * Finds where a given base sequence is within the strand
     * 
     * @param subseq the sequence to find
     * @return the index in the strand where the subsequence was found, or -1 if it isn't found.
     */
    public int find(Strand subseq)
    {
        return find(subseq.getSeq());
    }
    
    /**
     * Finds where a given base sequence is within the strand
     * 
     * @param subseq the sequence to find
     * @param startAt the index to start looking at
     * @return the index in the strand where the subsequence was found, or -1 if it isn't found.
     */
    public int find(String[] subseq, int startAt)
    {
        return find(stringsToBases(subseq), startAt);
    }
    
    /**
     * Finds where a given base sequence is within the strand
     * 
     * @param subseq the sequence to find
     * @return the index in the strand where the subsequence was found, or -1 if it isn't found.
     */
    public int find(String[] subseq)
    {
        return find(subseq, 0);
    }
    
    /**
     * Finds where a given base sequence is within the strand
     * 
     * @param subseq the sequence to find
     * @param startAt the index to start looking at
     * @return the index in the strand where the subsequence was found, or -1 if it isn't found.
     */
    public int find(String subseq, int startAt)
    {
        return find(subseq.split(""), startAt);
    }
    
    /**
     * Finds where a given base sequence is within the strand
     * 
     * @param subseq the sequence to find
     * @return the index in the strand where the subsequence was found, or -1 if it isn't found.
     */
    public int find(String subseq)
    {
        return find(subseq, 0);
    }
    
    /**
     * Finds where a given base sequence is within the strand
     * 
     * @param subseq the sequence to find
     * @param startAt the index to start looking at
     * @return the index in the strand where the subsequence was found, or -1 if it isn't found.
     */
    public int find(Base subseq, int startAt)
    {
        return find(new Base[]{subseq}, startAt);
    }
    
    /**
     * Finds where a given base sequence is within the strand
     * 
     * @param subseq the sequence to find
     * @return the index in the strand where the subsequence was found, or -1 if it isn't found.
     */
    public int find(Base subseq)
    {
        return find(subseq, 0);
    }
    
    /**
     * Finds the location of a full codon.
     * 
     * Prerequisites: 
     *      codon is an array of exactly 3 bases
     *      startAt >= geneStart
     * 
     * 
     * @param codon an array of exactly 3 bases to look for
     * @param geneStart the index of the strand where the gene starts
     * @param startAt the index of the strand to start looking for the codon
     */
    public int findCodon(Base[] codon, int geneStart, int startAt)
    {
        if (codon.length != 3)
        {
            return -1;
        }
        
        //TODO: Determine if there is a codon that matches the requested sequence.
        //      Only look after the geneStart location and after the startAt location.
        //      (assume that startAt >= geneStart)
        //
        //      Note: you are trying to find full codons, which are always 3 bases long.
        //      This also means that you need to make sure that there are only full codons
        //      between the start of the gene and where you think a match might be.
        //
        //      If the codon contains a multi-base character (see getPairSeq notes)
        //      any of the bases the multi-base represents should match.
        //      Any multi-bases in this Strands sequence need to match exactly.
        //
        //      Example: N as an element of codon matches anything, but
        //          N as an element of this strand's sequence is only matched by another N in codon.
        //
        //      If there is a match, return the index of the first location of the match.
        //
        
        return -1;
    }
    
    /**
     * Finds the location of a full codon.
     * 
     * Prerequisites: 
     *      codon is an array of exactly 3 bases.
     * 
     * 
     * @param codon an array of exactly 3 bases to look for
     * @param geneStart the index of the strand where the gene starts
     */
    public int findCodon(Base[] codon, int geneStart)
    {
        return findCodon(codon, geneStart, geneStart);
    }
    
    /**
     * Finds the location of a full codon.
     * 
     * Prerequisites: 
     *      codon is an array of exactly 3 bases.
     *      startAt >= geneStart
     * 
     * 
     * @param codon an array of exactly 3 bases to look for
     * @param geneStart the index of the strand where the gene starts
     * @param startAt the index of the strand to start looking for the codon
     */
    public int findCodon(String[] codon, int geneStart, int startAt)
    {
        return findCodon(stringsToBases(codon), geneStart, startAt);
    }
    
    /**
     * Finds the location of a full codon.
     * 
     * Prerequisites: 
     *      codon is an array of exactly 3 bases.
     * 
     * 
     * @param codon an array of exactly 3 bases to look for
     * @param geneStart the index of the strand where the gene starts
     */
    public int findCodon(String[] codon, int geneStart)
    {
        return findCodon(codon, geneStart, geneStart);
    }
    
    /**
     * Finds the location of a full codon.
     * 
     * Prerequisites: 
     *      codon is a String of exactly 3 bases.
     *      startAt >= geneStart
     * 
     * 
     * @param codon a String of exactly 3 bases to look for
     * @param geneStart the index of the strand where the gene starts
     * @param startAt the index of the strand to start looking for the codon
     */
    public int findCodon(String codon, int geneStart, int startAt)
    {
        return findCodon(codon.split(""), geneStart, startAt);
    }
    
    /**
     * Finds the location of a full codon.
     * 
     * Prerequisites: 
     *      codon is a String of exactly 3 bases.
     * 
     * @param codon a String of exactly 3 bases to look for
     * @param geneStart the index of the strand where the gene starts
     */
    public int findCodon(String codon, int geneStart)
    {
        return findCodon(codon, geneStart, geneStart);
    }
    
    /**
     * Finds the location of the next start codon ATG
     * 
     * Prerequisites: the strand should be in 5' orientation.
     * 
     * Note: This could find spurious starts if asked to start in
     * the middle of another gene.
     * 
     * @param startAt the location in the sequence to start looking
     * @return the index of the A in the ATG sequence, or -1 if not found
     */
    public int findGeneStart(int startAt)
    {
        //TODO: find the location, if any of the first
        //      ATG sequence starting at startAt
        return -1;
    }
    
    /**
     * Finds the location of the next start codon ATG
     * 
     * Prerequisites: the strand should be in 5' orientation.
     * 
     * Note: This could find spurious starts if asked to start in
     * the middle of another gene.
     * 
     * @return the index of the A in the ATG sequence, or -1 if not found
     */
    public int findGeneStart()
    {
        return findGeneStart(0);
    }
    
    /**
     * Finds the location of the next stop codon (TGA/TAA/TAG) after
     * the start of the gene.
     * 
     * Prerequisites: the strand should be in 5' orientation.
     * 
     * @param geneStart the index of the start of the gene to consider
     * @return the index of the T in the stop codon, or -1 if not found
     * 
     */
    public int findGeneStop(int geneStart)
    {
        //TODO: find the location of the next stop codon (TGA/TAA/TAG)
        //      after the start of the gene.
        return -1;
    }
    
    /**
     * Generate a string representation of the strand.
     * 
     * The representation is memoized.
     * 
     */
    public String toString()
    {
        if (stringRep == null)
        {
            StringBuilder sb = new StringBuilder();
            switch (type)
            {
                case THREE_PRIME:
                    sb.append("DNA 3'-");
                    break;
                case FIVE_PRIME:
                    sb.append("DNA 5'-");
                    break;
                case RNA:
                    sb.append("RNA ");
                    break;
            }
            
            for (int i = 0; i < seq.length; i++)
            {
                sb.append(seq[i]); // Java magic with Enum types -- converts to string.
            }
            
            switch (type)
            {
                case THREE_PRIME:
                    sb.append("-5'");
                    break;
                case FIVE_PRIME:
                    sb.append("-3'");
                    break;
            }
            
            stringRep = sb.toString();
        }
        
        return stringRep;
    }
    
}
