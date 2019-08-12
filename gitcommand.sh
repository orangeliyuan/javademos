git config user.name = ""
git config user.email = ""

git config alias.save '!f() { git add -A && git commit -m "$@"; }; f'
git config alias.upload '!f() { git add -A && git commit -m "$@" && git push; }; f'
git config alias.download '!f() { git clone "$@"; }; f '
git config alias.dw-last '!f() { git clone -b "$@" --depth 1 "$@" }; f'
