package com.example.al.class01;

public class Code01_PrintBinary {

	/**
	 * << 按为左移 多少位
	 *
	 * & 运算符 与
	 * &是二元运算符，它以特定的方式的方式组合操作数中对应的位 如果对应的位都为1，那么结果就是1， 如果任意一个位是0 则结果就是0
	 *
	 * | 运算符 或
	 * | 跟 & 的区别在于 如果对应的位中任一个操作数为1 那么结果就是1
	 *
	 *  ^ 运算符 异或
	 * ^运算符跟 | 类似，但有一点不同的是 如果两个操作位都为1的话，结果产生0
	 *
	 * ~ 运算符 非
	 * ~是对位求反 1变0， 0变1
	 * 0 归属于非负区 -2^31~2^31-1。
	 *
	 *
	 *
	 * @param num
	 */
	public static void print(int num) {
		for (int i = 31; i >= 0; i--) {
			//当前数字的值和对应位数的二进制值进行与操作，如果这位是1的话，&操作之后是1，如果这位是0的话则是0；
			System.out.print((num & (1 << i)) == 0 ? "0" : "1");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// 32位
//		int num = 4;
//
//		print(num);
//		
//		
//		int test = 1123123;
//		print(test);
//		print(test<<1);
//		print(test<<2);
//		print(test<<8);
//		
//		
//		int a = Integer.MAX_VALUE;
//		System.out.println(a);

		print(-1);
		print(-2);
		print(0);
		print(~0);
		print(1);
		print(2);
//		int a = Integer.MIN_VALUE;
//		print(a);

//		int b = 123823138;
//		int c = ~b;
//		print(b);
//		print(c);

//		print(-5);

//		System.out.println(Integer.MIN_VALUE);
//		System.out.println(Integer.MAX_VALUE);

		int a = 12319283;
		int b = 3819283;
		print(a);
		print(b);
		System.out.println("=============");
		print(a | b);
		print(a & b);
		print(a ^ b);

//		int a = Integer.MIN_VALUE;
//		print(a);
//		print(a >> 1);
//		print(a >>> 1);
//		
//		int c = Integer.MIN_VALUE;
//		int d = -c ;
//		
//		print(c);
//		print(d);

	}

}
