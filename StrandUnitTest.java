import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StrandUnitTest.
 *
 * @author  Gregory McWhirter
 * @version 0.1
 */
public class StrandUnitTest
{
    /**
     * Default constructor for test class StrandUnitTest
     */
    public StrandUnitTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testStrandStringsToBases()
    {
        String[] input1 = {"A","C","G","T","U","X","Z",""};
        String[] input2 = {"C","G","A","U","T","Z","","X"};
        String[] input3 = "ATGCURYKMSWBDHVNX".split("");
        
        Base[] output1 = {Base.A, Base.C, Base.G, Base.T, Base.U, Base.X, Base.X, Base.X};
        Base[] output2 = {Base.C, Base.G, Base.A, Base.U, Base.T, Base.X, Base.X, Base.X};
        Base[] output3 = Base.values();
        
        assertArrayEquals("Conversion of \"ACGTUXZ*\" was incorrect", output1, Strand.stringsToBases(input1));
        assertArrayEquals("Conversion of \"CGAUTXZ*X\" was incorrect", output2, Strand.stringsToBases(input2));
        assertArrayEquals("Conversion of \"ATGCURYKMSWBDHVNX\" was incorrect", output3, Strand.stringsToBases(input3));
    }
    
    @Test
    public void testStrandTypeLength()
    {
        Strand strand;
        strand = new Strand(StrandType.THREE_PRIME, 5);
        assertEquals("Strand type not properly set for 3'", StrandType.THREE_PRIME, strand.getStrandType());
        assertEquals("Strand length not properly set for 3'", 5, strand.getLength());
        
        strand = new Strand(StrandType.FIVE_PRIME, 6);
        assertEquals("Strand type not properly set for 5'", StrandType.FIVE_PRIME, strand.getStrandType());
        assertEquals("Strand length not properly set for 5'", 6, strand.getLength());
        
        strand = new Strand(StrandType.RNA, 7);
        assertEquals("Strand type not properly set for RNA", StrandType.RNA, strand.getStrandType());
        assertEquals("Strand length not properly set for RNA", 7, strand.getLength());
    }
    
    @Test
    public void testStrandTypeStringArray()
    {
        Strand strand;
        try
        {
            strand = new Strand(StrandType.THREE_PRIME, new String[] {"A","C","G","T","C","G"});
            assertEquals("Strand type not properly set for 3'", StrandType.THREE_PRIME, strand.getStrandType());
            assertEquals("Strand length not set properly for 3'", 6, strand.getLength());
            assertArrayEquals("Strand contents not set properly for 3'", new Base[] {Base.A, Base.C, Base.G, Base.T, Base.C, Base.G}, strand.getSeq());
        }
        catch (BaseException e)
        {
            assertTrue("Legal bases threw BaseException for 3'", false);
        }
        
        try
        {
            strand = new Strand(StrandType.FIVE_PRIME, new String[] {"A","C","G","T","C"});
            assertEquals("Strand length not set properly for 5'", 5, strand.getLength());
            assertEquals("Strand type not properly set for 5'", StrandType.FIVE_PRIME, strand.getStrandType());
            assertArrayEquals("Strand contents not set properly for 5'", new Base[]{Base.A, Base.C, Base.G, Base.T, Base.C}, strand.getSeq());
        }
        catch (BaseException e)
        {
            assertTrue("Legal bases threw BaseException for 5'", false);
        }
        
        try
        {
            strand = new Strand(StrandType.RNA, new String[] {"A","C","G","U"});
            assertEquals("Strand type not properly set for RNA", StrandType.RNA, strand.getStrandType());
            assertEquals("Strand length not set properly for RNA", 4, strand.getLength());
            assertArrayEquals("Strand contents not set properly for RNA", new Base[]{Base.A, Base.C, Base.G, Base.U}, strand.getSeq());
        }
        catch (BaseException e)
        {
            assertTrue("Legal bases threw BaseException for RNA", false);
        }
    }
    
    @Test
    public void testStrandTypeString()
    {
        Strand strand;
        try
        {
            strand = new Strand(StrandType.THREE_PRIME, "ACGTCG");
            assertEquals("Strand type not properly set for 3'", StrandType.THREE_PRIME, strand.getStrandType());
            assertEquals("Strand length not set properly for 3'", 6, strand.getLength());
            assertArrayEquals("Strand contents not set properly for 3'", new Base[] {Base.A, Base.C, Base.G, Base.T, Base.C, Base.G}, strand.getSeq());
        }
        catch (BaseException e)
        {
            assertTrue("Legal bases threw BaseException for 3'", false);
        }
        
        try
        {
            strand = new Strand(StrandType.FIVE_PRIME, "ACGTC");
            assertEquals("Strand length not set properly for 5'", 5, strand.getLength());
            assertEquals("Strand type not properly set for 5'", StrandType.FIVE_PRIME, strand.getStrandType());
            assertArrayEquals("Strand contents not set properly for 5'", new Base[]{Base.A, Base.C, Base.G, Base.T, Base.C}, strand.getSeq());
        }
        catch (BaseException e)
        {
            assertTrue("Legal bases threw BaseException for 5'", false);
        }
        
        try
        {
            strand = new Strand(StrandType.RNA, "ACGU");
            assertEquals("Strand type not properly set for RNA", StrandType.RNA, strand.getStrandType());
            assertEquals("Strand length not set properly for RNA", 4, strand.getLength());
            assertArrayEquals("Strand contents not set properly for RNA", new Base[]{Base.A, Base.C, Base.G, Base.U}, strand.getSeq());
        }
        catch (BaseException e)
        {
            assertTrue("Legal bases threw BaseException for RNA", false);
        }
    }
    
