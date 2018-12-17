%En primer lugar para el siguiente programa la estructura de un diccionario, es la siguiente: [E:V,E1:V1,E2:V2,....,EN:VN], en donde E es la llave de un elemento y V es el valor correspondiente a la llave, estas llaves no pueden estar duplicadas.
%La consulta para agregar un elemento a un diccionario es de la siguiente manera, agregar(D,Y,Z), en donde D es el diccionario, Y es una lista con una llave con su respectivo valor de la forma [E:V] y M una variable para la lista resultante.
%La consulta para obtener un valor dado una llave, es de la siguiente manera, get_valor(D,K,Z), en donde D es el diccionario, K es la llave correspondiente al valor y Z es una variable para el valor resultante.
%La consulta para obtener todas las llaves de un diccionario, es de la siguiente manera, get_llaves(D,Z), en donde D es el diccionario y Z es una variable para la lista resultante.
%La consulta para obtener todos los valores de un diccionario, es de la siguiente manera, get_values(D,Z), en donde D es el diccionario y Z es una variable para la lista resultante.
%La consulta para obtener el largo de un diccionario, es de la siguiente manera, get_tam(D,T) en donde D es el diccionario y T es una variable para el tamaño del diccionario.
editar([K:_ | []],[K:N],[K:N]).
editar([K:N | []],[_:_],[K:N]).
editar([K:_|L],[K:N1],[K:N1|M]):-editar(L,[K:N1],M).
editar([K:N|L],[K1:N1],[K:N|M]):-editar(L,[K1:N1],M).
agregar(Dicc,[K:N],M):-get_llaves(Dicc,S),member(K,S),editar(Dicc,[K:N],M),!.
agregar(Dicc,[K:N],M):-get_llaves(Dicc,S),not(member(K,S)),append(Dicc,[K:N],M),!.
get_valor([K:V|_],K,V):-!.
get_valor([X:_|L],K,V):- not(X = K),get_valor(L,K,V).
get_llaves([],[]).
get_llaves([X:_|L],[X|M]):-get_llaves(L,M).
get_values([],[]).
get_values([_:X|L],[X|M]):-get_values(L,M).
get_tam([],0).
get_tam([_:_|L],M):-get_tam(L,T),M is T + 1.
