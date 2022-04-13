import java.util.Scanner;
import java.util.LinkedList;

class Connect4 {
    static final int limite = 4;
    public static int nos_total = 0; 
    
    public static int Evaluate(String c1, String c2, String c3, String c4){
	if((c1.equals("X") && c2.equals("X") && c3.equals("X") && c4.equals("-")) || (c1.equals("-") && c2.equals("X") && c3.equals("X") && c4.equals("X")) || (c1.equals("X") && c2.equals("-") && c3.equals("X") && c4.equals("X")) || (c1.equals("X") && c2.equals("X") && c3.equals("-") && c4.equals("X")))
	    return -50;
	if((c1.equals("X") && c2.equals("X") && c3.equals("-") && c4.equals("-")) || (c1.equals("X") && c2.equals("-") && c3.equals("X") && c4.equals("-")) || (c1.equals("X") && c2.equals("-") && c3.equals("-") && c4.equals("X")) || (c1.equals("-") && c2.equals("X") && c3.equals("-") && c4.equals("X")) || (c1.equals("-") && c2.equals("X") && c3.equals("X") && c4.equals("-")) || (c1.equals("-") && c2.equals("-") && c3.equals("X") && c4.equals("X"))) 
	    return -10;
	if((c1.equals("X") && c2.equals("-") && c3.equals("-") && c4.equals("-")) || (c1.equals("-") && c2.equals("X") && c3.equals("-") && c4.equals("-")) || (c1.equals("-") && c2.equals("-") && c3.equals("X") && c4.equals("-")) || (c1.equals("-") && c2.equals("-") && c3.equals("-") && c4.equals("X")))
	    return -1;
	
	if((c1.equals("O") && c2.equals("-") && c3.equals("-") && c4.equals("-")) || (c1.equals("-") && c2.equals("O") && c3.equals("-") && c4.equals("-")) || (c1.equals("-") && c2.equals("-") && c3.equals("O") && c4.equals("-")) || (c1.equals("-") && c2.equals("-") && c3.equals("-") && c4.equals("O")))
	    return 1;

	if((c1.equals("O") && c2.equals("O") && c3.equals("-") && c4.equals("-")) || (c1.equals("O") && c2.equals("-") && c3.equals("O") && c4.equals("-")) || (c1.equals("O") && c2.equals("-") && c3.equals("-") && c4.equals("O")) || (c1.equals("-") && c2.equals("O") && c3.equals("-") && c4.equals("O")) || (c1.equals("-") && c2.equals("O") && c3.equals("O") && c4.equals("-")) || (c1.equals("-") && c2.equals("-") && c3.equals("O") && c4.equals("O")))
	    return 10;

	if((c1.equals("O") && c2.equals("O") && c3.equals("O") && c4.equals("-")) || (c1.equals("-") && c2.equals("O") && c3.equals("O") && c4.equals("O")) || (c1.equals("O") && c2.equals("-") && c3.equals("O") && c4.equals("O")) || (c1.equals("O") && c2.equals("O") && c3.equals("-") && c4.equals("O")))
	    return 50;
	
	return 0;
    }
	
       	    
    
