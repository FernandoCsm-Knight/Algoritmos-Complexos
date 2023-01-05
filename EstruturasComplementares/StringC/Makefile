BINDIR=bin
OBJDIR=obj
SOURCEDIR=src
INCDIR=. ./src/header

CC=gcc
OPT=-O0
CFLAGS=-Wall -Wextra -pedantic -g $(foreach D,$(INCDIR),-I$(D)) $(OPT) $(DEPFLAGS)
DEPFLAGS=-MP -MD

CFILES=$(notdir $(foreach D,$(SOURCEDIR),$(wildcard $(D)/*.c)))
OBJECTS=$(patsubst %.c,$(OBJDIR)/%.o,$(CFILES))
DEPFILES=$(patsubst %.c,%.d,$(CFILES))

BINARY=$(BINDIR)/strTests

default: $(BINARY)

$(BINARY): $(OBJECTS)
	$(CC) $^ -o $@ 
	
$(OBJDIR)/%.o:$(SOURCEDIR)/%.c 
	$(CC) $(CFLAGS) -c $< -o $@ 

run: 
	./$(BINDIR)/./strTests

clean:
	rm -r $(OBJDIR)/*.o $(BINDIR)/*