#include "genetico.h"
#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <time.h>

typedef struct tNodo
{
	void* dato;
	char tipo;
} tNodo;

typedef struct listaE
{
	tNodo m_Nodo;
	struct listaE* next;
} listaE;

int valor(void* Lista)
{
	listaE* cur = (listaE*) Lista;
	if (cur->m_Nodo.tipo == 'c')
		return sizeof(char)*2;
	if(cur->m_Nodo.tipo == 'b')
		return sizeof(bool);

	return sizeof(int);
}

void copyNodo(listaE* nNodo, listaE* cNodo)
{
	nNodo->m_Nodo.tipo = cNodo->m_Nodo.tipo;
	if(nNodo->m_Nodo.tipo == 'i')
	{
		nNodo->m_Nodo.dato = malloc(sizeof(int*));
		*((int *)nNodo->m_Nodo.dato) = *((int *)cNodo->m_Nodo.dato);
	}

	else if(nNodo->m_Nodo.tipo == 'c')
	{
		nNodo->m_Nodo.dato = malloc(sizeof(char*));
		*((char *)nNodo->m_Nodo.dato) = *((char *)cNodo->m_Nodo.dato);
	}

	else if(nNodo->m_Nodo.tipo == 'b')
	{
		nNodo->m_Nodo.dato = malloc(sizeof(bool*));
		*((bool *)nNodo->m_Nodo.dato) = *((bool *)cNodo->m_Nodo.dato);
	}
}

void setNodo(listaE* h)
{
	h->m_Nodo.dato = NULL;
	unsigned char tipo = rand() % 3;
	if(tipo == 0)
	{
		h->m_Nodo.tipo = 'i';
		h->m_Nodo.dato = malloc(sizeof(int*));
		(*(int *)h->m_Nodo.dato) = rand() % 10;
	}

	else if(tipo == 1)
	{
		h->m_Nodo.tipo = 'c';
		h->m_Nodo.dato = malloc(sizeof(char*));
		(*(char *)h->m_Nodo.dato) = 65 + rand() % 6;
	}

	else if(tipo == 2)
	{
		h->m_Nodo.tipo = 'b';
		h->m_Nodo.dato = malloc(sizeof(bool*));
		(*(bool *)h->m_Nodo.dato) = rand() % 2;
	}
}

void* generarSolucion(int n)
{
	listaE* head = (listaE*)malloc(sizeof(listaE));
	head->next = NULL;
	setNodo(head);
	listaE* cur = head;

	for(int i = 1; i < n; ++i)
	{
		listaE* newEn = (listaE*)malloc(sizeof(listaE));
		newEn->next = NULL;
		setNodo(newEn);
		cur->next = newEn;
		cur = newEn;
	}

	return head;
}

void* copiar(void* Lista)
{
	listaE* nHead = (listaE*)malloc(sizeof(listaE));
	nHead->next = NULL;
	nHead->m_Nodo.tipo = ' ';
	nHead->m_Nodo.dato = NULL;
	copyNodo(nHead, Lista);
	listaE* cur = nHead;
	listaE* curPtr = Lista;
	while(curPtr->next != NULL)
	{
		curPtr = curPtr->next;
		listaE* newEn = (listaE*)malloc(sizeof(listaE));
		newEn->next = NULL;
		newEn->m_Nodo.tipo = ' ';
		newEn->m_Nodo.dato = NULL;
		copyNodo(newEn, curPtr);
		cur->next = newEn;
		cur = newEn;
	}

	return nHead;
}

void borrar(void* Lista)
{
	free(((listaE*)Lista)->m_Nodo.dato);
	if(((listaE*)Lista)->next != NULL)
	{
		borrar(((listaE*)Lista)->next);
		((listaE*)Lista)->next = NULL;
	}

	free(Lista);
}

void imprimirSolucion(void* Lista)
{
	listaE* cur = (listaE*)Lista;
	while(cur->next != NULL)
	{
		if(cur->m_Nodo.tipo == 'i')
			printf("(%i, i)\n", *(int*)cur->m_Nodo.dato);
		else if(cur->m_Nodo.tipo == 'c')
			printf("(%c, c)\n", *(char*)cur->m_Nodo.dato);
		else if(cur->m_Nodo.tipo == 'b')
			printf("(%d, b)\n", *(bool*)cur->m_Nodo.dato);

		cur = cur->next;
	}

	if(cur->m_Nodo.tipo == 'i')
		printf("(%i, i)\n", *(int*)cur->m_Nodo.dato);
	else if(cur->m_Nodo.tipo == 'c')
		printf("(%c, c)\n", *(char*)cur->m_Nodo.dato);
	else if(cur->m_Nodo.tipo == 'b')
		printf("(%d, b)\n", *(bool*)cur->m_Nodo.dato);
}

