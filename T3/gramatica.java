import java.util.Scanner;

class gramatica{
    public static String[] name_m = {"cacador","cachorro","rio","mar","tempo","sino","vento","martelo","rosto","tambor"};
    public static String[] name_f= {"menina","noticia","floresta","porta","vida","mae","cidade"};
    public static String[] name_m_p = {"lobos","tambores"};
    public static String[] name_f_p = {"meninas","lagrimas"};
    public static String[] verb = {"corre","correu","bateu"};
    public static String[] verb_p  = {"corriam","bateram","correram"};
    public static String[] prep = {"para","com"};
    public static String[] contraction_f = {"na","pela","Na","Pela"};
    public static String[] contraction_m  = {"no","pelo","No","Pelo"};
    public static String[] contraction_m_p  = {"nos","pelos","Nos","Pelos"};
    public static String[] contraction_f_p  = {"nas","pelas","Nas","Pelas"};
    public static String[] determiner_m  = {"o","O"};
    public static String[] determiner_f  = {"a","A"};
    public static String[] determiner_m_p  = {"os","Os"};
    public static String[] determiner_f_p  = {"as","As"};

    public static boolean isName_m(String s){
	for(int i=0;i<name_m.length;i++)
	    if(s.equals(name_m[i]))
		return true;
	return false;
    }
    
    public static boolean isName_f(String s){
	for(int i=0;i<name_f.length;i++)
	    if(s.equals(name_f[i]))
		return true;
	return false;
    }
    
    public static boolean isName_m_p(String s){
	for(int i=0;i<name_m_p.length;i++)
	    if(s.equals(name_m_p[i]))
		return true;
	return false;
    }
    
    public static boolean isName_f_p(String s){
	for(int i=0;i<name_f_p.length;i++)
	    if(s.equals(name_f_p[i]))
		return true;
	return false;
    }

    public static boolean isVerb(String s){
	for(int i=0;i<verb.length;i++)
	    if(s.equals(verb[i]))
		return true;
	return false;
    }

    public static boolean isVerb_p(String s){
	for(int i=0;i<verb_p.length;i++)
	    if(s.equals(verb_p[i]))
		return true;
	return false;
    }

    public static boolean isPrep(String s){
	for(int i=0;i<prep.length;i++)
	    if(s.equals(prep[i]))
		return true;
	return false;
    }

    public static boolean isContraction_m(String s){
	for(int i=0;i<contraction_m.length;i++)
	    if(s.equals(contraction_m[i]))
		return true;
	return false;
    }

       public static boolean isContraction_f(String s){
	for(int i=0;i<contraction_f.length;i++)
	    if(s.equals(contraction_f[i]))
		return true;
	return false;
    }

       public static boolean isContraction_m_p(String s){
	for(int i=0;i<contraction_m_p.length;i++)
	    if(s.equals(contraction_m_p[i]))
		return true;
	return false;
    }

       public static boolean isContraction_f_p(String s){
	for(int i=0;i<contraction_f_p.length;i++)
	    if(s.equals(contraction_f_p[i]))
		return true;
	return false;
    }
    
    public static boolean isDeterminer_m(String s){
	for(int i=0;i<determiner_m.length;i++)
	    if(s.equals(determiner_m[i]))
		return true;
	return false;
    }

    public static boolean isDeterminer_f(String s){
	for(int i=0;i<determiner_f.length;i++)
	    if(s.equals(determiner_f[i]))
		return true;
	return false;
    }

      public static boolean isDeterminer_m_p(String s){
	for(int i=0;i<determiner_m_p.length;i++)
	    if(s.equals(determiner_m_p[i]))
		return true;
	return false;
    }

    public static boolean isDeterminer_f_p(String s){
	for(int i=0;i<determiner_f_p.length;i++)
	    if(s.equals(determiner_f_p[i]))
		return true;
	return false;
    }

