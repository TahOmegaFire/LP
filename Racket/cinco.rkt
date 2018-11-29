#lang scheme
#|
Funcion : Factorial
Descripcion: Determina el factorial de un entero
Parametros:
n entero
Retorno: Resultado del factorial n
|#
(define (factorial n)
  (cond
    [(<= n 1) 1]
    [else (* n (factorial (- n 1)))]
    )
  )
|#
Funcion : Rec_cos
Descripcion: Determina el valor aproximado del coseno
Parametros:
valor valor de la variable a evaluar
iter numero de iteraciones
Retorno: Resultado del coseno
|#
(define (rec_cos valor iter)
  (cond
    [(= iter 1) valor]
    [(= (remainder iter 2) 0)
     (+ 1 (rec_cos (/ (expt valor (* 2 iter)) (factorial((* 2 iter)))) (- iter 1) ))
     ]
    [(= (remainder iter 2) 1)
     (+ 1 (rec_cos (/ (* -1 (expt valor (* 2 iter))) (factorial((* 2 iter)))) (- iter 1) ))
     ]
    )
  )

(rec_cos (/ pi 2) 3)
