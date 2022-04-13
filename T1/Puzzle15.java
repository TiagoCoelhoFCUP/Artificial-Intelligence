import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;


class Puzzle15{
    // Metodo que guarda elementos do standard input para uma Board
    public static void StoreBoard(Board b,Scanner stdin){ 
    	for(int i=0;i<4;i++)
	    for(int j=0;j<4;j++){
		b.matrix[i][j]= stdin.nextInt();
		if(b.matrix[i][j]==0){
		    b.x_zero=i;
		    b.y_zero=j;
		}
	    }
    }
    //Metodo que verifica se os elementos de uma Board são todos validos
    public static void isValid(Board b){
	boolean[] vetor = new boolean[16];
	Arrays.fill(vetor,false);
	for(int i=0;i<4;i++)
	    for(int j=0;j<4;j++)
		if(b.matrix[i][j]<=15 && b.matrix[i][j]>=0)
		    vetor[b.matrix[i][j]] = true; 
	for(int i=0;i<16;i++)
	    if(vetor[i]!=true){
		System.out.println("Erro, board invalida.");
		System.exit(1);
	    }
    }
    
    //Metodo executado quando o programa e executado de forma errada
    //Contem instruçoes de como executar o programa corretamente
    public static void Menu(){
	System.out.println();
	System.out.println("Como Executar:");
	System.out.println("java Puzzle15 'Busca'\n");
	System.out.println("Tipos de Busca:");
	System.out.println("DFS - Busca em Profundidade");
	System.out.println("BFS - Busca em Largura");
	System.out.println("BILP - Busca Iterativa Limitada em Profundidade");
	System.out.println("A* - Busca A estrela");
	System.out.println("Gulosa - Busca Gulosa");
	System.out.println();
    }
    
    //Metodo que verifica se o problema dado tem soluçao
    //Isto e, compara ambas as Boards e verifica se tem a mesma paridade
    public static Boolean isPossible(Board Inicial,Board Final){
	Boolean result=false;
	int []Inicial_vetor = new int[16];
	int [] Final_vetor = new int[16];
	int inversoes1=0,inversoes2=0,num=0;

	for(int i=0;i<4;i++)
	    for(int j=0;j<4;j++){
		Inicial_vetor[num] = Inicial.matrix[i][j];
		Final_vetor[num] = Final.matrix[i][j];
		num++;
	    }
	for(int i=0;i<16;i++)
	    for(int j=i+1;j<16;j++){
		if(Inicial_vetor[j]!=0 && Inicial_vetor[i]>Inicial_vetor[j])
		    inversoes1++;
		if(Final_vetor[j]!=0 && Final_vetor[i]>Final_vetor[j])
		    inversoes2++;
	    }
	if(((4-Final.x_zero)%2 == 1) == ((inversoes2%2)==0) == ((4-Inicial.x_zero)%2 == 1) == ((inversoes1%2)==0)) 
	    result = true;

	return result;
    }

    //Metodo que calcula a heuristica: Numero total de peças fora do lugar
    public static int ForaLugar(Board Inicial,Board Final){
	int total=0;
	for(int i=0;i<4;i++)
	    for(int j=0;j<4;j++)
		if(Inicial.matrix[i][j]!=Final.matrix[i][j])
		    total++;
	return total;
    }

    //Metodo que retorna as coordenadas de um ponto existente numa Board
    public static int[] findCoordinates(int n,Board b){
	int [] vetor= new int[2];
	for(int i=0;i<4;i++)
	    for(int j=0;j<4;j++)
		if(b.matrix[i][j]==n){
		    vetor[0]=i;
		    vetor[1]=j;
		}
	return vetor;
    }

    //Metodo que calcula a heuristica: Distancia de Manhattan
    public static int ManhattanDistance(Board Inicial,Board Final){
	int dist=0;
	int [] vetor = new int[2];
	for(int i=0;i<4;i++)
	    for(int j=0;j<4;j++){
	        vetor = findCoordinates(Inicial.matrix[i][j],Final);
		dist = dist + (Math.abs(vetor[0]-i)+Math.abs(vetor[1]-j));
	    }
	return dist;
    }
    
    //Metodo que verifica se duas Boards sao iguais, comparando as suas matrizes
    public static Boolean isEqual(Board b1, Board b2){
	for(int i=0;i<4;i++)
	    for(int j=0;j<4;j++)
		if(b1.matrix[i][j]!=b2.matrix[i][j])
		    return false;
	return true;
    }

