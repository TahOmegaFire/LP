C = gcc
CFLAGS = -std=c11 -g
TARGET = bin/genetico.out
SRC = $(addprefix src/, main.c genetico.c)

all : $(SRC)
	$(CC) $(SRC) $(CFLAGS) -o $(TARGET)
