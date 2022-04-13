class flight{
    public String place1;
    public String place2;
    public String dep_time;
    public String arr_time;
    public String f_num;
    public String[] days;
    public String route;

    public flight(String Place1,String Place2, String Dep_time, String Arr_time, String F_num, String[] Days){
        place1 = Place1;
        place2 = Place2;
        dep_time = Dep_time;
        arr_time = Arr_time;
        f_num = F_num;
        days = Days;
        route = "empty";
    }

    public flight(flight f){
	this.place1 = f.place1;
	this.place2 = f.place2;
	this.dep_time = f.dep_time;
	this.arr_time = f.arr_time;
	this.f_num = f.f_num;
	this.days = f.days;
	this.route = f.route;
    }
}

