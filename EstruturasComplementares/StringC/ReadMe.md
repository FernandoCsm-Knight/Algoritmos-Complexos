# Welcome to string in c

## Fernando Campos Silva Dal Maria

**To use this feature first run the config file in your system.**

Ex:
```bash
cd EstruturasComplementares/StringC/
./.config
```
In case you are using windows you will need to recompile the code before going any further. Thus far you should run the following code:

```bash
gcc -Wall -Wextra .config.c -o .config.exe
```

**After runnig the config file you can run make to compile the program.** 

Ex:

```bash
make
```

or (exclusive)

```bash
make run
```

**For more information:**

You may need such advanced information about the code. For this purpose a `valgrind` rule is available at makefile. Before using it remember to install valgrind on your linux system and reboot you machine.

The commands below can be used to install `valgrind`:

```bash
sudo apt install valgrind
```

or (exclusive)

```bash
sudo pacman -S valgrind
```

With the package installed you can edit the [makefile](./Makefile) and/or run:

```bash
make valgrind
```

*Thank you for seeing this feature*!
