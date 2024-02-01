package com.test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.services.TernarySearchTree;

public class Test {
	
	public static void main(String[] args) {
		TernarySearchTree tst = new TernarySearchTree();
//		tst.insertWord("Hello");		
//		tst.insertWord("Help");
//		tst.insertWord("Hell");
//		tst.insertWord("High");
//		tst.insertWord("Cat");
//		tst.insertWord("Call");
//		tst.insertWord("cord");
//		System.out.println();
//		tst.DFT();
//		tst.startsWith("h");
		
//		String str = "build a chest next to your pal box and you can easily transport seemingly unlimited size stacks so long as you can turn and select the chest from where you land you dont need to do the drop and pick up thing do that at both ends and it speeds up transfer substantially";
//		tst.parseText(str);
		
		File file;
		try {
			file = new File("C:\\Users\\Jeremy\\Desktop\\words.txt");
			tst.parseFile(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ready for searching");
		Scanner sc = new Scanner(System.in);
		String input="";
		while(!input.equals("?")) {
			System.out.println("ENTER YOUR WORD FOR STARTS WITH");
			input = sc.next();
			tst.startsWith(input);
			System.out.println("Press ? to exit");
		}
		sc.close();
	}
}
