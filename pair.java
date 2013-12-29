/*
 * 
 * author: Erik Muro
 * 
 * 
 * 
 * 
 * My pair class
 * 
 * I was inspired by my experience in CS225 using the C++ standard library
 * C++ has a class called pair which stores a pair of template type variables
 */


/*
 * 
 * My pair class saves the current pair's 
 * x position in first
 * y position in Second
 * 
 * parents x pos
 * parents y pos
 * 
 * height of the pair in the maze relative to the root pair(node)
 * 
 * Also saves the cost from the root pair to the current pair
 * 
 */


public class pair {
	int first, second, parentF, parentS, ht, costFromStart;
	
	
	public pair(int f, int s, int pf, int ps, int height) {
		first=f;
		second = s;
		parentF= pf;
		parentS = ps;
		
		ht= height;
		costFromStart = 1;
		// TODO Auto-generated constructor stub
	}
	
	public pair(int f, int s, int pf, int ps, int height, int c) {
		first=f;
		second = s;
		parentF= pf;
		parentS = ps;
		
		ht= height;
		costFromStart = c;
		// TODO Auto-generated constructor stub
	}
	
	
/*	for the use of Part 1.3 Uniform search cost since my maze for Part 1.3 save floats and longs
 * I simply changed my costfromStart to a float variable or long variable
	public pair(int ft, int s, int pf, int ps, int height, float f) {
	
		first=ft;
		second = s;
		parentF= pf;
		parentS = ps;
		
		ht= height;
		costFromStart = f;
		
	}
	
*/
}
