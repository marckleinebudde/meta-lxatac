# umpf-base: v6.11
# umpf-name: 6.11/customers/lxa/lxatac
# umpf-version: 6.11/customers/lxa/lxatac/20241111-1
# umpf-topic: v6.11/topic/reproducible-build
# umpf-hashinfo: d6ed6f191343a77bfe41d7436b51dffe8bcac441
# umpf-topic-range: 98f7e32f20d28ec452afb208f9cffc08448a2652..1b888dc7203b47ea21aacbf471cd762f82f36678
SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  "
# umpf-topic: v6.8/customers/lxa/lxatac
# umpf-hashinfo: 41e4da0d7f6a4d2ddef615f2d69fc7d6298e737e
# umpf-topic-range: 1b888dc7203b47ea21aacbf471cd762f82f36678..e3e86afd5e87a3c0d3a0441c0243709432a15d67
SRC_URI += "\
  file://patches/0101-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0102-ARM-dts-stm32-lxa-tac-Add-support-for-generation-3-d.patch \
  file://patches/0103-ARM-dts-stm32-lxa-tac-extend-the-alias-table.patch \
  file://patches/0104-ARM-dts-stm32-lxa-tac-disable-the-real-time-clock.patch \
  "
# umpf-release: 6.11/customers/lxa/lxatac/20241111-1
# umpf-topic-range: e3e86afd5e87a3c0d3a0441c0243709432a15d67..2641aafd3302692a20766af9722f17503b9c9d2a
SRC_URI += "\
  file://patches/0201-Release-6.11-customers-lxa-lxatac-20241111-1.patch \
  "
UMPF_BASE = "6.11"
UMPF_VERSION = "20241111-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION = "${UMPF_BASE}"
# umpf-end