    //Metodo utilizado para imprimir as matrizes de uma Board quando o resultado e obtido
    public static void Print(Board b,int altura){
	while(b!= null){
	    System.out.println();
	    System.out.println("No de profundiade: "+altura);
	    --altura;
	    System.out.println("====================\n");
	    for(int i=0;i<4;i++){
		System.out.println("-----------------");
		System.out.print("|");
		for(int j=0;j<4;j++){
		    if(b.matrix[i][j]>=0 && b.matrix[i][j]<10){
			if(j!=3) 
			    System.out.print(" " + b.matrix[i][j] + " |");	
			else
			    System.out.print(" " + b.matrix[i][j] + " |");
		    }
		    
		    else{
			if(j!=3)
			    System.out.print(" " + b.matrix[i][j] + "|");
			else
			    System.out.print(" " + b.matrix[i][j] + "|");
		    }
		}
		System.out.println();
	    }
	    System.out.println("-----------------");
	    System.out.println();
  
	    if(b.move.equals("direita") || b.move.equals("esquerda"))
		System.out.println("Movimento do espaço em branco para a "+b.move+" resulta em:" );
	    else if(b.move.equals("null")==false)
		System.out.println("Movimento do espaço em branco para "+b.move+" resulta em:" );
	    
	     b = b.pai;
	    System.out.println();
	}
    }

    //Metodo que dada uma Board e duas coordenadas,x e y, muda a posiçao da peça em branco para o espaço pretendido
    public static void SwitchZero(Board b,int x,int y){
	if(x<4 && x>=0 && y<4 && y>=0){
	    if(b.x_zero == (x +1))
		b.move = "baixo";
	    else if(b.x_zero == (x -1))
		b.move = "cima";
	    else if(b.y_zero == (y +1))
		b.move = "direita";
	    else
		b.move = "esquerda";
	    b.matrix[b.x_zero][b.y_zero] = new Integer (b.matrix[x][y]);
	    b.matrix[x][y] = 0;
	    b.x_zero=x;
	    b.y_zero=y;
	}
    }

    //Metodo que verifica se um no ja foi visitado pela funçao de busca
    public static Boolean isContained(LinkedList<Node> list, Board b){   
        for (Node n : list)
            if(isEqual(b,n.board))
                return true;
        return false;
    }
    
    //Semelhante ao metodo anterior
    //Faz a verificaçao dos nos repetidos mas tem em conta a altura dos mesmos
    //Utilizado na BFS e BILP para nao perder a soluçao otima
    public static Boolean depthComparator(LinkedList<Node> list, Board b,int altura_novo){
        for (Node n : list)
            if(isEqual(b,n.board)){
		if(altura_novo<n.altura)
		    return false;
		else
		    return true;
	    }
        return false;
    }
    
