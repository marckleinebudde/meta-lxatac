SUMMARY = "Tool to make firmware files for the Linux display driver panel-mipi-dbi."
LICENSE = "CC0-1.0"
LIC_FILES_CHKSUM = "file://mipi-dbi-cmd;beginline=4;endline=13;md5=5e3d3f14cc87aa9e8976d728520cbcae"
SRCREV = "1cbd40135a8c7f25d7b444a7fac77fd3c3ad471e"

SRC_URI = "git://github.com/notro/panel-mipi-dbi.git;protocol=https;branch=main"

S = "${WORKDIR}/git"

inherit native

do_configure[noexec] = "1"
do_compile[noexec] = "1"
do_install () {
    install -D -p -m 0755 ${S}/mipi-dbi-cmd ${D}${bindir}/mipi-dbi-cmd
}

RDEPENDS:${PN} += "python3-native"