    public static int  Utility(Tabuleiro t1,String peça){
	int total=0;
	for(int i=0;i<6;i++){ //horizontal
	    for(int j=0;j<4;j++){
		if(t1.matrix[i][j].equals("X") && t1.matrix[i][j+1].equals("X") && t1.matrix[i][j+2].equals("X") && t1.matrix[i][j+3].equals("X"))
		    return -512;
		if(t1.matrix[i][j].equals("O") && t1.matrix[i][j+1].equals("O") && t1.matrix[i][j+2].equals("O") && t1.matrix[i][j+3].equals("O"))
		    return 512;
		total = total + Evaluate(t1.matrix[i][j],t1.matrix[i][j+1],t1.matrix[i][j+2],t1.matrix[i][j+3]);
	    }
	}
	
	for(int j=0;j<7;j++){ //vertical
	    for(int i=0;i<3;i++){
		if(t1.matrix[i][j].equals("X") && t1.matrix[i+1][j].equals("X") && t1.matrix[i+2][j].equals("X") && t1.matrix[i+3][j].equals("X"))
		    return -512;
		if(t1.matrix[i][j].equals("O") && t1.matrix[i+1][j].equals("O") && t1.matrix[i+2][j].equals("O") && t1.matrix[i+3][j].equals("O"))
		    return 512;
		total = total + Evaluate(t1.matrix[i][j],t1.matrix[i+1][j],t1.matrix[i+2][j],t1.matrix[i+3][j]);
	    }
	}

	for(int i=0;i<3;i++){ //d1
	    if(t1.matrix[i][i].equals("X") && t1.matrix[i+1][i+1].equals("X") && t1.matrix[i+2][i+2].equals("X") && t1.matrix[i+3][i+3].equals("X"))
		return -512;
	    if(t1.matrix[i][i].equals("O") && t1.matrix[i+1][i+1].equals("O") && t1.matrix[i+2][i+2].equals("O") && t1.matrix[i+3][i+3].equals("O"))
		return 512;
	    total = total + Evaluate(t1.matrix[i][i],t1.matrix[i+1][i+1],t1.matrix[i+2][i+2],t1.matrix[i+3][i+3]);
	}
	
	for(int i=1;i<3;i++) { //d2
	    if(t1.matrix[i][i-1].equals("X") && t1.matrix[i+1][i].equals("X") && t1.matrix[i+2][i+1].equals("X") && t1.matrix[i+3][i+2].equals("X"))
		return -512;
	    if(t1.matrix[i][i-1].equals("O") && t1.matrix[i+1][i].equals("O") && t1.matrix[i+2][i+1].equals("O") && t1.matrix[i+3][i+2].equals("O"))
		return 512;
	    total = total + Evaluate(t1.matrix[i][i-1],t1.matrix[i+1][i],t1.matrix[i+2][i+1],t1.matrix[i+3][i+2]);
	}

	if(t1.matrix[2][0].equals("X") && t1.matrix[3][1].equals("X") && t1.matrix[4][2].equals("X") && t1.matrix[5][3].equals("X")) //d3
	    return -512;
	if(t1.matrix[2][0].equals("O") && t1.matrix[3][1].equals("O") && t1.matrix[4][2].equals("O") && t1.matrix[5][3].equals("O"))
	    return 512;
	total = total + Evaluate(t1.matrix[2][0],t1.matrix[3][1],t1.matrix[4][2],t1.matrix[5][3]); 

	for(int i=0;i<3;i++){ //d4
	    if(t1.matrix[i][i+1].equals("X") && t1.matrix[i+1][i+2].equals("X") && t1.matrix[i+2][i+3].equals("X") && t1.matrix[i+3][i+4].equals("X"))
		return -512;
	    if(t1.matrix[i][i+1].equals("O") && t1.matrix[i+1][i+2].equals("O") && t1.matrix[i+2][i+3].equals("O") && t1.matrix[i+3][i+4].equals("O"))
		return 512;
	    total = total + Evaluate(t1.matrix[i][i+1],t1.matrix[i+1][i+2],t1.matrix[i+2][i+3],t1.matrix[i+3][i+4]);
	}
	
	for(int i=0;i<2;i++){ //d5
	     if(t1.matrix[i][i+2].equals("X") && t1.matrix[i+1][i+3].equals("X") && t1.matrix[i+2][i+4].equals("X") && t1.matrix[i+3][i+5].equals("X"))
		return -512;
	    if(t1.matrix[i][i+2].equals("O") && t1.matrix[i+1][i+3].equals("O") && t1.matrix[i+2][i+4].equals("O") && t1.matrix[i+3][i+5].equals("O"))
		return 512;
	    total = total + Evaluate(t1.matrix[i][i+2],t1.matrix[i+1][i+3],t1.matrix[i+2][i+4],t1.matrix[i+3][i+5]);
	}
	
	if(t1.matrix[0][3].equals("X") && t1.matrix[1][4].equals("X") && t1.matrix[2][5].equals("X") && t1.matrix[3][6].equals("X")) //d6
	    return -512;
	if(t1.matrix[0][3].equals("O") && t1.matrix[1][4].equals("O") && t1.matrix[2][5].equals("O") && t1.matrix[3][6].equals("O")) 
	    return 512;	
	total = total + Evaluate(t1.matrix[0][3],t1.matrix[1][4],t1.matrix[2][5],t1.matrix[3][6]);
	

	for(int i=5;i>2;i--){ //d1'
	    if(t1.matrix[i][5-i].equals("X") && t1.matrix[i-1][5-i+1].equals("X") && t1.matrix[i-2][5-i+2].equals("X") && t1.matrix[i-3][5-i+3].equals("X"))
		return -512;
	    if(t1.matrix[i][5-i].equals("O") && t1.matrix[i-1][5-i+1].equals("O") && t1.matrix[i-2][5-i+2].equals("O") && t1.matrix[i-3][5-i+3].equals("O"))
		return 512;
	    total = total + Evaluate(t1.matrix[i][5-i],t1.matrix[i-1][5-i+1],t1.matrix[i-2][5-i+2],t1.matrix[i-3][5-i+3]);
	}
	for(int i=4;i>2;i--){ //d2'
	    if(t1.matrix[i][4-i].equals("X") && t1.matrix[i-1][4-i+1].equals("X") && t1.matrix[i-2][4-i+2].equals("X") && t1.matrix[i-3][4-i+3].equals("X"))
		return -512;
	    if(t1.matrix[i][4-i].equals("O") && t1.matrix[i-1][4-i+1].equals("O") && t1.matrix[i-2][4-i+2].equals("O") && t1.matrix[i-3][4-i+3].equals("O"))
		return 512;
	    total = total + Evaluate(t1.matrix[i][4-i],t1.matrix[i-1][4-i+1],t1.matrix[i-2][4-i+2],t1.matrix[i-3][4-i+3]);
	}

	if(t1.matrix[3][0].equals("X") && t1.matrix[2][1].equals("X") && t1.matrix[1][2].equals("X") && t1.matrix[0][3].equals("X")) //d3'
	    return -512;
	if(t1.matrix[3][0].equals("O") && t1.matrix[2][1].equals("O") && t1.matrix[1][2].equals("O") && t1.matrix[0][3].equals("O")) 
	    return 512;
	total = total + Evaluate(t1.matrix[3][0],t1.matrix[2][1],t1.matrix[1][2],t1.matrix[0][3]); 

	for(int i=5;i>2;i--){ //d4'
	    if(t1.matrix[i][5-i+1].equals("X") && t1.matrix[i-1][5-i+2].equals("X") && t1.matrix[i-2][5-i+3].equals("X") && t1.matrix[i-3][5-i+4].equals("X"))
		return -512;
	    if(t1.matrix[i][5-i+1].equals("O") && t1.matrix[i-1][5-i+2].equals("O") && t1.matrix[i-2][5-i+3].equals("O") && t1.matrix[i-3][5-i+4].equals("O"))
		return 512;
	    total = total + Evaluate(t1.matrix[i][5-i+1],t1.matrix[i-1][5-i+2],t1.matrix[i-2][5-i+3],t1.matrix[i-3][5-i+4]);
	}
	
	for(int i=5;i>3;i--){ //d5'
	    if(t1.matrix[i][5-i+2].equals("X") && t1.matrix[i-1][5-i+3].equals("X") && t1.matrix[i-2][5-i+4].equals("X") && t1.matrix[i-3][5-i+5].equals("X"))
		return -512;
	    if(t1.matrix[i][5-i+2].equals("O") && t1.matrix[i-1][5-i+3].equals("O") && t1.matrix[i-2][5-i+4].equals("O") && t1.matrix[i-3][5-i+5].equals("O"))
		return 512;
	    total = total + Evaluate(t1.matrix[i][5-i+2],t1.matrix[i-1][5-i+3],t1.matrix[i-2][5-i+4],t1.matrix[i-3][5-i+5]);
	}

	if(t1.matrix[5][3].equals("X") && t1.matrix[4][4].equals("X") && t1.matrix[3][5].equals("X") && t1.matrix[2][6].equals("X")) //d6
	    return -512;
	if(t1.matrix[5][3].equals("O") && t1.matrix[4][4].equals("O") && t1.matrix[3][5].equals("O") && t1.matrix[2][6].equals("O")) 
	    return 512;
	total = total + Evaluate(t1.matrix[5][3],t1.matrix[4][4],t1.matrix[3][5],t1.matrix[2][6]);
	    
	if(peça.equals("X"))
	    total = total -16;
	if(peça.equals("O"))
	    total = total +16;
	return total;
    }  

