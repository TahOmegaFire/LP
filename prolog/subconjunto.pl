%Las consultas en este problema se hacen llamando a subc(X, Y, Z), con X la lista inicial de elementos, Y el número esperado de la suma, y Z una variable con la lista de elementos cuya suma da Y.

subc([],_,[]).
subc([X|L],N,[M|R]):- suma(X,[X|L],M,N), subc(L,N,R),!.
suma(_,[],[],_).
suma(X,[S|M],P,N):- not(N is X + S), suma(X,M,P,N).
suma(X,[S|M],[X , S | P],N):- N is X + S, suma(X,M,P,N), !.
