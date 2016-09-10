
public class MegaInt {
	
	public static void main(String[] args) {
		MegaInt num = new MegaInt("125");
		MegaInt num2 = new MegaInt("7321");
		MegaInt suMegaInt = num.add(num2);
		System.out.println(suMegaInt.toString());
		
	}

	class Node {
		int digit;
		Node next;
		Node prev;
		
		public Node(int n) {
			digit = n;
			next = null;
			prev = null;
		}
	}
	
	public Node head;
	public Node end;
	
	public MegaInt(String str) {
		head = new Node(Integer.parseInt(str.charAt(0) + ""));
		end = head;
		
		for (int i = 1; i < str.length(); i++) {
			Node newNum = new Node(Integer.parseInt(str.charAt(i) + ""));
			end.next = newNum;
			newNum.prev = end;
			end = end.next;
		}
	}
	
	public MegaInt add(MegaInt num2) {
		Node n1Curr = end;
		Node n2Curr = num2.end;
		int carry = 0;
		
		StringBuilder ans = new StringBuilder();
		ans.append("");
		
		while (n1Curr != null || n2Curr != null) {
			carry = 0;
			int sum = 0;
			if (n1Curr == null) {
				sum = n2Curr.digit + carry;
			}
			else if (n2Curr == null) {
				sum = n1Curr.digit + carry;
			}
			else {
				sum = n1Curr.digit + n2Curr.digit + carry;
			}
			if (sum > 9) {
				carry = sum / 10;
			}
			
			int n = sum % 10;
			ans.append(n);
			
			if (n1Curr != null) {
				n1Curr = n1Curr.prev;
			}
			
			if (n2Curr != null) {
				n2Curr = n2Curr.prev;
			}
		}
		
		return new MegaInt(ans.reverse().toString());
	}
	
	public String multiply(MegaInt num2) {
		return null;
	}
	
	public String toString() {
		Node curr = this.head;
		StringBuilder ans = new StringBuilder();
		ans.append("");
		while (curr != null) {
			ans.append(curr.digit);
			curr = curr.next;
		}
		return ans.toString();
	}
	
	public int length(MegaInt num) {
		Node curr = head;
		int len = 0;
		while (curr != null) {
			len++;
		}
		return len;
	}
}
