# Bioinformatics

## What is Bioinformatics?

Except from http://www.ncbi.nlm.nih.gov/books/NBK21136/

    A genome sequence is not an end in itself. A major challenge still has to 
    be met in understanding what the genome contains and how the genome 
    functions. The former is addressed by a combination of computer analysis 
    and experimentation, with the primary aim of locating the genes and their 
    control regions. The first part of this chapter is devoted to these methods. 
    The second question - understanding how the genome functions - is, to a 
    certain extent, merely a different way of stating the objectives of molecular 
    biology over the last 30 years. The difference is that in the past attention 
    has been directed at the expression pathways for individual genes, with 
    groups of genes being considered only when the expression of one gene is 
    linked to that of another. Now the question has become more general and 
    relates to the expression of the genome as a whole. The techniques used to 
    address this topic will be covered in the latter parts of this chapter.
    
    Once a DNA sequence has been obtained, whether it is the sequence of a 
    single cloned fragment or of an entire chromosome, then various methods 
    can be employed to locate the genes that are present. These methods can 
    be divided into those that involve simply inspecting the sequence, by eye 
    or more frequently by computer, to look for the special sequence features 
    associated with genes, and those methods that locate genes by experimental 
    analysis of the DNA sequence. The computer methods form part of the 
    methodology called bioinformatics…
    
    
## Manipulating DNA Sequences

We will first be finishing the Strand class.

The purpose of Strand is to store and manipulate DNA and RNA sequences.

To get an overview of the class, on the main screen, open the project documentation
by choosing Project Documentation in the Tools menu.

Try your best to get an overview of how the class works and what methods/capabilities
it should have from the documentation. You may also want to examine the code in Strand
and the other classes at the same time. Pay special attention to the private instance variables 
that are part of the Strand class. They do not show up in the documentation.

### Unit Testing

For this project, we will be using unit tests to see if our code is complete.

To turn on the testing tools, go to:

- The main BlueJ menu
- Preferences
- Interface tab
- Select the checkbox for "Show unit testing tools"

This should create a new button on the left-hand side of the main window
that says "Run Tests".

Clicking that button will show us the current test output.

After making changes, we should come back to the main screen and re-run the
tests to see what effect our changes had.

### Finishing the Constructors

Strand has 4 different constructors.
Each constructor is missing a step to properly initialize the instance variable
that represents the sequence being stored.

Identify the tests that might be related to the constructors. See why they are failing.

Find each of the constructors in the code. Follow the directions (part of the TODO 
comments) in each of the constructors to fix/finish them. 

Be sure to re-run the tests as you go to see what effect your changes have. Make sure that the
relevant tests pass before continuing. If any tests that used to pass are broken, you should go
back and fix them.

### Filling the Sequence

Next, we need to fix the fill method. This method will let us save our sequence data.

Identify the tests that might be related to the fill method. See why they are failing.

Find the fill method that has TODO comments as part of it.
Complete those tasks to make sure that we can save base pair data into our Strand.

Be sure to re-run the tests as you go to see what effect your changes have. Make sure that the
relevant tests pass before continuing. If any tests that used to pass are broken, you should go
back and fix them.

### Sequence Validation

Next we need to fix the strand's validation. DNA sequences are not allowed to have
the base Uracil (U) as part of them, and RNA sequences are not allowed to have the
base Thymine (T).

Identify the tests that might be related to validation. See why they are failing.

Find the validate method and notice its TODO comment(s).
Complete the tasks to make sure that we only have valid bases in the Strand's sequence.

Be sure to re-run the tests as you go to see what effect your changes have. Make sure that the
relevant tests pass before continuing. If any tests that used to pass are broken, you should go
back and fix them.

### Checking for Equality

Since Strands are objects, we cannot use == to determine if they are the same or not.
Instead, we have to implement an equals method (similar to Strings).

Identify the tests that might be related to checking for equality. See why they are failing.

