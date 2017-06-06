package br.ufc.quixada.eda.arvoreavl;

public class TreeAVL {
	private NodeAVL root = null;
	
	private int height(NodeAVL node){
		return (node != null ? node.getHeight() : 0);
	}
	
	private NodeAVL leftRotation(NodeAVL node){
		NodeAVL aux = node.getRight();
		node.setRight(aux.getLeft());
		aux.setLeft(node);
		return aux;
	}
	
	private NodeAVL rightRotation(NodeAVL node){
		NodeAVL aux = node.getLeft();
		node.setLeft(aux.getRight());
		aux.setRight(node);
		return aux;
	}
	
	private NodeAVL doubleLeftRotation(NodeAVL node){
		node = rightRotation(node);
		return leftRotation(node);
	}
	
	private NodeAVL doubleRightRotation(NodeAVL node){
		node = leftRotation(node);
		return rightRotation(node);
	}
	
	private NodeAVL insert(NodeAVL node, int key){
		if(node == null) return new NodeAVL(key);
		else if(node.getKey() > key){
			node.setLeft(insert(node.getLeft(), key));
			if(height(node.getLeft()) - height(node.getRight()) == 2){
				if(height(node.getLeft().getLeft()) > height(node.getLeft().getRight()))
					node = rightRotation(node);
				else node = doubleRightRotation(node);
			}
		} else if(node.getKey() < key){
			node.setRight(insert(node.getRight(), key));
			if(height(node.getRight()) - height(node.getLeft()) == 2){
				if(height(node.getRight().getRight()) > height(node.getRight().getLeft()))
					node = leftRotation(node);
				else node = doubleLeftRotation(node);
			}
		}
		node.setHeight( Math.max( height( node.getLeft() ), height( node.getRight() ) ) );
		return node;
	}
	
	public void insert(int key){
		this.root = insert(this.root, key);
	}
	
	private String str(int nivel, char c){
		String res = "";
		if(nivel == 0)
			return res;
		while(nivel > 0){
			res += " ";
			nivel--;
		}
		
		return res;
	}
	private void rshow(NodeAVL node, int nivel){
        if(node == null)
            return;

        rshow(node.getLeft(), nivel + 1);
        System.out.println((str(4 * nivel, ' ')) + node.getKey());
        rshow(node.getRight(), nivel + 1);
    }
    public void show(){
        rshow(this.root, 0);
    }
}