    public static Tabuleiro MaxValue(Tabuleiro t1){
	nos_total++;
	String peça = "O";
	t1.utility = Utility(t1,peça);
	if(t1.utility==-512 || t1.utility==512 || t1.altura>=limite )
	    return t1;
	Tabuleiro t2 = new Tabuleiro();
	t2.utility = Integer.MIN_VALUE;
	LinkedList<Tabuleiro> descendentes = t1.MakeDescendentes(peça);
	while(!descendentes.isEmpty()){
	    Tabuleiro t3 = MinValue(descendentes.poll());
	    if(t2.utility < t3.utility)
		t2 = t3;
	}
	return t2;
    }
    
    public static Tabuleiro MaxValue(Tabuleiro t1,int alfa,int beta){
	nos_total++;
	String peça = "O";
	t1.utility = Utility(t1,peça);
	if(t1.utility==-512 || t1.utility==512 || t1.altura>=limite )
	    return t1;
	Tabuleiro t2 = new Tabuleiro();
	t2.utility = Integer.MIN_VALUE;
	LinkedList<Tabuleiro> descendentes = t1.MakeDescendentes(peça);
	while(!descendentes.isEmpty()){
	    Tabuleiro t3 = MinValue(descendentes.poll(),alfa,beta);
	    if(t2.utility < t3.utility)
		t2 = t3;
	    if(t2.utility>=beta)
		return t2;
	    if(t2.utility>alfa)
		alfa = t2.utility;
	}
	return t2;
    }
    