    //Metodo que retorna a lista dos Nodes descedentes para a funçao de busca
    public static LinkedList<Node> MakeDescendentes(int heur, Node n, LinkedList<Node> visitados, Board Final){
	LinkedList<Node> descendentes = new LinkedList<Node>();
	int [] heur_array = new int [4];
	Board [] board_array = new Board [4];
	for(int i=0;i<4;i++)
	    board_array[i]= new Board(n.board);

	SwitchZero(board_array[0],(board_array[0].x_zero),(board_array[0].y_zero-1));
	SwitchZero(board_array[1],(board_array[1].x_zero),(board_array[1].y_zero+1));
	SwitchZero(board_array[2],(board_array[2].x_zero-1),(board_array[2].y_zero));
	SwitchZero(board_array[3],(board_array[3].x_zero+1),(board_array[3].y_zero));

        if(heur==1){ //Busca Gulosa com a heuristica "Numero total de peças fora do lugar"
	    heur_array[0] = ForaLugar(board_array[0],Final);
	    heur_array[1] = ForaLugar(board_array[1],Final);
	    heur_array[2] = ForaLugar(board_array[2],Final);
	    heur_array[3] = ForaLugar(board_array[3],Final);

	    for(int i=0;i<4;i++){
		if(isContained(visitados,board_array[i])==false)
		    descendentes.add(new Node(n.altura+1,heur_array[i],board_array[i]));
	    }
	}

	if(heur==2){ //Busca A* com a heuristica "Numero total de peças fora do lugar"
	    heur_array[0] = (n.altura+1) + ForaLugar(board_array[0],Final);
	    heur_array[1] = (n.altura+1) + ForaLugar(board_array[1],Final);
	    heur_array[2] = (n.altura+1) + ForaLugar(board_array[2],Final);
	    heur_array[3] = (n.altura+1) + ForaLugar(board_array[3],Final);

	    for(int i=0;i<4;i++){
		if(!isEqual(board_array[i],n.board))
		    descendentes.add(new Node(n.altura+1,heur_array[i],board_array[i]));
	    }
	}

	if(heur==3){ //Busca Gulosa com a heuristica "Manhattan Distance"
	    heur_array[0] = ManhattanDistance(board_array[0],Final);
	    heur_array[1] = ManhattanDistance(board_array[1],Final);
	    heur_array[2] = ManhattanDistance(board_array[2],Final);
	    heur_array[3] = ManhattanDistance(board_array[3],Final);
	    
	    for(int i=0;i<4;i++){
		if(isContained(visitados,board_array[i])==false)
		    descendentes.add(new Node(n.altura+1,heur_array[i],board_array[i]));
	    }
	}
	
	
	if(heur==4){ //Busca A* com a heuristica "Manhattan Distance"
	    heur_array[0] = (n.altura+1) + ManhattanDistance(board_array[0],Final);
	    heur_array[1] = (n.altura+1) + ManhattanDistance(board_array[1],Final);
	    heur_array[2] = (n.altura+1) + ManhattanDistance(board_array[2],Final);
	    heur_array[3] = (n.altura+1) + ManhattanDistance(board_array[3],Final);
	    
	    for(int i=0;i<4;i++){
		if(!isEqual(board_array[i],n.board))
		    descendentes.add(new Node(n.altura+1,heur_array[i],board_array[i]));
	    }
	}

	if(heur==5){ //Busca BFS
	    for(int i=0;i<4;i++){
		if(isContained(visitados,board_array[i])==false)
		    descendentes.add(new Node(n.altura+1,0,board_array[i]));
	    }
	}

	if(heur==6){ //Busca DFS e BILP
	    for(int i=0;i<4;i++){
		if(depthComparator(visitados,board_array[i],(n.altura+1))==false)
		    descendentes.add(new Node(n.altura+1,0,board_array[i]));
	    }
	}   
	
	return descendentes;
    }

    //Algoritmo de busca DFS
    public static void DFSearchAlgorithm(Board Inicial,Board Final,int heur){
	long startTime = System.currentTimeMillis();
	LinkedList<Node> queue = new LinkedList<Node>();
	LinkedList<Node> descendentes = new LinkedList<Node>();
	LinkedList<Node> visitados = new LinkedList<Node>();
	int num_gerados=0;
	int num_visitados=0;
        queue.add(new Node(0,0,Inicial));
        while(queue.isEmpty()!=true){
	    Node n = queue.poll();
	    if(n.altura<=15){  //limite de profundidade sugerido pela professora: 15
		visitados.add(n);
		num_visitados++;
		if(((double)(System.currentTimeMillis() - startTime) / 1000.0) >= 60){ //limite de 1 min para encontrar solução
		    System.out.println();
		    System.out.println("Soluçao nao encontrada em menos de 1 minuto");
		    System.out.println("Numero de nos gerados: "+num_gerados);
		    System.out.println("Numero de nos visitados: "+num_visitados);
		    return;
		}
		if(isEqual(n.board,Final)==true){
		    System.out.println();
		    System.out.println("Soluçao encontrada em "+n.altura+" passos");
		    System.out.println("Numero de nos gerados: "+num_gerados);
		    System.out.println("Numero de nos visitados: "+num_visitados);
		    System.out.println("Quantidade de tempo gasto: "+(double)(System.currentTimeMillis() - startTime) / 1000.0 + " segundos.");
		    Print(n.board,n.altura);
		    return;
		}
		else{
		    descendentes = MakeDescendentes(heur,n,visitados,Final);
		    while(descendentes.isEmpty()!=true){
			queue.addFirst(descendentes.poll());
			num_gerados++;
		    }
		}
	    }
	}
	System.out.println("Soluçao nao encontrada\n");
    }

