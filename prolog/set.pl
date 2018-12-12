editar([K:_ | []],[K:N],[K:N]).
editar([K:N | []],[_:_],[K:N]).
editar([K:_|L],[K:N1],[K:N1|M]):-editar(L,[K:N1],M).
editar([K:N|L],[K1:N1],[K:N|M]):-editar(L,[K1:N1],M).
agregar(Dicc,[K:N],M):-get_llaves(Dicc,S),member(K,S),editar(Dicc,[K:N],M).
agregar(Dicc,[K:N],M):-get_llaves(Dicc,S),not(member(K,S)),append(Dicc,[K:N],M).
get_valor([K:V|_],K,V).
get_valor([X:_|L],K,V):- not(X = K),get_valor(L,K,V).
get_llaves([],[]).
get_llaves([X:_|L],[X|M]):-get_llaves(L,M).
get_values([],[]).
get_values([_:X|L],[X|M]):-get_values(L,M).
get_tam([],0).
get_tam([_:_|L],M):-get_tam(L,T),M is T + 1.
