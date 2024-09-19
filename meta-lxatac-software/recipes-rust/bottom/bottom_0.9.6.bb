inherit cargo

SRC_URI += "git://github.com/ClementTsang/bottom.git;protocol=https;branch=main"
SRCREV = "6d251098710f3119af11ecdd8761929acb010fab"
S = "${WORKDIR}/git"
CARGO_SRC_DIR = ""

# The bottom Cargo.toml strips release builds, why makes it hard to debug.
# Yocto has its own stripping feature, that preserves the debug symbols but
# only installs the stripped version.
# Pre-stripped binaries trigger a yocto QA error.
CARGO_BUILD_FLAGS += "--config profile.release.strip=false"

SRC_URI += " \
    crate://crates.io/addr2line/0.21.0 \
    crate://crates.io/adler/1.0.2 \
    crate://crates.io/ahash/0.8.3 \
    crate://crates.io/aho-corasick/1.0.4 \
    crate://crates.io/allocator-api2/0.2.16 \
    crate://crates.io/anstream/0.3.2 \
    crate://crates.io/anstyle-parse/0.2.1 \
    crate://crates.io/anstyle-query/1.0.0 \
    crate://crates.io/anstyle-wincon/1.0.2 \
    crate://crates.io/anstyle/1.0.1 \
    crate://crates.io/anyhow/1.0.75 \
    crate://crates.io/assert_cmd/2.0.12 \
    crate://crates.io/autocfg/1.1.0 \
    crate://crates.io/backtrace/0.3.69 \
    crate://crates.io/bitflags/1.3.2 \
    crate://crates.io/bitflags/2.4.0 \
    crate://crates.io/bstr/1.6.0 \
    crate://crates.io/byteorder/1.4.3 \
    crate://crates.io/cargo-husky/1.5.0 \
    crate://crates.io/cassowary/0.3.0 \
    crate://crates.io/cc/1.0.82 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/clap/4.3.23 \
    crate://crates.io/clap_builder/4.3.23 \
    crate://crates.io/clap_complete/4.3.2 \
    crate://crates.io/clap_lex/0.5.0 \
    crate://crates.io/clap_mangen/0.2.12 \
    crate://crates.io/colorchoice/1.0.0 \
    crate://crates.io/concat-string/1.0.1 \
    crate://crates.io/core-foundation-sys/0.8.4 \
    crate://crates.io/core-foundation/0.9.3 \
    crate://crates.io/crossbeam-channel/0.5.8 \
    crate://crates.io/crossbeam-deque/0.8.3 \
    crate://crates.io/crossbeam-epoch/0.9.15 \
    crate://crates.io/crossbeam-utils/0.8.16 \
    crate://crates.io/crossterm/0.26.1 \
    crate://crates.io/crossterm/0.27.0 \
    crate://crates.io/crossterm_winapi/0.9.1 \
    crate://crates.io/ctrlc/3.4.0 \
    crate://crates.io/darling/0.10.2 \
    crate://crates.io/darling_core/0.10.2 \
    crate://crates.io/darling_macro/0.10.2 \
    crate://crates.io/deranged/0.3.7 \
    crate://crates.io/difflib/0.4.0 \
    crate://crates.io/dirs-sys/0.4.1 \
    crate://crates.io/dirs/5.0.1 \
    crate://crates.io/doc-comment/0.3.3 \
    crate://crates.io/either/1.9.0 \
    crate://crates.io/enum-as-inner/0.5.1 \
    crate://crates.io/equivalent/1.0.1 \
    crate://crates.io/errno-dragonfly/0.1.2 \
    crate://crates.io/errno/0.3.2 \
    crate://crates.io/fern/0.6.2 \
    crate://crates.io/filedescriptor/0.8.2 \
    crate://crates.io/float-cmp/0.9.0 \
    crate://crates.io/fnv/1.0.7 \
    crate://crates.io/getrandom/0.2.10 \
    crate://crates.io/gimli/0.28.0 \
    crate://crates.io/hashbrown/0.14.0 \
    crate://crates.io/heck/0.4.1 \
    crate://crates.io/hermit-abi/0.3.2 \
    crate://crates.io/humantime/2.1.0 \
    crate://crates.io/ident_case/1.0.1 \
    crate://crates.io/indexmap/2.0.0 \
    crate://crates.io/indoc/2.0.3 \
    crate://crates.io/io-lifetimes/1.0.11 \
    crate://crates.io/is-terminal/0.4.9 \
    crate://crates.io/itertools/0.10.5 \
    crate://crates.io/itertools/0.11.0 \
    crate://crates.io/itoa/1.0.9 \
    crate://crates.io/kstring/2.0.0 \
    crate://crates.io/lazycell/1.3.0 \
    crate://crates.io/libc/0.2.147 \
    crate://crates.io/libloading/0.7.4 \
    crate://crates.io/linux-raw-sys/0.3.8 \
    crate://crates.io/linux-raw-sys/0.4.5 \
    crate://crates.io/lock_api/0.4.10 \
    crate://crates.io/log/0.4.20 \
    crate://crates.io/mach2/0.4.1 \
    crate://crates.io/memchr/2.5.0 \
    crate://crates.io/memoffset/0.9.0 \
    crate://crates.io/miniz_oxide/0.7.1 \
    crate://crates.io/mio/0.8.8 \
    crate://crates.io/nix/0.26.2 \
    crate://crates.io/normalize-line-endings/0.3.0 \
    crate://crates.io/ntapi/0.4.1 \
    crate://crates.io/num-traits/0.2.16 \
    crate://crates.io/num_cpus/1.16.0 \
    crate://crates.io/nvml-wrapper-sys/0.7.0 \
    crate://crates.io/nvml-wrapper/0.9.0 \
    crate://crates.io/object/0.32.0 \
    crate://crates.io/once_cell/1.18.0 \
    crate://crates.io/option-ext/0.2.0 \
    crate://crates.io/parking_lot/0.12.1 \
    crate://crates.io/parking_lot_core/0.9.8 \
    crate://crates.io/paste/1.0.14 \
    crate://crates.io/predicates-core/1.0.6 \
    crate://crates.io/predicates-tree/1.0.9 \
    crate://crates.io/predicates/3.0.3 \
    crate://crates.io/proc-macro2/1.0.66 \
    crate://crates.io/quote/1.0.33 \
    crate://crates.io/ratatui/0.22.0 \
    crate://crates.io/rayon-core/1.11.0 \
    crate://crates.io/rayon/1.7.0 \
    crate://crates.io/redox_syscall/0.2.16 \
    crate://crates.io/redox_syscall/0.3.5 \
    crate://crates.io/redox_users/0.4.3 \
    crate://crates.io/regex-automata/0.3.7 \
    crate://crates.io/regex-syntax/0.7.5 \
    crate://crates.io/regex/1.9.4 \
    crate://crates.io/roff/0.2.1 \
    crate://crates.io/rustc-demangle/0.1.23 \
    crate://crates.io/rustix/0.37.23 \
    crate://crates.io/rustix/0.38.9 \
    crate://crates.io/ryu/1.0.15 \
    crate://crates.io/same-file/1.0.6 \
    crate://crates.io/scopeguard/1.2.0 \
    crate://crates.io/serde/1.0.188 \
    crate://crates.io/serde_derive/1.0.188 \
    crate://crates.io/serde_json/1.0.105 \
    crate://crates.io/serde_spanned/0.6.3 \
    crate://crates.io/signal-hook-mio/0.2.3 \
    crate://crates.io/signal-hook-registry/1.4.1 \
    crate://crates.io/signal-hook/0.3.17 \
    crate://crates.io/smallvec/1.11.0 \
    crate://crates.io/starship-battery/0.8.2 \
    crate://crates.io/static_assertions/1.1.0 \
    crate://crates.io/strsim/0.10.0 \
    crate://crates.io/strsim/0.9.3 \
    crate://crates.io/syn/1.0.109 \
    crate://crates.io/syn/2.0.29 \
    crate://crates.io/sysctl/0.5.4 \
    crate://crates.io/sysinfo/0.29.8 \
    crate://crates.io/terminal_size/0.2.6 \
    crate://crates.io/termtree/0.4.1 \
    crate://crates.io/thiserror-impl/1.0.47 \
    crate://crates.io/thiserror/1.0.47 \
    crate://crates.io/time-core/0.1.1 \
    crate://crates.io/time-macros/0.2.13 \
    crate://crates.io/time/0.3.27 \
    crate://crates.io/toml_datetime/0.6.3 \
    crate://crates.io/toml_edit/0.19.14 \
    crate://crates.io/typenum/1.16.0 \
    crate://crates.io/unicode-ident/1.0.11 \
    crate://crates.io/unicode-segmentation/1.10.1 \
    crate://crates.io/unicode-width/0.1.10 \
    crate://crates.io/uom/0.35.0 \
    crate://crates.io/utf8parse/0.2.1 \
    crate://crates.io/version_check/0.9.4 \
    crate://crates.io/wait-timeout/0.2.0 \
    crate://crates.io/walkdir/2.3.3 \
    crate://crates.io/wasi/0.11.0+wasi-snapshot-preview1 \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi-util/0.1.5 \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi/0.3.9 \
    crate://crates.io/windows-core/0.51.1 \
    crate://crates.io/windows-sys/0.48.0 \
    crate://crates.io/windows-targets/0.48.5 \
    crate://crates.io/windows/0.51.1 \
    crate://crates.io/windows_aarch64_gnullvm/0.48.5 \
    crate://crates.io/windows_aarch64_msvc/0.48.5 \
    crate://crates.io/windows_i686_gnu/0.48.5 \
    crate://crates.io/windows_i686_msvc/0.48.5 \
    crate://crates.io/windows_x86_64_gnu/0.48.5 \
    crate://crates.io/windows_x86_64_gnullvm/0.48.5 \
    crate://crates.io/windows_x86_64_msvc/0.48.5 \
    crate://crates.io/winnow/0.5.14 \
    crate://crates.io/wrapcenum-derive/0.4.0 \
"

