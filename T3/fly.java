import java.util.Scanner;
import java.util.LinkedList;

class fly{
    static String[] s1 = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
    static flight f1 = new flight("edinburgh","london","9:40","10:50","ba4733",s1);
    static String[] s2 = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
    static flight f2 = new flight("edinburgh","london","13:40","14:50","ba4773",s2);
    static String[] s3 = {"monday","tuesday","wednesday","thursday","friday","sunday"};
    static flight f3 = new flight("edinburgh","london","19:40","20:50","ba4833",s3);
    static String[] s4 = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
    static flight f4 = new flight("london","edinburgh","9:40","10:50","ba4732",s4);
    static String[] s5 = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
    static flight f5 = new flight("london","edinburgh","11:40","12:50","ba4752",s5);
    static String[] s6 = {"monday","tuesday","wednesday","thursday","friday"};
    static flight f6 = new flight("london","edinburgh","18:40","19:50","ba4822",s6);
    static String[] s7 = {"friday"};
    static flight f7 = new flight("london","ljubljana","13:20","16:20","ju210",s7);
    static String[] s8 = {"sundacd IAy"};
    static flight f8 = new flight("london","ljubljana","13:20","16:20","ju213",s8);
    static String[] s9 = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
    static flight f9 = new flight("london","zurich","9:10","11:45","ba614",s9);
    static String[] s10 = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
    static flight f10 = new flight("london","zurich","14:45","17:20","sr805",s10);
    static String[] s11 = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
    static flight f11 = new flight("london","milan","8:30","11:20","ba510",s11);
    static String[] s12 = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
    static flight f12 = new flight("london","milan","11:00","13:50","az459",s12);
    static String[] s13 = {"tuesday","thursday"};
    static flight f13 = new flight("ljubljana","zurich","11:30","12:40","ju322",s13);
    static String[] s14 = {"friday"};
    static flight f14 = new flight("ljubljana","london","11:10","12:20","yu200",s14);
    static String[] s15 = {"sunday"};
    static flight f15 = new flight("ljubljana","london","11:25","12:20","yu212",s15);
    static String[] s16 = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
    static flight f16 = new flight("milan","london","9:10","10:00","az458",s16);
    static String[] s17 = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
    static flight f17 = new flight("milan","london","12:20","13:10","ba511",s17);
    static String[] s18 = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
    static flight f18 = new flight("milan","zurich","9:25","10:15","sr621",s18);
    static String[] s19 = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
    static flight f19 = new flight("milan","zurich","12:45","13:35","sr623",s19);
    static String[] s20 = {"tuesday","thursday"};
    static flight f20 = new flight("zurich","ljubljana","13:30","14:40","yu323",s20);
    static String[] s21 = {"monday","tuesday","wednesday","thursday","friday","saturday"};
    static flight f21 = new flight("zurich","london","9:00","9:40","ba613",s21);
    static String[] s22 = {"monday","tuesday","wednesday","thursday","friday","sunday"};
    static flight f22 = new flight("zurich","london","16:10","16:55","sr806",s22);
    static String[] s23 = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
    static flight f23 = new flight("zurich","milan","7:55","8:45","sr620",s23);


    public static flight[] flight_array = {f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23};

    public static String[] flight_locations = {"edinburgh","london","ljubljana","milan","zurich"};


    public static LinkedList<String> flightDay(String Place1, String Place2){
        LinkedList<String> visited = new LinkedList<String>();
        for(int i=0;i<flight_array.length;i++){
	    if((flight_array[i].place1).equals(Place1) && (flight_array[i].place2).equals(Place2)){
                for(int j=0;j<flight_array[i].days.length;j++){
                    if(!visited.contains(flight_array[i].days[j])){
                        visited.add(flight_array[i].days[j]);
                    }
                }
            }
        }
	return visited;
    }
    
