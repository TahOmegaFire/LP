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

void setNodo(listaE* h)
{
	unsigned char tipo = rand() % 3;
	if(tipo == 0)
	{
		h->m_Nodo.tipo = 'i';
		h->m_Nodo.dato = malloc(sizeof(int));
		(*(int *)h->m_Nodo.dato) = rand() % 10;
	}

	else if(tipo == 1)
	{
		h->m_Nodo.tipo = 'c';
		h->m_Nodo.dato = malloc(sizeof(char));
		(*(int *)h->m_Nodo.dato) = 65 + rand() % 6;
	}

	else if(tipo == 2)
	{
		h->m_Nodo.tipo = 'b';
		h->m_Nodo.dato = malloc(sizeof(bool));
		(*(int *)h->m_Nodo.dato) = rand() % 2;
	}
}

void* generarSolucion(int n)
{
	srand(time(NULL));
	listaE* head = (listaE*)malloc(sizeof(listaE));
	head->next = NULL;
	setNodo(head);
	listaE* cur = head;
	
	for(int i = 0; i < n; ++i)
	{
		listaE* newEn = (listaE*)malloc(sizeof(listaE));
		newEn->next = NULL;
		setNodo(newEn);
		cur->next = newEn;
		cur = newEn;
	}
}

void* copiar(void* Lista)
{

}