    @Test
    public void testStrandTypeBases()
    {
        Strand strand;
        Base[] bases;
        try
        {
            bases = new Base[] {Base.A, Base.C, Base.G, Base.T, Base.C};
            strand = new Strand(StrandType.THREE_PRIME, bases);
            assertEquals("Strand type not properly set for 3'", StrandType.THREE_PRIME, strand.getStrandType());
            assertEquals("Strand length not set properly for 3'", 5, strand.getLength());
            assertArrayEquals("Strand contents not set properly for 3'", bases, strand.getSeq());
            assertNotSame("Strand contents not copied for 3'", bases, strand.getSeq()); 
        }
        catch (BaseException e)
        {
            assertTrue("Legal bases threw BaseException for 3'", false);
        }
        
        try
        {
            bases = new Base[]{Base.A, Base.C, Base.G, Base.T};
            strand = new Strand(StrandType.FIVE_PRIME, bases);
            assertEquals("Strand length not set properly for 5'", 4, strand.getLength());
            assertEquals("Strand type not properly set for 5'", StrandType.FIVE_PRIME, strand.getStrandType());
            assertArrayEquals("Strand contents not set properly for 5'", bases, strand.getSeq());
            assertNotSame("Strand contents not copied for 5'", bases, strand.getSeq());
        }
        catch (BaseException e)
        {
            assertTrue("Legal bases threw BaseException for 5'", false);
        }
        
        try
        {
            bases = new Base[]{Base.C, Base.G, Base.A, Base.U, Base.U};
            strand = new Strand(StrandType.RNA, bases);
            assertEquals("Strand type not properly set for RNA", StrandType.RNA, strand.getStrandType());
            assertEquals("Strand length not set properly for RNA", 5, strand.getLength());
            assertArrayEquals("Strand contents not set properly for RNA", bases, strand.getSeq());
            assertNotSame("Strand contents not copied for RNA", bases, strand.getSeq());
        }
        catch (BaseException e)
        {
            assertTrue("Legal bases threw BaseException for RNA", false);
        }
    }
    
    @Test
    public void testStrandValidateBasesConstructor()
    {
        Strand strand;
        boolean thrown;
        
        try
        {
            strand = new Strand(StrandType.THREE_PRIME, new Base[] {Base.U, Base.C, Base.G, Base.T, Base.C});
            thrown = false;
        }
        catch (BaseException e)
        {
            thrown = true;
        }
        assertTrue("Illegal base not caught for 3'", thrown);
        
        try
        {
            strand = new Strand(StrandType.FIVE_PRIME, new Base[] {Base.U, Base.C, Base.G, Base.T, Base.C});
            thrown = false;
        }
        catch (BaseException e)
        {
            thrown = true;
        }
        assertTrue("Illegal base not caught for 5'", thrown);
        
        try
        {
            strand = new Strand(StrandType.RNA, new Base[] {Base.T, Base.C, Base.G, Base.T, Base.C});
            thrown = false;
        }
        catch (BaseException e)
        {
            thrown = true;
        }
        assertTrue("Illegal base not caught for RNA", thrown);
    }

    @Test
    public void testStrandValidateStringArrayConstructor()
    {
        Strand strand;
        boolean thrown;
        
        String[] illegals35 = {"U"};
        String[] illegalsR = {"T"};
        
        for (String base : illegals35)
        {
            try
            {
                strand = new Strand(StrandType.THREE_PRIME, new String[] {base});
                thrown = false;
            }
            catch (BaseException e)
            {
                thrown = true;
            }
            assertTrue("Illegal base "+base+" not caught for 3'", thrown);
            
            try
            {
                strand = new Strand(StrandType.FIVE_PRIME, new String[] {base});
                thrown = false;
            }
            catch (BaseException e)
            {
                thrown = true;
            }
            assertTrue("Illegal base "+base+" not caught for 5'", thrown);
        }
        
        for (String base : illegalsR)
        {
            try
            {
                strand = new Strand(StrandType.RNA, new String[] {base});
                thrown = false;
            }
            catch (BaseException e)
            {
                thrown = true;
            }
            assertTrue("Illegal base "+base+" not caught for RNA", thrown);
        }
    }
    
    @Test
    public void testStrandValidateStringConstructor()
    {
        Strand strand;
        boolean thrown;
        
        String[] illegals35 = {"U"};
        String[] illegalsR = {"T"};
        
        for (String base : illegals35)
        {
            try
            {
                strand = new Strand(StrandType.THREE_PRIME, base);
                thrown = false;
            }
            catch (BaseException e)
            {
                thrown = true;
            }
            assertTrue("Illegal base "+base+" not caught for 3'", thrown);
            
            try
            {
                strand = new Strand(StrandType.FIVE_PRIME, base);
                thrown = false;
            }
            catch (BaseException e)
            {
                thrown = true;
            }
            assertTrue("Illegal base "+base+" not caught for 5'", thrown);
        }
        
        for (String base : illegalsR)
        {
            try
            {
                strand = new Strand(StrandType.RNA, base);
                thrown = false;
            }
            catch (BaseException e)
            {
                thrown = true;
            }
            assertTrue("Illegal base "+base+" not caught for RNA", thrown);
        }
    }
    
