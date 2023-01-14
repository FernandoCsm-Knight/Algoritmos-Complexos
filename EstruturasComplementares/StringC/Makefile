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

BINARY=$(BINDIR)/strTests

default: $(BINARY)
	
$(BINARY): $(OBJECTS)
	$(CC) $^ -o $@ 
	$(foreach F,$(wildcard $(OBJDIR)/*.d),mv $(F) -t $(DEPDIR);)
	
$(OBJDIR)/%.o:$(SOURCEDIR)/%.c 
	$(CC) $(CFLAGS) -c $< -o $@ 

valgrind:
	valgrind --leak-check=yes --show-leak-kinds=all ./$(BINDIR)/./strTests

run: $(BINARY)
	./$(BINDIR)/./strTests

clean:
	$(foreach F,$(wildcard $(OBJDIR)/*.o),rm -r $(F);) 
	$(foreach F,$(wildcard $(DEPDIR)/*.d),rm -r $(F);)
	rm -r $(BINDIR)/* 