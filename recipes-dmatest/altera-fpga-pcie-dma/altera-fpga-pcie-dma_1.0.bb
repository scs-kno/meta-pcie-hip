SUMMARY = "DMA test application"
DESCRIPTION = "Test the DMA loopback with Intel PCIe HIP"
# This is specified in the kernel sources
# LICENSE = "BSD-2-Clause|GPL-2.0-only"
LICENSE = "BSD-2-Clause"
# LIC_FILES_CHKSUM = "file://COPYING;md5=5a2b62d63490ed55486909997f38bc34"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-2-Clause;md5=cb641bc04cda31daea161b1bc15da69f"

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

