SUMMARY = "Building Intel/Altera PCIe kernel module"
DESCRIPTION = "${SUMMARY}"
# Kernel source gives LICENSE = "BSD-2-Clause|GPL-2.0-only"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=5a2b62d63490ed55486909997f38bc34"

inherit module

# SRC_URI = "file://altera_dma_pcie.tar.gz;subdir=${BP}
SRC_URI = "file://altera_dma.c \
           file://altera_dma_cmd.h \
           file://altera_dma.h \
           file://Makefile \
          "

TARGET_CFLAGS:append = " -Wno-error=date-time Wno-error=implicit-fallthrough "
# BUILD_CFLAGS:append = " -Wno-error=date-time Wno-error=implicit-fallthrough "
# HOST_CFLAGS:append = " -Wno-error=date-time Wno-error=implicit-fallthrough "
# TARGET_CC_ARCH:append = " -Wno-error=date-time Wno-error=implicit-fallthrough "
# HOST_CC_ARCH:append = " -Wno-error=date-time Wno-error=implicit-fallthrough "
# CC += " -Wno-error=date-time Wno-error=implicit-fallthrough "
# CPPFLAGS:prepend = " -Wno-error=date-time Wno-error=implicit-fallthrough "

# S = "${WORKDIR}/${BP}"  # only needed for tar.gz files

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
KERNEL_MODULE_AUTOLOAD += "altera-dma"

# added because the files have been added in SRC_URI
do_configure() {
           install -m 0644 ${WORKDIR}/Makefile ${S}
           install -m 0644 ${WORKDIR}/altera_dma.c ${S}
           install -m 0644 ${WORKDIR}/altera_dma.h ${S}
           install -m 0644 ${WORKDIR}/altera_dma_cmd.h ${S}
}
