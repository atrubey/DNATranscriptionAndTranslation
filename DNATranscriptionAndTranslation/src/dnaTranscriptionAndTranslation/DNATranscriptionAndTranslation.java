package dnaTranscriptionAndTranslation;

import java.util.Scanner;

public class DNATranscriptionAndTranslation {
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner (System.in);
		int DNAStartingEnd; 
		
		do {
		System.out.println("Enter the which end the DNA sequence starts with (5 or 3): ");
		DNAStartingEnd = keyboard.nextInt();
		} while (!(DNAStartingEnd == 3 || DNAStartingEnd == 5)); 
		System.out.println("Enter the DNA sequence: ");
		keyboard.nextLine(); 
		String DNASequence = keyboard.nextLine(); 
		String mRNASequence = "", aminoAcidSequence = "", startCodon = "AUG";
		int mRNAStartingEnd; 
		
		if (DNAStartingEnd == 5) {
			mRNAStartingEnd = 3; 
		} else {
			mRNAStartingEnd = 5; 
		}
		
		for (int i = 0; i < DNASequence.length(); i++) {
			char currentChar = DNASequence.charAt(i); 
			if (currentChar == 'A') {
				mRNASequence += "U"; 
			} else if (currentChar == 'T') {
				mRNASequence += "A"; 
			} else if (currentChar == 'G') {
				mRNASequence += "C"; 
			} else if (currentChar == 'C') {
				mRNASequence += "G"; 
			} else {
				System.out.println("Error - Invalid base.");
				System.exit(0);
				break; 
			}
		}
		
		if (mRNAStartingEnd == 3) {
	        char[] temparray = mRNASequence.toCharArray();
	        int left, right=0;
	        right = temparray.length-1;
	 
	        for (left=0; left < right ; left++ ,right--)
	        {
	            // Swap values of left and right
	            char temp = temparray[left];
	            temparray[left] = temparray[right];
	            temparray[right]=temp;
	        }
	        
	        mRNASequence = ""; 
	        
	        for (char c : temparray) {
	        		mRNASequence += c;
	        }
		}
		
		System.out.println("mRNA Sequence: ");
		System.out.println("5' - " + mRNASequence + " - 3'");

		System.out.println("Enter the first codon you are looking for to set the reading frame: ");
		startCodon = keyboard.nextLine(); 
		
		int startCodonLoc = mRNASequence.indexOf(startCodon); 
		if (startCodonLoc == -1) {
			System.out.println("This codon is not the given mRNA sequence.");
			System.exit(0);
		} else {
			
			for (int i = startCodonLoc; i < mRNASequence.length(); i += 3) {
				if (i + 3 > mRNASequence.length()) {
					break; 
				}
				aminoAcidSequence += getAminoAcid(mRNASequence.substring(i, i + 3)) + " - "; 
			}
			
			System.out.println("Amino Acid Sequence: ");
			System.out.println(aminoAcidSequence);
			System.out.println("This amino acid sequence starts at base " + (startCodonLoc+1) + ".");
			
		}
		
		
		
		
	}
	
	static String getAminoAcid(String codon) {
		
		if (codon.equals("UUU") || codon.equals("UUC")) {
			return "Phe"; 
		} else if (codon.equals("UUA") || codon.equals("UUG") || codon.equals("CUU") || codon.equals("CUC") || codon.equals("CUA") || codon.equals("CUG")) {
			return "Leu"; 
		} else if (codon.equals("AUU") || codon.equals("AUC") || codon.equals("AUA")) {
			return "Ile"; 
		} else if (codon.equals("AUG")) {
			return "Met"; 
		} else if (codon.equals("GUU") || codon.equals("GUC") || codon.equals("GUA") || codon.equals("GUG")) {
			return "Val"; 
		} else if (codon.equals("UCU") || codon.equals("UCC") || codon.equals("UCA") || codon.equals("UCG") || codon.equals("AGU") || codon.equals("AGC")) {
			return "Ser"; 
		} else if (codon.equals("CCU") || codon.equals("CCC") || codon.equals("CCA") || codon.equals("CCG")) {
			return "Pro"; 
		} else if (codon.equals("ACU") || codon.equals("ACC") || codon.equals("ACA") || codon.equals("ACG")) {
			return "Thr"; 
		} else if (codon.equals("GCU") || codon.equals("GCC") || codon.equals("GCA") || codon.equals("GCG")) {
			return "Ala"; 
		} else if (codon.equals("UAU") || codon.equals("UAC")) {
			return "Tyr"; 
		} else if (codon.equals("UAA") || codon.equals("UAG") || codon.equals("UGA")) {
			return "STOP"; 
		} else if (codon.equals("CAU") || codon.equals("CAC")) {
			return "His"; 
		} else if (codon.equals("CAA") || codon.equals("CAG")) {
			return "Gln"; 
		} else if (codon.equals("AAU") || codon.equals("AAC")) {
			return "Asn"; 
		} else if (codon.equals("AAA") || codon.equals("AAG")) {
			return "Lys"; 
		} else if (codon.equals("GAU") || codon.equals("GAC")) {
			return "Asp"; 
		} else if (codon.equals("GAA") || codon.equals("GAG")) {
			return "Glu"; 
		} else if (codon.equals("UGU") || codon.equals("UGC")) {
			return "Cys"; 
		} else if (codon.equals("UGG")) {
			return "Trp"; 
		} else if (codon.equals("CGU") || codon.equals("CGC") || codon.equals("CGA") || codon.equals("CGG") || codon.equals("AGA") || codon.equals("AGG")) {
			return "Arg"; 
		} else if (codon.equals("GGU") || codon.equals("GGC") || codon.equals("GGA") || codon.equals("GGG")) {
			return "Gly"; 
		} else {
			return null; 
		}
		
	}

}
