SUMMARY = "DMA test application"
DESCRIPTION = "Test the DMA loopback with Intel PCIe HIP"
# This is specified in the kernel sources
LICENSE = "BSD/GPL"
# INHIBIT_PACKAGE_STRIP = "1"
TARGET_CC_ARCH += "${LDFLAGS}"


FILES:${PN} = " \
    ${bindir} \
" 

python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*  Altera DMA test application                *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

addtask display_banner before do_build

# SRC_URI = "file://mda.tar.gz;subdir=${BP}
SRC_URI = "file://altera_dma_cmd.h \
           file://altera_dma_load \
           file://Makefile \
           file://user.c \
          "

# S = "${WORKDIR}/${BP}"  # only needed for tar.gz

do_configure() {
           install -m 0644 ${WORKDIR}/altera_dma_cmd.h ${S} 
           install -m 0644 ${WORKDIR}/altera_dma_load  ${S} 
           install -m 0644 ${WORKDIR}/Makefile  ${S} 
           install -m 0644 ${WORKDIR}/user.c  ${S} 
}
do_compile() {
    oe_runmake
}
do_install() { 
    install -d ${D}${bindir}
    install -m 0755 ${S}/altera_user ${D}${bindir}
    install -m 0755 ${S}/altera_dma_load ${D}${bindir}
}