    public static void menu(){
	System.out.println("========================================================");
	System.out.println("=                         Menu                         =");
	System.out.println("========================================================");
	System.out.println("= 1) Dias da Semana em que existe x voo disponivel     =");
	System.out.println("=------------------------------------------------------=");
	System.out.println("= 2) Voos entre duas localidade num dia da semana x    =");
	System.out.println("=------------------------------------------------------=");
	System.out.println("= 3) Rotas para  visitar 3 localidades numa semana     =");
	System.out.println("========================================================");
    }
	
    
    public static LinkedList<flight> availableFlights(String Place1, String Place2, String Day){
        LinkedList<flight> list = new LinkedList<flight>();
        for(int i=0;i<flight_array.length;i++){
            if((flight_array[i].place1).equals(Place1) && (flight_array[i].place2).equals(Place2)){
                for(int j=0;j<flight_array[i].days.length;j++){
		    if((flight_array[i].days[j]).equals(Day)){
                        list.add(flight_array[i]);
			break;
                    }
                }
            }
        }
        return list;
    }

    public static LinkedList<Route> possibleRoutes(String Place1,String Place2,String Place3,String Day1,String Day2,String Day3){
	LinkedList<flight> flights1 = new LinkedList<flight>();
        LinkedList<flight> flights2 = new LinkedList<flight>();
        LinkedList<flight> flights3 = new LinkedList<flight>();
        LinkedList<Route> flights_route = new LinkedList<Route>();
	
	flights1 = availableFlights(Place1,Place2,Day1);
	while(!flights1.isEmpty()){
	    flight f1 = new flight(flights1.poll());
	    f1.route = Day1;
	    flights2 = availableFlights(Place2,Place3,Day2);
	    while(!flights2.isEmpty()){
		flight f2 = new flight(flights2.poll());
		f2.route = Day2;
		flights3 = availableFlights(Place3,Place1,Day3);
		while(!flights3.isEmpty()){
		    flight f3 = new flight(flights3.poll());
		    f3.route = Day3;
		    flights_route.add(new Route(f1,f2,f3));
		}
	    }
	}

	return flights_route;
    }
    
    public static LinkedList<Route> existsRoute(String Place1,String Place2,String Place3){
        LinkedList<Route> all_routes = new LinkedList<Route>();
	LinkedList<Route> aux = possibleRoutes(Place1,Place2,Place3,"tuesday","wednesday","thursday");
	while(!aux.isEmpty())
	    all_routes.add(aux.poll());
	aux = possibleRoutes(Place1,Place2,Place3,"tuesday","wednesday","friday");
	while(!aux.isEmpty())
	    all_routes.add(aux.poll());
	aux = possibleRoutes(Place1,Place2,Place3,"tuesday","thursday","friday");
	while(!aux.isEmpty())
	    all_routes.add(aux.poll());
	aux = possibleRoutes(Place1,Place2,Place3,"wednesday","thursday","friday");
	while(!aux.isEmpty())
	    all_routes.add(aux.poll());
	return all_routes;
    }
    		
			
			
    public static boolean isBigger(String Time1, String Time2){
        String t1_parsed[] = Time1.split(":");
        String t2_parsed[] = Time2.split(":");
        int Hour1 = Integer.parseInt(t1_parsed[0]);
        int Hour2 = Integer.parseInt(t2_parsed[0]);
        int Min1 = Integer.parseInt(t1_parsed[1]);
        int Min2 = Integer.parseInt(t2_parsed[1]);
        if(Hour1 > Hour2)
            return true;
	if(Hour1 < Hour2)
            return false;
        if(Hour1 == Hour2){
            if(Min1 == Min2)
                return true;
            if(Min1 > Min2)
                return true;
            else
                return false;
        }
        return false;
    }

    public static void incrementTime(flight f1){
	String f1_parsed[] = f1.arr_time.split(":");
        int Hour = Integer.parseInt(f1_parsed[0]);
        int Min = Integer.parseInt(f1_parsed[1]);
        Min = Min + 40;
        if(Min>=60){
            Hour++;
            Min = Min%60;
        }
        if(Min==0)
            f1.arr_time = Hour+":00";
	else
            f1.arr_time = Hour+":"+Min;
    }