    @Test
    public void testStrandValidateFillStrings()
    {
        Strand strand3 = new Strand(StrandType.THREE_PRIME, 1);
        Strand strand5 = new Strand(StrandType.FIVE_PRIME, 1);
        Strand strandR = new Strand(StrandType.RNA, 1);
        boolean thrown = false;
        
        String[] bases35 = {"A","C","G","T"};
        String[] illegals35 = {"U"};
        
        String[] basesR = {"A","C","G","U"};
        String[] illegalsR = {"T"};
        
        for (String base : bases35)
        {
            try {
                strand3.fill(new String[]{base});
                thrown = false;
            } catch (BaseException e){thrown = true;}
            assertTrue("strand3 fill with "+base+" should not fail", !thrown);
            
            try {
                strand3.fill(base);
                thrown = false;
            } catch (BaseException e){thrown = true;}
            assertTrue("strand3 fill with "+base+" as string should not fail", !thrown);
            
            try {
                strand5.fill(new String[]{base});
                thrown = false;
            } catch (BaseException e){thrown = true;}
            assertTrue("strand5 fill with "+base+" should not fail", !thrown);

            try {
                strand5.fill(base);
                thrown = false;
            } catch (BaseException e){thrown = true;}
            assertTrue("strand5 fill with "+base+" as string should not fail", !thrown);
        }
        
        for (String base : illegals35)
        {
            try {
                strand3.fill(new String[]{base});
                thrown = false;
            } catch (BaseException e){thrown = true;}
            assertTrue("strand3 fill with "+base+" should fail", thrown);
            
            try {
                strand3.fill(base);
                thrown = false;
            } catch (BaseException e){thrown = true;}
            assertTrue("strand3 fill with "+base+" as string should fail", thrown);

            try {
                strand5.fill(new String[]{base});
                thrown = false;
            } catch (BaseException e){thrown = true;}
            assertTrue("strand5 fill with "+base+" should fail", thrown);
            
            try {
                strand5.fill(base);
                thrown = false;
            } catch (BaseException e){thrown = true;}
            assertTrue("strand5 fill with "+base+" as string should fail", thrown);
        }
        
        for (String base : basesR)
        {
            try {
                strandR.fill(new String[]{base});
                thrown = false;
            } catch (BaseException e){thrown = true;}
            assertTrue("strandR fill with "+base+" should not fail", !thrown);
            
            try {
                strandR.fill(base);
                thrown = false;
            } catch (BaseException e){thrown = true;}
            assertTrue("strandR fill with "+base+" as string should not fail", !thrown);
        }
        
        for (String base : illegalsR)
        {
            try {
                strandR.fill(new String[]{base});
                thrown = false;
            } catch (BaseException e){thrown = true;}
            assertTrue("strandR fill with "+base+" should fail", thrown);
            
            try {
                strandR.fill(base);
                thrown = false;
            } catch (BaseException e){thrown = true;}
            assertTrue("strandR fill with "+base+" as string should fail", thrown);
        }
        
    }
    
    @Test
    public void testStrandValidateFillBases()
    {
        Strand strand3 = new Strand(StrandType.THREE_PRIME, 1);
        Strand strand5 = new Strand(StrandType.FIVE_PRIME, 1);
        Strand strandR = new Strand(StrandType.RNA, 1);
        boolean thrown = false;
        
        Base[] bases35 = {Base.A, Base.C, Base.G, Base.T};
        Base[] illegals35 = {Base.U};
        
        Base[] basesR = {Base.A, Base.C, Base.G, Base.U};
        Base[] illegalsR = {Base.T};
        
        for (Base base : bases35)
        {
            try {
                strand3.fill(new Base[]{base});
                thrown = false;
            } catch (BaseException e){thrown = true;}
            assertTrue("strand3 fill with Base "+base+" should not fail", !thrown);
            
            try {
                strand5.fill(new Base[]{base});
                thrown = false;
            } catch (BaseException e){thrown = true;}
            assertTrue("strand5 fill with Base "+base+" should not fail", !thrown);
        }
        
        for (Base base : illegals35)
        {
            try {
                strand3.fill(new Base[]{base});
                thrown = false;
            } catch (BaseException e){thrown = true;}
            assertTrue("strand3 fill with Base "+base+" should fail", thrown);

            try {
                strand5.fill(new Base[]{base});
                thrown = false;
            } catch (BaseException e){thrown = true;}
            assertTrue("strand5 fill with Base "+base+" should fail", thrown);
        }
        
        for (Base base : basesR)
        {
            try {
                strandR.fill(new Base[]{base});
                thrown = false;
            } catch (BaseException e){thrown = true;}
            assertTrue("strandR fill with Base "+base+" should not fail", !thrown);
        }
        
        for (Base base : illegalsR)
        {
            try {
                strandR.fill(new Base[]{base});
                thrown = false;
            } catch (BaseException e){thrown = true;}
            assertTrue("strandR fill with Base "+base+" should fail", thrown);
        }
    }
    
