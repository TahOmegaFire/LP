%Se espera que para la consulta, se llame a ciudades(X, Y, Z), con X la ciudad de origen, Y la cantidad de combustible disponible, y Z una variable para la lista de alcanzables.
%Las ciudades disponibles están enumeradas del 1 al 10.

ciudad(1,2,1).
ciudad(2,5,2).
ciudad(5,6,1).
ciudad(6,8,3).
ciudad(8,10,4).
ciudad(10,9,1).
ciudad(9,7,2).
ciudad(7,4,3).
ciudad(4,3,2).
ciudad(3,1,2).
ciudad(6,4,1).
ciudad(7,6,1).
ciudad(7,8,1).
ciudad(8,9,2).
ciudad(9,10,1).
ciudades(O,Com,R):- findall((D,P),ciudad(O,D,P),L),min(L,Com,M),list_to_set(M,S),delete(S,O,R),!.
min(_,Com,[]):- Com < 0 .
min([],_,[]).
min([(_,P)|L],Com,M):- Com2 is Com - P, Com2 < 0,min(L,Com,M).
min([(D,P)|L],Com,[D|M]):- Com2 is Com - P, Com2 >= 0,findall((D1,P1),ciudad(D,D1,P1),S),min(S,Com2,R),min(L,Com,T),append(R,T,M).
