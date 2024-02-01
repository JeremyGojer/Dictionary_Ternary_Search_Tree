package com.services;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.beans.Node;

public class TernarySearchTree {
	public Node<Character> head;

	public TernarySearchTree() {
		head = null;
	}

	public void insertWord(String word) {
		word = word.toLowerCase();

		Node<Character> it = head;
		Node<Character> itp = null;
		for(char ch:word.toCharArray()) {
			Node<Character> temp = new Node<Character>(ch);

			if(head==null) {
				head = temp;
				it = head;
			}
			else {
				if(it==null) {
					it=temp;
					itp.setMid(temp);
					
				}
				else {
					while(it.getData()!=ch) {
						if(it.getData()>ch) {
							if(it.getLeft()==null) {
								it.setLeft(temp);
								it = temp;
								break;
							}
							else {
								it = it.getLeft();
							}
						}
						else{
							if(it.getRight()==null) {
								it.setRight(temp);
								it = temp;
								break;
							}
							else {
								it = it.getRight();
							}
						}
					}
				}


			}
			itp = it;
			it = it.getMid();
		}
		itp.setEow(true);

	}

	public void BST() {
		Queue<Node<Character>> queue = new ConcurrentLinkedQueue<Node<Character>>();
		Node<Character> it = head;
		if(it!=null) {
			queue.add(it);
		}
		while(!queue.isEmpty()) {
			it = queue.poll();
			if(it.getLeft()!=null) {
				queue.add(it.getLeft());
			}
			if(it.getMid()!=null) {
				queue.add(it.getMid());
			}
			if(it.getRight()!=null) {
				queue.add(it.getRight());
			}
			System.out.println(it.getData());

		}
	}

	public void DFT() {
		Stack<Node<Character>> stk = new Stack<Node<Character>>();
		Node<Character> it = head;
		if(it!=null) {
			stk.push(it);
		}
		while(!stk.isEmpty()) {
			it = stk.pop();
			if(it.getLeft()!=null) {
				stk.push(it.getLeft());
			}
			if(it.getMid()!=null) {
				stk.push(it.getMid());
			}
			if(it.getRight()!=null) {
				stk.push(it.getRight());
			}
			System.out.println(it.getData() + " : " + it);
		}
	}
	
	public boolean ifWordPresent(String str) {
		Node<Character>[] itxarr = new Node[1];
		return ifWordPresent(str, itxarr);
	}
	
	public boolean ifWordPresent(String str,Node<Character>[] prev) {
		str = str.toLowerCase();
		
		if(head==null) {
			return false;
		}
		if(str.length()<=0) {
			return false;
		}
		Node<Character> it = head;
		for(char ch : str.toCharArray()) {
			if(it==null) {
				return false;
			}
			while(it.getData()!=ch) {
				if(it.getData()>ch) {
					if(it.getLeft()!=null) {
						it = it.getLeft();
					}
					else {
						break;
					}
				}
				else if(it.getData()<ch) {
					if(it.getRight()!=null) {
						it = it.getRight();
					}
					else {
						break;
					}
				}
			}
			if(it.getData()==ch) {
				prev[0] = it;
				
				it = it.getMid();
			}
			else {
				return false;
			}	
		}
		return true;
	}
	
	public List<String> startsWith(String str) {
		List<String> strlst = new ArrayList<String>();
		Node<Character>[] itxarr = new Node[1];
		itxarr[0] = new Node<Character>('?');
		if(ifWordPresent(str,itxarr)) {
			Node<Character> start = itxarr[0].getMid();
			if(start!=null) {
				traceSiblings(str,start);
			}
		}
		return strlst;
	}

	public void traceSiblings(String prefix,Node<Character> start) {
		if(start!=null) {
			traceSiblings(prefix,start.getLeft());
			String newPrefix = prefix + start.getData();
			if(start.getMid()!=null) {
				if(start.isEow()) {
					System.out.println(newPrefix);
				}
				traceSiblings(newPrefix,start.getMid());
			}
			else {
				System.out.println(newPrefix);
			}
			traceSiblings(prefix,start.getRight());
			
		}
		
	}
	
	public void parseInputStream(InputStream inputStream) {
		int x;
		char ch;
		String temp = "";
		try {
			while((x=inputStream.read())!=-1) {
				ch = (char) x;
				if(ch>='a' && ch<='z') {
					temp += ch;
				}
				else {
					if(temp.length()!=0) {
						insertWord(temp);
					}
					temp = "";
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void parseText(String str) {
		InputStream is = new ByteArrayInputStream(str.getBytes());
		parseInputStream(is);
	}
	
	public void parseFile(File file) throws FileNotFoundException {
		if(file.exists()) {
			InputStream is = new FileInputStream(file);
			parseInputStream(is);
		}
	}

}
