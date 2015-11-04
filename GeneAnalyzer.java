import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class examines a few test FASTA files
 * 
 * @author Gregory McWhirter
 * @version 0.1
 */
public class GeneAnalyzer
{

    /**
     * Main method:
     * 1. Loads data from 6 sequences into Strand objects (cystic fibrosis gene regions):
     *      cftr11589_A.txt [http://www.ncbi.nlm.nih.gov/nuccore/DQ388142.1]
     *      cftr11589_A_coding.txt [http://www.ncbi.nlm.nih.gov/nuccore/DQ388142.1]
     *      cftr11589_B.txt [http://www.ncbi.nlm.nih.gov/nuccore/DQ388143.1]
     *      cftr11589_B_coding.txt [http://www.ncbi.nlm.nih.gov/nuccore/DQ388143.1]
     *      cftr_refseq.txt [http://www.ncbi.nlm.nih.gov/nuccore/NG_016465.4]
     *      cftr_refseq_coding.txt [http://www.ncbi.nlm.nih.gov/nuccore/NG_016465.4]
     * 
     * 2. Attempts to find genes in each sequence and displays where they were found.
     * 
     */
    public static void main(String[] args) throws BaseException
    {
        Scanner pause = new Scanner(System.in);
        
        Strand strandA_full = new Strand(Strand.Type.FIVE_PRIME, getStrandFromFile("cftr11589_A.txt"));
        Strand strandA_coding = new Strand(Strand.Type.FIVE_PRIME, getStrandFromFile("cftr11589_A_coding.txt"));
        Strand strandB_full = new Strand(Strand.Type.FIVE_PRIME, getStrandFromFile("cftr11589_B.txt"));
        Strand strandB_coding = new Strand(Strand.Type.FIVE_PRIME, getStrandFromFile("cftr11589_B_coding.txt"));
        Strand strandR_full = new Strand(Strand.Type.FIVE_PRIME, getStrandFromFile("cftr_refseq.txt"));
        Strand strandR_coding = new Strand(Strand.Type.FIVE_PRIME, getStrandFromFile("cftr_refseq_coding.txt"));
        
        int sAfg = findGenes(strandA_full);
        int sAcg = findGenes(strandA_coding);
        System.out.println();
        System.out.println("Genes from full: " + sAfg);
        System.out.println("Genes from coding: " + sAcg);
        
        System.out.println("\nType anything to continue...");
        pause.nextLine();
        
        int sBfg = findGenes(strandB_full);
        int sBcg = findGenes(strandB_coding);
        System.out.println();
        System.out.println("Genes from full: " + sBfg);
        System.out.println("Genes from coding: " + sBcg);
        
        System.out.println("\nType anything to continue...");
        pause.nextLine();
        
        int sRfg = findGenes(strandR_full);
        int sRcg = findGenes(strandR_coding);
        System.out.println();
        System.out.println("Genes from full: " + sRfg);
        System.out.println("Genes from coding: " + sRcg);
    }
    
    /**
     * Attempts to find genes in a strand (naively).
     * 
     * Prints out associated data along the way
     * 
     * Prerequisites: strand should be a 5' DNA strand
     * 
     * @param strand the strand of dna to search for genes in
     * @return how many genes were found
     */
    public static int findGenes(Strand strand)
    {
        System.out.println("--------------------------------");
        System.out.println("Base pairs: " + strand.getLength());
        System.out.println();
        
        int[] startStop = findGene(strand);
        int count = 0;
        
        do
        {
            if (startStop == null)
            {
                System.out.println("No more genes found.");
            }
            else {
                count++;
                System.out.println("Gene start: "+ startStop[0]);
                System.out.println("Gene stop: "+ startStop[1]);
                startStop = findGene(strand, startStop[1]+2);
            }
        }
        while (startStop != null);
        
        System.out.println("Genes found: " + count);
        return count;
    }
    
    /**
     * Tries to find the start and end of a gene at or after a given position in a strand
     * 
     * Prerequisites: strand should be a 5' DNA strand
     * 
     * @param strand the DNA strand to look in
     * @param startAt where to start looking for the gene
     * @return an array of 2 integers: the first number is the start of the gene, the second is the end; null if none is found.
     */
    public static int[] findGene(Strand strand, int startAt)
    {
        int start = strand.findGeneStart(startAt);
        int end = -1;
        
        if (start >= 0)
        {
            end = strand.findGeneStop(start);
            
            if (end >= 0)
            {
                int[] startStop = new int[2];
                startStop[0] = start;
                startStop[1] = end;
                return startStop;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }
    
    /**
     * Tries to find the start and end of a gene in a strand
     * 
     * Prerequisites: strand should be a 5' DNA strand
     * 
     * @param strand the DNA strand to look in
     * @return an array of 2 integers: the first number is the start of the gene, the second is the end; null if none is found.
     */
    public static int[] findGene(Strand strand)
    {
        return findGene(strand, 0);
    }
    
    /**
     * Opens a FASTA formatted file and reads the sequence into an array of bases
     * 
     * Note: reads multi-sequence files, but does not differentiate among the sequences
     * after they have been read (they get added to the same String array)
     * 
     * On read error, this will return a 0-length array
     * 
     * @param filename the name of the file to read the sequence from
     * @return an array of bases, once base letter per string
     */
    public static String[] getStrandFromFile(String filename)
    {
        try
        {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            List<String> bases = new ArrayList<String>();
            
            boolean started = false;
            String line;
            String[] temp;
            while (true)
            {
                line = file.readLine();
                if (line == null)
                {
                    break;
                }
                else {
                    line = line.trim();
                    if (line.length() > 0 && (line.substring(0,1).equals(">") || line.substring(0,1).equals(";")))
                    {
                        continue;
                    }
                    else {
                        temp = line.split("");
                        for (String base : temp)
                        {
                            bases.add(base);
                        }
                    }
                }
            }
            
            file.close();
            return bases.toArray(new String[0]);
        }
        catch (java.io.FileNotFoundException e)
        {
            return new String[0];
        }
        catch(java.io.IOException e)
        {
            return new String[0];
        }
    }
}
