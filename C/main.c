#include "genetico.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
	srand(time(NULL));
	void* list1 = generarSolucion(5);
	void* list2 = generarSolucion(5);

	imprimirSolucion(list1);
	printf("\n\n");
	imprimirSolucion(list2);

	void* list3 = copiar(list1);
	printf("\n\n");
	imprimirSolucion(list3);
	printf("\n\n");

	cruceMedio(list1, list2);
	imprimirSolucion(list1);
	printf("\n\n");
	imprimirSolucion(list2);
	printf("\n\n");
	imprimirSolucion(list3);

	borrar(list1);
	borrar(list2);
	borrar(list3);

	return 0;
}
