
public class Node {
	private int time; // Request time.
	private int req_index; // Request Index. Pointer to the airline meta data.
	private Node left;
	private Node right;

	public Node(int t, int i) {
		time = t;
		req_index = i;
		left = right = null;
	}

	public int getTime() {
		return time;
	}
	public void setTime(int t) {
		time = t;
	}

	public int getReq_index() {
		return req_index;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public void setLeft(Node l) {
		left = l;
	}

	public void setRight(Node r) {
		right = r;
	}

	public String toString() {
		return time + " " + req_index;
	}
}
