class Node implements Comparable<Node> {
    public int altura;
    public int heuristica;
    public Board board;
    
    //Costrutor do Node
    Node(int altura,int heuristica, Board b) {
	this.altura = altura;
	this.board = b;
	this.heuristica = heuristica;
    }

    //Possiblita a comparação de Nodes com base na heuristica
    public int compareTo(Node p) {
	if(this.heuristica < p.heuristica)
	    return -1;
	else
	    return 1;
    }
}