    @Test
    public void testStrandLength()
    {
        Strand strand3 = new Strand(StrandType.THREE_PRIME, 3);
        Strand strand5 = new Strand(StrandType.FIVE_PRIME, 4);
        Strand strandR = new Strand(StrandType.RNA, 5);
        
        assertEquals("getLength() incorrect for 3' called with length 3", 3, strand3.getLength());
        assertEquals("getLength() incorrect for 5' called with length 4", 4, strand5.getLength());
        assertEquals("getLength() incorrect for RNA called with length 5", 5, strandR.getLength());
    }
    
    @Test
    public void testStrandEquals()
    {
        try
        {
            Strand strand3a = new Strand(StrandType.THREE_PRIME, new String[]{"A","C","G","T"});
            Strand strand3b = new Strand(StrandType.THREE_PRIME, new String[]{"A","C","G","T"});
            Strand strand3c = new Strand(StrandType.THREE_PRIME, new String[]{"A","G","C","T"});
            Strand strand3d = new Strand(StrandType.THREE_PRIME, new String[]{"A","C","G"});
            Strand strand3e = new Strand(StrandType.THREE_PRIME, new String[]{"A","C","G","T", "T"});
            
            Strand strand5a = new Strand(StrandType.FIVE_PRIME, new String[]{"A","C","G","T"});
            Strand strand5b = new Strand(StrandType.FIVE_PRIME, new String[]{"A","C","G","T"});
            Strand strand5c = new Strand(StrandType.FIVE_PRIME, new String[]{"A","G","C","T"});
            Strand strand5d = new Strand(StrandType.FIVE_PRIME, new String[]{"A","C","G"});
            Strand strand5e = new Strand(StrandType.FIVE_PRIME, new String[]{"A","C","G","T","T"});
            
            Strand strandRa = new Strand(StrandType.RNA, new String[]{"A","C","G"});
            Strand strandRb = new Strand(StrandType.RNA, new String[]{"A","C","G"});
            Strand strandRc = new Strand(StrandType.RNA, new String[]{"A","U","G"});
            Strand strandRd = new Strand(StrandType.RNA, new String[]{"A","C","G","G"});
            Strand strandRe = new Strand(StrandType.RNA, new String[]{"A","C"});
            
            assertTrue("3'-ACGT should equal 3'-ACGT", strand3a.equals(strand3b));
            assertEquals("3'-ACGT should equal 3'-ACGT in a test", strand3a, strand3b);
            assertFalse("3'-ACGT should not equal 3'-AGCT", strand3a.equals(strand3c));
            assertFalse("3'-ACGT should not equal 3'-ACG", strand3a.equals(strand3d));
            assertFalse("3'-ACGT should not equal 3'-ACGTT", strand3a.equals(strand3e));

            assertTrue("5'-ACGT should equal 5'-ACGT", strand5a.equals(strand5b));
            assertEquals("5'-ACGT should equal 5'-ACGT in a test", strand5a, strand5b);
            assertFalse("5'-ACGT should not equal 5'-AGCT", strand5a.equals(strand5c));
            assertFalse("5'-ACGT should not equal 5'-ACG", strand5a.equals(strand5d));
            assertFalse("5'-ACGT should not equal 5'-ACGTT", strand5a.equals(strand5e));
            
            assertTrue("RNA ACG should equal RNA ACG", strandRa.equals(strandRb));
            assertEquals("RNA ACG should equal RNA ACG in a test", strandRa, strandRb);
            assertFalse("RNA ACG should not equal RNA AUG", strandRa.equals(strandRc));
            assertFalse("RNA ACG should not equal RNA ACGG", strandRa.equals(strandRd));
            assertFalse("RNA ACG should not equal RNA AC", strandRa.equals(strandRe));
            
            assertFalse("3'-ACGT should not equal 5'-ACGT", strand3a.equals(strand5a));
            assertFalse("5'-ACGT should not equal 3'-ACGT", strand5a.equals(strand3a));
            assertFalse("3'-ACG should not equal RNA ACG", strand3d.equals(strandRa));
            assertFalse("RNA ACG should not equal 3'-ACG", strandRa.equals(strand3d));
            assertFalse("5'-ACG should not equal RNA ACG", strand5d.equals(strandRa));
            assertFalse("RNA ACG should not equal 5'-ACG", strandRa.equals(strand5d));
        }
        catch (BaseException e)
        {
            assertTrue("A strand threw when it shouldn't have.", false);
        }
    }
    