    //Algoritmo de busca BFS
    public static void BFSearchAlgorithm(Board Inicial,Board Final,int heur){
	long startTime = System.currentTimeMillis();
	LinkedList<Node> queue = new LinkedList<Node>();
	LinkedList<Node> descendentes = new LinkedList<Node>();
	LinkedList<Node> visitados = new LinkedList<Node>();
	int num_gerados=0;
	int num_visitados=0;
        queue.add(new Node(0,0,Inicial));
        while(queue.isEmpty()!=true){
	    Node n = queue.poll();
	    visitados.add(n);
	    num_visitados++;
	    if(((double)(System.currentTimeMillis() - startTime) / 1000.0) >= 60){ //limite de 1 min para encontrar solução
		System.out.println();
		System.out.println("Soluçao nao encontrada em menos de 1 minuto");
		System.out.println("Numero de nos gerados: "+num_gerados);
		System.out.println("Numero de nos visitados: "+num_visitados);
		return;
	    }
	    if(isEqual(n.board,Final)==true){
		System.out.println();
		System.out.println("Soluçao encontrada em "+n.altura+" passos");
		System.out.println("Numero de nos gerados: "+num_gerados);
		System.out.println("Numero de nos visitados: "+num_visitados);
		System.out.println("Quantidade de tempo gasto: "+(double)(System.currentTimeMillis() - startTime) / 1000.0 + " segundos.");
	        Print(n.board,n.altura);
		return;
	    }
	    else{
		descendentes = MakeDescendentes(heur,n,visitados,Final);
	        while(descendentes.isEmpty()!=true){
		    queue.add(descendentes.poll());
		    num_gerados++;
		}
	    }
	}
	System.out.println("Soluçao nao encontrada\n");
    }

    //Algoritmo de busca BILP
    public static void BILPSearchAlgorithm(Board Inicial,Board Final,int heur){
	int limite = 0;
	long startTime = System.currentTimeMillis();
	LinkedList<Node> queue = new LinkedList<Node>();
	LinkedList<Node> descendentes = new LinkedList<Node>();
	LinkedList<Node> visitados = new LinkedList<Node>();
	int num_gerados=0;
	int num_visitados=0;
        queue.add(new Node(0,0,Inicial));
	while(true){
	    while(queue.isEmpty()!=true){
		Node n = queue.poll();
		if(n.altura<=limite){
		    visitados.add(n);
		    num_visitados++;
		    if(((double)(System.currentTimeMillis() - startTime) / 1000.0) >= 60){ //limite de 1 min para encontrar solução
			System.out.println();
			System.out.println("Soluçao nao encontrada em menos de 1 minuto");
			System.out.println("Numero de nos gerados: "+num_gerados);
			System.out.println("Numero de nos visitados: "+num_visitados);
			return;
		    }
		    if(isEqual(n.board,Final)==true){
			System.out.println();
			System.out.println("Soluçao encontrada em "+n.altura+" passos");
			System.out.println("Numero de nos gerados: "+num_gerados);
			System.out.println("Numero de nos visitados: "+num_visitados);
			System.out.println("Quantidade de tempo gasto: "+(double)(System.currentTimeMillis() - startTime) / 1000.0 + " segundos.");
			Print(n.board,n.altura);
			return;
		    }
		    else{
			descendentes = MakeDescendentes(heur,n,visitados,Final);
			while(descendentes.isEmpty()!=true){
			    queue.addFirst(descendentes.poll());
			    num_gerados++;
			}
		    }
		}
	    }
	    queue.clear();
	    queue.add(new Node(0,0,Inicial));
	    visitados.clear();
	    limite++;
	}
    }


