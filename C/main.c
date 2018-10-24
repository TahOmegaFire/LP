#include "genetico.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
	srand(time(NULL));
	genetico(mutacionRand,cruceIntercalado,5,4);
	return 0;
}