    @Test
    public void testStrandPairSeq()
    {
        try
        {
            Strand strand3 = new Strand(StrandType.THREE_PRIME, new String[]{"A","C","G","T","A"});
            Strand strand5 = new Strand(StrandType.FIVE_PRIME, new String[]{"A","C","G","T","A"});
            Strand strandR = new Strand(StrandType.RNA, new String[]{"U","G","C","A","U"});
            
            Base[] pair35 = {Base.T, Base.G, Base.C, Base.A, Base.T};
            Base[] pair35R = {Base.U, Base.G, Base.C, Base.A, Base.U};
            Base[] pairR = {Base.A, Base.C, Base.G, Base.U, Base.A};
            Base[] pairRN = {Base.A, Base.C, Base.G, Base.T, Base.A};
            
            assertArrayEquals("3'-ACGTA pair should be TGCAT", pair35, strand3.getPairSeq());
            assertArrayEquals("5'-ACGTA pair should be TGCAT", pair35, strand5.getPairSeq());
            assertArrayEquals("3'-ACGTA pair called with false should be TGCAT", pair35, strand3.getPairSeq(false));
            assertArrayEquals("5'-ACGTA pair called with false should be TGCAT", pair35, strand5.getPairSeq(false));
            assertArrayEquals("3'-ACGTA pair called with true should be UGCAU", pair35R, strand3.getPairSeq(true));
            assertArrayEquals("5'-ACGTA pair called with true should be UGCAU", pair35R, strand5.getPairSeq(true));
            
            assertArrayEquals("RNA UGCAU pair should be ACGUA", pairR, strandR.getPairSeq());
            assertArrayEquals("RNA UGCAU pair called with true should be ACGUA", pairR, strandR.getPairSeq(true));
            assertArrayEquals("RNA UGCAU pair called with false should be ACGTA", pairRN, strandR.getPairSeq(false));
        }
        catch (BaseException e)
        {
            assertTrue("A strand threw when it shouldn't have.", false);
        }
    }

    @Test
    public void testStrandPairStrand()
    {
        try
        {
            Strand strand3 = new Strand(StrandType.THREE_PRIME, new String[]{"A","C","G","T","A"});
            Strand pair35 = new Strand(StrandType.FIVE_PRIME, new String[]{"T","G","C","A","T"});
            Strand pair3R = new Strand(StrandType.RNA, new String[]{"U","G","C","A","U"});
            
            Strand strand5 = new Strand(StrandType.FIVE_PRIME, new String[]{"A","C","G","T","A"});
            Strand pair53 = new Strand(StrandType.THREE_PRIME, new String[]{"T","G","C","A","T"});
            Strand pair5R = new Strand(StrandType.RNA, new String[]{"U","G","C","A","U"});
            
            Strand strandR = new Strand(StrandType.RNA, new String[]{"U","G","C","A","U"});
            Strand pairR = new Strand(StrandType.RNA, new String[]{"A","C","G","U","A"});
            Strand pairR3 = new Strand(StrandType.THREE_PRIME, new String[]{"A","C","G","T","A"});
            Strand pairR5 = new Strand(StrandType.FIVE_PRIME, new String[]{"A","C","G","T","A"});
            
            assertEquals("3'-ACGTA pair should be 5'-TGCAT", pair35, strand3.getPairStrand());
            assertEquals("3'-ACGTA pair w/ false should be 5'-TGCAT", pair35, strand3.getPairStrand(false));
            assertEquals("3'-ACGTA pair w/ true should be RNA UGCAU", pair3R, strand3.getPairStrand(true));
            assertEquals("3'-ACGTA pair w/ FIVE should be 5'-TGCAT", pair35, strand3.getPairStrand(StrandType.FIVE_PRIME));
            assertEquals("3'-ACGTA pair w/ THREE should be 3'-TGCAT", pair53, strand3.getPairStrand(StrandType.THREE_PRIME));
            assertEquals("3'-ACGTA pair w/ RNA should be RNA UGCAU", pair3R, strand3.getPairStrand(StrandType.RNA));
            
            assertEquals("5'-ACGTA pair should be 3'-TGCAT", pair53, strand5.getPairStrand());
            assertEquals("5'-ACGTA pair w/ false should be 3'-TGCAT", pair53, strand5.getPairStrand(false));
            assertEquals("5'-ACGTA pair w/ true should be RNA UGCAU", pair5R, strand5.getPairStrand(true));
            assertEquals("5'-ACGTA pair w/ FIVE should be 5'-TGCAT", pair35, strand5.getPairStrand(StrandType.FIVE_PRIME));
            assertEquals("5'-ACGTA pair w/ THREE should be 3'-TGCAT", pair53, strand5.getPairStrand(StrandType.THREE_PRIME));
            assertEquals("5'-ACGTA pair w/ RNA should be RNA UGCAU", pair5R, strand5.getPairStrand(StrandType.RNA));
            
            assertEquals("RNA UGCAU pair should be RNA ACGUA", pairR, strandR.getPairStrand());
            assertEquals("RNA UGCAU pair w/ false should be RNA ACGUA", pairR, strandR.getPairStrand(false));
            assertEquals("RNA UGCAU pair w/ true should be RNA ACGUA", pairR, strandR.getPairStrand(true));
            assertEquals("RNA UGCAU pair w/ FIVE should be 5'-ACGTA", pairR5, strandR.getPairStrand(StrandType.FIVE_PRIME));
            assertEquals("RNA UGCAU pair w/ THREE should be 3'-ACGTA", pairR3, strandR.getPairStrand(StrandType.THREE_PRIME));
            assertEquals("RNA UGCAU pair w/ RNA should be RNA ACGUA", pairR, strandR.getPairStrand(StrandType.RNA));
        }
        catch (BaseException e)
        {
            assertTrue("A strand threw when it shouldn't have.", false);
        }
    }
    
