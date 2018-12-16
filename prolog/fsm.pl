%El automata presente acepta palabras en el lenguaje descrito por la expresion regular (abab|baba)(a|b)*c
%Para realizar una consulta, se debe llamar a automata(X), con X una lista de caracteres. Ejemplo: automata(['a', 'b', 'a', 'b', 'a', 'c'])

automata(X) :- nier(X, 0).

nier(X, S) :- 0 = S, (length(X, 0) ->  nier0(X, '') ; (nth0(0, X, Elm), nier0(X, Elm), !)).
nier(X, S) :- 1 = S, (length(X, 0) ->  nier1(X, '') ; (nth0(0, X, Elm), nier1(X, Elm), !)).
nier(X, S) :- 2 = S, (length(X, 0) ->  nier2(X, '') ; (nth0(0, X, Elm), nier2(X, Elm), !)).
nier(X, S) :- 3 = S, (length(X, 0) ->  nier3(X, '') ; (nth0(0, X, Elm), nier3(X, Elm), !)).
nier(X, S) :- 4 = S, (length(X, 0) ->  nier4(X, '') ; (nth0(0, X, Elm), nier4(X, Elm), !)).
nier(X, S) :- 5 = S, (length(X, 0) ->  nier5(X, '') ; (nth0(0, X, Elm), nier5(X, Elm), !)).
nier(X, S) :- 6 = S, (length(X, 0) ->  nier6(X, '') ; (nth0(0, X, Elm), nier6(X, Elm), !)).
nier(X, S) :- 7 = S, (length(X, 0) ->  nier7(X, '') ; (nth0(0, X, Elm), nier7(X, Elm), !)).
nier(X, S) :- 8 = S, (length(X, 0) ->  nier8(X, '') ; (nth0(0, X, Elm), nier8(X, Elm), !)).
nier(X, S) :- 9 = S, (length(X, 0) ->  nier9(X, '') ; (nth0(0, X, Elm), nier9(X, Elm), !)).
nier(X, S) :- 10 = S, (length(X, 0) ->  nier10(X, '') ; (nth0(0, X, Elm), nier10(X, Elm))).

nier0(X, Elm) :- Elm = 'a', X = [_|T], nier(T, 1), !.
nier0(X, Elm) :- Elm = 'b', X = [_|T], nier(T, 6), !.
nier0(_, _) :- writeln("Automata caido en estado 0"), fail.

nier1(X, Elm) :- Elm = 'b', X = [_|T], nier(T, 2), !.
nier1(_, _) :- writeln("Automata caido en estado 1"), fail.

nier2(X, Elm) :- Elm = 'a', X = [_|T], nier(T, 3), !.
nier2(_, _) :- writeln("Automata caido en estado 2"), fail.

nier3(X, Elm) :- Elm = 'b', X = [_|T], nier(T, 4), !.
nier3(_, _) :- writeln("Automata caido en estado 3"), fail.

nier4(X, Elm) :- Elm = 'a', X = [_|T], nier(T, 4), !.
nier4(X, Elm) :- Elm = 'b', X = [_|T], nier(T, 4), !.
nier4(X, Elm) :- Elm = 'c', X = [_|T], nier(T, 5).

nier5(X, _) :- length(X, 0), writeln("Palabra aceptada en el automata"), true, !.
nier5(_, _) :- writeln("Palabra sale del estado de aceptacion 5"), fail.

nier6(X, Elm) :- Elm = 'a', X = [_|T], nier(T, 7), !.
nier6(_, _) :- writeln("Automata caido en estado 7"), fail.

nier7(X, Elm) :- Elm = 'b', X = [_|T], nier(T, 8), !.
nier7(_, _) :- writeln("Automata caido en estado 8"), fail.

nier8(X, Elm) :- Elm = 'a', X = [_|T], nier(T, 9), !.
nier8(_, _) :- writeln("Automata caido en estado 8"), fail.

nier9(X, Elm) :- Elm = 'a', X = [_|T], nier(T, 9), !.
nier9(X, Elm) :- Elm = 'b', X = [_|T], nier(T, 9), !.
nier9(X, Elm) :- Elm = 'c', X = [_|T], nier(T, 10).

nier10(X, _) :- length(X, 0), writeln("Palabra aceptada en el automata"), true, !.
nier10(_, _) :- writeln("Palabra sale del estado de aceptacion 10"), fail.