    public static void decrementTime(flight f1){
	String f1_parsed[] = f1.arr_time.split(":");
        int Hour = Integer.parseInt(f1_parsed[0]);
        int Min = Integer.parseInt(f1_parsed[1]);
        Min = Min - 40;
        if(Min<0){
            Hour--;
            Min = Min+60;
            Min = Min%60;
        }
        if(Min==0)
            f1.arr_time = Hour+":00";
        else
            f1.arr_time = Hour+":"+Min;
    }
    
    public static LinkedList<Route> allRoutes(String Place1, String Place2, String Place3, String Day){
        LinkedList<flight> list1 = availableFlights(Place1,Place2,Day);
	LinkedList<Route> route = new LinkedList<Route>();
	if(list1.isEmpty())
            return route;
	while(!list1.isEmpty()){
            flight f1 = list1.poll();
            LinkedList<flight> list2 = availableFlights(Place2,Place3,Day);
            while(!list2.isEmpty()){
                flight f2 = list2.poll();
                incrementTime(f1);
                if(isBigger(f2.dep_time,f1.arr_time)){
		    decrementTime(f1);
                    route.add(new Route(f1,f2));
		}
		else
		    decrementTime(f1);
            }
        }
        return route;
    }
    public static LinkedList<Route> allRoutes(String Place1, String Place2, String Place3, String Place4,String Day){
	LinkedList<flight> list1 = availableFlights(Place1,Place2,Day);
	LinkedList<Route> route = new LinkedList<Route>();
	LinkedList<Route> route_final = new LinkedList<Route>();
	if(list1.isEmpty())
	    return route;
	while(!list1.isEmpty()){
	    flight f1 = list1.poll();
            LinkedList<flight> list2 = availableFlights(Place2,Place3,Day);
	    while(!list2.isEmpty()){
                flight f2 = list2.poll();
		incrementTime(f1);
		if(isBigger(f2.dep_time,f1.arr_time)){
		    decrementTime(f1);
		    LinkedList<flight> list3 = availableFlights(Place3,Place4,Day);
		    while(!list3.isEmpty()){
			flight f3 = list3.poll();
			incrementTime(f2);
			if(isBigger(f2.dep_time,f1.arr_time)){
			    decrementTime(f2);
			    route.add(new Route(f1,f2,f3));
			}
			else
			    decrementTime(f2);
		    }
		}
		else
		    decrementTime(f1);
	    }
	}
	while(!route.isEmpty()){
	    Route r = route.poll();
	    if(!(r.f1.place1).equals(r.f2.place2) && !(r.f2.place1).equals(r.f3.place2))
		route_final.add(r);
	}
	return route_final;
    }
	    
	    
    public static LinkedList<Route> route(String Place1, String Place2, String Place3){
	LinkedList<Route> rotas = new LinkedList<Route>();
	LinkedList<Route> voos = existsRoute(Place1,Place2,Place3);
        while(!voos.isEmpty())
	    rotas.add(voos.poll());
	voos = existsRoute(Place1,Place3,Place2);
	while(!voos.isEmpty())
	    rotas.add(voos.poll());
	voos = existsRoute(Place2,Place1,Place3);
	while(!voos.isEmpty())
	    rotas.add(voos.poll());
	voos = existsRoute(Place2,Place3,Place1);
	while(!voos.isEmpty())
	    rotas.add(voos.poll());
	voos = existsRoute(Place3,Place1,Place2);
	while(!voos.isEmpty())
	    rotas.add(voos.poll());
	voos = existsRoute(Place3,Place2,Place1);
	while(!voos.isEmpty())
	    rotas.add(voos.poll());
	return rotas;
    }

