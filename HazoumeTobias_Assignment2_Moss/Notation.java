
/**
 * @author tobias
 *
 */
public class Notation {

	private static final StackInterface<Character> CheckStack = null;
	// this will let us initialize the stack and queue I made from scratch
	static StackInterface<Character> myStack = new MyStack<Character>();
	static QueueInterface<Character> myQueue = new MyQueue<Character>();

	// what should i pass here?
	/**
	 * 
	 */
	public Notation() {

	}


	/**
	 * Convert an infix expression into a postfix expression
	 * 
	 * @param infix - the infix expression in string format
	 * @return - the postfix expression in string format
	 * @throws InvalidNotationFormatException - if the infix expression format is
	 *                                        invalid
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {


		for (char chr : infix.toCharArray()) {

			// If the current character in the infix is a space, ignore it.
			if (chr == ' ') {
				continue; // go to the next char of the loop
			}

			// If the current character in the infix is a digit,
			// copy it to the postfix solution queue

			if (Character.isDigit(chr)) {
				myQueue.enqueue(chr);
			} else if (chr == '(') {
				// If the current character in the
				// infix is a left parenthesis, push it onto the stack
				myStack.push(chr);
				// If the current character in the infix is an operator
			} else if (chr == '+' || chr == '-' || chr == '*' || chr == '/') {

				if ((chr =='+' || chr =='-') && (myStack.top() == '*' || myStack.top() == '/')) { //!!!!!!
					myQueue.enqueue(myStack.pop());
					// 2.Push the current character in the infix onto the stack
					myStack.push(chr);
				}else {
					myStack.push(chr);
				}
			} else if (chr == ')') {
				boolean leftParenFound = false;
				while (true) {
					if (myStack.isEmpty()) {
						break;
					} else if (myStack.top() != '(') {
						myQueue.enqueue(myStack.pop());
					} else {
						// 2.Pop (and discard) the left parenthesis from the stack
						// When the infix expression has been read

						myStack.pop();
						leftParenFound = true;
						break;
					}
				}
				if (!leftParenFound) {
					throw new InvalidNotationFormatException("no ( found");
				}

			}

		}
		
		//Pop any remaining operators and insert them in postfix solution queue.
		for(int i =0; i < myStack.size(); i++) 
		{
			myQueue.enqueue(myStack.pop());
		}
		

		/**
		 * In the infixToPostfix method, you MUST use a queue for the internal structure
		 * that holds the postfix solution. Then use the toString method of the Queue to
		 * return the solution as a string.
		 */
		return myQueue.toString();

	}

	/**
	 * Convert the Postfix expression to the Infix expression
	 * 
	 * @param postfix - the postfix expression in string format
	 * @return the infix expression in string format
	 * @throws InvalidNotationFormatException - if the postfix expression format is
	 *                                        invalid
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		StackInterface<String> localStack = new MyStack<String>();

		for (char chr : postfix.toCharArray()) 
		{
			if (chr == ' ') {
				continue; // go to the next char of the loop
			}
			
			if (Character.isDigit(chr))
			{
				localStack.push(String.valueOf(chr));
				
			}
			if ((chr == '+') || (chr == '-') || (chr == '*')  || (chr == '/')) 
			{
				if(localStack.size()<2) 
				{
					throw new InvalidNotationFormatException();
				}
				//2.Create a string with 1st value and then the operator and then the 2nd value.
				String newString = "("+localStack.pop() +chr + localStack.pop()+")";
				// Push the resulting string back to the stack
				localStack.push(newString);
				
			}
			
		}
		if(localStack.size() >1) 
		{
			throw new InvalidNotationFormatException();
		}
		
		
		
		return postfix;

	}

	/**
	 * Evaluates a postfix expression from a string to a double
	 * 
	 * @param postfixExpr - the postfix expression in String format
	 * @return - the evaluation of the postfix expression as a double
	 * @throws - InvalidNotationFormatException - if the postfix expression format
	 *           is invalid
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {

		return 0;
	}

}
