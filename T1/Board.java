class Board{
    public int[][] matrix; 
    public int x_zero,y_zero; 
    public Board pai;
    public String move;

    //Construtor de Board vazia
    //Cria uma Board sem pai, com uma matrix preenchida com 0s
    public Board(){
	Board b1 = this;
	b1.pai = null;
	b1.matrix = new int[4][4];
	for(int i=0;i<4;i++)
	    for(int j=0;j<4;j++)
		b1.matrix[i][j]= 0;
	b1.x_zero = 0;
	b1.y_zero = 0;
	b1.move = "null";
    }

    //Cria uma Board igual á Board dada
    //O pai dessa nova Board pass a ser a Board dada
    public Board(Board b2){
	this.matrix = new int [4][4];
	Board b1 = this;
	for(int i=0;i<4;i++)
	    for(int j=0;j<4;j++)
	        b1.matrix[i][j]= new Integer (b2.matrix[i][j]);
	b1.pai = b2;
	b1.x_zero = new Integer (b2.x_zero);
	b1.y_zero = new Integer (b2.y_zero);
	b1.move = "null";
    }
   }