    //Algoritmo de busca Gulosa
    public static void GulosaSearchAlgorithm(Board Inicial,Board Final,int heur){
	long startTime = System.currentTimeMillis();
	PriorityQueue<Node> queue = new PriorityQueue<Node>();
	LinkedList<Node> descendentes = new LinkedList<Node>();
	LinkedList<Node> visitados = new LinkedList<Node>();
	int num_gerados=0;
	int num_visitados=0;
        queue.add(new Node(0,0,Inicial));
        while(queue.isEmpty()!=true){
	    Node n = queue.poll();
	    visitados.add(n);
	    num_visitados++;
	    if(isEqual(n.board,Final)==true){
		System.out.println();
		System.out.println("Soluçao encontrada em "+n.altura+" passos");
		System.out.println("Numero de nos gerados: "+num_gerados);
		System.out.println("Numero de nos visitados: "+num_visitados);
		System.out.println("Quantidade de tempo gasto: "+(double)(System.currentTimeMillis() - startTime) / 1000.0 + " segundos.");
	        Print(n.board,n.altura);
		return;
	    }
	    else{
		descendentes = MakeDescendentes(heur,n,visitados,Final);
	        while(descendentes.isEmpty()!=true){
		    queue.add(descendentes.poll());
		    num_gerados++;
		}
	    }
	}
	System.out.println("Soluçao nao encontrada\n");
    }


    //Algoritmo de busca A*
    public static void ASTARSearchAlgorithm(Board Inicial,Board Final,int heur){
	long startTime = System.currentTimeMillis();
	PriorityQueue<Node> queue = new PriorityQueue<Node>();
	LinkedList<Node> descendentes = new LinkedList<Node>();
	LinkedList<Node> visitados = new LinkedList<Node>();
	int num_gerados=0;
	int num_visitados=0;
        queue.add(new Node(0,0,Inicial));
        while(queue.isEmpty()!=true){
	    Node n = queue.poll();
	    visitados.add(n);
	    num_visitados++;
	    if(isEqual(n.board,Final)==true){
		System.out.println();
		System.out.println("Soluçao encontrada em "+n.altura+" passos");
		System.out.println("Numero de nos gerados: "+num_gerados);
		System.out.println("Numero de nos visitados: "+num_visitados);
		System.out.println("Quantidade de tempo gasto: "+(double)(System.currentTimeMillis() - startTime) / 1000.0 + " segundos.");
	        Print(n.board,n.altura);
		return;
	    }
	    else{
		descendentes = MakeDescendentes(heur,n,visitados,Final);
	        while(descendentes.isEmpty()!=true){
		    queue.add(descendentes.poll());
		    num_gerados++;
		}
	    }
	}
	System.out.println("Soluçao nao encontrada\n");
    }
	    
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
        Board Inicial = new Board();
	Board Final = new Board();
	int n,heur;
	Boolean possible;

	//Verifica se os argumentos foram lidos corretamente
	if(args.length == 0){
	    System.out.println("Erro: Nenhum argumento encontrado.");
	    Menu();
	    return;
	}
	System.out.println("Introduza a board inicial:");
	StoreBoard(Inicial,stdin);
	isValid(Inicial);
	System.out.println("Introduza a board final:");
	StoreBoard(Final,stdin);
	isValid(Final);
	possible = isPossible(Inicial,Final);
	if(possible==false){
	    System.out.println("Problema sem soluçao\n");
	    System.exit(1);
	}
	    switch(args[0]){
	    case "DFS":
	        DFSearchAlgorithm(Inicial,Final,6);
		break;
	    case "BFS":
		BFSearchAlgorithm(Inicial,Final,5);
		break;
	    case "BILP":
	        BILPSearchAlgorithm(Inicial,Final,6);
		break;
	    case "A*":
		System.out.println();
		System.out.println("Selecione a heuristica pretendida:");
		System.out.println("1) Somatorio do numero de peças fora do lugar");
		System.out.println("2) Distancia de Manhattan");
		heur = stdin.nextInt();
		if(heur == 2 || heur == 1)
		    ASTARSearchAlgorithm(Inicial,Final,(heur * 2));
		else
		    System.out.println("Heuristica selecionada invalida\n");
		break;
	    case "Gulosa":
		System.out.println();
		System.out.println("Selecione a heuristica pretendida:");
		System.out.println("1) Somatorio do número de peças fora do lugar");
		System.out.println("2) Distancia de Manhattan");
		heur = stdin.nextInt();
		if(heur==2)
		    GulosaSearchAlgorithm(Inicial,Final,3);
		else if(heur==1)
		    GulosaSearchAlgorithm(Inicial,Final,heur);
		else
		    System.out.println("Heuristica selecionada invalida\n");
		break;
	    default:
	        System.out.print("\033[H\033[2J");  //utilizado no caso default para dar clear no terminal
		System.out.flush();
		System.out.println("Erro: Opção Invalida\n");
		Menu();
		break;
	    }
    }
}

