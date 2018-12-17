%Las consultas en este problema se hacen llamando a subconjunto(X, Y, Z), con X la lista inicial de elementos, Y el número esperado de la suma, y Z una variable con la lista de elementos cuya suma da Y.
aux(_,[],[]).
aux(X,[X1|L],[P|M]):- append(X,[X1],P),aux(X,L,M).
aux(X,[X1|L],[P|M]):- append([X],[X1],P),aux(X,L,M).
comb(_,[],[]).
comb(X,[X1|L],S):- append(X,[X1],K),aux(X,[X1|L],P),comb(K,L,M),append(M,P,S).
comb(X,[X1|L],S):- append([X],[X1],K),aux(X,[X1|L],P),comb(K,L,M),append(M,P,S).
subc([],[]).
subc([X|L],M):- comb(X,L,P),subc(L,S),append(P,S,M),!.
suma([],0).
suma([X|L],M):- suma(L,Tam), M is Tam + X.
suma_l([],_,[]).
suma_l([X|L],N,M):- suma(X,T), not(N = T),suma_l(L,N,M).
suma_l([X|L],N,[X|M]):- suma(X,T), N = T ,suma_l(L,N,M).
subconjunto(L,N,P):- not(member(N,L)),subc(L,M),suma_l(M,N,P),!.
subconjunto(L,N,P):- member(N,L),subc(L,M),suma_l(M,N,R),append(R,[[N]],P),!.
