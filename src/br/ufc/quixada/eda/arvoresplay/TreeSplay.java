package br.ufc.quixada.eda.arvoresplay;

public class TreeSplay<T> {
	private NodeSplay<T> root;

	private NodeSplay<T> leftRotation(NodeSplay<T> node){
		NodeSplay<T> aux = node.getRight();
		node.setRight(aux.getLeft());
		aux.setLeft(node);
		return aux;
	}

	private NodeSplay<T> rightRotation(NodeSplay<T> node){
		NodeSplay<T> aux = node.getLeft();
		node.setLeft(aux.getRight());
		aux.setRight(node);
		return aux;
	}

	private NodeSplay<T> splay(NodeSplay<T> node, int key){
		if(node == null) return null;
		if(node.getKey() == key) return node;
		if(node.getKey() > key){
			if(node.getLeft() != null){
				node.setLeft(splay(node.getLeft(), key));
				node = rightRotation(node);
			}
		}else if(node.getKey() < key){
			if(node.getRight() != null){
				node.setRight(splay(node.getRight(), key));
				node = leftRotation(node);
			}
		}

		return node;
	}

	public T get(int key){
		root = splay(root, key);
		if(root.getKey() == key) return root.getInfo();
		else return null;
	}

	public void insert(int key, T info){
		if(root == null)
			root = new NodeSplay<T>(key, info);
		if(this.get(key) == null){
			NodeSplay<T> node = new NodeSplay<T>(key, info);
			if(root.getKey() < node.getKey()){
				node.setLeft(root);
				node.setRight(root.getRight());
				this.root = node;
			}else{
				node.setLeft(root.getLeft());
				node.setRight(root);
				this.root = node;
			}
		}
	}

	public void remove(int key){
		if(this.get(key) != null){
			if(root.getKey() == key){
				root.setLeft(splay(root.getLeft(), key));
				root.getLeft().setRight(root);
				root = root.getLeft();
				root.setRight(root.getRight().getRight());
			}else{
				root = splay(root, key);
			}
		}
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

	private void rshow(NodeSplay<T> node, int nivel){
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