    @Test
    public void testStrandSubStrand()
    {
        try
        {
            Strand strand = new Strand(StrandType.THREE_PRIME, new String[] {"A","C","G","T","C","G"});
            
            assertEquals("Substrand of ACGTCG starting at 0 failed", strand, strand.getSubStrand(0));
            assertEquals("Substrand of ACGTCG starting at 0 and ending at length failed", strand, strand.getSubStrand(0, strand.getLength()));
            assertNotSame("Substrand of ACGTCG creating a new object failed", strand, strand.getSubStrand(0));
            assertNotSame("Substrand of ACGTCG creating a new object failed w/ end", strand, strand.getSubStrand(0, strand.getLength()));
            
            assertEquals("Substrand of ACGTCG starting at 1 failed", new Strand(StrandType.THREE_PRIME, new String[] {"C","G","T","C", "G"}), strand.getSubStrand(1));
            assertEquals("Substrand of ACGTCG starting at 1 and ending at len-1 failed", new Strand(StrandType.THREE_PRIME, new String[] {"C","G","T","C"}), strand.getSubStrand(1,strand.getLength() - 1));
        }
        catch (BaseException e)
        {
            assertTrue("A strand threw when it shouldn't have.", false);
        }
    }
    
    @Test
    public void testStrandToString()
    {
        try
        {
            Strand strand3 = new Strand(StrandType.THREE_PRIME, new String[] {"A","C","G","T","C","G"});
            Strand strand5 = new Strand(StrandType.FIVE_PRIME, new String[] {"C","G","T","A"});
            Strand strandR = new Strand(StrandType.RNA, new String[] {"C","G","U","A"});
            
            assertEquals("DNA 3'-ACGTCG-5' representation was incorrect.", "DNA 3'-ACGTCG-5'", strand3.toString());
            assertEquals("DNA 5'-CGTA-3' representation was incorrect.", "DNA 5'-CGTA-3'", strand5.toString());
            assertEquals("RNA CGUA representation was incorrect.", "RNA CGUA", strandR.toString());
        }
        catch (BaseException e)
        {
            assertTrue("A strand threw when it shouldn't have.", false);
        }
    }
    
    @Test
    public void testStrandFind()
    {
        try
        {
            Strand strand = new Strand(StrandType.FIVE_PRIME, new String[]{"A","A","C","C","G","G","T","T","A","C","G","T"});
            
            //Test Base[]
            assertEquals("Base[] in AACCGGTTACGT should have found A at 0", 0, strand.find(new Base[]{Base.A}));
            assertEquals("Base[] in AACCGGTTACGT should have found A at 0 startAt 0", 0, strand.find(new Base[]{Base.A}, 0));
            assertEquals("Base[] in AACCGGTTACGT should have found A at 1 startAt 1", 1, strand.find(new Base[]{Base.A}, 1));
            assertEquals("Base[] in AACCGGTTACGT should have found AC at 1", 1, strand.find(new Base[]{Base.A, Base.C}));
            assertEquals("Base[] in AACCGGTTACGT should have found AC at 8 startAt 5", 8, strand.find(new Base[]{Base.A, Base.C}, 5));
            assertEquals("Base[] in AACCGGTTACGT should not find AT", -1, strand.find(new Base[]{Base.A, Base.T}));
            assertEquals("Base[] in AACCGGTTACGT should not find AA startAt 1", -1, strand.find(new Base[]{Base.A, Base.A}, 1));
            assertEquals("Base[] in AACCGGTTACGT should not find U", -1, strand.find(new Base[]{Base.U}));
        
            //Test Strand
            assertEquals("Strand in AACCGGTTACGT should have found A at 0", 0, strand.find(new Strand(StrandType.FIVE_PRIME, new Base[]{Base.A})));
            assertEquals("Strand in AACCGGTTACGT should have found A at 0 startAt 0", 0, strand.find(new Strand(StrandType.THREE_PRIME, new Base[]{Base.A}), 0));
            assertEquals("Strand in AACCGGTTACGT should have found A at 1 startAt 1", 1, strand.find(new Strand(StrandType.FIVE_PRIME, new Base[]{Base.A}), 1));
            assertEquals("Strand in AACCGGTTACGT should have found AC at 1", 1, strand.find(new Strand(StrandType.FIVE_PRIME, new Base[]{Base.A, Base.C})));
            assertEquals("Strand in AACCGGTTACGT should have found AC at 8 startAt 5", 8, strand.find(new Strand(StrandType.FIVE_PRIME, new Base[]{Base.A, Base.C}), 5));
            assertEquals("Strand in AACCGGTTACGT should not find AT", -1, strand.find(new Strand(StrandType.FIVE_PRIME, new Base[]{Base.A, Base.T})));
            assertEquals("Strand in AACCGGTTACGT should not find AA startAt 1", -1, strand.find(new Strand(StrandType.FIVE_PRIME, new Base[]{Base.A, Base.A}), 1));
            assertEquals("Strand in AACCGGTTACGT should not find U", -1, strand.find(new Strand(StrandType.RNA, new Base[]{Base.U})));
        
            //Test String[]
            assertEquals("String[] in AACCGGTTACGT should have found A at 0", 0, strand.find(new String[]{"A"}));
            assertEquals("String[] in AACCGGTTACGT should have found A at 0 startAt 0", 0, strand.find(new String[]{"A"}, 0));
            assertEquals("String[] in AACCGGTTACGT should have found A at 1 startAt 1", 1, strand.find(new String[]{"A"}, 1));
            assertEquals("String[] in AACCGGTTACGT should have found AC at 1", 1, strand.find(new String[]{"A","C"}));
            assertEquals("String[] in AACCGGTTACGT should have found AC at 8 startAt 5", 8, strand.find(new String[]{"A","C"}, 5));
            assertEquals("String[] in AACCGGTTACGT should not find AT", -1, strand.find(new String[]{"A", "T"}));
            assertEquals("String[] in AACCGGTTACGT should not find AA startAt 1", -1, strand.find(new String[]{"A", "A"}, 1));
            assertEquals("String[] in AACCGGTTACGT should not find U", -1, strand.find(new String[]{"U"}));
        
            //Test String
            assertEquals("String in AACCGGTTACGT should have found A at 0", 0, strand.find("A"));
            assertEquals("String in AACCGGTTACGT should have found A at 0 startAt 0", 0, strand.find("A", 0));
            assertEquals("String in AACCGGTTACGT should have found A at 1 startAt 1", 1, strand.find("A", 1));
            assertEquals("String in AACCGGTTACGT should have found AC at 1", 1, strand.find("AC"));
            assertEquals("String in AACCGGTTACGT should have found AC at 8 startAt 5", 8, strand.find("AC", 5));
            assertEquals("String in AACCGGTTACGT should not find AT", -1, strand.find("AT"));
            assertEquals("String in AACCGGTTACGT should not find AA startAt 1", -1, strand.find("AA", 1));
            assertEquals("String in AACCGGTTACGT should not find U", -1, strand.find("U"));
        
            //Test Base
            assertEquals("Base in AACCGGTTACGT should have found A at 0", 0, strand.find(Base.A));
            assertEquals("Base in AACCGGTTACGT should have found A at 0 startAt 0", 0, strand.find(Base.A, 0));
            assertEquals("Base in AACCGGTTACGT should have found A at 1 startAt 1", 1, strand.find(Base.A, 1));
            assertEquals("Base in AACCGGTTACGT should have found A at 8 startAt 5", 8, strand.find(Base.A, 5));
            assertEquals("Base in AACCGGTTACGT should not find A startAt 9", -1, strand.find(Base.A, 9));
            assertEquals("Base in AACCGGTTACGT should not find U", -1, strand.find(Base.U));
        }
        catch(BaseException e)
        {
            assertTrue("A strand threw when it shouldn't have.", false);
        }
    }
    
