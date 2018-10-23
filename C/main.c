#include "genetico.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int valor(void*);
int main()
{
	srand(time(NULL));
	genetico(mutacionRand,cruceIntercalado,10,10);
	return 0;
}
