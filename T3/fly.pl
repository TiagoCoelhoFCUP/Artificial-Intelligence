:- op(50,xfy,:).

member(X,[X|L]).
member(X,[Y|L]):-
    member(X,L).

% setof(Day,flightday(london,edinburgh,Day),Days).

flight(Place1,PLace2,Day,Fnum,Deptime,Arrtime):-
    timetable(Place1,PLace2,Flightlist),
    member(Deptime/Arrtime/Fnum/Daylist, Flightlist),
    checkday(Day, Daylist).

flightday(Place1,PLace2,Day):-flight(Place1,PLace2,Day,_,_,_).

checkday(Day,Daylist):-
    member(Day,Daylist).

checkday(Day,alldays):-
    Daylist = [mo,tu,we,th,fr,sa,su],
    member(Day,Daylist).


route(Place1,Place2,Day,Visited,[Place1-Place2/Fnum/Deptime]):-
    flight(Place1,Place2,Day,Fnum,Deptime,_).

route(Place1,Place2,Day,Visited,[Place1-Place3:Fnum1/Dep1|RestRoute]) :-
    not(member(Place1 , Visited)),
    flight(Place1,Place3,Day,Fnum1,Dep1,Arr1),
    route(Place3,Place2,Day,[Place1| Visited],RestRoute),
    deptime(RestRoute,Dep2),
    transfer(Arr1,Dep2).


deptime([Place1-Place2/Fnum/Dep|_], Dep).

transfer(Hour1:Min1,Hour2:Min2):-
    60*(Hour2-Hour1) + Min2 - Min1 >=40.

timetable(edinburgh,london,
[9:40/10:50/ba4733/alldays,
13:40/14:50/ba4773/alldays,
19:40/20:50/ba4833/[mo,tu,we,th,fr,su]]).

timetable(london,edinburgh,
[9:40/10:50/ba4732/alldays,
11:40/12:50/ba4752/alldays,
18:40/19:50/ba4822/[mo,tu,we,th,fr]]).

timetable(london,ljubljana,
[13:20/16:20/ju201/[fr],
13:20/16:20/ju213/[su]]).

timetable(london,zurich,
[9:10/11:45/ba614/alldays,
14:45/17:20/sr805/alldays]).

timetable(london,milan,
[8:30/11:20/ba510/alldays,
11:00/13:50/az459/alldays]).

timetable(ljubljana,zurich,
[11:30/12:40/ju322/[tu,th]]).

timetable(ljubljana,london,
[11:10/12:20/yu200/[fr],
11:25/12:20/yu212/[su]]).

timetable(milan,london,
[9:10/10:00/az458/alldays,
12:20/13:10/ba511/alldays]).

timetable(milan,zurich,
[9:25/10:15/sr621/alldays,
12:45/13:35/sr623/alldays]).

timetable(zurich,ljubljana,
[13:30/14:40/yu323/[tu,th]]).

timetable(zurich,london,
[9:00/9:40/ba613/[mo,tu,we,th,fr,sa],
16:10/16:55/sr806/[mo,tu,we,th,fr,su]]).

timetable(zurich,milan,
[7:55/8:45/sr620/alldays]).