void cruceMedio(void* Lista1, void* Lista2)
{
	int c = 1;
	listaE* ptr = (listaE*)Lista1;
	while(ptr->next != NULL)
	{
		++c;
		ptr = ptr->next;
	}

	c /= 2;

	ptr = (listaE*)Lista1;
	listaE* ptr2 = (listaE*)Lista2; //I dunno how else to do this lmao

	for(int i = 0; i < c; ++i)
	{
		tNodo temp = ptr->m_Nodo;
		ptr->m_Nodo = ptr2->m_Nodo;
		ptr2->m_Nodo = temp;
		ptr = ptr->next;
		ptr2 = ptr2->next;
	}
}

void cruceIntercalado(void* Lista1, void* Lista2)
{
	int c = 1;
	listaE* ptr = (listaE*)Lista1;
	while(ptr->next != NULL)
	{
		++c;
		ptr = ptr->next;
	}

	ptr = (listaE*)Lista1;
	listaE* ptr2 = (listaE*)Lista2; //I dunno how else to do this lmao

	for(int i = 0; i < c; ++i)
	{
		if(i % 2 == 1)
		{
			tNodo temp = ptr->m_Nodo;
			ptr->m_Nodo = ptr2->m_Nodo;
			ptr2->m_Nodo = temp;
		}
		ptr = ptr->next;
		ptr2 = ptr2->next;

	}
}

void mutacionRand(void* Lista)
{
	listaE* head = (listaE*)Lista;
	listaE* ptr = head;
	int c = 1;
	while(ptr->next != NULL)
	{
		++c;
		ptr = ptr->next;
	}

	c = (rand() % c);
	ptr = head;
	for(int i = 0; i < c; ++i)
		ptr = ptr->next;

	unsigned char tipo = rand() % 3;
	if(tipo == 0)
	{
		ptr->m_Nodo.tipo = 'i';
		ptr->m_Nodo.dato = realloc(ptr->m_Nodo.dato, sizeof(int*));
		(*(int *)ptr->m_Nodo.dato) = rand() % 10;
	}

	else if(tipo == 1)
	{
		ptr->m_Nodo.tipo = 'c';
		ptr->m_Nodo.dato = realloc(ptr->m_Nodo.dato, sizeof(char*));
		(*(char *)ptr->m_Nodo.dato) = 65 + rand() % 6;
	}

	else if(tipo == 2)
	{
		ptr->m_Nodo.tipo = 'b';
		ptr->m_Nodo.dato = realloc(ptr->m_Nodo.dato, sizeof(bool*));
		(*(bool *)ptr->m_Nodo.dato) = rand() % 2;
	}
}

void mutacionTipo(void* Lista)
{
	listaE* head = (listaE*)Lista;
	listaE* ptr = head;
	int c = 1;
	while(ptr->next != NULL)
	{
		++c;
		ptr = ptr->next;
	}

	c = (rand() % c);
	ptr = head;
	for(int i = 0; i < c; ++i)
		ptr = ptr->next;

	switch(ptr->m_Nodo.tipo)
	{
	case 'i':
		(*(int *)ptr->m_Nodo.dato) = rand() % 10;
		break;

	case 'c':
		(*(char *)ptr->m_Nodo.dato) = 65 + rand() % 6;
		break;

	case 'b':
		(*(bool *)ptr->m_Nodo.dato) = !(*(bool *)ptr->m_Nodo.dato);
		break;

	default:
		break;
	}
}



int evaluacionLista(int (*fun)(void*), void* Lista)
{
	listaE* cur = (listaE*) Lista;
	int val=0;
	while (cur->next != NULL)
	{
		val+=(*fun)(cur);
		cur=cur->next;
	}
	val+=(*fun)(cur);
	return val;
}
void* reemplazar(void* list1, void* listn1)
{
	borrar(list1);
	return listn1;
}
void genetico(void (*muta)(void*), void(*cruce)(void*,void*),int n, int iteraciones)
{
	void* list1 = generarSolucion(n);
	void* list2 = generarSolucion(n);
	int val_1,val_2,val_n1,val_n2;
	while (iteraciones > 0)
	{
		val_1=evaluacionLista(valor,list1);
		val_2=evaluacionLista(valor,list2);
		void* listn1 = copiar(list1);
		void* listn2 = copiar(list2);
		val_n1=evaluacionLista(valor,listn1);
		val_n2=evaluacionLista(valor,listn2);
		if (val_1 < val_n1)
		{
			borrar(list1);
			list1= copiar(listn1);
			val_1=val_n1;
		}
		if (val_2 < val_n2) {
			borrar(list2);
			list2 = copiar(listn2);
			val_2=val_n2;
		}
		(*muta)(listn1);
		(*muta)(listn2);
		val_n1=evaluacionLista(valor,listn1);
		val_n2=evaluacionLista(valor,listn2);
		if (val_1 < val_n1)
		{
			borrar(list1);
			list1=copiar(listn1);
			val_1=val_n1;
		}
		borrar(listn1);
		if (val_2 < val_n2) {
			borrar(list2);
			list2=copiar(listn2);
			val_2=val_n2;
		}
		borrar(listn2);
		iteraciones--;
	}
	printf("lista1 con puntaje %d\n",val_1);
	imprimirSolucion(list1);
	printf("\n\n");
	printf("lista2 con puntaje %d\n",val_2);
	imprimirSolucion(list2);
	borrar(list1);
	borrar(list2);
}
