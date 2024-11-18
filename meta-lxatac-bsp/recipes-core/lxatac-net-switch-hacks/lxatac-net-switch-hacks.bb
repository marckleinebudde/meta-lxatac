LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit allarch

SRC_URI += " \
    file://01-increase-atomic-mem-pool-size.conf \
"

do_install() {
    # Increase the kernel atomic memory pool size.
    # This pool is used for allocations in the hot path.
    # It seems like the kernel sometimes runs out of memory in this pool when
    # under high load.
    install -D -m0644 ${WORKDIR}/01-increase-atomic-mem-pool-size.conf \
        ${D}${libdir}/sysctl.d/01-increase-atomic-mem-pool-size.conf
}

FILES:${PN} += "\
    ${libdir}/sysctl.d/ \
"
