package br.ufc.quixada.eda.arvorerubronegra;

public class NodeRedBlack<T> {
	public static final boolean BLACK = false;
	public static final boolean RED = true;
	
	private NodeRedBlack<T> left, right;
	private boolean color;
	private int key;
	private T value;
		
	public NodeRedBlack(int key, T value){
		this.key = key;
		this.value = value;
		this.color = RED;
		this.left = null;
		this.right = null;
	}
	
	public NodeRedBlack<T> getLeft() {
		return left;
	}
	
	public void setLeft(NodeRedBlack<T> left) {
		this.left = left;
	}
	
	public NodeRedBlack<T> getRight() {
		return right;
	}
	
	public void setRight(NodeRedBlack<T> right) {
		this.right = right;
	}

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
			this.value = value;
	}
}
