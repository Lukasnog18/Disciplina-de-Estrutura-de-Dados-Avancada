package br.ufc.quixada.eda.arvorerubronegra;

public class TreeRedBlack<T> {
	private NodeRedBlack<T> root;
		
	private boolean isRed(NodeRedBlack<T> node){
		if(node == null) return false;
		else if(node.isColor() == NodeRedBlack.RED) return true;
		else return false;
	}
	private boolean isBlack(NodeRedBlack<T> node){
		return !this.isRed(node);
	}
	
	private void toRecolor(NodeRedBlack<T> node){
		node.setColor(NodeRedBlack.RED);
		node.getLeft().setColor(NodeRedBlack.BLACK);
		node.getRight().setColor(NodeRedBlack.BLACK);
	}
	
	private NodeRedBlack<T> leftRotation(NodeRedBlack<T> node){
		NodeRedBlack<T> aux = node.getRight();
		node.setRight(aux.getLeft());
		aux.setLeft(node);
		return aux;
	}
	private NodeRedBlack<T> rightRotation(NodeRedBlack<T> node){
		NodeRedBlack<T> aux = node.getLeft();
		node.setLeft(aux.getRight());
		aux.setRight(node);
		return aux;
	}
	
	private NodeRedBlack<T> r_insert(NodeRedBlack<T> node, int key, T value){
		if(root == null)
			return new NodeRedBlack<T>(key, value);
		if(root.getKey() > key) root.setLeft(r_insert(node.getLeft(), key, value));
		else if(root.getKey() < key) root.setRight(r_insert(node.getRight(), key, value));
		if(isRed(node.getLeft()) && isRed(node.getRight()) && isRed(node.getLeft().getLeft()))
			toRecolor(node);
		else if(isRed(node) && isRed(node.getRight()))
			this.root = leftRotation(node);
		else if(isRed(node.getLeft()) && isBlack(node.getRight()) && isRed(node)){
			this.root = rightRotation(node);
			root.setColor(NodeRedBlack.BLACK);
			root.getRight().setColor(NodeRedBlack.RED);
		}
		if(isRed(node.getLeft()) && isRed(node.getRight()) && isRed(node.getRight().getRight()))
			toRecolor(node);
		else if(isRed(node) && isRed(node.getLeft()))
			this.root = rightRotation(node);
		else if(isRed(node.getRight()) && isBlack(node.getLeft()) && isRed(node)){
			this.root = leftRotation(node);
			root.setColor(NodeRedBlack.BLACK);
			root.getLeft().setColor(NodeRedBlack.RED);
		}
		
		return node;
	}
	public void insert(int key, T value){
		this.root = r_insert(root, key, value);
		this.root.setColor(NodeRedBlack.BLACK);
	}
}