    public static String isSentence(String[] s){
	String tree ="sentence(";
	int i=0;
	String singularity="";
	if(s.length<3 || s.length>6)
	    return "false";
	if(i<s.length && isDeterminer_m(s[i])){
	    singularity = "s";
	    if((i+1)<s.length && !isName_m(s[i+1]))
		return "false";
	}
	if(i<s.length && isDeterminer_f(s[i])){
	    singularity = "s";
	    if((i+1)<s.length && !isName_f(s[i+1]))
		return "false";
	}
	if(i<s.length && isDeterminer_m_p(s[i])){
	    singularity = "p";
	    if((i+1)<s.length && !isName_m_p(s[i+1]))
		return "false";
	}
	if(i<s.length && isDeterminer_f_p(s[i])){
	    singularity = "p";
	    if((i+1)<s.length && !isName_f_p(s[i+1]))
		return "false";
	}
	if(!singularity.equals(""))
	    tree = tree + "noun_phrase(determiner("+s[i]+"), name("+s[i+1]+")), ";
	else{
	    if(i<s.length && isContraction_m(s[i])){
		singularity = "s";
		if((i+1)<s.length && !isName_m(s[i+1]))
		    return "false";
	    }
	    if(i<s.length && isContraction_f(s[i])){
		singularity = "s";
		if((i+1)<s.length && !isName_f(s[i+1]))
		    return "false";
	    }
	
	    if(i<s.length && isContraction_m_p(s[i])){
		singularity = "p";
		if((i+1)<s.length && !isName_m_p(s[i+1]))
		    return "false";
	    }

	    if(i<s.length && isContraction_f_p(s[i])){
		singularity = "p";
		if((i+1)<s.length && !isName_f_p(s[i+1]))
		    return "false";
	    }
	    if(singularity.equals(""))
		return "false";
	    else
		tree = tree + "noun_phrase(contraction("+s[i]+"), name("+s[i+1]+")), ";
	}   
	i = 2;
	if(i<s.length && singularity.equals("s") && !isVerb(s[i]))
	    return "false";
	if(i<s.length && singularity.equals("p") && !isVerb_p(s[i]))
	    return "false";
	if(s.length==3){
	    tree = tree + "verbal_phrase(verb("+s[i]+")))";
	    return tree;
	}
	tree = tree + "verbal_phrase(verb("+s[i]+"), ";
	i = 3;
	if(i<s.length && isContraction_m(s[i])){
	    if((i+1)<s.length && isName_m(s[i+1])){
		tree = tree + "noun_phrase(contraction("+s[i]+"), name("+s[i+1]+"))))";
		return tree;
	    }
	    else
		return "false";
	}
	if(i<s.length && isContraction_f(s[i])){
	    if((i+1)<s.length && isName_f(s[i+1])){
		tree = tree + "noun_phrase(contraction("+s[i]+"), name("+s[i+1]+"))))";
		return tree;
	    }
	    else
		return "false";
	}
	
	if(i<s.length && isContraction_m_p(s[i])){
	    if((i+1)<s.length && isName_m_p(s[i+1])){
		tree = tree + "noun_phrase(contraction("+s[i]+"), name("+s[i+1]+"))))";
		return tree;
	    }
	    else
		return "false";
	}

	if(i<s.length && isContraction_f_p(s[i])){
	    if((i+1)<s.length && isName_f_p(s[i+1])){
		tree = tree + "noun_phrase(contraction("+s[i]+"), name("+s[i+1]+"))))";
		return tree;
	    }
	    else
		return "false";
	}

	if(i<s.length && isPrep(s[i])){
	    if((i+1)<s.length && (i+2)<s.length && isDeterminer_m(s[i+1]) && (!isName_m(s[i+2])))
		return "false";
	    if((i+1)<s.length && (i+2)<s.length && isDeterminer_m(s[i+1]) && isName_m(s[i+2])){
		tree = tree + "prep_phrase(preposition("+s[i]+"), noun_phrase(determiner("+s[i+1]+"),name("+s[i+2]+")))))";
		return tree;
	    }
	    if((i+1)<s.length && (i+2)<s.length && isDeterminer_f(s[i+1]) && (!isName_f(s[i+2])))
		return "false";
	    if((i+1)<s.length && (i+2)<s.length && isDeterminer_f(s[i+1]) && isName_f(s[i+2])){
		tree = tree + "prep_phrase(preposition("+s[i]+"), noun_phrase(determiner("+s[i+1]+"),name("+s[i+2]+")))))";
		return tree;
	    }
	    if((i+1)<s.length && (i+2)<s.length && isDeterminer_m_p(s[i+1]) && (!isName_m_p(s[i+2])))
		return "false";
	    if((i+1)<s.length && (i+2)<s.length && isDeterminer_m_p(s[i+1]) && isName_m_p(s[i+2])){
		tree = tree + "prep_phrase(preposition("+s[i]+"), noun_phrase(determiner("+s[i+1]+"),name("+s[i+2]+")))))";
		return tree;
	    }
	    if((i+1)<s.length && (i+2)<s.length && isDeterminer_f_p(s[i+1]) && (!isName_f_p(s[i+2])))
		return "false";
	    if((i+1)<s.length && (i+2)<s.length && isDeterminer_f_p(s[i+1]) && isName_f_p(s[i+2])){
		tree = tree + "prep_phrase(preposition("+s[i]+"), noun_phrase(determiner("+s[i+1]+"),name("+s[i+2]+")))))";
		return tree;
	    }
	}

	if(i<s.length && isDeterminer_m(s[i])){
	    if((i+1)<s.length && isName_m(s[i+1])){
		tree = tree + "noun_phrase(determiner("+s[i]+"),name("+s[i+1]+"))))";
		return tree;
	    }
	    else
		return "false";
	}

	if(i<s.length && isDeterminer_f(s[i])){
	    if((i+1)<s.length && isName_f(s[i+1])){
		tree = tree + "noun_phrase(determiner("+s[i]+"),name("+s[i+1]+"))))";
		return tree;
	    }
	    else
		return "false";
	}

	if(i<s.length && isDeterminer_m_p(s[i])){
	    if((i+1)<s.length && isName_m_p(s[i+1])){
		tree = tree + "noun_phrase(determiner("+s[i]+"),name("+s[i+1]+"))))";
		return tree;
	    }
	    else
		return "false";
	}

	if(i<s.length && isDeterminer_f_p(s[i])){
	    if((i+1)<s.length && isName_f_p(s[i+1])){
		tree = tree + "noun_phrase(determiner("+s[i]+"),name("+s[i+1]+"))))";
		return tree;
	    }
	    else
		return "false";
	}
	return "false";
    }

    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	String s = stdin.nextLine();
	String[] parsed = s.split(" ");
	System.out.println(isSentence(parsed));
    }
}
