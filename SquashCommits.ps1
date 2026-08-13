
# Fix ANSI Color on PWSH Core issues when displaying objects
if ($PSEdition -eq "Core") {
    $PSStyle.OutputRendering = "PlainText"
}

git checkout MyNewFeature
git reset --soft $(git merge-base MyNewFeature main)
git commit -m "Squashing commits for MyNewFeature"

git push --force-with-lease origin MyNewFeature