Find the equals method and notice its TODO comments.
Complete the tasks to make sure that strands are considered equal under the right conditions.

Be sure to re-run the tests as you go to see what effect your changes have. Make sure that the
relevant tests pass before continuing. If any tests that used to pass are broken, you should go
back and fix them.

### Generating a Pair Sequence

One of the most basic things we might want to do with a DNA sequence is determine its pair
(whether the pair is mRNA or the other side of the DNA double helix).

Identify the tests that might be related to generating a pair sequence. See why they are failing.

Find the getPairSeq method that has TODO comments.
Complete the tasks to make sure that pair sequences are generated correctly.

Be sure to re-run the tests as you go to see what effect your changes have. Make sure that the
relevant tests pass before continuing. If any tests that used to pass are broken, you should go
back and fix them.

Also notice how the tests for getPairStrand should also now work. Make sure to look at the code
for the getPairStrand method to see how your fix for getPairSeq might be related.

### Reversing a Strand

Another basic thing we might want to do with a DNA sequence is to reverse it if it is in the wrong
direction.

Identify the tests that might be related to reversing a strand. See why they are failing.

Find the getReverseStrand method that has TODO comments.
Complete the tasks to make sure that reverse strands are generated correctly.

Be sure to re-run the tests as you go to see what effect your changes have. Make sure that the
relevant tests pass before continuing. If any tests that used to pass are broken, you should go
back and fix them.

### Generating a Sub-Strand / Sub-Sequence

Yet another basic thing we might want to do with a DNA sequence is to get a subsequence
(similar to how we looked at substrings).

Identify the tests that might be related to subsequences. See why they are failing.

Find the getSubStrand method that has TODO comments.
Complete the tasks to make sure that substrands are generated correctly.

Be sure to re-run the tests as you go to see what effect your changes have. Make sure that the
relevant tests pass before continuing. If any tests that used to pass are broken, you should go
back and fix them.

## Searching for Information

Once we can manipulate a strand/sequence, we can start finding information in it.

### Finding a Sub-Sequence

Identify the tests that might be related to finding a subsequence. See why they are failing.

Find the find method that has TODO comments.
Complete the tasks to make sure that subsequences can be located correctly.

Be sure to re-run the tests as you go to see what effect your changes have. Make sure that the
relevant tests pass before continuing. If any tests that used to pass are broken, you should go
back and fix them.

### Finding a Codon

A codon is a triplet of bases that code for a particular amino acid (or other function).
Not all subsequences are codons. If a gene starts at a particular base pair, then the
codons for that gene are the triplets that come after (without overlap, and without skips).

Identify the tests that might be related to finding a codon. See why they are failing.

Find the findCodon method that has TODO comments.
Complete the tasks to make sure that codons can be located correctly.

Be sure to re-run the tests as you go to see what effect your changes have. Make sure that the
relevant tests pass before continuing. If any tests that used to pass are broken, you should go
back and fix them.

### Finding a Gene Start

The beginnings of genes are often (but not always) indicated by an ATG group.

Identify the tests that might be related to finding the start of a gene. See why they are failing.

Find the findGeneStart method that has TODO comments.
Complete the tasks to make sure that the start of a gene can be located correctly.

Be sure to re-run the tests as you go to see what effect your changes have. Make sure that the
relevant tests pass before continuing. If any tests that used to pass are broken, you should go
back and fix them.

### Finding a Gene Stop

The endings of genes are complicated. Sometimes (but not always) they areindicated by 
one of a TGA, TAA, or TAG *codon*.

Identify the tests that might be related to finding the end of a gene. See why they are failing.

Find the findGeneStop method that has TODO comments.
Complete the tasks to make sure that the start of a gene can be located correctly.

Be sure to re-run the tests as you go to see what effect your changes have. Make sure that the
relevant tests pass before continuing. If any tests that used to pass are broken, you should go
back and fix them.