    public static Tabuleiro MinValue(Tabuleiro t1){
	nos_total++;
	String peça = "X";
	t1.utility = Utility(t1,peça);
	if(t1.utility==-512 || t1.utility==512 || t1.altura>=limite )
	    return t1;
	Tabuleiro t2 = new Tabuleiro();
	t2.utility = Integer.MAX_VALUE;
	LinkedList<Tabuleiro> descendentes = t1.MakeDescendentes(peça);
	while(!descendentes.isEmpty()){
	    Tabuleiro t3 = MaxValue(descendentes.poll());
	    if(t2.utility > t3.utility)
		t2 = t3;
	}
	return t2;
    }

    public static Tabuleiro MinValue(Tabuleiro t1,int alfa,int beta){
	nos_total++;
	String peça = "X";
	t1.utility = Utility(t1,peça);
	if(t1.utility==-512 || t1.utility==512 || t1.altura>=limite )
	    return t1;
	Tabuleiro t2 = new Tabuleiro();
	t2.utility = Integer.MAX_VALUE;
	LinkedList<Tabuleiro> descendentes = t1.MakeDescendentes(peça);
	while(!descendentes.isEmpty()){
	    Tabuleiro t3 = MaxValue(descendentes.poll(),alfa,beta);
	    if(t2.utility > t3.utility)
		t2 = t3;
	    if(t2.utility<=alfa)
		return t2;
	    if(t2.utility<beta)
		beta = t2.utility;	
	}
	return t2; 
    }

    public static Tabuleiro MINIMAX_DECISION(Tabuleiro t1){
	long startTime = System.currentTimeMillis();
	Tabuleiro inicial = new Tabuleiro(t1);
	Tabuleiro t2 = MaxValue(t1);
	while(t2.pai.isEqual(inicial)!=true)
	    t2=t2.pai;
	long endTime = System.currentTimeMillis();
	System.out.println("Tempo de Execuçao: " + (endTime - startTime) + " milésimas de segundo.");
	System.out.println("Nos expandidos: " + nos_total + ".");
	nos_total = 0;
	return t2;
    }


