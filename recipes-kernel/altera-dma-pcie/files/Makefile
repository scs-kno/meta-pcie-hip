MODULE_NAME := altera-dma
obj-m += altera_dma.o
$(MODULE_NAME)-y := altera_dma.o

SRC := $(shell pwd)

all:
	        $(MAKE) -C $(KERNEL_SRC) M=$(SRC)

modules_install:
	        $(MAKE) -C $(KERNEL_SRC) M=$(SRC) modules_install

clean:
	rm -rf *.o *~ core .depend .*.cmd *.ko *.mod.c .tmp_versions *.symvers *.order

