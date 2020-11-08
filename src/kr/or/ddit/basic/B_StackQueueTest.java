package kr.or.ddit.basic;

import java.util.LinkedList;

public class B_StackQueueTest {
	/* 
	 * 데이터를 담아서 처리할 때 사용하는 자료구조
	 
	 Stack => 제일 먼저 들어간 자료가 나중에 나오는 것  
	 			후입선출(LIFO)의 자료구조
	 			
	 Queue => 제일 먼저 들어간 자료가 먼저 나오는것
	 			선입선출(FIFO)의 자료구조
	 			
	 	Stack과 Queue는 LinkedList로 구현해서 사용할 수 있다.		
	 */
	
	public static void main(String[] args) {
		//Stack명령	(ex.되돌리기, 콜스택 : 리턴하면 제자리로 돌아옴, 뒤로가기/앞으로가기 )
		//1. 자료 입력 : push(입력데이터);
		//2. 자료 출력 : pop(); ===> 자료를 꺼내온 후 꺼내온 데이터를 Stack에서 지운다.
		//3. 		 peek(); ==> 삭제 없이 자료를 꺼내온다.
		
		LinkedList<String> stack = new LinkedList<>();
		
		stack.push("1.홍길동");
		stack.push("2.일지매");
		stack.push("3.이순신");
		stack.push("4.변학도");
		
		//출력되는 왼쪽이 출입구 
		System.out.println("stack 값 : " + stack);
		System.out.println();
		
		//pop을 사용하여 꺼내오기 
		String data = stack.pop();
		System.out.println("pop을 사용하여 꺼내온 값 : " + data);
		
		//2번째 값을 꺼내옴 
		System.out.println("두번째 꺼내온 값 : " + stack.pop());
		
		//꺼내온 값이 사라짐
		System.out.println("stack 값 : " + stack);
		System.out.println();
		
		//stack에 데이터를 추가 -> 3개 데이터 들어있음 
		stack.push("5.성춘향");
		System.out.println("데이터 추가 후 stack 값 : " + stack);
		
		//최근에 추가한 "성춘향"의 데이터가 나옴 
		System.out.println("꺼내온 값 : " + stack.pop());
		System.out.println();
		
		//peek를 사용하여 값을 꺼내오기 
		System.out.println("삭제없이(peek 사용)꺼내온 값 : " + stack.peek());
		System.out.println("stack 값 : " + stack);

		
		
	/*
		 Queue명령	(ex.프린트, 
		 1. 자료 입력 : offer(입력데이터);
		 2. 자료 출력 : poll();		==> 자료를 꺼내온 후 꺼내온 데이터를  Queue에서 삭제한다.
		            peek();		==> 삭제없이 데이터를 꺼내온다.
	*/
		System.out.println("\n------------------------------------------------\n");
		LinkedList<String> queue = new LinkedList<>();
		queue.offer("1.홍길동");
		queue.offer("2.일지매");
		queue.offer("3.이순신");
		queue.offer("4.변학도");
		
		System.out.println("Queue 값 : " + queue);
		
		//poll을 사용 
		String temp = queue.poll();
		System.out.println("poll을 사용하여 꺼내온 값  : " + temp);
		System.out.println("두번째 꺼내온 값 : " + queue.poll());
		System.out.println("queue 값 : " + queue);
		System.out.println();
		
		queue.offer("5.성춘향");
		System.out.println("데이터를 추가 후  queue 값 : " + queue);
		System.out.println();
		
		System.out.println("꺼내온 값 : " + queue.poll());
		System.out.println("queue 값 : " + queue);
		System.out.println();
		
		//peek 사용
		System.out.println("peek를 사용하여 삭제없이 꺼내온 값 : " + queue.peek());
		System.out.println("queue 값 : " + queue);
		
	}

}
