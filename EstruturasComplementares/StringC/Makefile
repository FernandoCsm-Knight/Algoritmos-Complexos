BINDIR=bin
OBJDIR=obj
DEPDIR=lib
SOURCEDIR=src
INCDIR=. ./src/header

CC=gcc
OPT=-O0
CFLAGS=-Wall -Wextra -pedantic -g $(foreach D,$(INCDIR),-I$(D)) $(OPT) $(DEPFLAGS)
DEPFLAGS=-MP -MD

CFILES=$(notdir $(foreach D,$(SOURCEDIR),$(wildcard $(D)/*.c)))
OBJECTS=$(patsubst %.c,$(OBJDIR)/%.o,$(CFILES))
DEPFILES=$(patsubst %.c,$(DEPDIR)%.d,$(CFILES))

BINARY=$(BINDIR)/strTests

default: $(BINARY)
	mv $(OBJDIR)/*.d $(DEPDIR)

$(BINARY): $(OBJECTS)
	$(CC) $^ -o $@ 
	
$(OBJDIR)/%.o:$(SOURCEDIR)/%.c 
	$(CC) $(CFLAGS) -c $< -o $@ 

valgrind:
	valgrind --leak-check=yes --show-leak-kinds=all ./$(BINDIR)/./strTests

run: 
	./$(BINDIR)/./strTests

clean:
	rm -r $(OBJDIR)/*.o $(DEPDIR)/*.d $(BINDIR)/* 