    public static LinkedList<Route> route2(String Place1, String Place2, String Day){
        LinkedList<Route> route = new LinkedList<Route>();
        LinkedList<flight> direct_flights = new LinkedList<flight>();
        direct_flights  = availableFlights(Place1,Place2,Day);
        while(!direct_flights.isEmpty())
            route.add(new Route(direct_flights.poll()));
        for(int i=0;i<flight_locations.length;i++){
            LinkedList<Route> route_aux = new LinkedList<Route>();
            route_aux = allRoutes(Place1,flight_locations[i],Place2,Day);
            while(!route_aux.isEmpty())
                route.add(route_aux.poll());
        }
        for(int i=0;i<flight_locations.length;i++){
	    for(int j=0;j<flight_locations.length;j++){
	      LinkedList<Route> route_aux = new LinkedList<Route>();
	  route_aux = allRoutes(Place1,flight_locations[i],flight_locations[j],Place2,Day);
	  while(!route_aux.isEmpty())
	      route.add(route_aux.poll());
	    }
	}
        return route;
    }

    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	menu();
	int n = stdin.nextInt();
	stdin.nextLine();
	switch(n){
	case 1:
	    System.out.println("Introduza a localidade de origem:");
	    String Place1 = stdin.next();
	    System.out.println("Introduza a localidade de destino:");
	    String Place2 = stdin.next();
	    LinkedList<String> days = flightDay(Place1,Place2);
	    if(days.isEmpty())
		System.out.println("Nenhum dia da semana encontrado.");
	    else{
		System.out.println("Dias com voos disponiveis:");
		System.out.print(days.poll());
		while(!days.isEmpty())
		    System.out.print(","+days.poll());
		System.out.println();
	    }
	    break;
	case 2:
	    System.out.println("Introduza a localidade de origem:");
	    String Place_1 = stdin.next();
	    System.out.println("Introduza a localidade de destino:");
	    String Place_2 = stdin.next();
	    System.out.println("Introduza o dia da semana:");
	    String Day = stdin.next();
	    LinkedList<Route> Rotas = route2(Place_1,Place_2,Day);
	    if(Rotas.isEmpty())
		System.out.println("Nenhuma rota encontrada.");
	    else{
		System.out.println();
		System.out.println("Rotas encontradas:");
		while(!Rotas.isEmpty()){
		    Route r = Rotas.poll();
		    if(r.size == 1){
			System.out.println("Percurso: "+r.f1.place1+"-"+r.f1.place2+" /Numero do Voo: "+r.f1.f_num+" /Hora de Partida: "+r.f1.dep_time+" /Hora de Chegada: "+r.f1.arr_time+"\n");
		    }
		    if(r.size == 2){
			System.out.println("Percurso: "+r.f1.place1+"-"+r.f1.place2+" /Numero do Voo: "+r.f1.f_num+" /Hora de Partida: "+r.f1.dep_time+" /Hora de Chegada: "+r.f1.arr_time+"");
			System.out.println("Percurso: "+r.f2.place1+"-"+r.f2.place2+" /Numero do Voo: "+r.f2.f_num+" /Hora de Partida: "+r.f2.dep_time+" /Hora de Chegada: "+r.f2.arr_time+"\n");
		    }
		    if(r.size == 3){
			System.out.println("Percurso: "+r.f1.place1+"-"+r.f1.place2+" /Numero do Voo: "+r.f1.f_num+" /Hora de Partida: "+r.f1.dep_time+" /Hora de Chegada: "+r.f1.arr_time+"");
			System.out.println("Percurso: "+r.f2.place1+"-"+r.f2.place2+" /Numero do Voo: "+r.f2.f_num+" /Hora de Partida: "+r.f2.dep_time+" /Hora de Chegada: "+r.f2.arr_time+"");
			System.out.println("Percurso: "+r.f3.place1+"-"+r.f3.place2+" /Numero do Voo: "+r.f3.f_num+" /Hora de Partida: "+r.f3.dep_time+" /Hora de Chegada: "+r.f3.arr_time+"\n");
		    }
		}
	    }
	    break;
	case 3:
	    System.out.println("Introduza as 3 localidades que pretende visitar:");
	    String location1 = stdin.next();
	    String location2 = stdin.next();
	    String location3 = stdin.next();
	    LinkedList<Route> melhores_rotas = route(location1,location2,location3);
	    LinkedList<Route> percorridos = new LinkedList<Route>();
	    if(melhores_rotas.isEmpty())
		System.out.println("Nenhuma rota encontrada.");
	    else{
		System.out.println();
		System.out.println("Rota encontrada:");
		System.out.println();
		System.out.println("Percurso: "+location1+"/"+location2+"/"+location3+":");
		System.out.println("========================================");
	        for(Route r : melhores_rotas){
		    if(r.f1.place1.equals(location1) && r.f2.place1.equals(location2) && !percorridos.contains(r)){
			percorridos.add(r);
			System.out.println("Percurso: "+r.f1.place1+"-"+r.f1.place2+" /Numero do Voo: "+r.f1.f_num+" /Dia: "+r.f1.route+" /Hora de Partida: "+r.f1.dep_time+" /Hora de Chegada: "+r.f1.arr_time);
			System.out.println("Percurso: "+r.f2.place1+"-"+r.f2.place2+" /Numero do Voo: "+r.f2.f_num+" /Dia: "+r.f2.route+" /Hora de Partida: "+r.f2.dep_time+" /Hora de Chegada: "+r.f2.arr_time);
			System.out.println("Percurso: "+r.f3.place1+"-"+r.f3.place2+" /Numero do Voo: "+r.f3.f_num+" /Dia: "+r.f3.route+" /Hora de Partida: "+r.f3.dep_time+" /Hora de Chegada: "+r.f3.arr_time+"\n");
		    }
		}
		System.out.println();
		System.out.println("Percurso: "+location1+"/"+location3+"/"+location2+":");
		System.out.println("=========================================");
	        for(Route r : melhores_rotas){
		    if(r.f1.place1.equals(location1) && r.f2.place1.equals(location3) && !percorridos.contains(r)){
			percorridos.add(r);
			System.out.println("Percurso: "+r.f1.place1+"-"+r.f1.place2+" /Numero do Voo: "+r.f1.f_num+" /Dia: "+r.f1.route+" /Hora de Partida: "+r.f1.dep_time+" /Hora de Chegada: "+r.f1.arr_time);
			System.out.println("Percurso: "+r.f2.place1+"-"+r.f2.place2+" /Numero do Voo: "+r.f2.f_num+" /Dia: "+r.f2.route+" /Hora de Partida: "+r.f2.dep_time+" /Hora de Chegada: "+r.f2.arr_time);
			System.out.println("Percurso: "+r.f3.place1+"-"+r.f3.place2+" /Numero do Voo: "+r.f3.f_num+" /Dia: "+r.f3.route+" /Hora de Partida: "+r.f3.dep_time+" /Hora de Chegada: "+r.f3.arr_time+"\n");
		    }
		}
		System.out.println();
		System.out.println("Percurso: "+location2+"/"+location1+"/"+location3+":");
		System.out.println("========================================");
	        for(Route r : melhores_rotas){
		    if(r.f1.place1.equals(location2) && r.f2.place1.equals(location1) && !percorridos.contains(r)){
			percorridos.add(r);
			System.out.println("Percurso: "+r.f1.place1+"-"+r.f1.place2+" /Numero do Voo: "+r.f1.f_num+" /Dia: "+r.f1.route+" /Hora de Partida: "+r.f1.dep_time+" /Hora de Chegada: "+r.f1.arr_time);
			System.out.println("Percurso: "+r.f2.place1+"-"+r.f2.place2+" /Numero do Voo: "+r.f2.f_num+" /Dia: "+r.f2.route+" /Hora de Partida: "+r.f2.dep_time+" /Hora de Chegada: "+r.f2.arr_time);
			System.out.println("Percurso: "+r.f3.place1+"-"+r.f3.place2+" /Numero do Voo: "+r.f3.f_num+" /Dia: "+r.f3.route+" /Hora de Partida: "+r.f3.dep_time+" /Hora de Chegada: "+r.f3.arr_time+"\n");
		    }
		}
		System.out.println();
		System.out.println("Percurso: "+location2+"/"+location3+"/"+location1+":");
		System.out.println("=========================================");
	        for(Route r : melhores_rotas){
		    if(r.f1.place1.equals(location2) && r.f2.place1.equals(location3) && !percorridos.contains(r)){
			percorridos.add(r);
			System.out.println("Percurso: "+r.f1.place1+"-"+r.f1.place2+" /Numero do Voo: "+r.f1.f_num+" /Dia: "+r.f1.route+" /Hora de Partida: "+r.f1.dep_time+" /Hora de Chegada: "+r.f1.arr_time);
			System.out.println("Percurso: "+r.f2.place1+"-"+r.f2.place2+" /Numero do Voo: "+r.f2.f_num+" /Dia: "+r.f2.route+" /Hora de Partida: "+r.f2.dep_time+" /Hora de Chegada: "+r.f2.arr_time);
			System.out.println("Percurso: "+r.f3.place1+"-"+r.f3.place2+" /Numero do Voo: "+r.f3.f_num+" /Dia: "+r.f3.route+" /Hora de Partida: "+r.f3.dep_time+" /Hora de Chegada: "+r.f3.arr_time+"\n");
		    }
		}
		System.out.println();
		System.out.println("Percurso: "+location3+"/"+location1+"/"+location2+":");
		System.out.println("========================================");
	        for(Route r : melhores_rotas){
		    if(r.f1.place1.equals(location3) && r.f2.place1.equals(location1) && !percorridos.contains(r)){
			percorridos.add(r);
			System.out.println("Percurso: "+r.f1.place1+"-"+r.f1.place2+" /Numero do Voo: "+r.f1.f_num+" /Dia: "+r.f1.route+" /Hora de Partida: "+r.f1.dep_time+" /Hora de Chegada: "+r.f1.arr_time);
			System.out.println("Percurso: "+r.f2.place1+"-"+r.f2.place2+" /Numero do Voo: "+r.f2.f_num+" /Dia: "+r.f2.route+" /Hora de Partida: "+r.f2.dep_time+" /Hora de Chegada: "+r.f2.arr_time);
			System.out.println("Percurso: "+r.f3.place1+"-"+r.f3.place2+" /Numero do Voo: "+r.f3.f_num+" /Dia: "+r.f3.route+" /Hora de Partida: "+r.f3.dep_time+" /Hora de Chegada: "+r.f3.arr_time+"\n");
		    }
		}
		System.out.println();
		System.out.println("Percurso: "+location3+"/"+location2+"/"+location1+":");
		System.out.println("=========================================");
	        for(Route r : melhores_rotas){
		    if(r.f1.place1.equals(location3) && r.f2.place1.equals(location2) && !percorridos.contains(r)){
			percorridos.add(r);
			System.out.println("Percurso: "+r.f1.place1+"-"+r.f1.place2+" /Numero do Voo: "+r.f1.f_num+" /Dia: "+r.f1.route+" /Hora de Partida: "+r.f1.dep_time+" /Hora de Chegada: "+r.f1.arr_time);
			System.out.println("Percurso: "+r.f2.place1+"-"+r.f2.place2+" /Numero do Voo: "+r.f2.f_num+" /Dia: "+r.f2.route+" /Hora de Partida: "+r.f2.dep_time+" /Hora de Chegada: "+r.f2.arr_time);
			System.out.println("Percurso: "+r.f3.place1+"-"+r.f3.place2+" /Numero do Voo: "+r.f3.f_num+" /Dia: "+r.f3.route+" /Hora de Partida: "+r.f3.dep_time+" /Hora de Chegada: "+r.f3.arr_time+"\n");
		    }
		}
	    }
	    break;
	default:
	    break;
	}
    }
}
	    









