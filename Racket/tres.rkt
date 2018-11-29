#lang scheme
|#
Funcion : Suma_arbol
Descripcion: Suma los nodos de un arbol hasta encontrar el numero buscado
Parametros:
lista Es el arbol en una lista
val_bus Valor buscado
Retorno: Resultado de sumar todos los nodos
|#
(define (suma_arbol lista val_bus)
    (cond
    [(= (car lista) val_bus) val_bus]
    [(not (null? (cadr lista)))
    (+ (car lista) (suma_arbol (cadr lista) val_bus))
    
    ]
    [(not (null? (caddr lista)))
    (+ (car lista) (suma_arbol (caddr lista) val_bus))
    ]
    [else 0]
    
    )
  )


(suma_arbol '(8 (3 (2 () ()) (6 (4 () () ) ())) (10 () ())) 8)
