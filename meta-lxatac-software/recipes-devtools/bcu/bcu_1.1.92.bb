SUMMARY = "NXP Board Control Utilities"
DESCRIPTION = "The NXP Board Control Utilities are able to control various \
               features of NXP i.MX evaluation boards (EVK) from a host \
               computer. \
               Features like resetting the board, selecting the boot mode, \
               monitoring power consumption, programming the EEPROM and others"
HOMEPAGE = "https://github.com/nxp-imx/bcu"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=884d48c2aa7b82e1ad4a33909fab24b6"

SRC_URI = "git://github.com/nxp-imx/bcu;protocol=https;branch=master \
           file://0001-CMakeLists-do-not-use-vendored-libcurl.patch \
           "
SRCREV = "04fecca3706896820c0119538c7545cbe52e85ed"

S = "${WORKDIR}/git"

DEPENDS = "curl libyaml libusb1 openssl libftdi"

inherit cmake pkgconfig

