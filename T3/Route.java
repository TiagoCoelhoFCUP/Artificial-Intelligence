class Route{
    public flight f1;
    public flight f2;
    public flight f3;
    public int size;

    public Route(flight flight1,flight flight2,flight flight3){
        f1 = flight1;
        f2 = flight2;
        f3 = flight3;
        size = 3;
    }

    public Route(flight flight1,flight flight2){
        f1 = flight1;
        f2 = flight2;
        f3 = null;
        size = 2;
    }
    public Route(flight flight1){
        f1 = flight1;
        f2 = null;
        f3 = null;
        size = 1;
    }
}


