MODULE_NAME := altera_user
# obj-m += user.o
SRC := $(shell pwd)

all:
	        # $(MAKE) -C $(KERNEL_SRC) $(LDFLAGS) user.c
	        # $(CC) -I$(KERNEL_SRC) user.c
	        $(CC) $(LDFLAGS) -o altera_user user.c

clean:
	rm -rf *.o *~ user