    @Test
    public void testStrandReverse()
    {
        try
        {
            Strand strand3 = new Strand(StrandType.THREE_PRIME, new String[]{"A","C","G","T","A"});
            Strand rev3 = new Strand(StrandType.FIVE_PRIME, new String[]{"A","T","G","C","A"});
            
            Strand strand5 = new Strand(StrandType.FIVE_PRIME, new String[]{"A","C","G","T","A"});
            Strand rev5 = new Strand(StrandType.THREE_PRIME, new String[]{"A","T","G","C","A"});
            
            Strand strandR = new Strand(StrandType.RNA, new String[]{"U","G","C","A","U"});
            Strand revR = new Strand(StrandType.RNA, new String[]{"U","A","C","G","U"});
            
            assertEquals("3'-ACGTA reverse should be 5'-ATGCA", rev3, strand3.getReverseStrand());
            assertEquals("5'-ACGTA reverse should be 3'-ATGCA", rev5, strand5.getReverseStrand());
            assertEquals("RNA UGCAU reverse should be RNA UACGU", revR, strandR.getReverseStrand());
        }
        catch (BaseException e)
        {
            assertTrue("A strand threw when it shouldn't have.", false);
        }
    }
    
    @Test
    public void testStrandFindCodon()
    {
        try
        {
            Strand strand = new Strand(StrandType.FIVE_PRIME, new String[]{"A","A","C","C","G","G","T","T","A","C","G","T"});
            
            //Test Base[]
            assertEquals("Base[] in 5'-AACCGGTTACGT should have found AAC at 0 geneStart 0", 0, strand.findCodon(new Base[]{Base.A, Base.A, Base.C}, 0));
            assertEquals("Base[] in 5'-AACCGGTTACGT should have found AAC at 0 geneStart 0 startAt 0", 0, strand.findCodon(new Base[]{Base.A, Base.A, Base.C}, 0, 0));
            
            assertEquals("Base[] in 5'-AACCGGTTACGT should have found ACC at 1 geneStart 1", 1, strand.findCodon(new Base[]{Base.A, Base.C, Base.C}, 1));
            assertEquals("Base[] in 5'-AACCGGTTACGT should have found ACC at 1 geneStart 1 startAt 1", 1, strand.findCodon(new Base[]{Base.A, Base.C, Base.C}, 1, 1));
            
            assertEquals("Base[] in 5'-AACCGGTTACGT should have found ACG at 8 geneStart 2", 8, strand.findCodon(new Base[]{Base.A, Base.C, Base.G}, 2));
            assertEquals("Base[] in 5'-AACCGGTTACGT should have found ACG at 8 geneStart 2 startAt 2", 8, strand.findCodon(new Base[]{Base.A, Base.C, Base.G}, 2, 2));
            assertEquals("Base[] in 5'-AACCGGTTACGT should have found ACG at 8 geneStart 2 startAt 4", 8, strand.findCodon(new Base[]{Base.A, Base.C, Base.G}, 2, 4));
            
            assertEquals("Base[] in 5'-AACCGGTTACGT should have not found ACG geneStart 0", -1, strand.findCodon(new Base[]{Base.A, Base.C, Base.G}, 0));
            assertEquals("Base[] in 5'-AACCGGTTACGT should have not found ACG geneStart 0 startAt 0", -1, strand.findCodon(new Base[]{Base.A, Base.C, Base.G}, 0, 0));
            assertEquals("Base[] in 5'-AACCGGTTACGT should have not found ACG geneStart 0 startAt 2", -1, strand.findCodon(new Base[]{Base.A, Base.C, Base.G}, 0, 2));
            
            assertEquals("Base[] in 5'-AACCGGTTACGT should have not found ACC geneStart 0", -1, strand.findCodon(new Base[]{Base.A, Base.C, Base.C}, 0));
            assertEquals("Base[] in 5'-AACCGGTTACGT should have not found ACC geneStart 0 startAt 1", -1, strand.findCodon(new Base[]{Base.A, Base.C, Base.C}, 0, 1));
            
        
            //Test String[]
            assertEquals("String[] in 5'-AACCGGTTACGT should have found AAC at 0 geneStart 0", 0, strand.findCodon(new String[]{"A", "A", "C"}, 0));
            assertEquals("String[] in 5'-AACCGGTTACGT should have found AAC at 0 geneStart 0 startAt 0", 0, strand.findCodon(new String[]{"A", "A", "C"}, 0, 0));
            
            assertEquals("String[] in 5'-AACCGGTTACGT should have found ACC at 1 geneStart 1", 1, strand.findCodon(new String[]{"A", "C", "C"}, 1));
            assertEquals("String[] in 5'-AACCGGTTACGT should have found ACC at 1 geneStart 1 startAt 1", 1, strand.findCodon(new String[]{"A", "C", "C"}, 1, 1));
            
            assertEquals("String[] in 5'-AACCGGTTACGT should have found ACG at 8 geneStart 2", 8, strand.findCodon(new String[]{"A", "C", "G"}, 2));
            assertEquals("String[] in 5'-AACCGGTTACGT should have found ACG at 8 geneStart 2 startAt 2", 8, strand.findCodon(new String[]{"A", "C", "G"}, 2, 2));
            assertEquals("String[] in 5'-AACCGGTTACGT should have found ACG at 8 geneStart 2 startAt 4", 8, strand.findCodon(new String[]{"A", "C", "G"}, 2, 4));
            
            assertEquals("String[] in 5'-AACCGGTTACGT should have not found ACG geneStart 0", -1, strand.findCodon(new String[]{"A", "C", "G"}, 0));
            assertEquals("String[] in 5'-AACCGGTTACGT should have not found ACG geneStart 0 startAt 0", -1, strand.findCodon(new String[]{"A", "C", "G"}, 0, 0));
            assertEquals("String[] in 5'-AACCGGTTACGT should have not found ACG geneStart 0 startAt 2", -1, strand.findCodon(new String[]{"A", "C", "G"}, 0, 2));
            
            assertEquals("String[] in 5'-AACCGGTTACGT should have not found ACC geneStart 0", -1, strand.findCodon(new String[]{"A", "C", "C"}, 0));
            assertEquals("String[] in 5'-AACCGGTTACGT should have not found ACC geneStart 0 startAt 1", -1, strand.findCodon(new String[]{"A", "C", "C"}, 0, 1));
        
            //Test String
            assertEquals("String in 5'-AACCGGTTACGT should have found AAC at 0 geneStart 0", 0, strand.findCodon("AAC", 0));
            assertEquals("String in 5'-AACCGGTTACGT should have found AAC at 0 geneStart 0 startAt 0", 0, strand.findCodon("AAC", 0, 0));
            
            assertEquals("String in 5'-AACCGGTTACGT should have found ACC at 1 geneStart 1", 1, strand.findCodon("ACC", 1));
            assertEquals("String in 5'-AACCGGTTACGT should have found ACC at 1 geneStart 1 startAt 1", 1, strand.findCodon("ACC", 1, 1));
            
            assertEquals("String in 5'-AACCGGTTACGT should have found ACG at 8 geneStart 2", 8, strand.findCodon("ACG", 2));
            assertEquals("String in 5'-AACCGGTTACGT should have found ACG at 8 geneStart 2 startAt 2", 8, strand.findCodon("ACG", 2, 2));
            assertEquals("String in 5'-AACCGGTTACGT should have found ACG at 8 geneStart 2 startAt 4", 8, strand.findCodon("ACG", 2, 4));
            
            assertEquals("String in 5'-AACCGGTTACGT should have not found ACG geneStart 0", -1, strand.findCodon("ACG", 0));
            assertEquals("String in 5'-AACCGGTTACGT should have not found ACG geneStart 0 startAt 0", -1, strand.findCodon("ACG", 0, 0));
            assertEquals("String in 5'-AACCGGTTACGT should have not found ACG geneStart 0 startAt 2", -1, strand.findCodon("ACG", 0, 2));
            
            assertEquals("String in 5'-AACCGGTTACGT should have not found ACC geneStart 0", -1, strand.findCodon("ACC", 0));
            assertEquals("String in 5'-AACCGGTTACGT should have not found ACC geneStart 0 startAt 1", -1, strand.findCodon("ACC", 0, 1));
        
        }
        catch(BaseException e)
        {
            assertTrue("A strand threw when it shouldn't have.", false);
        }
    }
}
