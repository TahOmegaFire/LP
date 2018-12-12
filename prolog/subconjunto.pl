subc([],_,[]).
subc([X|L],N,[M|R]):- suma(X,[X|L],M,N), subc(L,N,R),!.
suma(_,[],[],_).
suma(X,[S|M],P,N):- not(N is X + S), suma(X,M,P,N).
suma(X,[S|M],[X , S | P],N):- N is X + S, suma(X,M,P,N), !.