    public static Tabuleiro ALFA_BETA_SEARCH(Tabuleiro t1){
	long startTime = System.currentTimeMillis();
	Tabuleiro inicial = new Tabuleiro(t1);
	Tabuleiro t2 = MaxValue(t1,Integer.MIN_VALUE,Integer.MAX_VALUE);
	while(t2.pai.isEqual(inicial)!=true)
	    t2=t2.pai;
	long endTime = System.currentTimeMillis();
	System.out.println("Tempo de Execuçao: " + (endTime - startTime) + " milésimas de segundo.");
	System.out.println("Nos expandidos: " + nos_total + ".");
	nos_total = 0;
	return t2;
    }

    

    
    public static void main(String [] args){
	int coluna;
	Tabuleiro t1;
	Scanner stdin = new Scanner(System.in);
	if(args.length == 0){
	    System.out.println("Erro: Nenhum argumento encontrado.");
	    return;
	}
	switch(args[0]){
	case "MINIMAX":
	    System.out.println("Decida quem sera o primeiro a jogar");
	    System.out.println("1) Computador");
	    System.out.println("2) Pessoa");
	    if(stdin.nextInt()==1){
		t1 = new Tabuleiro();
		t1 = MINIMAX_DECISION(t1);
		while(Utility(t1,"O")!=512 && Utility(t1,"O")!=-512){
		    if(t1.isFull()){
			t1.printTab();
			System.out.println("Empate");
			break;
		    }
		    t1.printTab();
		    t1.altura = 0;
		    System.out.println("O computador jogou. É agora a sua vez(X)");
		    System.out.println("Introduza a coluna na qual gostaria de colocar uma peça.");
		    coluna = stdin.nextInt();
		    while(t1.addTab(coluna,"X")!=true){
			System.out.println("Impossivel introduzir a peça nessa coluna.");
			t1.printTab();
			System.out.println("Introduza uma nova coluna");
			coluna = stdin.nextInt();
		    }
		    t1 = MINIMAX_DECISION(t1);
		}
		t1.printTab();
		if(t1.utility==512)
		    System.out.println("O computador ganhou.");
		else
		    System.out.println("Voce ganhou.");
	    }
	    else{
		t1 = new Tabuleiro();
		t1.printTab();
		System.out.println("E agora a sua vez(X).");
		System.out.println("Introduza a coluna na qual gostaria de colocar uma peça.");
		coluna = stdin.nextInt();
		while(t1.addTab(coluna,"X")!=true){
		    System.out.println("Impossivel introduzir a peça nessa coluna.");
		    t1.printTab();
		    System.out.println("Introduza uma nova coluna");
		    coluna = stdin.nextInt();
		}
		t1 = MINIMAX_DECISION(t1);
		while(Utility(t1,"O")!=512 && Utility(t1,"O")!=-512){
		    if(t1.isFull()){
			t1.printTab();
			System.out.println("Empate");
			break;
		    }
		    t1.printTab();
		    t1.altura = 0;
		    System.out.println("O computador jogou. E agora a sua vez(X)");
		    System.out.println("Introduza a coluna na qual gostaria de colocar uma peça.");
		    coluna = stdin.nextInt();
		    while(t1.addTab(coluna,"X")!=true){
			System.out.println("Impossivel introduzir a peça nessa coluna.");
			t1.printTab();
			System.out.println("Introduza uma nova coluna");
			coluna = stdin.nextInt();
		    }
		    t1 = MINIMAX_DECISION(t1);
		}
		t1.printTab();
		if(t1.utility==512)
		    System.out.println("O computador ganhou.");
		else
		    System.out.println("Voce ganhou.");
	    }
	    break;
	case "ALFABETA":
	    System.out.println("Decida quem sera o primeiro a jogar");
	    System.out.println("1) Computador");
	    System.out.println("2) Pessoa");
	    if(stdin.nextInt()==1){
		t1 = new Tabuleiro();
		t1 = ALFA_BETA_SEARCH(t1);
		while(Utility(t1,"O")!=512 && Utility(t1,"O")!=-512){
		    if(t1.isFull()){
			t1.printTab();
			System.out.println("Empate");
			break;
		    }
		    t1.printTab();
		    t1.altura = 0;
		    System.out.println("O computador jogou. E agora a sua vez(X)");
		    System.out.println("Introduza a coluna na qual gostaria de colocar uma peça.");
		    coluna = stdin.nextInt();
		    while(t1.addTab(coluna,"X")!=true){
			System.out.println("Impossivel introduzir a peça nessa coluna.");
			t1.printTab();
			System.out.println("Introduza uma nova coluna");
			coluna = stdin.nextInt();
		    }
		    t1 = ALFA_BETA_SEARCH(t1);
		}
		t1.printTab();
		if(t1.utility==512)
		    System.out.println("O computador ganhou.");
		else
		    System.out.println("Voce ganhou.");
	    }
	    else{
		t1 = new Tabuleiro();
		t1.printTab();
		System.out.println("E agora a sua vez(X).");
		System.out.println("Introduza a coluna na qual gostaria de colocar uma peça.");
		coluna = stdin.nextInt();
		while(t1.addTab(coluna,"X")!=true){
		    System.out.println("Impossivel introduzir a peça nessa coluna.");
		    t1.printTab();
		    System.out.println("Introduza uma nova coluna");
		    coluna = stdin.nextInt();
		}
		t1 = ALFA_BETA_SEARCH(t1);
		while(Utility(t1,"O")!=512 && Utility(t1,"O")!=-512){
		    if(t1.isFull()){
			t1.printTab();
			System.out.println("Empate");
			break;
		    }
		    t1.printTab();
		    t1.altura = 0;
		    System.out.println("O computador jogou. E agora a sua vez(X)");
		    System.out.println("Introduza a coluna na qual gostaria de colocar uma peça.");
		    coluna = stdin.nextInt();
		    while(t1.addTab(coluna,"X")!=true){
			System.out.println("Impossivel introduzir a peça nessa coluna.");
			t1.printTab();
			System.out.println("Introduza uma nova coluna");
			coluna = stdin.nextInt();
		    }
		    t1 = ALFA_BETA_SEARCH(t1);
		}
		t1.printTab();
		if(t1.utility==512)
		    System.out.println("O computador ganhou.");
		else
		    System.out.println("Voce ganhou.");
	    }
	    break;
	}
    }
}
