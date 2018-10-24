#include "genetico.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
	srand(time(NULL));
	genetico(mutacionRand,cruceIntercalado,5,5);
	return 0;
}
