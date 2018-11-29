#lang scheme
|#
Funcion : es_iterable
Descripcion: Determina si el intervalo es valido para iterar y buscar una raiz
Parametros:
eq Funcion lambda 
l valor a evaluar
Retorno: True o False, indicando si se puede o no buscar una raiz
|#
(define (es_iterable eq l)
  (if (<= (* (eq (car l)) (eq (cadr l))) 0)
      #t
      #f
  )
  )
|#
Funcion : biseccion
Descripcion: Determina la raiz de un polinomio
Parametros:
lista Lista del intervalo en donde buscar la raiz
iter numero de iteraciones
Retorno: Retorna la raiz del polinomio
|#
(define (biseccion eq lista iter)
  (let aux([l lista] [num iter] [m 0])
    (cond
      [(= num 0) m]
      [(= (eq (car l)) 0) (car l)]
      [(= (eq (cadr l)) 0) (cadr l)]
      [(es_iterable eq l)
       (let ([p (/ (+ (car l) (cadr l)) 2)])
         (cond
           [(es_iterable eq (list (car l) p))
            (aux (list (car l) p) (- num 1) p)
            ]
           [(es_iterable eq (list p (cadr l)))
            (aux (list p (cadr l)) (- num 1) p)
            ]
           
           )
         )
       ]
       [else null]

      )
    )
 )
(biseccion (lambda(x) (+ (* x x) (* 2 x) 0)) '(-1 4) 100)