SRC_URI[addr2line-0.21.0.sha256sum] = "8a30b2e23b9e17a9f90641c7ab1549cd9b44f296d3ccbf309d2863cfe398a0cb"
SRC_URI[adler-1.0.2.sha256sum] = "f26201604c87b1e01bd3d98f8d5d9a8fcbb815e8cedb41ffccbeb4bf593a35fe"
SRC_URI[ahash-0.8.3.sha256sum] = "2c99f64d1e06488f620f932677e24bc6e2897582980441ae90a671415bd7ec2f"
SRC_URI[aho-corasick-1.0.4.sha256sum] = "6748e8def348ed4d14996fa801f4122cd763fff530258cdc03f64b25f89d3a5a"
SRC_URI[allocator-api2-0.2.16.sha256sum] = "0942ffc6dcaadf03badf6e6a2d0228460359d5e34b57ccdc720b7382dfbd5ec5"
SRC_URI[anstream-0.3.2.sha256sum] = "0ca84f3628370c59db74ee214b3263d58f9aadd9b4fe7e711fd87dc452b7f163"
SRC_URI[anstyle-parse-0.2.1.sha256sum] = "938874ff5980b03a87c5524b3ae5b59cf99b1d6bc836848df7bc5ada9643c333"
SRC_URI[anstyle-query-1.0.0.sha256sum] = "5ca11d4be1bab0c8bc8734a9aa7bf4ee8316d462a08c6ac5052f888fef5b494b"
SRC_URI[anstyle-wincon-1.0.2.sha256sum] = "c677ab05e09154296dd37acecd46420c17b9713e8366facafa8fc0885167cf4c"
SRC_URI[anstyle-1.0.1.sha256sum] = "3a30da5c5f2d5e72842e00bcb57657162cdabef0931f40e2deb9b4140440cecd"
SRC_URI[anyhow-1.0.75.sha256sum] = "a4668cab20f66d8d020e1fbc0ebe47217433c1b6c8f2040faf858554e394ace6"
SRC_URI[assert_cmd-2.0.12.sha256sum] = "88903cb14723e4d4003335bb7f8a14f27691649105346a0f0957466c096adfe6"
SRC_URI[autocfg-1.1.0.sha256sum] = "d468802bab17cbc0cc575e9b053f41e72aa36bfa6b7f55e3529ffa43161b97fa"
SRC_URI[backtrace-0.3.69.sha256sum] = "2089b7e3f35b9dd2d0ed921ead4f6d318c27680d4a5bd167b3ee120edb105837"
SRC_URI[bitflags-1.3.2.sha256sum] = "bef38d45163c2f1dde094a7dfd33ccf595c92905c8f8f4fdc18d06fb1037718a"
SRC_URI[bitflags-2.4.0.sha256sum] = "b4682ae6287fcf752ecaabbfcc7b6f9b72aa33933dc23a554d853aea8eea8635"
SRC_URI[bstr-1.6.0.sha256sum] = "6798148dccfbff0fae41c7574d2fa8f1ef3492fba0face179de5d8d447d67b05"
SRC_URI[byteorder-1.4.3.sha256sum] = "14c189c53d098945499cdfa7ecc63567cf3886b3332b312a5b4585d8d3a6a610"
SRC_URI[cargo-husky-1.5.0.sha256sum] = "7b02b629252fe8ef6460461409564e2c21d0c8e77e0944f3d189ff06c4e932ad"
SRC_URI[cassowary-0.3.0.sha256sum] = "df8670b8c7b9dae1793364eafadf7239c40d669904660c5960d74cfd80b46a53"
SRC_URI[cc-1.0.82.sha256sum] = "305fe645edc1442a0fa8b6726ba61d422798d37a52e12eaecf4b022ebbb88f01"
SRC_URI[cfg-if-1.0.0.sha256sum] = "baf1de4339761588bc0619e3cbc0120ee582ebb74b53b4efbf79117bd2da40fd"
SRC_URI[clap-4.3.23.sha256sum] = "03aef18ddf7d879c15ce20f04826ef8418101c7e528014c3eeea13321047dca3"
SRC_URI[clap_builder-4.3.23.sha256sum] = "f8ce6fffb678c9b80a70b6b6de0aad31df727623a70fd9a842c30cd573e2fa98"
SRC_URI[clap_complete-4.3.2.sha256sum] = "5fc443334c81a804575546c5a8a79b4913b50e28d69232903604cada1de817ce"
SRC_URI[clap_lex-0.5.0.sha256sum] = "2da6da31387c7e4ef160ffab6d5e7f00c42626fe39aea70a7b0f1773f7dd6c1b"
SRC_URI[clap_mangen-0.2.12.sha256sum] = "8f2e32b579dae093c2424a8b7e2bea09c89da01e1ce5065eb2f0a6f1cc15cc1f"
SRC_URI[colorchoice-1.0.0.sha256sum] = "acbf1af155f9b9ef647e42cdc158db4b64a1b61f743629225fde6f3e0be2a7c7"
SRC_URI[concat-string-1.0.1.sha256sum] = "7439becb5fafc780b6f4de382b1a7a3e70234afe783854a4702ee8adbb838609"
SRC_URI[core-foundation-sys-0.8.4.sha256sum] = "e496a50fda8aacccc86d7529e2c1e0892dbd0f898a6b5645b5561b89c3210efa"
SRC_URI[core-foundation-0.9.3.sha256sum] = "194a7a9e6de53fa55116934067c844d9d749312f75c6f6d0980e8c252f8c2146"
SRC_URI[crossbeam-channel-0.5.8.sha256sum] = "a33c2bf77f2df06183c3aa30d1e96c0695a313d4f9c453cc3762a6db39f99200"
SRC_URI[crossbeam-deque-0.8.3.sha256sum] = "ce6fd6f855243022dcecf8702fef0c297d4338e226845fe067f6341ad9fa0cef"
SRC_URI[crossbeam-epoch-0.9.15.sha256sum] = "ae211234986c545741a7dc064309f67ee1e5ad243d0e48335adc0484d960bcc7"
SRC_URI[crossbeam-utils-0.8.16.sha256sum] = "5a22b2d63d4d1dc0b7f1b6b2747dd0088008a9be28b6ddf0b1e7d335e3037294"
SRC_URI[crossterm-0.26.1.sha256sum] = "a84cda67535339806297f1b331d6dd6320470d2a0fe65381e79ee9e156dd3d13"
SRC_URI[crossterm-0.27.0.sha256sum] = "f476fe445d41c9e991fd07515a6f463074b782242ccf4a5b7b1d1012e70824df"
SRC_URI[crossterm_winapi-0.9.1.sha256sum] = "acdd7c62a3665c7f6830a51635d9ac9b23ed385797f70a83bb8bafe9c572ab2b"
SRC_URI[ctrlc-3.4.0.sha256sum] = "2a011bbe2c35ce9c1f143b7af6f94f29a167beb4cd1d29e6740ce836f723120e"
SRC_URI[darling-0.10.2.sha256sum] = "0d706e75d87e35569db781a9b5e2416cff1236a47ed380831f959382ccd5f858"
SRC_URI[darling_core-0.10.2.sha256sum] = "f0c960ae2da4de88a91b2d920c2a7233b400bc33cb28453a2987822d8392519b"
SRC_URI[darling_macro-0.10.2.sha256sum] = "d9b5a2f4ac4969822c62224815d069952656cadc7084fdca9751e6d959189b72"
SRC_URI[deranged-0.3.7.sha256sum] = "7684a49fb1af197853ef7b2ee694bc1f5b4179556f1e5710e1760c5db6f5e929"
SRC_URI[difflib-0.4.0.sha256sum] = "6184e33543162437515c2e2b48714794e37845ec9851711914eec9d308f6ebe8"
SRC_URI[dirs-sys-0.4.1.sha256sum] = "520f05a5cbd335fae5a99ff7a6ab8627577660ee5cfd6a94a6a929b52ff0321c"
SRC_URI[dirs-5.0.1.sha256sum] = "44c45a9d03d6676652bcb5e724c7e988de1acad23a711b5217ab9cbecbec2225"
SRC_URI[doc-comment-0.3.3.sha256sum] = "fea41bba32d969b513997752735605054bc0dfa92b4c56bf1189f2e174be7a10"
SRC_URI[either-1.9.0.sha256sum] = "a26ae43d7bcc3b814de94796a5e736d4029efb0ee900c12e2d54c993ad1a1e07"
SRC_URI[enum-as-inner-0.5.1.sha256sum] = "c9720bba047d567ffc8a3cba48bf19126600e249ab7f128e9233e6376976a116"
SRC_URI[equivalent-1.0.1.sha256sum] = "5443807d6dff69373d433ab9ef5378ad8df50ca6298caf15de6e52e24aaf54d5"
SRC_URI[errno-dragonfly-0.1.2.sha256sum] = "aa68f1b12764fab894d2755d2518754e71b4fd80ecfb822714a1206c2aab39bf"
SRC_URI[errno-0.3.2.sha256sum] = "6b30f669a7961ef1631673d2766cc92f52d64f7ef354d4fe0ddfd30ed52f0f4f"
SRC_URI[fern-0.6.2.sha256sum] = "d9f0c14694cbd524c8720dd69b0e3179344f04ebb5f90f2e4a440c6ea3b2f1ee"
SRC_URI[filedescriptor-0.8.2.sha256sum] = "7199d965852c3bac31f779ef99cbb4537f80e952e2d6aa0ffeb30cce00f4f46e"
SRC_URI[float-cmp-0.9.0.sha256sum] = "98de4bbd547a563b716d8dfa9aad1cb19bfab00f4fa09a6a4ed21dbcf44ce9c4"
SRC_URI[fnv-1.0.7.sha256sum] = "3f9eec918d3f24069decb9af1554cad7c880e2da24a9afd88aca000531ab82c1"
SRC_URI[getrandom-0.2.10.sha256sum] = "be4136b2a15dd319360be1c07d9933517ccf0be8f16bf62a3bee4f0d618df427"
SRC_URI[gimli-0.28.0.sha256sum] = "6fb8d784f27acf97159b40fc4db5ecd8aa23b9ad5ef69cdd136d3bc80665f0c0"
SRC_URI[hashbrown-0.14.0.sha256sum] = "2c6201b9ff9fd90a5a3bac2e56a830d0caa509576f0e503818ee82c181b3437a"
SRC_URI[heck-0.4.1.sha256sum] = "95505c38b4572b2d910cecb0281560f54b440a19336cbbcb27bf6ce6adc6f5a8"
SRC_URI[hermit-abi-0.3.2.sha256sum] = "443144c8cdadd93ebf52ddb4056d257f5b52c04d3c804e657d19eb73fc33668b"
SRC_URI[humantime-2.1.0.sha256sum] = "9a3a5bfb195931eeb336b2a7b4d761daec841b97f947d34394601737a7bba5e4"
SRC_URI[ident_case-1.0.1.sha256sum] = "b9e0384b61958566e926dc50660321d12159025e767c18e043daf26b70104c39"
SRC_URI[indexmap-2.0.0.sha256sum] = "d5477fe2230a79769d8dc68e0eabf5437907c0457a5614a9e8dddb67f65eb65d"
SRC_URI[indoc-2.0.3.sha256sum] = "2c785eefb63ebd0e33416dfcb8d6da0bf27ce752843a45632a67bf10d4d4b5c4"
SRC_URI[io-lifetimes-1.0.11.sha256sum] = "eae7b9aee968036d54dce06cebaefd919e4472e753296daccd6d344e3e2df0c2"
SRC_URI[is-terminal-0.4.9.sha256sum] = "cb0889898416213fab133e1d33a0e5858a48177452750691bde3666d0fdbaf8b"
SRC_URI[itertools-0.10.5.sha256sum] = "b0fd2260e829bddf4cb6ea802289de2f86d6a7a690192fbe91b3f46e0f2c8473"
SRC_URI[itertools-0.11.0.sha256sum] = "b1c173a5686ce8bfa551b3563d0c2170bf24ca44da99c7ca4bfdab5418c3fe57"
SRC_URI[itoa-1.0.9.sha256sum] = "af150ab688ff2122fcef229be89cb50dd66af9e01a4ff320cc137eecc9bacc38"
SRC_URI[kstring-2.0.0.sha256sum] = "ec3066350882a1cd6d950d055997f379ac37fd39f81cd4d8ed186032eb3c5747"
SRC_URI[lazycell-1.3.0.sha256sum] = "830d08ce1d1d941e6b30645f1a0eb5643013d835ce3779a5fc208261dbe10f55"
SRC_URI[libc-0.2.147.sha256sum] = "b4668fb0ea861c1df094127ac5f1da3409a82116a4ba74fca2e58ef927159bb3"
SRC_URI[libloading-0.7.4.sha256sum] = "b67380fd3b2fbe7527a606e18729d21c6f3951633d0500574c4dc22d2d638b9f"
SRC_URI[linux-raw-sys-0.3.8.sha256sum] = "ef53942eb7bf7ff43a617b3e2c1c4a5ecf5944a7c1bc12d7ee39bbb15e5c1519"
SRC_URI[linux-raw-sys-0.4.5.sha256sum] = "57bcfdad1b858c2db7c38303a6d2ad4dfaf5eb53dfeb0910128b2c26d6158503"
SRC_URI[lock_api-0.4.10.sha256sum] = "c1cc9717a20b1bb222f333e6a92fd32f7d8a18ddc5a3191a11af45dcbf4dcd16"
SRC_URI[log-0.4.20.sha256sum] = "b5e6163cb8c49088c2c36f57875e58ccd8c87c7427f7fbd50ea6710b2f3f2e8f"
SRC_URI[mach2-0.4.1.sha256sum] = "6d0d1830bcd151a6fc4aea1369af235b36c1528fe976b8ff678683c9995eade8"
SRC_URI[memchr-2.5.0.sha256sum] = "2dffe52ecf27772e601905b7522cb4ef790d2cc203488bbd0e2fe85fcb74566d"
SRC_URI[memoffset-0.9.0.sha256sum] = "5a634b1c61a95585bd15607c6ab0c4e5b226e695ff2800ba0cdccddf208c406c"
SRC_URI[miniz_oxide-0.7.1.sha256sum] = "e7810e0be55b428ada41041c41f32c9f1a42817901b4ccf45fa3d4b6561e74c7"
SRC_URI[mio-0.8.8.sha256sum] = "927a765cd3fc26206e66b296465fa9d3e5ab003e651c1b3c060e7956d96b19d2"
SRC_URI[nix-0.26.2.sha256sum] = "bfdda3d196821d6af13126e40375cdf7da646a96114af134d5f417a9a1dc8e1a"
SRC_URI[normalize-line-endings-0.3.0.sha256sum] = "61807f77802ff30975e01f4f071c8ba10c022052f98b3294119f3e615d13e5be"
SRC_URI[ntapi-0.4.1.sha256sum] = "e8a3895c6391c39d7fe7ebc444a87eb2991b2a0bc718fdabd071eec617fc68e4"
SRC_URI[num-traits-0.2.16.sha256sum] = "f30b0abd723be7e2ffca1272140fac1a2f084c77ec3e123c192b66af1ee9e6c2"
SRC_URI[num_cpus-1.16.0.sha256sum] = "4161fcb6d602d4d2081af7c3a45852d875a03dd337a6bfdd6e06407b61342a43"
SRC_URI[nvml-wrapper-sys-0.7.0.sha256sum] = "c961a2ea9e91c59a69b78e69090f6f5b867bb46c0c56de9482da232437c4987e"
SRC_URI[nvml-wrapper-0.9.0.sha256sum] = "7cd21b9f5a1cce3c3515c9ffa85f5c7443e07162dae0ccf4339bb7ca38ad3454"
SRC_URI[object-0.32.0.sha256sum] = "77ac5bbd07aea88c60a577a1ce218075ffd59208b2d7ca97adf9bfc5aeb21ebe"
SRC_URI[once_cell-1.18.0.sha256sum] = "dd8b5dd2ae5ed71462c540258bedcb51965123ad7e7ccf4b9a8cafaa4a63576d"
SRC_URI[option-ext-0.2.0.sha256sum] = "04744f49eae99ab78e0d5c0b603ab218f515ea8cfe5a456d7629ad883a3b6e7d"
SRC_URI[parking_lot-0.12.1.sha256sum] = "3742b2c103b9f06bc9fff0a37ff4912935851bee6d36f3c02bcc755bcfec228f"
SRC_URI[parking_lot_core-0.9.8.sha256sum] = "93f00c865fe7cabf650081affecd3871070f26767e7b2070a3ffae14c654b447"
SRC_URI[paste-1.0.14.sha256sum] = "de3145af08024dea9fa9914f381a17b8fc6034dfb00f3a84013f7ff43f29ed4c"
SRC_URI[predicates-core-1.0.6.sha256sum] = "b794032607612e7abeb4db69adb4e33590fa6cf1149e95fd7cb00e634b92f174"
SRC_URI[predicates-tree-1.0.9.sha256sum] = "368ba315fb8c5052ab692e68a0eefec6ec57b23a36959c14496f0b0df2c0cecf"
SRC_URI[predicates-3.0.3.sha256sum] = "09963355b9f467184c04017ced4a2ba2d75cbcb4e7462690d388233253d4b1a9"
SRC_URI[proc-macro2-1.0.66.sha256sum] = "18fb31db3f9bddb2ea821cde30a9f70117e3f119938b5ee630b7403aa6e2ead9"
SRC_URI[quote-1.0.33.sha256sum] = "5267fca4496028628a95160fc423a33e8b2e6af8a5302579e322e4b520293cae"
SRC_URI[ratatui-0.22.0.sha256sum] = "8285baa38bdc9f879d92c0e37cb562ef38aa3aeefca22b3200186bc39242d3d5"
SRC_URI[rayon-core-1.11.0.sha256sum] = "4b8f95bd6966f5c87776639160a66bd8ab9895d9d4ab01ddba9fc60661aebe8d"
SRC_URI[rayon-1.7.0.sha256sum] = "1d2df5196e37bcc87abebc0053e20787d73847bb33134a69841207dd0a47f03b"
SRC_URI[redox_syscall-0.2.16.sha256sum] = "fb5a58c1855b4b6819d59012155603f0b22ad30cad752600aadfcb695265519a"
SRC_URI[redox_syscall-0.3.5.sha256sum] = "567664f262709473930a4bf9e51bf2ebf3348f2e748ccc50dea20646858f8f29"
SRC_URI[redox_users-0.4.3.sha256sum] = "b033d837a7cf162d7993aded9304e30a83213c648b6e389db233191f891e5c2b"
SRC_URI[regex-automata-0.3.7.sha256sum] = "49530408a136e16e5b486e883fbb6ba058e8e4e8ae6621a77b048b314336e629"
SRC_URI[regex-syntax-0.7.5.sha256sum] = "dbb5fb1acd8a1a18b3dd5be62d25485eb770e05afb408a9627d14d451bae12da"
SRC_URI[regex-1.9.4.sha256sum] = "12de2eff854e5fa4b1295edd650e227e9d8fb0c9e90b12e7f36d6a6811791a29"
SRC_URI[roff-0.2.1.sha256sum] = "b833d8d034ea094b1ea68aa6d5c740e0d04bad9d16568d08ba6f76823a114316"
SRC_URI[rustc-demangle-0.1.23.sha256sum] = "d626bb9dae77e28219937af045c257c28bfd3f69333c512553507f5f9798cb76"
SRC_URI[rustix-0.37.23.sha256sum] = "4d69718bf81c6127a49dc64e44a742e8bb9213c0ff8869a22c308f84c1d4ab06"
SRC_URI[rustix-0.38.9.sha256sum] = "9bfe0f2582b4931a45d1fa608f8a8722e8b3c7ac54dd6d5f3b3212791fedef49"
SRC_URI[ryu-1.0.15.sha256sum] = "1ad4cc8da4ef723ed60bced201181d83791ad433213d8c24efffda1eec85d741"
SRC_URI[same-file-1.0.6.sha256sum] = "93fc1dc3aaa9bfed95e02e6eadabb4baf7e3078b0bd1b4d7b6b0b68378900502"
SRC_URI[scopeguard-1.2.0.sha256sum] = "94143f37725109f92c262ed2cf5e59bce7498c01bcc1502d7b9afe439a4e9f49"
SRC_URI[serde-1.0.188.sha256sum] = "cf9e0fcba69a370eed61bcf2b728575f726b50b55cba78064753d708ddc7549e"
SRC_URI[serde_derive-1.0.188.sha256sum] = "4eca7ac642d82aa35b60049a6eccb4be6be75e599bd2e9adb5f875a737654af2"
SRC_URI[serde_json-1.0.105.sha256sum] = "693151e1ac27563d6dbcec9dee9fbd5da8539b20fa14ad3752b2e6d363ace360"
SRC_URI[serde_spanned-0.6.3.sha256sum] = "96426c9936fd7a0124915f9185ea1d20aa9445cc9821142f0a73bc9207a2e186"
SRC_URI[signal-hook-mio-0.2.3.sha256sum] = "29ad2e15f37ec9a6cc544097b78a1ec90001e9f71b81338ca39f430adaca99af"
SRC_URI[signal-hook-registry-1.4.1.sha256sum] = "d8229b473baa5980ac72ef434c4415e70c4b5e71b423043adb4ba059f89c99a1"
SRC_URI[signal-hook-0.3.17.sha256sum] = "8621587d4798caf8eb44879d42e56b9a93ea5dcd315a6487c357130095b62801"
SRC_URI[smallvec-1.11.0.sha256sum] = "62bb4feee49fdd9f707ef802e22365a35de4b7b299de4763d44bfea899442ff9"
SRC_URI[starship-battery-0.8.2.sha256sum] = "36335b5b5ba5328b4ad2024807423010b7f533a7e5315dfd9df0acbc9d2c550e"
SRC_URI[static_assertions-1.1.0.sha256sum] = "a2eb9349b6444b326872e140eb1cf5e7c522154d69e7a0ffb0fb81c06b37543f"
SRC_URI[strsim-0.10.0.sha256sum] = "73473c0e59e6d5812c5dfe2a064a6444949f089e20eec9a2e5506596494e4623"
SRC_URI[strsim-0.9.3.sha256sum] = "6446ced80d6c486436db5c078dde11a9f73d42b57fb273121e160b84f63d894c"
SRC_URI[syn-1.0.109.sha256sum] = "72b64191b275b66ffe2469e8af2c1cfe3bafa67b529ead792a6d0160888b4237"
SRC_URI[syn-2.0.29.sha256sum] = "c324c494eba9d92503e6f1ef2e6df781e78f6a7705a0202d9801b198807d518a"
SRC_URI[sysctl-0.5.4.sha256sum] = "ed66d6a2ccbd656659289bc90767895b7abbdec897a0fc6031aca3ed1cb51d3e"
SRC_URI[sysinfo-0.29.8.sha256sum] = "d10ed79c22663a35a255d289a7fdcb43559fc77ff15df5ce6c341809e7867528"
SRC_URI[terminal_size-0.2.6.sha256sum] = "8e6bf6f19e9f8ed8d4048dc22981458ebcf406d67e94cd422e5ecd73d63b3237"
SRC_URI[termtree-0.4.1.sha256sum] = "3369f5ac52d5eb6ab48c6b4ffdc8efbcad6b89c765749064ba298f2c68a16a76"
SRC_URI[thiserror-impl-1.0.47.sha256sum] = "6bb623b56e39ab7dcd4b1b98bb6c8f8d907ed255b18de254088016b27a8ee19b"
SRC_URI[thiserror-1.0.47.sha256sum] = "97a802ec30afc17eee47b2855fc72e0c4cd62be9b4efe6591edde0ec5bd68d8f"
SRC_URI[time-core-0.1.1.sha256sum] = "7300fbefb4dadc1af235a9cef3737cea692a9d97e1b9cbcd4ebdae6f8868e6fb"
SRC_URI[time-macros-0.2.13.sha256sum] = "733d258752e9303d392b94b75230d07b0b9c489350c69b851fc6c065fde3e8f9"
SRC_URI[time-0.3.27.sha256sum] = "0bb39ee79a6d8de55f48f2293a830e040392f1c5f16e336bdd1788cd0aadce07"
SRC_URI[toml_datetime-0.6.3.sha256sum] = "7cda73e2f1397b1262d6dfdcef8aafae14d1de7748d66822d3bfeeb6d03e5e4b"
SRC_URI[toml_edit-0.19.14.sha256sum] = "f8123f27e969974a3dfba720fdb560be359f57b44302d280ba72e76a74480e8a"
SRC_URI[typenum-1.16.0.sha256sum] = "497961ef93d974e23eb6f433eb5fe1b7930b659f06d12dec6fc44a8f554c0bba"
SRC_URI[unicode-ident-1.0.11.sha256sum] = "301abaae475aa91687eb82514b328ab47a211a533026cb25fc3e519b86adfc3c"
SRC_URI[unicode-segmentation-1.10.1.sha256sum] = "1dd624098567895118886609431a7c3b8f516e41d30e0643f03d94592a147e36"
SRC_URI[unicode-width-0.1.10.sha256sum] = "c0edd1e5b14653f783770bce4a4dabb4a5108a5370a5f5d8cfe8710c361f6c8b"
SRC_URI[uom-0.35.0.sha256sum] = "8362194c7a9845a7a7f3562173d6e1da3f24f7132018cb78fe77a5b4474187b2"
SRC_URI[utf8parse-0.2.1.sha256sum] = "711b9620af191e0cdc7468a8d14e709c3dcdb115b36f838e601583af800a370a"
SRC_URI[version_check-0.9.4.sha256sum] = "49874b5167b65d7193b8aba1567f5c7d93d001cafc34600cee003eda787e483f"
SRC_URI[wait-timeout-0.2.0.sha256sum] = "9f200f5b12eb75f8c1ed65abd4b2db8a6e1b138a20de009dacee265a2498f3f6"
SRC_URI[walkdir-2.3.3.sha256sum] = "36df944cda56c7d8d8b7496af378e6b16de9284591917d307c9b4d313c44e698"
SRC_URI[wasi-0.11.0+wasi-snapshot-preview1.sha256sum] = "9c8d87e72b64a3b4db28d11ce29237c246188f4f51057d65a7eab63b7987e423"
SRC_URI[winapi-i686-pc-windows-gnu-0.4.0.sha256sum] = "ac3b87c63620426dd9b991e5ce0329eff545bccbbb34f3be09ff6fb6ab51b7b6"
SRC_URI[winapi-util-0.1.5.sha256sum] = "70ec6ce85bb158151cae5e5c87f95a8e97d2c0c4b001223f33a334e3ce5de178"
SRC_URI[winapi-x86_64-pc-windows-gnu-0.4.0.sha256sum] = "712e227841d057c1ee1cd2fb22fa7e5a5461ae8e48fa2ca79ec42cfc1931183f"
SRC_URI[winapi-0.3.9.sha256sum] = "5c839a674fcd7a98952e593242ea400abe93992746761e38641405d28b00f419"
SRC_URI[windows-core-0.51.1.sha256sum] = "f1f8cf84f35d2db49a46868f947758c7a1138116f7fac3bc844f43ade1292e64"
SRC_URI[windows-sys-0.48.0.sha256sum] = "677d2418bec65e3338edb076e806bc1ec15693c5d0104683f2efe857f61056a9"
SRC_URI[windows-targets-0.48.5.sha256sum] = "9a2fa6e2155d7247be68c096456083145c183cbbbc2764150dda45a87197940c"
SRC_URI[windows-0.51.1.sha256sum] = "ca229916c5ee38c2f2bc1e9d8f04df975b4bd93f9955dc69fabb5d91270045c9"
SRC_URI[windows_aarch64_gnullvm-0.48.5.sha256sum] = "2b38e32f0abccf9987a4e3079dfb67dcd799fb61361e53e2882c3cbaf0d905d8"
SRC_URI[windows_aarch64_msvc-0.48.5.sha256sum] = "dc35310971f3b2dbbf3f0690a219f40e2d9afcf64f9ab7cc1be722937c26b4bc"
SRC_URI[windows_i686_gnu-0.48.5.sha256sum] = "a75915e7def60c94dcef72200b9a8e58e5091744960da64ec734a6c6e9b3743e"
SRC_URI[windows_i686_msvc-0.48.5.sha256sum] = "8f55c233f70c4b27f66c523580f78f1004e8b5a8b659e05a4eb49d4166cca406"
SRC_URI[windows_x86_64_gnu-0.48.5.sha256sum] = "53d40abd2583d23e4718fddf1ebec84dbff8381c07cae67ff7768bbf19c6718e"
SRC_URI[windows_x86_64_gnullvm-0.48.5.sha256sum] = "0b7b52767868a23d5bab768e390dc5f5c55825b6d30b86c844ff2dc7414044cc"
SRC_URI[windows_x86_64_msvc-0.48.5.sha256sum] = "ed94fce61571a4006852b7389a063ab983c02eb1bb37b47f8272ce92d06d9538"
SRC_URI[winnow-0.5.14.sha256sum] = "d09770118a7eb1ccaf4a594a221334119a44a814fcb0d31c5b85e83e97227a97"
SRC_URI[wrapcenum-derive-0.4.0.sha256sum] = "6bcc065c85ad2c3bd12aa4118bf164835712e25080c392557801a13292c60aec"

LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=5d45cffa3a75da17d285cc60c0c458cc \
"

SUMMARY = "A customizable cross-platform graphical process/system monitor for the terminal. Supports Linux, macOS, and Windows."
HOMEPAGE = "https://github.com/ClementTsang/bottom"
LICENSE = "MIT"

# includes this file if it exists but does not fail
# this is useful for anything you may want to override from
# what cargo-bitbake generates.
include bottom-${PV}.inc
include bottom.inc
