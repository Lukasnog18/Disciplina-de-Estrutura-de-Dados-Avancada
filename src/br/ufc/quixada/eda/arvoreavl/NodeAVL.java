package br.ufc.quixada.eda.arvoreavl;

public class NodeAVL {
	private NodeAVL left, right;
	private int height, key;
	
	public NodeAVL (int key){
		this.left = null;
		this.right = null;
		this.height = 1;
		this.key = key;
	}

	public NodeAVL getLeft() {
		return left;
	}

	public void setLeft(NodeAVL left) {
		this.left = left;
	}

	public NodeAVL getRight() {
		return right;
	}

	public void setRight(NodeAVL right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
}
