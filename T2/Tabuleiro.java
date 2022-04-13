import java.util.LinkedList;

class Tabuleiro{
    public String[][] matrix;
    public int altura;
    public int utility;
    public Tabuleiro pai;

    public Tabuleiro(){
        this.matrix = new String[6][7];
        for(int i=0;i<6;i++)
            for(int j=0;j<7;j++)
                this.matrix[i][j]="-";
	this.altura = 0;
	this.utility = 0;
	this.pai = null;
    }

    public Tabuleiro(Tabuleiro t2){
        this.matrix = new String[6][7];
        for(int i=0;i<6;i++)
            for(int j=0;j<7;j++)
                this.matrix[i][j]=t2.matrix[i][j];
	this.altura = t2.altura+1;
	this.utility = 0;
	this.pai = t2;
    }
    public void printTab(){
        for(int i = 0;i<6;i++){
	    for(int j=0;j<7;j++)
                System.out.print(this.matrix[i][j]+" ");
            System.out.println("\n");
        }
	System.out.println("=============");
	System.out.println("0 1 2 3 4 5 6\n");
    }

    public Boolean addTab(int coluna,String peça){
        int i = 5;
        Boolean sucess=false;
        for(int j =0;j<7;j++){
            if(j==coluna){
                while(i>=0){
                    if(this.matrix[i][j].equals("-")){
                        this.matrix[i][j] = peça;
                        sucess = true;
			break;
		    }
                    else
                        i--;
	        }
            }
        }
        return sucess;
    }

    public Boolean isEqual(Tabuleiro t2){
        for(int i=0;i<6;i++)
	    for(int j=0;j<7;j++)
		if(!(this.matrix[i][j].equals(t2.matrix[i][j])))
                    return false;
	return true;
    }

    public Boolean isFull(){
	for(int i=0;i<6;i++)
	    for(int j=0;j<7;j++)
		if(this.matrix[i][j].equals("-"))
		    return false;
	return true;
    }
    public LinkedList<Tabuleiro> MakeDescendentes(String peça){
        LinkedList<Tabuleiro> descendentes = new LinkedList<Tabuleiro>();
	Tabuleiro[] possiveis_descendentes = new Tabuleiro[7];
	for(int i=0;i<7;i++){
            possiveis_descendentes[i] = new Tabuleiro(this);
            possiveis_descendentes[i].addTab(i,peça);
	}
    
	for(int i=0;i<7;i++){
	    if(!this.isEqual(possiveis_descendentes[i]))
		descendentes.add(possiveis_descendentes[i]);
	}	
	return descendentes;
    }
}
