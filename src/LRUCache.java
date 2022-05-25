import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: eumes
 * @date: 2022/5/24
 **/
public class LRUCache {
	// LRU
	// get
	// put
	public static void main(String[] args) {

	}

	//                  tail
	//   |               |
	// head -  n1 - n2 - n3
	private int capacity;
	private Node head;
	private Node tail;
	Map<Integer, Node> map;

//	LinkedHashMap

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>(capacity);
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node == null) {
			return -1;
		}

		// 挪到head位置
		moveToHead(node);

		return node.value;
	}

	// 将node挪到头位置
	private void moveToHead(Node node) {
		if (node == head) {
			return;
		} else if (node == tail) {
			node.prev.next = null;
			tail = node.prev;
		} else {
			// prev  ---   node  --- next
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}

		node.prev = null;
		node.next = head;
		head.prev = node;
		head = node;
	}

	public void put(int key, int value) {
		Node node = map.get(key);
		if (node != null) {
			// 挪到head位置
			// TODO: 2022/5/24  更新value值
			moveToHead(node);
		} else {
			// 先判断capacity
			if (map.size() == capacity) {
				// 删除最后一个
				removeTail();
			}
			node = new Node(key, value);
			// 放到head位置
			putToHead(node);
			map.put(key, node);
		}
	}

	private void removeTail() {
		map.remove(tail);
		if (map.size() == 0) {
			tail = null;
			head = null;
		} else if (map.size() == 1) {
			tail = head;
		} else {
			Node prev = tail.prev;
			tail.prev.next = null;
			tail = prev;
		}
	}

	private void putToHead(Node node) {
		if (map.size() == 0) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head.prev = node;
			node.prev = null;
			head = node;
		}
	}

	class Node {
		int key;
		int value;
		Node prev;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

}
