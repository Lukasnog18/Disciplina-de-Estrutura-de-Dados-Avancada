package br.ufc.quixada.eda.arvoresplay;

public class NodeSplay<T> {
	private NodeSplay<T> left, right;
	private int key;
	private T info;
	
	public NodeSplay(int key, T info){
		this.key = key;
		this.info = info;
		this.left = null;
		this.right = null;
	}

	public NodeSplay<T> getLeft() {
		return left;
	}

	public void setLeft(NodeSplay<T> left) {
		this.left = left;
	}

	public NodeSplay<T> getRight() {
		return right;
	}

	public void setRight(NodeSplay<T> right) {
		this.right = right;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

}
