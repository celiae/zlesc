#!/usr/bin/env sh

# abort on errors
set -e

# ssh
eval $(ssh-agent)
ssh-add /home/ceelia/.ssh/github_id_rsa

# push source code
git add -A
git config user.email "ceelia0g@gmail.com"
git config user.name "Cheng Liang"
git commit -m 'source code'
git push -f git@github.com:celiae/zlesc -u master:backend